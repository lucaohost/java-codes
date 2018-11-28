<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
           
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
           
            <form action="VacinacaoController" method="post" class="form-horizontal">
                <fieldset>
                    <c:import url="/VacinacaoController" />
                    <div class="form-group">
                        <label class="control-label" for="crianca">Criança:</label>
                        <select id="crianca" name="crianca" class="form-control">
                            <c:forEach var="crianca" items="${criancas}"> 
                                <option value='${crianca.id}'>${crianca.nome}</option> 
                            </c:forEach>
                        </select>
                    </div>           
                    
                    <div class="form-group">
                        <label class="control-label" for="vacina">Vacina:</label>
                        <select id="vacina" name="vacina" class="form-control">
                            <c:forEach var="vacina" items="${vacinas}"> 
                                <option value='${vacina.id}'>${vacina.nome}</option> 
                            </c:forEach>
                        </select>
                    </div>           
                   
                    <div class="form-row">
                        <div class="form-group col-md-6">
                          <label class="control-label" for="lote">Lote:</label>  
                        <input id="lote" name="lote" type="text" placeholder="Digite o lote" class="form-control" required="" >
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="data">Data:</label>
                            <div class='input-group date' id='datetimepicker1'>
                                <input class="form-control" type="date" value="" id="data" name="data">                                
                            </div>                            
                        </div>                        
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href='listvacina.jsp'" type="button">Cancelar</button>
                    </div>
                    </div>
                   
                </fieldset>
            </form>

        </div>
    </div>
</div>    
<jsp:include page="inc/rodape.inc.jsp" />
