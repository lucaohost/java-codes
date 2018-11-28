/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('#email').blur(function () {
        $.ajax({
            method: "GET",
            url: 'UsuarioController',
            data: {
                acao: "verificarEmail",
                email: $(this).val()
            },
            success: function (responseText) {
                var response = JSON.parse(responseText);
                var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+com+$/;
                var isEmail = regex.test($("#email").val());
                if (response.message === "N" || !isEmail) {
                    $("#message").html("");
                    $("#message").addClass("alert alert-danger");
                    $("#message").show();
                    if (response.message === "N")
                        $("#message").append("Nenhum usuário cadastrado possui o e-mail informado.<br>");
                    if (!isEmail)
                        $("#message").append("Email com formato inválido.<br>");
                    $("#login").attr("disabled", true);
                } else {
                    $("#message").hide();
                    $("#login").attr("disabled", false);
                }

            }
        });
    });
});

