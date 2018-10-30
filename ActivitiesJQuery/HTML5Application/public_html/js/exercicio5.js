//Se você clicar em um elemento <p>, ele deverá ser ocultado.
$(function () {
    $("p").click(function(){
        $(this).hide();
    });
});