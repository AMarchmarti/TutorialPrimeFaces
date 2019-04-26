package org.brujula.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void conect()throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/primefaces_tuto" +
                    "?user=root&password=root&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC"));
        }catch (SQLException e){
             e.printStackTrace();
        }
    }

    public void closed() throws Exception {
        try{
            if ((getConnection() != null) &&(!getConnection().isClosed())){
                getConnection().close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
