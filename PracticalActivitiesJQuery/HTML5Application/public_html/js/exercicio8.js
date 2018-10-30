//Se você pressionar uma tecla do teclado dentro do elemento <input>, ele deverá estar oculta.
$(function () {
    $("input").keypress(function(){
        $(this).hide();
    });
});