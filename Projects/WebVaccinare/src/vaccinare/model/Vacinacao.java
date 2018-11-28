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
public class Vacinacao implements IModel{

    private int id;
    private Vacina vacina;
    private Date dataAplicacao;
    private Usuario aplicador;
    private Crianca crianca;

    public Vacinacao() {
    }

    public Vacinacao(Vacina vacina, Date dataAplicacao, Usuario aplicador, Crianca crianca) {
        this.vacina = vacina;
        this.dataAplicacao = dataAplicacao;
        this.aplicador = aplicador;
        this.crianca = crianca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Usuario getAplicador() {
        return aplicador;
    }

    public void setAplicador(Usuario aplicador) {
        this.aplicador = aplicador;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }
    

    /**
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void insert() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call INSERTVACINACAO (?,?,?,?)}");
        cstmt.setInt(1, this.vacina.getId());
        cstmt.setDate(2, this.dataAplicacao);
        cstmt.setInt(3, this.aplicador.getId());
        cstmt.setInt(4, this.crianca.getId());
        //Executa o comando SQL
        try {
            cstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        cstmt.close();
    }

    public ArrayList<Vacinacao> select(String nomeCrianca) throws SQLException, ClassNotFoundException {
        ArrayList<Vacinacao> vacinacoes = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTVACINACOES (?)}");
        cstmt.setString(1, "%" + nomeCrianca + "%");
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
            //Crio uma crianca para adicionar no array de crianças
            Vacinacao vc = new Vacinacao();
            Usuario u = new Usuario();
            Crianca c = new Crianca();
            vc.setId(rs.getInt("id"));
            u.setLogin(rs.getString("login"));
            c.setNome(rs.getString("nome"));
            vc.setCrianca(c);
            vc.setAplicador(u);
            vacinacoes.add(vc);
        }
        return vacinacoes;
    }

    public void update() throws Exception {
        //Fiz prevenção de erros que impossibilita update desse objeto
    }

    public void delete() throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call DELETEVACINACAO (?)}");
        cstmt.setInt(1, this.id);
        cstmt.executeUpdate();
        cstmt.close();
    }

    public void selectAttributes(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{call SELECTATTRIBUTESVACINACAO (?)}");
        cstmt.setInt(1, id);
        ResultSet rs = cstmt.executeQuery();
        if (rs.next()) {
              Vacinacao vc = new Vacinacao();
              Usuario u = new Usuario();
              Crianca c = new Crianca();
              Vacina v =  new Vacina();
            this.id = rs.getInt("vacinacao_id");
            c.setId(rs.getInt("crianca_id"));
            v.setId(rs.getInt("vacina_id"));
            u.setId(rs.getInt("user_id"));
            v.setNomeVacina(rs.getString("nome_vacina"));
            this.dataAplicacao = rs.getDate("data_aplicacao");
            u.setLogin(rs.getString("login"));
            c.setNome(rs.getString("nome"));
            vc.setCrianca(c);
            vc.setAplicador(u);
            vc.setVacina(v);
        }
    }
}
