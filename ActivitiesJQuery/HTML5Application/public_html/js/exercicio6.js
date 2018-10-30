//Se você clicar duas vezes em um elemento <p>, ele deve estar oculto. 
$(function () {
    $("p").dblclick(function(){
        $(this).hide();
    });
});