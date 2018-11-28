<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Vacinacao" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Vacinas</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <form action="VacinaController" method="post" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${vacina.id!=null?vacina.id:""}">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome da Vacina:</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome da vacina" class="form-control" required="" value="${vacina.nome!=null?vacina.nome:""}" maxlength="100">
                    </div>                               
                    <div class="form-group">
                        <label class="control-label" for="nome">Abreviatura</label>  
                        <input id="abreviatura" name="abreviatura" type="text" placeholder="Digite o abreviatura" class="form-control" required="" value="${vacina.abreviatura!=null?vacina.abreviatura:""}" maxlength="100">
                    </div>                               
                    <div class="form-group">
                        <label class="control-label" for="nome">Quantidade:</label>  
                        <input id="quantidade" name="quantidade" type="number" placeholder="Digite a quantidade" class="form-control" required="" value="${vacina.quantidade!=null?vacina.quantidade:""}" maxlength="100">

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listvacinas.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>     
                </fieldset>
            </form>
            <div id="message" class="alert alert-danger" style="display: none;"></div>
        </div>
    </div>
</div>      
<jsp:include page="inc/rodape.inc.jsp" />
<script src="js/cadvacinas.js"></script>
