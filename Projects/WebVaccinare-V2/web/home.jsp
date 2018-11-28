<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gest�o da Cl�nica Vaccinare</h2>
        </div>
        <%
        String nome=(String)session.getAttribute("nomeUsuario");        
        %>
        <div class="panel-body">
            <p> Seja bem vindo(a), <strong><%=nome %></strong>.</p>
            <p> Este � o Site de Adminitra��o da Cl�nica Vaccinare.</p>
            <p>Neste espa�o � poss�vel:</p>
            <ul class="list">
                <li>Gerenciar cadastros de Crian�as</li>
                <li>Gerenciar cadastros de Vacina��es</li>
                <li>Gerenciar cadastros de Vacinas</li>
              </ul>
        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
