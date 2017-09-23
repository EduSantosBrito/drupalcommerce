$( document ).ready(function() {
        $('.carousel').carousel({
                dist: 0,
                padding: 20,
        });
        $("#large-navbar").hide();
        $(".button-collapse").sideNav();
        $('.collapsible').collapsible();
        $('.dropdown-button').dropdown({
        constrainWidth: false, // Does not change width of dropdown to that of the activator
        gutter: 42, // Spacing from edge
        belowOrigin: false, // Displays dropdown below the button
        alignment: 'left', // Displays dropdown with edge aligned to the left of button
        stopPropagation: true // Stops event propagation
    });
        $('.dropdown-button + .dropdown-content').on('click', function(event) {
                event.stopPropagation();
        });
        $('.dropdown-button-login').dropdown({
        constrainWidth: false, // Does not change width of dropdown to that of the activator
        gutter: 0, // Spacing from edge
        belowOrigin: true, // Displays dropdown below the button
        alignment: 'left', // Displays dropdown with edge aligned to the left of button
        stopPropagation: true // Stops event propagation
    });	
});
$("#small-bar").click(function() {
        $("#small-navbar").hide();
        $("#large-navbar").fadeIn("slow");
});
$("#large-bar").click(function() {
        $("#large-navbar").hide();
        $("#small-navbar").fadeIn("slow");
});
$('.moveNextCarousel').click(function(e){
    e.preventDefault();
    e.stopPropagation();
    $('.carousel').carousel('next');
});
$('.movePrevCarousel').click(function(e){
e.preventDefault();
e.stopPropagation();
$('.carousel').carousel('prev');
});