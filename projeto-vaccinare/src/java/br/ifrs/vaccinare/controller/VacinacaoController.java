/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.controller;

import br.ifrs.vaccinare.dao.UsuarioDAO;
import br.ifrs.vaccinare.dao.VacinacaoDAO;
import br.ifrs.vaccinare.model.Crianca;
import br.ifrs.vaccinare.model.Usuario;
import br.ifrs.vaccinare.model.Vacinacao;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "VacinacaoController", urlPatterns = {"/VacinacaoController"})
public class VacinacaoController extends HttpServlet {

    private static String LOGIN = "/login.jsp";
    private static String HOME = "/home.jsp";
    private static String ERRO = "/erro.jsp";
    private static String LISTVACINAS = "/listvacina.jsp";
    private static String DETALHEVACINA = "/detalhevacina.jsp";

    private final VacinacaoDAO dao;

    public VacinacaoController() {
        super();
        this.dao = new VacinacaoDAO();
    }

    //cuida de posts vindo de pesquisa e inserção de vacinacoes
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";

        try {
            if (request.getParameter("nome_pesquisa") != null) {
                String nomePesquisa = request.getParameter("nome_pesquisa");
                forward = LISTVACINAS;
                this.listarUltimasVacinas(request, nomePesquisa);
            } else {

                Crianca crianca = new Crianca();
                long idCrianca = Long.parseLong(request.getParameter("crianca"));
                Date dataVacinacao = Date.valueOf(request.getParameter("dataVacinacao"));
                crianca.setId(idCrianca);

                Vacinacao vacinacao = new Vacinacao();
                vacinacao.setDataVacinacao(dataVacinacao);
                vacinacao.setNomeVacina(request.getParameter("vacina"));
                vacinacao.setLote(request.getParameter("lote"));
                vacinacao.setUltimaVacinacao(true);
                vacinacao.setCrianca(crianca);

                String mensagem = "";
                this.dao.salvar(vacinacao);
                mensagem = "<div class='alert alert-success'>"
                        + "<strong>Sucesso!</strong> Nova Vacinação cadastrada com sucesso!"
                        + "</div>";
                forward = LISTVACINAS;
                this.listarUltimasVacinas(request, "");
                request.setAttribute("mensagem", mensagem);
            }
        } catch (Exception ex) {
            forward = ERRO;
            request.setAttribute("mensagem", ex.toString());
        } finally {
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }

    public void listarUltimasVacinas(HttpServletRequest request, String pesquisa) throws Exception {
        List<Vacinacao> vacinas = this.dao.pesquisarUltimasVacinas(pesquisa);
        request.setAttribute("vacinas", vacinas);
        Crianca kid = vacinas.get(0).getCrianca();
        String pesquisou = "S";
        request.setAttribute("pesquisou", pesquisou);
    }

// Recebe gets de quando é clicado em Detalhes na Listagem de Vacinas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (request.getParameter("idCrianca") != null) {
                forward = DETALHEVACINA;
                Long idCrianca = Long.parseLong(request.getParameter("idCrianca"));
                List<Vacinacao> vacinas = this.dao.pesquisarPorIdCrianca(idCrianca);
                request.setAttribute("vacinas", vacinas);
                request.setAttribute("nomeCrianca", vacinas.get(0).getCrianca().getNome());
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
