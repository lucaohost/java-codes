//Quando o ponteiro do mouse entra no elemento <span>, ele deve ser ocultado.
$(function () {
    $("span").mouseenter(function(){
        $(this).hide();
    });
});