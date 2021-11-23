package com.dentista.sabado.repository.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConfigDB {

        private String jdbcDriver;
        private String dbUrl;
        private String nomeUsuario;
        private String senhaUsuario;

        public ConfigDB(String jdbcDriver, String dbUrl, String nomeUsuario, String senhaUsuario) {
            this.jdbcDriver = jdbcDriver;
            this.dbUrl = dbUrl;
            this.nomeUsuario = nomeUsuario;
            this.senhaUsuario = senhaUsuario;
        }

        public ConfigDB() {
            this.jdbcDriver = "org.h2.Driver";
            this.dbUrl = "jdbc:h2:mem:clinica7;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
            this.nomeUsuario = "sa";
            this.senhaUsuario = "";
        }

        public Connection conectarComBancoDeDados() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(dbUrl, nomeUsuario, senhaUsuario);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }
}
