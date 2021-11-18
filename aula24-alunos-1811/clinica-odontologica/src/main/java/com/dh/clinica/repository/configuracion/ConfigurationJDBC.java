package com.dh.clinica.repository.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senhaUsuario;



    public Connection conectarComBancoDeDados() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senhaUsuario);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return connection;
    }


    //Podemos usar este constructor para nos conectar com outra configuração
    public ConfigurationJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senhaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public ConfigurationJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:mem:clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nomeUsuario = "sa";
        this.senhaUsuario = "";
    }




}
