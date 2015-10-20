$(document).ready(function(e){

    $('#contact-details-tab').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#request-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#request-details-tab').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#contact-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#ContactTab-NextButton').click(function(e)
	{
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#contact-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
