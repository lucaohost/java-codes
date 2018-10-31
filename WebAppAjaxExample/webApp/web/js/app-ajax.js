
$(document).ready(function() {
	$('#userName').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $(this).val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});