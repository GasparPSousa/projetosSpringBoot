package com.example.demo.repository.impl;

import com.example.demo.util.Util;
import com.example.demo.model.Endereco;
import com.example.demo.model.Paciente;
import com.example.demo.repository.IDao;
import com.example.demo.repository.configuracao.ConfiguracaoJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoH2 enderecoDaoH2;

    public PacienteDaoH2(EnderecoDaoH2 enderecoDaoH2) {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }


    @Override
    public Paciente salvar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));
        String query = String.format(
                "INSERT INTO paciente " +
                        "(nome, sobrenome, cpf, data_cadastro, endereco_id) " +
                        "VALUES('%s', '%s', '%s', '%s', '%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getCpf(),
                Util.dateToTimestamp(paciente.getDataCadastro()),
                paciente.getEndereco().getId());

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
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("SELECT id, nome, sobrenome, cpf, data_cadastro, endereco_id " +
                "FROM paciente WHERE id = '%s'", id);
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
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("DELETE FROM paciente WHERE id = '%s'", id);
        execute(connection, query);

    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = "SELECT * FROM paciente";
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
       Connection connection = configuracaoJDBC.conectarDB();
       Statement stmt = null;
       if(paciente.getEndereco() != null && paciente.getId() != null) {
           enderecoDaoH2.atualizar(paciente.getEndereco());
       }

       String query = String.format("UPDATE paciente SET " +
               "nome = '%s', " +
               "sobrenome = '%s', " +
               "data_cadastro = '%s', " +
               "endereco_id = '%s'" +
               "WHERE id = '%s'",
               paciente.getNome(),
               paciente.getSobrenome(),
               paciente.getDataCadastro(),
               paciente.getEndereco());

        execute(connection, query);
        return paciente;
    }

    private Paciente criarObjetoPaciente(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        String cpf = resultSet.getString("cpf");
        Date  data_cadastro = resultSet.getDate("data_cadastro");
        Endereco endereco_id = enderecoDaoH2.buscar(resultSet.getInt("endereco_id")).orElse(null);
        return new Paciente(id, nome, sobrenome, cpf, data_cadastro, endereco_id);

    }

    private void execute(Connection connection, String query) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
