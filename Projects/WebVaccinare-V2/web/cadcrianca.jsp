<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Criancas" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Crianças</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>
            
            <form action="CriancaController" method="post" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${crianca.id!=null?crianca.id:""}">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome:</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome" class="form-control" required="" value="${crianca.nome!=null?crianca.nome:""}" maxlength="100">
                    </div>           
                    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                          <label class="control-label" for="idade">Idade:</label>  
                        <input id="idade" name="idade" type="number" min="0" max="10" placeholder="Digite a idade" class="form-control" required="" value="${crianca.idade!=null?crianca.idade:""}">
                        </div>
                        <div class="form-group col-md-6">
                            <div class="form-group">
                                <label class="control-label" for="sexo">Sexo:</label>
                                <div class="col-md-6"> 
                                    <label class="radio-inline" for="masculino">
                                        <input type="radio" name="sexo" id="masculino" required="" value="M" ${(crianca.sexo!=null && crianca.sexo == "M")?"checked='checked'": ""}>
                                        Masculino
                                    </label> 
                                    <label class="radio-inline" for="feminino">
                                        <input type="radio" name="sexo" id="feminino" required="" value="F" ${(crianca.sexo != null && crianca.sexo == "F")?"checked='checked'": ""}>
                                        Feminino
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">

                            <label class="control-label" for="etnia">Cor/Etnia:</label>
                            <select id="etnia" name="etnia" class="form-control">
                              <option value="B" ${(crianca.etnia!=null && crianca.etnia=="B")?"selected='selected'": ""}>Branca</option>
                              <option value="N" ${(crianca.etnia!=null && crianca.etnia=="N")?"selected='selected'": ""}>Negra</option>
                              <option value="P" ${(crianca.etnia!=null && crianca.etnia=="P")?"selected='selected'": ""}>Parda</option>
                              <option value="I" ${(crianca.etnia!=null && crianca.etnia=="I")?"selected='selected'": ""}>Indígena</option>
                              <option value="A" ${(crianca.etnia!=null && crianca.etnia=="A")?"selected='selected'": ""}>Amarela</option>
                            </select>

                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="parto">Parto:</label>
                            <div class="checkbox">
                                <label for="parto_natural">                                    
                                  <input type="checkbox" name="parto" id="parto_natural" ${crianca.parto == true?"checked='checked'": ""} >
                                  Natural
                                </label>
                            </div>    
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="mae">Nome da Mãe:</label>  
                        <input id="mae" name="mae" type="text" placeholder="Digite o nome da mãe" class="form-control" required="" value="${crianca.mae!=null?crianca.mae:""}" maxlength="100">

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="email">E-mail:</label>  
                            <input id="email" name="email" type="email" aria-describedby="emailHelp"  placeholder="Digite o e-mail" class="form-control" required="" value="${crianca.email!=null?crianca.email:""}" maxlength="100">
                            <small id="emailHelp" class="form-text text-muted">Ex: email@gmail.com</small>
                        </div>
                    
                        <div class="form-group col-md-6">
                            <label class="control-label" for="telefone">Telefone:</label>  
                            <input id="telefone" name="telefone" type="text" aria-describedby="telHelp"  placeholder="Digite o e-mail" class="form-control" required="" value="${crianca.telefone!=null?crianca.telefone:""}" maxlength="20">
                            <small id="telHelp" class="form-text text-muted">Ex: (54)9876-5432</small>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href='listcrianca.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>                    
                </fieldset>
            </form>

        </div>
    </div>
</div>      
<jsp:include page="inc/rodape.inc.jsp" />
