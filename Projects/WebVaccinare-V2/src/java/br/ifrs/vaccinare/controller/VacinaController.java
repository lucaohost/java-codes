package br.ifrs.vaccinare.controller;

import br.ifrs.vaccinare.dao.VacinaDAO;
import static br.ifrs.vaccinare.model.CriancaVacina_.vacina;
import br.ifrs.vaccinare.model.ServerResponse;
import br.ifrs.vaccinare.model.Vacina;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.hibernate.Hibernate;

@WebServlet(name = "VacinaController", urlPatterns = {"/VacinaController"})
public class VacinaController extends HttpServlet {

    private static String LOGIN = "/login.jsp";
    private static String HOME = "/home.jsp";
    private static String ERRO = "/erro.jsp";
    private static String CADASTRO = "/cadvacinas.jsp";
    private static String LISTAGEM = "/listvacinas.jsp";

    private final VacinaDAO dao;

    public VacinaController() {
        super();
        
        this.dao = new VacinaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (!UsuarioController.verificaAcesso(request)) {
                forward = LOGIN;
                request.setAttribute("mensagem", "Usuário não autorizado");
            } else {
                String acao = request.getParameter("acao").toLowerCase();

                if (acao.equalsIgnoreCase("atualizar")) {
                    Long idVacina = Long.parseLong(request.getParameter("id"));
                    Vacina vacinaDB = this.dao.obter(idVacina);
                    forward = CADASTRO;
                    request.setAttribute("vacina", vacinaDB);
                }
                if (acao.equalsIgnoreCase("excluir")) {
                    Long idVacinaDB = Long.parseLong(request.getParameter("id"));
                    this.dao.excluir(idVacinaDB);
                    forward = LISTAGEM;
                    String mensagem = "<div class='alert alert-success'>"
                            + "<strong>Sucesso!</strong> Vacina apagada com sucesso!"
                            + "</div>";
                    request.setAttribute("mensagem", mensagem);
                }
                if (acao.equalsIgnoreCase("verficarVacinas")) {
                    String nomeVacina = request.getParameter("nome");
                    List<Vacina> vacinaDB = this.dao.pesquisar(nomeVacina);
                    forward = "";
                    Gson gsonObj = new Gson();
                    ServerResponse serverResponse = new ServerResponse();
                    String json;
                    if (!vacinaDB.isEmpty()) {
                        serverResponse.message = "Vacina já existe";
                        json = gsonObj.toJson(serverResponse);
                    } else {
                        serverResponse.message = "";
                        json = gsonObj.toJson(serverResponse);
                    }
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                }
            }
        } catch (Exception ex) {
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
        } finally {
            if (!forward.equals("")) {
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (!UsuarioController.verificaAcesso(request)) {
                forward = LOGIN;
                request.setAttribute("mensagem", "Usuário não autorizado");
            } else {
                if (request.getParameter("nome_pesquisa") != null) {
                    String nomePesquisa = request.getParameter("nome_pesquisa");
                    List<Vacina> vacinas = this.dao.pesquisar(nomePesquisa);
                    forward = "";
                    Gson gsonObj = new Gson();
                    ServerResponse serverResponse = new ServerResponse();
                    String jsonVacinas = gsonObj.toJson(vacinas);
                    serverResponse.message = jsonVacinas;
                    String json = gsonObj.toJson(serverResponse);
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                } else if (request.getParameter("nome") != null) {
                    Vacina vacina = new Vacina();
                    preencheModel(request, vacina);
                    String mensagem = "";
                    if (vacina.getId() != null) {
                        this.dao.atualizar(vacina);
                        mensagem = "<div class='alert alert-success'>"
                                + "<strong>Sucesso!</strong> Vacina atualizada com sucesso!"
                                + "</div>";
                        forward = CADASTRO;
                    } else {
                        this.dao.salvar(vacina);
                        mensagem = "<div class='alert alert-success'>"
                                + "<strong>Sucesso!</strong> Nova vacina criada com sucesso!"
                                + "</div>";
                        forward = LISTAGEM;
                    }
                    request.setAttribute("mensagem", mensagem);
                }
            }
        } catch (Exception ex) {
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
        } finally {
            if (!forward.equals("")) {
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }
        }
    }

    private void preencheModel(HttpServletRequest request, Vacina vacina) {
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            vacina.setId(Long.parseLong(request.getParameter("id")));
        }
        vacina.setNome(request.getParameter("nome"));
        vacina.setAbreviatura(request.getParameter("abreviatura"));
        vacina.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
    }
}
