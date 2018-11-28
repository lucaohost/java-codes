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
            
            <div class="form-row">
                <div class="form-group input-group">
                    <label class="control-label col-md-2" for="nome">Criança:</label>  
                    <input id="nome" name="nome" type="text" class="form-control col-md-10" readonly="" value="${crianca}" >
                </div>
            </div>              
            <br>

            <table class="table table-striped table-bordered table-condensed table-hover">
                <thead class="thead-dark text-center">
                    <tr>
                        <th>Vacina</th>
                        <th>Lote</th>
                        <th>Data</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vacinacao" items="${vacinacoes}">
                        <tr>
                            <td>${vacinacao[0]}</td>
                            <td width='15%'>${vacinacao[1]}</td>
                            <td width='15%'><fmt:formatDate pattern="dd/MM/yyyy" value="${vacinacao[2]}" /></td>                            
                        </tr>                            
                    </c:forEach>
                </tbody>
            </table>                    

            <div class="form-row">
                <div class="form-group col-md-12">
                    <label class="control-label" for="cancelar"></label>
                    <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listvacina.jsp'" type="button">Voltar</button>
                </div>
            </div>
        </div>
    </div>
</div>    

<jsp:include page="inc/rodape.inc.jsp" />
