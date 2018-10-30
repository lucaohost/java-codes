//Use o seletor correct para esconde todos os elementos  <p>
$(function () {
    $("p").each(function () {
        $(this).hide();
    });
})