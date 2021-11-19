package com.example.demo.repository.impl;

import com.example.demo.model.Dentista;
import com.example.demo.repository.IDao;
import com.example.demo.repository.configuracao.ConfiguracaoJDBC;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DentistaDaoH2 implements IDao<Dentista> {

    private final ConfiguracaoJDBC configuracaoJDBC;


    public DentistaDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("" +
                "INSERT INTO dentista " +
                "(nome, sobrenome, matricula) " +
                "VALUES " +
                "('%s','%s','%s')",
                dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula());

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                dentista.setId(keys.getInt(1));
            }
            stmt.close();
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }

    @Override
    public Optional<Dentista> buscar(Integer id) {
       Connection connection = configuracaoJDBC.conectarDB();
       Statement stmt = null;
       String query = String.format("SELECT id, nome, sobrenome, matricula FROM dentista WHERE id = '%s'", id);
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
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("DELETE FROM dentista where id = '%s'", id);
        execute(connection, query);
    }

    @Override
    public List<Dentista> buscarTodos() {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()) {
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
        Connection connection = configuracaoJDBC.conectarDB();
        String query = String.format("UPDATE dentista SET " +
                        "nome = '%s', sobrenome = '%s',matricula = '%s' " +
                        "WHERE id = '%s'",
                dentista.getNome(), dentista.getSobrenome(),
                dentista.getMatricula(), dentista.getId());

        execute(connection, query);
        return dentista;
    }

    private Dentista criarObjetoDentista(ResultSet resultSet) throws SQLException {
        return new Dentista(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("sobrenome"),
                resultSet.getString("matricula"));
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
