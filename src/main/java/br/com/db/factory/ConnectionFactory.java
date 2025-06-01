package br.com.db.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =  "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String LOGIN = "RM550445";
    private static final String PASSWORD = "271000";

    //RM98185
    //070696

    //metodo para obter uma conexao com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,LOGIN, PASSWORD);
    }

}
