$(function () {
    $('#pesquisar').click(function () {
        $.ajax({
            method: "POST",
            url: 'UsuarioController',
            data: {
                nome_pesquisa: $("#nome_pesquisa").val(),
            },
            success: function (responseText) {
                var response = JSON.parse(responseText);
                var arrayUsers = JSON.parse(response.message);
                $("#tableUsers").html("");
                for (i = 0; i < arrayUsers.length; i++) {
                    $("#tableUsers").append("<tr><td>" + arrayUsers[i].nome + "</td><td>" + arrayUsers[i].email + "<td width='15%'><a class='text-dark' href='UsuarioController?acao=atualizar&id=" + arrayUsers[i].id + "'><i class='fa fa-edit'></i>Alterar</a> | <a class='text-dark excluir' href='#' idUsuario='" + arrayUsers[i].id + "'><i class='fa fa-trash'></i>Excluir</a></td>");
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
                            window.location.href = "UsuarioController?acao=excluir&id=" + $(this).attr("idUsuario");
                        }
                    });
                });
            }
        });
    });
});