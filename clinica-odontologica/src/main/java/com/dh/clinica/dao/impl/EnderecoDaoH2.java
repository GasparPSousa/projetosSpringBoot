package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.IDao;
import com.dh.clinica.dao.configuration.ConfigurationJDBC;
import com.dh.clinica.model.Endereco;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoH2 implements IDao<Endereco> {
    private ConfigurationJDBC configurationJDBC;

    public EnderecoDaoH2() {
        this.configurationJDBC = new ConfigurationJDBC();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("INSERT INTO endereco(rua,numero,cidade,estado) VALUES('%s','%s','%s','%s')", endereco.getRua(),
                endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
           ResultSet keys = stmt.getGeneratedKeys();
           if(keys.next())
               endereco.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("SELECT id,rua,numero,cidade,estado FROM endereco where id = '%s'", id);
        Endereco endereco = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                endereco = criarObjetoEndereco(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public void remover(Integer id) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM endereco where id = %s", id);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT *  FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                enderecos.add(criarObjetoEndereco(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        String query = String.format("UPDATE endereco SET rua = '%s', numero = '%s',cidade = '%s',estado = '%s'  WHERE id = '%s'",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getId());
        execute(connection, query);
        return endereco;
    }

    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");
        return new Endereco(id, rua, numero, cidade, estado);

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
