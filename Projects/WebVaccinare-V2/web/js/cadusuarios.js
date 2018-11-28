/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {

    $('input').blur(function () {
        validar();
        if ($("#message").html() !== "") {
            $("#message").show();
        } else {
            $("#message").hide();
            $("#salvar").attr("disabled", false);
        }
    });

    function validar() {
        $("#message").html("");
        verificaNome();
        if ($("#email").val() !== "") {
            $.ajax({
                method: "GET",
                url: 'UsuarioController',
                data: {
                    acao: "verificarEmail",
                    email: $("#email").val()
                },
                success: function (responseText) {
                    var response = JSON.parse(responseText);
                    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+com+$/;
                    var isEmail = regex.test($("#email").val());
                    if (response.message === "S")
                        $("#message").append("Email informado já cadastrado.<br>");
                    if (!isEmail)
                        $("#message").append("Email com formato inválido.<br>");
                    if ($("#senha").val() !== "") {
                        verificaSenha();
                    }
                    if ($("#confirmacaoSenha").val() !== "") {
                        verificarConfirmacaoSenha();
                    }

                }
            });
        }
    }

    function verificaNome() {
        if ($("#nome").val().length < 10) {
            $("#message").append("O nome deve ter ao menos 10 caracteres<br>");
            $("#salvar").attr("disabled", true);
        }
    }

    function verificaSenha() {
        if (parseInt($("#forca_senha").attr("aria-valuenow")) < 2) {
            $("#message").append("Senha fraca demais<br>");
        }
    }

    function verificarConfirmacaoSenha() {
        if ($("#senha").val() !== $("#confirmacaoSenha").val()) {
            $("#message").append("Confirmação de senha não confere.<br>");
            $("#confirmacaoSenha").addClass("alert alert-danger");
        } else {
            $("#confirmacaoSenha").addClass("alert alert-success");
        }
    }



    $("#senha").keyup(function () {
        var desc = [{'width': '0px'}, {'width': '20%'}, {'width': '40%'}, {'width': '60%'}, {'width': '80%'}, {'width': '100%'}];
        var descClass = ['', 'progress-bar-danger', 'progress-bar-danger', 'progress-bar-warning', 'progress-bar-success', 'progress-bar-success'];
        var score = 0;
        if ($(this).val().length > 5)
            score++;
        if (($(this).val().match(/[a-z]/)) && ($(this).val().match(/[A-Z]/)))
            score++;
        if ($(this).val().match(/\d+/))
            score++;
        if ($(this).val().match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/))
            score++;
        if ($(this).val().length > 9)
            score++;
        $("#forca_senha").removeClass(descClass[score - 1]).addClass(descClass[score]).css(desc[score]);
        $("#forca_senha").attr("aria-valuenow", score);
    });

    function defineTipoPerfil() {
        if ($("#perfil").val() === "administrador") {
            $("#administrador").attr("checked", true);
        }
        if ($("#perfil").val() === "secretaria") {
            $("#secretaria").attr("checked", true);
        }
        if ($("#perfil").val() === "enfermeira") {
            $("#enfermeira").attr("checked", true);
        }
    }
    if ($("#perfil").val() !== "") {
        defineTipoPerfil();
    }
});

