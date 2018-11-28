<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Erro" />
</c:import>

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
                <c:out value="${mensagem}" escapeXml="false"/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="inc/rodape.inc.jsp" />