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
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucaxrl
 */
@WebServlet(name = "CriancaController", urlPatterns = {"/CriancaController"})
public class CriancaController extends HttpServlet {

    private static String CADASTRO = "/cadcrianca.jsp";
    private static String LISTAGEM = "/listcrianca.jsp";
    private static String CADASTROVACINA = "/cadvacina.jsp";
    private static String ERRO = "/erro.jsp";
    private static String EDICAO = "/cadcrianca.jsp";
    private static String LOGIN = "/login.jsp";

    private final CriancaDAO dao;

    public CriancaController() {
        super();
        this.dao = new CriancaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        try {
            String acao = request.getParameter("acao").toLowerCase();

            if (acao.equalsIgnoreCase("excluir")) {
                Long idCrianca = Long.parseLong(request.getParameter("id"));
                this.dao.excluir(idCrianca);
                forward = LISTAGEM;
                String mensagem = "<div class='alert alert-success'>"
                        + "<strong>Sucesso!</strong> Criança apagada com sucesso!"
                        + "</div>";
                request.setAttribute("mensagem", mensagem);
                this.listarCriancas(request, "");
            }

            if (acao.equalsIgnoreCase("abriredicao")) {
                Long idCrianca = Long.parseLong(request.getParameter("id"));
                Crianca crianca = this.dao.pesquisarPorId(idCrianca);
                forward = EDICAO;
                request.setAttribute("crianca", crianca);
                // problemas com validação de true e false no js
                char parto = crianca.isPartoNatural() ? 'S' : 'N';
                request.setAttribute("parto", parto);
            }

            if (acao.equalsIgnoreCase("listCriancas")) {
                forward = CADASTROVACINA;
                this.listarCriancas(request, "");
            }
        } catch (Exception ex) {
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
        } finally {
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";

        try {
            if (request.getParameter("nome_pesquisa") != null) {
                String nomePesquisa = request.getParameter("nome_pesquisa");
                forward = LISTAGEM;
                this.listarCriancas(request, nomePesquisa);
            } else {

                Crianca crianca = new Crianca();
                crianca.setNome(request.getParameter("nome"));
                crianca.setIdade(Integer.parseInt(request.getParameter("idade")));
                crianca.setSexo(request.getParameter("sexo").charAt(0));
                crianca.setEmail(request.getParameter("email"));
                crianca.setEtnia(request.getParameter("etnia").charAt(0));
                crianca.setNomeMae(request.getParameter("mae"));
                crianca.setTelefone(request.getParameter("telefone"));
                boolean partoNatural = request.getParameter("parto") != null ? true : false;
                crianca.setPartoNatural(partoNatural);

                String mensagem = "";
                if (request.getParameter("id").equals("")) {
                    this.dao.salvar(crianca);
                    mensagem = "<div class='alert alert-success'>"
                            + "<strong>Sucesso!</strong> Nova criança criada com sucesso!"
                            + "</div>";

                    forward = CADASTRO;
                    request.setAttribute("mensagem", mensagem);
                } else {
                    long id = Long.parseLong(request.getParameter("id"));
                    this.dao.atualizar(crianca, id);
                    mensagem = "<div class='alert alert-success'>"
                            + "<strong>Sucesso!</strong> Criança Atualizada com sucesso!"
                            + "</div>";
                    forward = LISTAGEM;
                    this.listarCriancas(request, "");
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

    public void listarCriancas(HttpServletRequest request, String pesquisa) throws Exception {
        List<Crianca> criancas = this.dao.pesquisar(pesquisa);
        request.setAttribute("criancas", criancas);
        String pesquisou = "S";
        request.setAttribute("pesquisou", pesquisou);
    }
}
