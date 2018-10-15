<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!DOCTYPE html>
    <html>
        <head>
            <!-- Meta tags Obrigatórias -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <!-- Meta tags Opcionais -->
            <meta name="description" content="Clínica Vaccinare">
            <meta name="author" content="IFRS-BG">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
            <!-- Fontawesome CSS -->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
            <!-- Título do Site -->
            <title>Clínica Vaccinare</title>
        </head>
        <body>
            <!-- Menu -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
                <div class="container">
                    <a class="navbar-brand" href="home.jsp">Clínica Vaccinare</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <%
                        //Se não for a página de login ou de erro então mostra o menu
                        String pageName = request.getParameter("pageName");
                        if (!pageName.equalsIgnoreCase("Login") && !pageName.equalsIgnoreCase("Erro")) {
                    %>    
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Home")) ? "active" : ""%>">
                                <a class="nav-link" href="home.jsp">Home <%= (pageName.equalsIgnoreCase("Home")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Listagem")) ? "active" : ""%>">
                                <a class="nav-link" href="listcrianca.jsp">Listagem Crianças<%= (pageName.equalsIgnoreCase("Listagem")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Cadastro")) ? "active" : ""%>">
                                <a class="nav-link" href="cadcrianca.jsp">Cadastro Crianças<%= (pageName.equalsIgnoreCase("Cadastro")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("CadastroVacina")) ? "active" : ""%>">
                                <a class="nav-link" href="CriancaController?acao=listCriancas">Nova Vacinação<%= (pageName.equalsIgnoreCase("CadastroVacina")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Vacinacoes")) ? "active" : ""%>">
                                <a class="nav-link" href="listvacina.jsp">Vacinações <%= (pageName.equalsIgnoreCase("Vacinacoes")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>                
                            <li class="nav-item <%= (pageName.equalsIgnoreCase("Sair")) ? "active" : ""%>">
                                <a class="nav-link" href="UsuarioController?logout=logout">Sair <%= (pageName.equalsIgnoreCase("Sair")) ? "<span class='sr-only'>(current)</span>" : ""%></a>
                            </li>                
                        </ul>
                    </div>
                    <%
                        }
                    %>            
                </div>
            </nav>
    
