//Use o seletor correto para ocultar todos os elementos com um atributo href.
$(function () {
    $("a").each(function () {
        let href = $(this).attr("href");
        if (typeof href !== "undefined") {
            $(this).hide();
        }
    });
});