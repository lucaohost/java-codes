/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mauricio.rosito
 */
public class ConnectionFactory {
    
    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/aluno_userDB";
    private final String USERNAME = "root";
    private final String PASSWORD = "aluno";
     
    public Connection getConnection(){
        Connection con = null;
        //Cria a conexão com o banco de dados
        try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           
        } catch (ClassNotFoundException | SQLException ex)  {
           System.out.println(ex.toString());
        }
        return con;
        
    }
    
    public void close(Connection con, Statement stmt, ResultSet rs){
        try {
            if (rs != null) rs.close( );
            if (stmt != null)stmt.close( );
            if (con != null)con.close( );
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
