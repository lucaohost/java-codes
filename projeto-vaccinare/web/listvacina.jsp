<%@page import="java.util.ArrayList"%>
<%@page import="br.ifrs.vaccinare.model.Crianca"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Vacinacoes" />
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
            <h2 class="panel-title text-center">Gestão de Vacinas</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas dos Controllers -->
            <c:out value="${mensagem}" escapeXml="false"/>
            <!-- Formulário de pesquisa -->
            <form action="VacinacaoController" method="post" class="form-horizontal">
                <div class="input-group">
                    <input class="form-control border-secondary py-2" type="search" id="nome_pesquisa" name="nome_pesquisa" placeholder="Pesquisar...">
                    <input class="form-control border-secondary py-2" type="hidden" id="pesquisou" name="pesquisou" value="${pesquisou}">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="pesquisar" name="pesquisar" value="nome">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>              
                <br>
            </form>
            <!-- Listagem -->
            <table class="table table-striped table-bordered table-condensed table-hover text-center">
                <thead class="thead-dark text-center">
                    <tr>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Última Vacina</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="vacina" items="${vacinas}">
                        <tr>
                            <td>${vacina.crianca.nome}</td>
                            <td width='15%'>${vacina.crianca.sexo}</td>
                            <td width='15%' class="dataVacinacao">${vacina.dataVacinacao}</td>
                            <td width='15%'><a class='text-dark' href='VacinacaoController?idCrianca=${vacina.crianca.id}'><i class='fa fa-edit'> </i>Detalhes</a></td>
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

        </div>
    </div>
</div>    
<script>
    if (document.getElementById("pesquisou").value != 'S') {
        document.getElementById("pesquisar").click();
    }
    function excluir(id) {
        if (confirm("Você realmente deseja excluir este registro?") == true) {
            window.location.href = "CriancaController?acao=excluir&id=" + id;
        }
    }
</script>    

<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />
