package br.ifrs.vaccinare.controller;

import br.ifrs.vaccinare.dao.CriancaDAO;
import br.ifrs.vaccinare.dao.VacinaDAO;
import br.ifrs.vaccinare.dao.VacinacaoDAO;
import br.ifrs.vaccinare.model.Crianca;
import br.ifrs.vaccinare.model.CriancaVacina;
import br.ifrs.vaccinare.model.Vacina;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VacinacaoController", urlPatterns = {"/VacinacaoController"})
public class VacinacaoController extends HttpServlet {

    private static String LOGIN = "/login.jsp";
    private static String CADASTRO = "/cadvacina.jsp";
    private static String LISTAGEM = "/listvacina.jsp";
    private static String DETALHES = "/detalhevacina.jsp";
    private static String ERRO = "/erro.jsp";

    private final VacinacaoDAO vacinacaoDAO;
    private final VacinaDAO vacinaDAO;
    private final CriancaDAO criancaDAO;

    public VacinacaoController() {
        super();
        
        this.vacinacaoDAO = new VacinacaoDAO();
        this.vacinaDAO = new VacinaDAO();
        this.criancaDAO = new CriancaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (UsuarioController.verificaAcesso(request) == false) {
                forward = LOGIN;
                String mensagem = "<div class='alert alert-warning'>"
                        + "<strong>Aviso!</strong> Acesso não autorizado!"
                        + "</div>";
                request.setAttribute("mensagem", mensagem);
            } else {

                String acao = "";
                
                if (request.getParameter("acao") != null) {
                    acao = request.getParameter("acao").toLowerCase();
                }
                
                switch (acao) {
                    case "detalhes":
                        
                        if (UsuarioController.verificaAcesso(request) == false) {
                            forward = LOGIN;
                            String mensagem = "<div class='alert alert-warning'>"
                                    + "<strong>Aviso!</strong> Acesso não autorizado!"
                                    + "</div>";
                            request.setAttribute("mensagem", mensagem);
                            
                            RequestDispatcher view = request.getRequestDispatcher(forward);
                            view.forward(request, response);
                        } else {
                            
                            Long idCrianca = Long.parseLong(request.getParameter("id"));
                            
                            List<Object[]> vacinacoes = this.vacinacaoDAO.obter(idCrianca);
                            
                            forward = DETALHES;
                            request.setAttribute("crianca", vacinacoes.get(0)[3]);
                            request.setAttribute("vacinacoes", vacinacoes);
                            
                            RequestDispatcher view = request.getRequestDispatcher(forward);
                            view.forward(request, response);
                        }
                        break;
                    case "verficarVacinas":
                        if (UsuarioController.verificaAcesso(request) == false) {
                            forward = LOGIN;
                            String mensagem = "<div class='alert alert-warning'>"
                                    + "<strong>Aviso!</strong> Acesso não autorizado!"
                                    + "</div>";
                            request.setAttribute("mensagem", mensagem);
                            RequestDispatcher view = request.getRequestDispatcher(forward);
                            view.forward(request, response);
                        } else {
                            Long idCrianca = Long.parseLong(request.getParameter("id"));
                            List<Object[]> vacinacoes = this.vacinacaoDAO.obter(idCrianca);
                            forward = DETALHES;
                            request.setAttribute("crianca", vacinacoes.get(0)[3]);
                            request.setAttribute("vacinacoes", vacinacoes);
                            RequestDispatcher view = request.getRequestDispatcher(forward);
                            view.forward(request, response);
                        }
                        break;
                    default:
                        

                        
                        List<Crianca> criancas = this.criancaDAO.pesquisar();

                        
                        List<Vacina> vacinas = this.vacinaDAO.pesquisar("");

                        
                        request.setAttribute("criancas", criancas);
                        request.setAttribute("vacinas", vacinas);
                        break;
                }

            }
        } catch (Exception ex) {
            
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";

        try {
            
            if (UsuarioController.verificaAcesso(request) == false) {
                forward = LOGIN;
                String mensagem = "<div class='alert alert-warning'>"
                        + "<strong>Aviso!</strong> Acesso não autorizado!"
                        + "</div>";
                request.setAttribute("mensagem", mensagem);
            } else {
                if (request.getParameter("nome_pesquisa") != null) {
                    
                    String nomePesquisa = request.getParameter("nome_pesquisa");
                    
                    List<Object[]> vacinacoes = this.vacinacaoDAO.pesquisar(nomePesquisa);
                    
                    forward = LISTAGEM;
                    request.setAttribute("vacinacoes", vacinacoes);
                } else {
                    

                    
                    CriancaVacina criancaVacina = new CriancaVacina();
                    criancaVacina.getCrianca().setId(Long.parseLong(request.getParameter("crianca")));
                    criancaVacina.getVacina().setId(Long.parseLong(request.getParameter("vacina")));
                    criancaVacina.setLote(request.getParameter("lote"));
                    criancaVacina.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
                    this.vacinacaoDAO.salvar(criancaVacina);

                    String mensagem = "";

                    
                    
                    mensagem = "<div class='alert alert-success'>"
                            + "<strong>Sucesso!</strong> Nova vacinação criada com sucesso!"
                            + "</div>";

                    
                    forward = LISTAGEM;
                    request.setAttribute("mensagem", mensagem);

                }
            }
        } catch (Exception ex) {
            
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
        } finally {
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);

        }
    }

}
