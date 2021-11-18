package com.dh.clinica.repository.impl;

import com.dh.clinica.repository.IDao;
import com.dh.clinica.repository.configuracion.ConfigurationJDBC;
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
        String query = String.format("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES('%s','%s','%s','%s')", endereco.getRua(),
                endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
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
        String query = String.format("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = '%s'", id);
        Endereco endereco = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                endereco = crearObjetoDomicilio(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM domicilios where id = %s", id);
        execute(connection, query);


    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT *  FROM domicilios";
        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                enderecos.add(crearObjetoDomicilio(result));

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
        String query = String.format("UPDATE domicilios SET calle = '%s', numero = '%s',localidad = '%s',provincia = '%s'  WHERE id = '%s'",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getId());
        execute(connection, query);
        return endereco;
    }

    private Endereco crearObjetoDomicilio(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String calle = result.getString("calle");
        String numero = result.getString("numero");
        String localidad = result.getString("localidad");
        String provincia = result.getString("provincia");
        return new Endereco(id, calle, numero, localidad, provincia);

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
