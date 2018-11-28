$(function () {
    $('#pesquisar').click(function () {
        $.ajax({
            method: "POST",
            url: 'VacinaController',
            data: {
                nome_pesquisa: $("#nome_pesquisa").val(),
            },
            success: function (responseText) {
                var response = JSON.parse(responseText);
                var arrayVacinas = JSON.parse(response.message);
                console.log(arrayVacinas);
                $("#tableVacinas").html("");
                for (i = 0; i < arrayVacinas.length; i++) {
                    $("#tableVacinas").append("<tr><td>" + arrayVacinas[i].nome + "</td><td>" + arrayVacinas[i].abreviatura + "</td><td>" + arrayVacinas[i].quantidade + "</td><td width='15%'><a class='text-dark' href='VacinaController?acao=atualizar&id=" + arrayVacinas[i].id + "'><i class='fa fa-edit'></i>Alterar</a> | <a class='text-dark excluir' idVacina='" + arrayVacinas[i].id + "' href='#'><i class='fa fa-trash'></i>Excluir</a></td>");
                }
                $(".excluir").click(function () {
                    swal({
                        title: "Confirmação",
                        text: "Você realmente deseja excluir este registro?",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true,
                    }).then((willDelete) => {
                        if (willDelete) {
                            window.location.href = "VacinaController?acao=excluir&id=" + $(this).attr("idVacina");
                        }
                    });
                });
            }
        });
    });
});