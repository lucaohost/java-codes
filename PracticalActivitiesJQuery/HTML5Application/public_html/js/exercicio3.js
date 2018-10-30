//Use o seletor correto para ocultar todos os elementos com class = "test".
$(function(){
    $(".test").each(function(){
        $(this).hide();
    });
});

