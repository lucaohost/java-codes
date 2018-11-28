<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="inc/cabecalho.inc.jsp">
    <c:param name="pageName" value="Usuarios" />
</c:import>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title text-center">Gestão de Usuarios</h2>
        </div>
        <div class="panel-body">
            <c:out value="${mensagem}" escapeXml="false"/>

            <form action="UsuarioController" method="post" class="form-horizontal">
                <fieldset>
                    <input type="hidden" name="id" id="id" value="${usuario.id!=null?usuario.id:""}">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome:</label>  
                        <input id="nome" name="nome" type="text" placeholder="Digite o nome" class="form-control" required="" value="${usuario.nome!=null?usuario.nome:""}" maxlength="100">
                    </div>                               
                    <div class="form-group">
                        <label class="control-label" for="nome">Email</label>  
                        <input id="email" name="email" type="text" placeholder="Digite o email" class="form-control" required="" value="${usuario.nome!=null?usuario.email:""}" maxlength="100">
                    </div>                               
                    <div class="form-group">
                        <label class="control-label" for="nome">Senha:</label>  
                        <input id="senha" name="senha" type="password" placeholder="Digite a senha" class="form-control" required="" value="${usuario.nome!=null?usuario.senha:""}" maxlength="100">

                    </div>
                    <div class="row">
                        <div class="col-2">
                            <div class="progress progress-striped active">
                                <div id="forca_senha" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Confirmação:</label>  
                        <input id="confirmacaoSenha" name="confirmacaoSenha" type="password" placeholder="Repita a senha" class="form-control" required="" value="${usuario.senha!=null?usuario.senha:""}" maxlength="100">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="perfil">Perfil:</label>
                        <input id="perfil" type="hidden" value="${usuario.perfil!=null?usuario.perfil:""}">
                        <input id="administrador" type="radio" name="perfil" value="administrador" required> Administrador
                        <input id="secretaria" type="radio" name="perfil" value="secretaria"> Secretaria
                        <input id="enfermeira" type="radio" name="perfil" value="enfermeira"> Enfermeira
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="control-label" for="salvar"></label>
                            <button id="salvar" name="salvar" class="btn btn-primary btn-lg btn-block">Salvar</button>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label" for="cancelar"></label>
                            <button id="cancelar" name="cancelar" class="btn btn-secondary btn-lg btn-block" onclick="window.location.href = 'listusuario.jsp'" type="button">Cancelar</button>
                        </div>
                    </div>     
                </fieldset>
            </form>
            <div id="message" class="alert alert-danger" style="display: none;"></div>
        </div>
    </div>
</div>
<jsp:include page="inc/rodape.inc.jsp" />
<script src="js/cadusuarios.js"></script>
