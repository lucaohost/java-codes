<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- Verifica as condições de acesso ao sistema -->
<!-- include_once './inc/acesso.inc.php'; -->
<!-- Cabeçalho da Página -->
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Cadastro" />
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
            <h2 class="panel-title text-center">Gestão de Crianças</h2>
        </div>
        <div class="panel-body">
            <!-- Mensagens vindas dos Controllers -->
            <c:out value="${mensagem}" escapeXml="false"/>
            <!-- Formulário que envia dados para o CriancaController -->
            <form action="CriancaController" method="post" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${crianca.id}">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome:</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome" class="form-control" required="" value="${crianca.nome}" maxlength="100">
                    </div>           

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="idade">Idade:</label>  
                            <input id="idade" name="idade" type="number" min="0" max="10" placeholder="Digite a idade" class="form-control" required="" value="${crianca.idade}">
                        </div>
                        <div class="form-group col-md-6">
                            <div class="form-group">
                                <label class="control-label" for="sexo">Sexo:</label>
                                <div class="col-md-6"> 
                                    <label class="radio-inline" for="masculino">
                                        <input type="hidden" name="sexoSetado" id="sexoSetado" required="" value="${crianca.sexo}" >
                                        <input type="radio" name="sexo" id="masculino" required="" value="M" >
                                        Masculino
                                    </label> 
                                    <label class="radio-inline" for="feminino">
                                        <input type="radio" name="sexo" id="feminino" required="" value="F" >
                                        Feminino
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">

                            <label class="control-label" for="etnia">Cor/Etnia:</label>
                            <input id="etniaSetada" type="hidden" value="${crianca.etnia}">
                            <select id="etnia" name="etnia" class="form-control">
                                <option value="B" >Branca</option>
                                <option value="N" >Negra</option>
                                <option value="P" >Parda</option>
                                <option value="I" >Indígena</option>
                                <option value="A" >Amarela</option>
                            </select>

                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="parto">Parto:</label>
                            <div class="checkbox">
                                <label for="parto_natural">                                    
                                    <input type="checkbox" name="parto" id="parto_natural">
                                    <input type="hidden" id="parto_setado" value="${parto}">
                                    Natural
                                </label>
                            </div>    
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="mae">Nome da Mãe:</label>  
                        <input id="mae" name="mae" type="text" placeholder="Digite o nome da mãe" class="form-control" required="" maxlength="100" value="${crianca.nomeMae}">

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="email">E-mail:</label>  
                            <input id="email" name="email" type="email" aria-describedby="emailHelp"  placeholder="Digite o e-mail" class="form-control" required="" value="${crianca.email}"  maxlength="100">
                            <small id="emailHelp" class="form-text text-muted">Ex: email@gmail.com</small>
                        </div>

                        <div class="form-group col-md-6">
                            <label class="control-label" for="telefone">Telefone:</label>  
                            <input id="telefone" name="telefone" type="text" aria-describedby="telHelp"  placeholder="Digite o e-mail" class="form-control" required="" value="${crianca.telefone}" maxlength="20">
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
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listcrianca.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>                    
                </fieldset>
            </form>

        </div>
    </div>
</div>                                        
<script>
    var etniaSetada = document.getElementById('etniaSetada').value;
    if (etniaSetada != "") {
        var sel = document.getElementById('etnia');
        var optSelected = etniaSetada;
        var opts = sel.options;
        for (var opt, j = 0; opt = opts[j]; j++) {
            if (opt.value == optSelected) {
                sel.selectedIndex = j;
                break;
            }
        }
    }
    if (document.getElementById("id").value != "") {
        document.getElementById("salvar").innerHTML = "Salvar Alterações";
    }
    if (document.getElementById("parto_setado").value == "S") {
        document.getElementById("parto_natural").checked = true;
    }
    if (document.getElementById("sexoSetado").value == "M") {
        document.getElementById("masculino").checked = true;
    }
    if (document.getElementById("sexoSetado").value == "F") {
        document.getElementById("feminino").checked = true;
    }

</script>
<!-- Rodapé da Página -->
<jsp:include page="inc/rodape.inc.jsp" />
