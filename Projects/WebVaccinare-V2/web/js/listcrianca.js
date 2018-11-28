$(function () {
    $(".excluir").click(function(){
        swal({
            title: "Confirmação",
            text: "Você realmente deseja excluir este registro?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                window.location.href = "CriancaController?acao=excluir&id=" + $(this).attr("idCrianca");
            }
        });
    });
});