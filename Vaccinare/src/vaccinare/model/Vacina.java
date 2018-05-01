/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author lucas.270498
 */
public class Vacina implements IModel{

    private int id;
    private long numeroLote;
    private String nomeVacina;
    private Date dataValidade;
    private String fornecedor;

    public Vacina() {
    }

    public Vacina(int id, long numeroLote, String nomeVacina, Date dataValidade, String fornecedor) {
        this.id = id;
        this.numeroLote = numeroLote;
        this.nomeVacina = nomeVacina;
        this.dataValidade = dataValidade;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public void insert() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call INSERTVACINA (?,?,?,?)}");
        cstmt.setLong(1, this.numeroLote);
        cstmt.setString(2, this.nomeVacina);
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dataValidadeFormated = sdf.format(this.dataValidade);
        cstmt.setDate(3, this.dataValidade);
        cstmt.setString(4, this.fornecedor);
        //Executa o comando SQL
        try {
            cstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        cstmt.close();
    }

    /**
     *
     * @param nomeVacina
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Vacina> select(String nomeVacina) throws SQLException, ClassNotFoundException {
        ArrayList<Vacina> vacinas = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTVACINA (?)}");
        cstmt.setString(1, "%" + nomeVacina + "%");
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
            //Crio uma crianca para adicionar no array de crianças
            Vacina v = new Vacina();
            v.setId(rs.getInt("id"));
            v.setNomeVacina(rs.getString("nome_vacina"));
            v.setNumeroLote(rs.getInt("numero_lote"));
            v.setDataValidade(rs.getDate("data_validade"));
            v.setFornecedor(rs.getString("fornecedor"));
            vacinas.add(v);
        }
        cstmt.close();
        return vacinas;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void update() throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call UPDATEVACINA (?,?,?,?,?)}");
        cstmt.setString(1, this.nomeVacina);
        cstmt.setLong(2, this.numeroLote);
        cstmt.setDate(3, this.dataValidade);
        cstmt.setString(4, this.fornecedor);
        cstmt.setInt(5, this.id);
        cstmt.executeUpdate();
        cstmt.close();
    }

    public void delete() throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call DELETEVACINA (?)}");
        cstmt.setInt(1, this.id);
        cstmt.executeUpdate();
        cstmt.close();
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void selectAttributes(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTATTRIBUTESVACINA (?)}");
        cstmt.setInt(1, id);
        ResultSet rs = cstmt.executeQuery();
        if (rs.next()) {

            this.id = rs.getInt("id");
            this.nomeVacina = rs.getString("nome_vacina");
            this.numeroLote = rs.getLong("numero_lote");
            this.dataValidade = rs.getDate("data_validade");
            this.fornecedor = rs.getString("fornecedor");

        }
        cstmt.close();
    }
}
