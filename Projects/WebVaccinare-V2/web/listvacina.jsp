<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
            
            <form action="VacinacaoController" method="post" class="form-horizontal">
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
                        <th>Última Vacina</th>
                        <th>Detalhes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vacinacao" items="${vacinacoes}">
                        <tr>
                            <td>${vacinacao[1]}</td>
                            <td width='15%'>${vacinacao[2].equalsIgnoreCase("M") ? "Masculino" : "Feminino"}</td>
                            <td width='15%'><fmt:formatDate pattern="dd/MM/yyyy" value="${vacinacao[3]}" /></td>
                            <td width='15%'><a class='text-dark' href='VacinacaoController?acao=detalhes&id=${vacinacao[0]}'><i class='fa fa-info-circle'></i>Detalhes</a></td>
                        </tr>                            
                    </c:forEach>
                </tbody>
            </table>                    
            
        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
