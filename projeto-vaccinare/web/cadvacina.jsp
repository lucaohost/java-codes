<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="CadastroVacina" />
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
            <!-- Formulário que envia dados para o CriancaController -->
            <form action="VacinacaoController" method="post" class="form-horizontal"style="margin-left:35%">
                <fieldset>      
                    <div class="form-row">
                        <div class="form-group col-md-6">

                            <label class="control-label" for="crianca">Criança:</label>
                            <select id="crianca" name="crianca" class="form-control">
                                <c:forEach var="crianca" items="${criancas}">
                                    <option value="${crianca.id}">${crianca.nome}</option>                          
                                </c:forEach>
                            </select>

                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">

                            <label class="control-label" for="vacina">Vacina:</label>
                            <select id="vacina" name="vacina" class="form-control">
                                <option value="Sarampo" >Sarampo</option>
                                <option value="Tétano" >Tétano</option>
                                <option value="Poliomelite" >Poliomelite</option>
                            </select>

                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="lote">Lote</label>  
                            <input id="lote" name="lote" type="text" aria-describedby="telHelp" class="form-control" required="" maxlength="20">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="dataVacinacao">Data</label>  
                            <input id="dataVacinacao" name="dataVacinacao" type="date" aria-describedby="telHelp" class="form-control" required="" maxlength="20">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                    </div>    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listvacina.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>  
                </fieldset>
            </form>

        </div>
    </div>
</div>
<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />
