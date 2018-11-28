<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                    <a class="navbar-brand" href="#">Clínica Vaccinare</a>
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
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Criancas")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Crianças <%= (pageName.equalsIgnoreCase("Criancas")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="listcrianca.jsp">Listar</a>
                                    <a class="dropdown-item" href="cadcrianca.jsp">Adicionar</a>                      
                                </div>
                            </li>
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Vacinacao")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Vacinação <%= (pageName.equalsIgnoreCase("Vacinacao")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="listvacina.jsp">Listar Vacinações</a>
                                    <a class="dropdown-item" href="cadvacina.jsp">Adicionar Vacinação</a>                      
                                    <a class="dropdown-item" href="listvacinas.jsp">Listar Vacinas</a>                      
                                    <a class="dropdown-item" href="cadvacinas.jsp">Adicionar Vacina</a>                      
                                </div>
                            </li>
                            <li class="nav-item dropdown <%= (pageName.equalsIgnoreCase("Usuarios")) ? "active" : ""%>">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Usuarios <%= (pageName.equalsIgnoreCase("Usuarios")) ? "<span class='sr-only'>(current)</span>" : ""%>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="listusuario.jsp">Listar</a>
                                    <a class="dropdown-item" href="cadusuario.jsp">Adicionar</a>                      
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="UsuarioController?acao=sair">Sair</a>
                            </li>
                        </ul>
                    </div>
                    <%
                        }
                    %>            
                </div>
            </nav>

