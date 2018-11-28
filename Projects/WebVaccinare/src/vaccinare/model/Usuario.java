/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas.270498
 */
public class Usuario implements IModel{

    private int id;
    private String login;
    private String senha;
    public static int authId;
    public static String authName;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean select() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTUSUARIO (?)}");
        cstmt.setString(1, this.login);
        ResultSet rs = cstmt.executeQuery();
        Usuario usuarioAuth = new Usuario();
        while (rs.next()) {
            usuarioAuth.setId(rs.getInt("id"));
            usuarioAuth.setLogin(rs.getString("login"));
            usuarioAuth.setSenha(rs.getString("senha"));
        }
        cstmt.close();
        if(this.login.equals(usuarioAuth.getLogin()) && this.senha.equals(usuarioAuth.senha)){
            Usuario.authId = usuarioAuth.id;
            Usuario.authName = usuarioAuth.login;
            return true;
        }
        return false;
        
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> select(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void selectAttributes(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
