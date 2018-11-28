<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Vacinacao" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Vacinas</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <div class="input-group">
                <input class="form-control border-secondary py-2" type="search" id="nome_pesquisa" name="nome_pesquisa" placeholder="Pesquisar...">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit" id="pesquisar" name="pesquisar">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>              
            <br>
            <table class="table table-striped table-bordered table-condensed table-hover">
                <thead class="thead-dark text-center">
                    <tr>
                        <th>Nome</th>
                        <th>Abreviatura</th>
                        <th>Quantidade</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="tableVacinas">
                </tbody>
            </table>                    

        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
<script src="js/listvacinas.js"></script>
