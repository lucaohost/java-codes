/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.controller;

import br.ifrs.vaccinare.dao.CriancaDAO;
import br.ifrs.vaccinare.model.Crianca;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mauricio.rosito
 */
@WebServlet(name = "CriancaController", urlPatterns = {"/CriancaController"})
public class CriancaController extends HttpServlet {

    private static String CADASTRO = "/cadcrianca.jsp";
    private static String LISTAGEM = "/listcrianca.jsp";
    private static String ERRO = "/erro.jsp";
    private static String EDICAO = "/cadcrianca.jsp";
    
    private final CriancaDAO dao;

    public CriancaController() {
        super();
        //Cria a classe DAO
        this.dao = new CriancaDAO();        
    }
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
       String forward = "";
        try{
            
            //Recebe os dados da URL
            Long idCrianca = Long.parseLong(request.getParameter("id"));
            String acao = request.getParameter("acao").toLowerCase();

            //Verifica qual ação deve realizar
            if(acao.equalsIgnoreCase("excluir")){
                //Exclui a criança da base de dados
                this.dao.excluir(idCrianca);
                //Define a página e atributos para redirecionar o site
                forward = LISTAGEM;        
                String mensagem = "<div class='alert alert-success'>"+ 
                                  "<strong>Sucesso!</strong> Criança apagada com sucesso!" +
                                  "</div>";
                request.setAttribute("mensagem", mensagem); 
     

            }
            
            if(acao.equalsIgnoreCase("abriredicao")){
                Crianca crianca = this.dao.pesquisarPorId(idCrianca);
                forward = EDICAO;
                request.setAttribute("crianca", crianca);
            }
        }
        catch(Exception ex){
            //Define a página e atributos para redirecionar o site
            forward = ERRO;        
            request.setAttribute("mensagem", ex.toString());    
        }finally{
            //Redireciona para a página correta
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        
        try{
            if(request.getParameter("nome_pesquisa")!=null){
                // Pesquisa por nome da criança
                String nomePesquisa = request.getParameter("nome_pesquisa");
                //Pesquisa pelo nome das crianças
                List<Crianca> criancas = this.dao.pesquisar(nomePesquisa);
                //Define a página e atributos para redirecionar o site
                forward = LISTAGEM;                 
                request.setAttribute("criancas", criancas);
                
                String pesquisou = "S";
                request.setAttribute("pesquisou", pesquisou);    
            }else{
                //Inserir  criança

                //Cria a classe MODEL
                Crianca crianca = new Crianca();
                //Recebe os dados do formulário e salva na MODEL
                crianca.setNome(request.getParameter("nome"));
                crianca.setIdade(Integer.parseInt(request.getParameter("idade")));
                crianca.setSexo(request.getParameter("sexo").charAt(0));

                String mensagem = "";

                //Insere uma nova criança na base de dados
                this.dao.salvar(crianca);
                mensagem = "<div class='alert alert-success'>"+ 
                           "<strong>Sucesso!</strong> Nova criança criada com sucesso!" +
                           "</div>";                

                //Define a página e atributos para redirecionar o site
                forward = CADASTRO;        
                request.setAttribute("mensagem", mensagem);    
            }
        }
        catch(Exception ex){
            //Define a página e atributos para redirecionar o site
            forward = ERRO;        
            request.setAttribute("mensagem", ex.toString());    
        }finally{
            //Redireciona para a página correta
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }    
   
}
