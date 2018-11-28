/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {

    $('input').blur(function () {
        $("#message").html("");
        if ($("#nome").val().length < 5) {
            $("#message").addClass("alert alert-danger");
            $("#message").show();
            $("#message").append("O nome da vacina deve ter pelo menos 5 caracteres<br>");
            $("#salvar").attr("disabled", true);
        } else {
            $.ajax({
                method: "GET",
                url: 'VacinaController',
                data: {
                    acao: "verficarVacinas",
                    nome: $("#nome").val()
                },
                success: function (responseText) {
                    var response = JSON.parse(responseText);
                    console.log(response.message);
                    if (response.message !== "") {
                        $("#message").show();
                        $("#message").append("Vacina já existe<br>");
                        $("#salvar").attr("disabled", true);
                    } else {
                        $("#message").hide();
                        $("#salvar").attr("disabled", false);
                    }
                    if ($("#abreviatura").val() !== "") {   
                        var size = $("#abreviatura").val().length;
                        if (size < 3 || size > 7) {
                            $("#message").show();
                            $("#message").append("A abreviatura deve ter entre 3 a 7 caracteres<br>");
                            $("#salvar").attr("disabled", true);
                        }
                    }
                }
            });
        }
    });
});

