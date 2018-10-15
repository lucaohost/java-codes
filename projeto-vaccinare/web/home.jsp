<%@page import="java.util.ArrayList"%>
<%@page import="br.ifrs.vaccinare.model.Crianca"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Home" />
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
        <div class="alert alert-secondary mt-3">
            <h2 class="text-center mb-5">Sistema Vaccinare para Gestão de Vacinações</h2>
            <p>O Sistema dispõe das seguintes funcionalidades: </p>
            <ul>
                <li><b>Listagem Crianças</b> com motor de busca habilitado par buscar por nomes de crianças, bem como partes de seus nomes também;</li>
                <li><b>Cadastro Crianças</b> de crianças contendo Nome, Sexo, Etnia, Idade, Parto Natural, Email e Nome da Mãe;</li>
                <li><b>Alterar Cadastro Crianças</b> para visualizar e alterar detalhes de uma Crianças Cadastrada;</li>
                <li><b>Nova Vacinação</b> para salvar vacinações realizadas contendo Crianças, Vacina, Lote e Data.</li>
                <li><b>Vacinações</b> para visualizar todos os nome das Crianças que já foram vacinadas, bem como Sexo e Última Vacina.</li>
                <li><b>Detalhes em Vacinações</b> para visualizar todas as vacinações de uma determinada criança.</li>
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
        if (confirm("Você realmente deseja excluir este registro?") == true) {
            window.location.href = "CriancaController?acao=excluir&id=" + id;
        }
    }
</script>    

<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />
