<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<!-- Cabe�alho da P�gina -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Erro" />
</c:import>

<!-- Conte�do da P�gina -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Ocorr�ncia Inesperada</h2>
        </div>
        <div class="panel-body">
            <div>
                <p>Lamentamos, mas ocorreu um erro inesperado em nossa aplica��o.</p>
                <p>Veja mais detalhes abaixo:</p>
            </div>
            <div class='alert alert-danger'>
                <strong>Erro!</strong>
                <!-- Mensagens vindas dos Controllers -->
                <c:out value="${mensagem}" escapeXml="false"/>
            </div>
        </div>
    </div>
</div>
<!-- Rodap� da P�gina -->
<jsp:include page="inc/rodape.inc.jsp" />