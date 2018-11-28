<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Usuarios" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Usuarios</h2>
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
                        <th>Email</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="tableUsers">
                </tbody>
            </table>                    

        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
<script src="js/listusuarios.js" charset="UTF-8"></script>
