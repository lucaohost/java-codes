<%@page import="java.util.ArrayList"%>
<%@page import="br.ifrs.vaccinare.model.Crianca"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condi��es de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabe�alho da P�gina -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
</c:import>
<%
if (request.getSession().getAttribute("idSession") == null) {
        String mensagem = "<div class='alert alert-warning'>"
                + "�rea restrita para usu�rios. Por favor insira suas credenciais."
                + "</div>";
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
%>
<!-- Conte�do da P�gina -->
<div class="container">
    <div class="panel panel-default">
        <div class="alert alert-secondary mt-3">
            <h2 class="text-center mb-5">Sistema Vaccinare para Gest�o de Vacina��es</h2>
            <p>O Sistema disp�e das seguintes funcionalidades: </p>
            <ul>
                <li><b>Listagem Crian�as</b> com motor de busca habilitado par buscar por nomes de crian�as, bem como partes de seus nomes tamb�m;</li>
                <li><b>Cadastro Crian�as</b> de crian�as contendo Nome, Sexo, Etnia, Idade, Parto Natural, Email e Nome da M�e;</li>
                <li><b>Alterar Cadastro Crian�as</b> para visualizar e alterar detalhes de uma Crian�as Cadastrada;</li>
                <li><b>Nova Vacina��o</b> para salvar vacina��es realizadas contendo Crian�as, Vacina, Lote e Data.</li>
                <li><b>Vacina��es</b> para visualizar todos os nome das Crian�as que j� foram vacinadas, bem como Sexo e �ltima Vacina.</li>
                <li><b>Detalhes em Vacina��es</b> para visualizar todas as vacina��es de uma determinada crian�a.</li>
                <li><b>Sair</b> para deslogar de suas conta.</li>
            </ul>
            <img class="mt-4 rounded mb-4" style="margin-left:28%" src="inc/Vaccinazione.jpg">
            <p><b>Suporte:</b> suporte@vaccinare.com.br</p>
        </div>
    </div>
</div>    
<script>
    if (document.getElementById("pesquisou").value != 'S') {
        document.getElementById("pesquisar").click();
    }
    function excluir(id) {
        if (confirm("Voc� realmente deseja excluir este registro?") == true) {
            window.location.href = "CriancaController?acao=excluir&id=" + id;
        }
    }
</script>    

<!-- Rodap� da P�gina -->
<jsp:include page="inc/rodape.inc.jsp" />
