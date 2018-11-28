<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão da Clínica Vaccinare</h2>
        </div>
        <%
        String nome=(String)session.getAttribute("nomeUsuario");        
        %>
        <div class="panel-body">
            <p> Seja bem vindo(a), <strong><%=nome %></strong>.</p>
            <p> Este é o Site de Adminitração da Clínica Vaccinare.</p>
            <p>Neste espaço é possível:</p>
            <ul class="list">
                <li>Gerenciar cadastros de Crianças</li>
                <li>Gerenciar cadastros de Vacinações</li>
                <li>Gerenciar cadastros de Vacinas</li>
              </ul>
        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
