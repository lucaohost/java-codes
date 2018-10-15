<%@page import="java.util.ArrayList"%>
<%@page import="br.ifrs.vaccinare.model.Crianca"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="detalhevacina" />
</c:import>
<%
    if (request.getSession().getAttribute("idSession") == null) {
        String mensagem = "<div class='alert alert-warning'>"
                + "Área restrita para usuários. Por favor insira suas credenciais."
                + "</div>";
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
%>
<!-- Conteúdo da Página -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Vacinas do ${nomeCrianca}</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas dos Controllers -->
            <c:out value="${mensagem}" escapeXml="false"/>
            <!-- Listagem -->
            <table class="table table-striped table-bordered table-condensed table-hover text-center mt-4">
                <thead class="thead-dark text-center">
                    <tr>
                        <th>Vacina</th>
                        <th>Lote</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="vacina" items="${vacinas}">
                        <tr>
                            <td>${vacina.nomeVacina}</td>
                            <td width='15%'>${vacina.lote}</td>
                            <td width='15%' class="dataVacinacao">${vacina.dataVacinacao}</td>
                        </tr>                            
                    </c:forEach>
                <script>
                    //formata datas
                    var obj = document.getElementsByClassName("dataVacinacao");
                    for (var prop in obj) {
                        var data = new Date(obj[prop].innerHTML + " 00:00:00");
                        obj[prop].innerHTML = data.toLocaleDateString('en-GB');
                    }
                </script>
                </tbody>
            </table>                    
            <div class="form-row" style="margin-left:35%;">
                <div class="form-group col-md-6">
                    <label class="control-label" for="cancelar"></label>
                    <button class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listvacina.jsp'" type="button">Voltar</button>
                </div>
            </div>  
        </div>
    </div>
</div>    

<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />
