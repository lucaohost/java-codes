/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.controller;

import br.ifrs.vaccinare.dao.UsuarioDAO;
import br.ifrs.vaccinare.model.Crianca;
import br.ifrs.vaccinare.model.Usuario;
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
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private static String LOGIN = "/login.jsp";
    private static String HOME = "/home.jsp";
    private static String ERRO = "/erro.jsp";

    private final UsuarioDAO dao;

    public UsuarioController() {
        super();
        this.dao = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (request.getParameter("email") != null && request.getParameter("senha") != null) {
                // tenta logar
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                Usuario usuario = this.dao.pesquisar(email, senha);
                if (usuario != null) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("idSession", usuario.getId());
                    forward = HOME;
                    request.setAttribute("usuario", usuario);
                } else {
                    String mensagem = "<div class='alert alert-danger'>"
                            + "Usuário ou Senha incorretos."
                            + "</div>";

                    forward = LOGIN;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        try {
            if (request.getParameter("logout") != null) {
                HttpSession session = request.getSession();
                session.invalidate();
                forward = LOGIN;
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
