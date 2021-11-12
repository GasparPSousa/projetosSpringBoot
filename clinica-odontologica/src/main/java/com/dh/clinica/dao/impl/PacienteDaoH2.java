package com.dh.clinica.dao.impl;


import com.dh.clinica.dao.IDao;
import com.dh.clinica.dao.configuration.ConfigurationJDBC;
import com.dh.clinica.model.Endereco;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.util.Util;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfigurationJDBC configurationJDBC;
    private EnderecoDaoH2 enderecoDaoH2;
    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2(EnderecoDaoH2 enderecoDaoH2) {
        this.configurationJDBC = new ConfigurationJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Registrando paciente : " + paciente.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));
        String query = String.format("INSERT INTO paciente(nome,sobrenome,cpf,data_cadastro,endereco_id) VALUES('%s','%s','%s','%s','%s')", paciente.getNome(),
                paciente.getSobrenome(), paciente.getCpf(), Util.dateToTimestamp(paciente.getDataCadastro()), paciente.getEndereco().getId());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                paciente.setId(keys.getInt(1));
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        log.debug("Buscando paciente com id  : " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("SELECT id,nome,sobrenome,cpf,data_cadastro,endereco_id FROM paciente where id = '%s'", id);
        Paciente paciente = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                paciente = criarObjetoPaciente(result);
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }

    @Override
    public void remover(Integer id) {
        log.debug("Eliminando paciente com id  : " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM paciente where id = %s", id);
        execute(connection, query);
    }

    @Override
    public List<Paciente> buscarTodos() {
        log.debug("Buscando todos os pacientes");
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT *  FROM paciente";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                pacientes.add(criarObjetoPaciente(result));

            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        log.debug("Atualizando um paciente: " + paciente.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        if (paciente.getEndereco() != null && paciente.getId() != null)
            enderecoDaoH2.atualizar(paciente.getEndereco());

        String query = String.format("UPDATE paciente SET nome = '%s', sobrenome = '%s',cpf = '%s' WHERE id = '%s'",
                paciente.getNome(), paciente.getSobrenome(), paciente.getCpf(), paciente.getId());
        execute(connection, query);
        return paciente;
    }

    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {

        Integer idPaciente = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String cpf = result.getString("cpf");
        Date dataCadastro = result.getDate("data_cadastro");
        Endereco endereco = enderecoDaoH2.buscar(result.getInt("endereco_id")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, cpf, dataCadastro, endereco);

    }

    private void execute(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
