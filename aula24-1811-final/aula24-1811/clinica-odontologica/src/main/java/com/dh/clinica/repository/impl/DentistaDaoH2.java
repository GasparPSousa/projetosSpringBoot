package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Dentista;
import com.dh.clinica.repository.IDao;
import com.dh.clinica.repository.configuracion.ConfigurationJDBC;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfigurationJDBC configurationJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoH2.class);

    public DentistaDaoH2() {
        this.configurationJDBC = new ConfigurationJDBC();
    }
    public DentistaDaoH2(ConfigurationJDBC configurationJDBC) {
        this.configurationJDBC = configurationJDBC;
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        log.debug("Registrando novo dentista : "+ dentista.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("INSERT INTO dentista(nome,sobrenome,matricula) VALUES('%s','%s','%s')", dentista.getNome(), dentista.getSobrenome(),
                dentista.getMatricula());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return dentista;
    }

    @Override
    public Optional<Dentista> buscar(Integer id) {
        log.debug("Buscando dentista com id : "+id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("SELECT id,nome,sobrenome,matricula FROM dentista where id = '%s'", id);
        Dentista dentista = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                dentista = criarObjetoDentista(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Apagando dentista com id : "+id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM dentista where id = %s", id);
        execute(connection, query);

    }

    @Override
    public List<Dentista> buscarTodos() {
        log.debug("Buscando todos os dentistas");
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                dentistas.add(criarObjetoDentista(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dentistas;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();

        String query = String.format("UPDATE dentista SET nome = '%s', sobrenome = '%s',matricula = '%s' WHERE id = '%s'",
               dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula(), dentista.getId());
        execute(connection, query);
        return dentista;
    }

    private Dentista criarObjetoDentista(ResultSet resultSet) throws SQLException {

        return new Dentista(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("sobrenome"), resultSet.getInt("matricula"));
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
