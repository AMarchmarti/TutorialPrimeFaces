package org.brujula.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void conect()throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConexion(DriverManager.getConnection("jdbc:mysql://localhost:3306/primefaces_tuto" +
                    "?user=root&password=root&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC"));
        }catch (SQLException e){
             e.printStackTrace();
        }
    }

    public void closed() throws Exception {
        try{
            if ((getConexion() != null) &&(!getConexion().isClosed())){
                getConexion().close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
