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
public class Crianca implements IModel{

    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private boolean partoNatural;
    private String nomeMae;
    private String etnia;

    public Crianca() {
    }

    public Crianca(String nome, int idade, String sexo, boolean partoNatural, String nomeMae, String etnia) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.partoNatural = partoNatural;
        this.nomeMae = nomeMae;
        this.etnia = etnia;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isPartoNatural() {
        return partoNatural;
    }

    public void setPartoNatural(boolean partoNatural) {
        this.partoNatural = partoNatural;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void insert() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call INSERTCRIANCA (?,?,?,?,?,?)}");
        cstmt.setString(1, this.nome);
        cstmt.setInt(2, this.idade);
        cstmt.setString(3, this.sexo);
        cstmt.setBoolean(4, this.partoNatural);
        cstmt.setString(5, this.nomeMae);
        cstmt.setString(6, this.etnia);
        //Executa o comando SQL
        try {
            cstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        cstmt.close();
    }

    public ArrayList<Crianca> select(String nome) throws SQLException, ClassNotFoundException {
        ArrayList<Crianca> criancas = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTCRIANCA (?)}");
        cstmt.setString(1, "%" + nome + "%");
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
            //Crio uma crianca para adicionar no array de crianças
            Crianca c = new Crianca();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setIdade(rs.getInt("idade"));
            c.setSexo(rs.getString("sexo"));
            c.setPartoNatural(rs.getBoolean("parto_natural"));
            c.setNomeMae(rs.getString("nome_mae"));
            c.setEtnia(rs.getString("etnia"));
            criancas.add(c);
        }
        cstmt.close();
        return criancas;
    }

    public void update() throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call UPDATECRIANCA (?,?,?,?,?,?,?)}");
        cstmt.setString(1, this.nome);
        cstmt.setInt(2, this.idade);
        cstmt.setString(3, this.sexo);
        cstmt.setBoolean(4, this.partoNatural);
        cstmt.setString(5, this.nomeMae);
        cstmt.setString(6, this.etnia);
        cstmt.setInt(7, this.id);
        cstmt.executeUpdate();
        cstmt.close();
    }

    public void delete() throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call DELETECRIANCA (?)}");
        cstmt.setInt(1, this.id);
        cstmt.executeUpdate();
        cstmt.close();
    }

    public void selectAttributes(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTATTRIBUTESCRIANCA (?)}");
        cstmt.setInt(1, id);
        ResultSet rs = cstmt.executeQuery();
        if (rs.next()) {

            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.sexo = rs.getString("sexo");
            this.partoNatural = rs.getBoolean("parto_natural");
            this.nomeMae = rs.getString("nome_mae");
            this.etnia = rs.getString("etnia");

        }
    }
}
