package br.com.rodrigofeitosa.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private Connection conn = null;

    private String driver = "org.postgres.Driver";

    private final String user="postgres";
    private final String password="rodrodrigues10";
    private final String dburl="jdbc:postgresql://localhost:5432/db_agenda";

    public Connection getConnection() {

            try {

///               Boolean useSSL=false;
//               // Properties props = loadProperties();
//               // String url = props.getProperty("dburl");
//
//                // conn = DriverManager.getConnection(url, props);
//                conn = DriverManager.getConnection(dburl, user, password);

                Class.forName(driver);
                conn = DriverManager.getConnection(dburl, user, password);
               // return conn;
            } catch (Exception e) {
                throw new DBException(e.getMessage());
            }
        return conn;
    }

   /* public static void closeConnetion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }*/

    /*private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DBException(e.getMessage());
        }
    }*/

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }
}
