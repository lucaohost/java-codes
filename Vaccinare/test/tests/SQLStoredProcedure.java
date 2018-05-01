package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import vaccinare.model.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio.rosito
 */
public class SQLStoredProcedure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            Connection con = null;
            con = DBConnection.getConnection();
           
            CallableStatement cstmt = 
                    con.prepareCall("{call MULTIPLY(?, ?, ?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setInt(2, 4);
            cstmt.setInt(3, 8);
            cstmt.execute();
            int result = cstmt.getInt(1);
            
            System.out.println(result);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
