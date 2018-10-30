<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Erro" />
</c:import>

<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Ocorrência Inesperada</h2>
        </div>
        <div class="panel-body">
            <div>
                <p>Lamentamos, mas ocorreu um erro inesperado em nossa aplicação.</p>
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
<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />