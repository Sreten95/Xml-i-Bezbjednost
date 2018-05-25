function logIn(){
	
	var $form = $("#loginForm");
	var data = getFormData($form);
	var s = JSON.stringify(data);
	console.log(s);
	 var data = 'username=' + $('#email').val() + '&password=' + $('#password').val();
	$.ajax({
		
		url: "/login",
		type: "POST",
		data: data,
		
		success: function(data){
			//top.location.href="index.html";
		},
		error: function(data){
			alert(data)
		}
		
	
	});
}