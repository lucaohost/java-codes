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

@WebServlet(name = "CriancaController", urlPatterns = {"/CriancaController"})
public class CriancaController extends HttpServlet {
    private static String LOGIN = "/login.jsp";
    private static String CADASTRO = "/cadcrianca.jsp";
    private static String LISTAGEM = "/listcrianca.jsp";
    private static String ERRO = "/erro.jsp";
    
    private final CriancaDAO dao;

    public CriancaController() {
        super();
        
        this.dao = new CriancaDAO();        
    }
      
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String forward = "";
        try{
            
            
            if(UsuarioController.verificaAcesso(request)==false)
            {
                forward = LOGIN;        
                String mensagem = "<div class='alert alert-warning'>"+ 
                                   "<strong>Aviso!</strong> Acesso não autorizado!" +
                                   "</div>";
                request.setAttribute("mensagem", mensagem);    
            }else{
                
            
                
                Long idCrianca = Long.parseLong(request.getParameter("id"));
                String acao = request.getParameter("acao").toLowerCase();

                
                switch(acao){
                    case "atualizar": 
                        
                        Crianca crianca = this.dao.obter(idCrianca);
                        
                        forward = CADASTRO;        
                        request.setAttribute("crianca", crianca);    
                        break;
                    case "excluir": 
                        
                        this.dao.excluir(idCrianca);
                        
                        forward = LISTAGEM;        
                        String mensagem = "<div class='alert alert-success'>"+ 
                                          "<strong>Sucesso!</strong> Criança apagada com sucesso!" +
                                          "</div>";
                        request.setAttribute("mensagem", mensagem); 
                        break;
                    }
            }
        }
        catch(Exception ex){
            
            forward = ERRO;        
            request.setAttribute("mensagem", ex.toString());    
        }finally{
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        
        try{
            
            
            if(UsuarioController.verificaAcesso(request)==false)
            {
                forward = LOGIN;        
                String mensagem = "<div class='alert alert-warning'>"+ 
                                   "<strong>Aviso!</strong> Acesso não autorizado!" +
                                   "</div>";
                request.setAttribute("mensagem", mensagem);    
            }else{
                
            
                if(request.getParameter("nome_pesquisa")!=null){
                    
                    String nomePesquisa = request.getParameter("nome_pesquisa");
                    
                    List<Crianca> criancas = this.dao.pesquisar(nomePesquisa);
                    
                    forward = LISTAGEM;                 
                    request.setAttribute("criancas", criancas);    
                }else{
                    

                    
                    Crianca crianca = new Crianca();
                    
                    preencheModel(request,crianca);                    
                    String mensagem = "";
                    if(crianca.getId()!=null){
                        
                        this.dao.atualizar(crianca);
                        mensagem = "<div class='alert alert-success'>"+ 
                                   "<strong>Sucesso!</strong> Criança atualizada com sucesso!" +
                                   "</div>";                
                    }else{
                        
                        this.dao.salvar(crianca);
                        mensagem = "<div class='alert alert-success'>"+ 
                                   "<strong>Sucesso!</strong> Nova criança criada com sucesso!" +
                                   "</div>";                
                    }
                    
                    forward = CADASTRO;        
                    request.setAttribute("mensagem", mensagem);    
                }
            }
        }
        catch(Exception ex){
            
            forward = ERRO;        
            request.setAttribute("mensagem", ex.toString());    
        }finally{
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }
    
    private void preencheModel(HttpServletRequest request,Crianca crianca){
        
        if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
            crianca.setId(Long.parseLong(request.getParameter("id")));
        }
        crianca.setNome(request.getParameter("nome"));
        crianca.setIdade(Integer.parseInt(request.getParameter("idade")));
        crianca.setSexo(request.getParameter("sexo"));
        crianca.setParto((request.getParameter("parto")!=null)?true:false);
        crianca.setEtnia(request.getParameter("etnia"));
        crianca.setMae(request.getParameter("mae"));
        crianca.setEmail(request.getParameter("email"));
        crianca.setTelefone(request.getParameter("telefone"));
    }

}
