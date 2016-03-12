$(document).ready(function () {
    $("#products").click(function () {
        $('html, body').animate({
            scrollTop: $('#sidebar').offset().top
        });
    });
});
