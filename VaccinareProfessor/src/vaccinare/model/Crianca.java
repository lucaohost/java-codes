/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mauricio.rosito
 */
public class Crianca {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private boolean partoNatural;
    private String mae;
    private String etnia;

    private ConnectionFactory cf;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public Crianca() {
        this.cf = new ConnectionFactory();
    }

    public Crianca(int id, String nome, int idade, String sexo, boolean partoNatural, String mae, String etnia) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.partoNatural = partoNatural;
        this.mae = mae;
        this.etnia = etnia;
        
        this.cf = new ConnectionFactory();
    }

    
    public void excluir() throws Exception {
        //Cria a conexão com o banco de dados
        Connection con = this.cf.getConnection();
        //Define o comando SQL
        String sql = " DELETE FROM crianca WHERE id= ? ";
        //Cria o PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, this.id);
        //Executa o comando SQL
        pstmt.executeUpdate();
        System.out.println("Criança excluída com sucesso!");
        //Fecha os objetos de banco de dados
        this.cf.close(con, pstmt, null);      
    }
    
    public void atualizar() throws Exception {
        //Cria a conexão com o banco de dados
        Connection con = this.cf.getConnection();
        //Define o comando SQL
        String sql = " UPDATE crianca SET ";
              sql += " nome = ?, ";
              sql += " idade = ?, ";
              sql += " sexo = ?, ";
              sql += " parto_natural = ?, ";
              sql += " mae = ?, ";
              sql += " etnia = ? ";
              sql += " WHERE id = ? ";
              
        //Cria o PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, this.nome);
        pstmt.setInt(2, this.idade);
        pstmt.setString(3, this.sexo);
        pstmt.setBoolean(4, this.partoNatural);
        pstmt.setString(5, this.mae);
        pstmt.setString(6, this.etnia);
        pstmt.setInt(7, this.id);
        
        //Executa o comando SQL
        pstmt.executeUpdate();
        System.out.println("Criança atualizada com sucesso!");
        //Fecha os objetos de banco de dados
        this.cf.close(con, pstmt, null); 

    }

    public void inserir() throws Exception {

        //Cria a conexão com o banco de dados
        Connection con = this.cf.getConnection();
        //Define o comando SQL
        String sql = " INSERT INTO crianca (nome, idade, sexo, parto_natural,mae, etnia) VALUES (?,?,?,?,?,?)";
        //Cria o PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, this.nome);
        pstmt.setInt(2, this.idade);
        pstmt.setString(3, this.sexo);
        pstmt.setBoolean(4, this.partoNatural);
        pstmt.setString(5, this.mae);
        pstmt.setString(6, this.etnia);
        //Executa o comando SQL
        pstmt.executeUpdate();
        System.out.println("Criança cadastrada com sucesso!");
        //Fecha os objetos de banco de dados
        this.cf.close(con, pstmt, null);  


    }

    public ArrayList<Crianca> listar(String nome) throws Exception {
        //Cria array de Crianca
        ArrayList<Crianca> criancas = new ArrayList<>();
        //Cria a conexão com o banco de dados
        Connection con = this.cf.getConnection();
        //Define o comando SQL
        String sql = " Select * from crianca ";
              sql += " WHERE nome LIKE ? ";
              sql += " ORDER BY nome ASC ";
        
        //Cria o PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, "%"+nome+"%");
        //Executa o comando SQL
        ResultSet rs = pstmt.executeQuery();

        // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados  
        while (rs.next()) {
            //Crio uma crianca para adicionar no array de crianças
            Crianca c = new Crianca();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setIdade(rs.getInt("idade"));
            c.setSexo(rs.getString("sexo"));
            c.setPartoNatural(rs.getBoolean("parto_natural"));
            c.setMae(rs.getString("mae"));
            c.setEtnia(rs.getString("etnia"));
            
            //Adiciono esta criança no array
            criancas.add(c);

        }

        //Fecha os objetos de banco de dados
        this.cf.close(con, pstmt, rs);
        //retorna o array de criancas
        return criancas;
    }
    
    public void buscar(int id) throws Exception {
        //Cria a conexão com o banco de dados
        Connection con = this.cf.getConnection();
        //Define o comando SQL
        String sql = "Select * from crianca ";
              sql += " Where id = ? ";
        
        //Cria o PreparedStatement
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        //Executa o comando SQL
        ResultSet rs = pstmt.executeQuery();

        // O método next() informa se houve resultados e posiciona o cursor do banco  
        // na próxima linha disponível para recuperação  
        // Como esperamos várias linhas utilizamos um laço para recuperar os dados  
        if (rs.next()) {
            
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.sexo = rs.getString("sexo");
            this.partoNatural = rs.getBoolean("parto_natural");
            this.mae = rs.getString("mae");
            this.etnia = rs.getString("etnia");
            
        }

        //Fecha os objetos de banco de dados
        this.cf.close(con, pstmt, rs);      
    }
    
    
}
