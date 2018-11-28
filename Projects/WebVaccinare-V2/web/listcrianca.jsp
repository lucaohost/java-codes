<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Criancas" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Crianças</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <form action="CriancaController" method="post" class="form-horizontal">
                <div class="input-group">
                    <input class="form-control border-secondary py-2" type="search" id="nome_pesquisa" name="nome_pesquisa" placeholder="Pesquisar...">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="pesquisar" name="pesquisar">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>              
                <br>
            </form>
            <table class="table table-striped table-bordered table-condensed table-hover">
                <thead class="thead-dark text-center">
                    <tr>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Idade</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="crianca" items="${criancas}">
                        <tr>
                            <td>${crianca.nome}</td>
                            <td width='15%'>${crianca.sexo.equalsIgnoreCase("M") ? "Masculino" : "Feminino"}</td>
                            <td width='15%'>${crianca.idade} anos</td>
                            <td width='15%'><a class='text-dark' href='CriancaController?acao=atualizar&id=${crianca.id}'><i class='fa fa-edit'></i>Alterar</a> | <a idCrianca='${crianca.id}' class='text-dark excluir' href='#'><i class='fa fa-trash'></i>Excluir</a></td>
                        </tr>                            
                    </c:forEach>
                </tbody>
            </table>                    

        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
<script src="js/listcrianca.js" charset="UTF-8"></script>
