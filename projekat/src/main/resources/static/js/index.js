
$( document ).ready(function() {
	$.ajax({
		url: "/user/status",
		type:"GET",
		success : function(data){
				if(data) {
					$("#toolbar").empty();
					$("#toolbar").append("<li class=\"left\" id=\"home_tb\" ><a href=\"index.html\">Home</a></li>")
								.append("<li class=\"left\" id=\"promjena_lozinke_tb\" ><a href=\"changePass.html\">Promjena lozinke</a></li> ")
									.append("<li class=\"right\" id=\"logout_tb\" ><a onclick=\"logout()\">Odjava</a></li>");
				} else {
					$("#toolbar").empty();
					$("#toolbar").append("<li class=\"left\" id=\"home_tb\" ><a href=\"index.html\">Home</a></li>")
								.append("<li class=\"right\" id=\"login_tb\" ><a href=\"login\">Prijava</a></li>")
									.append("<li class=\"right\" id=\"register_tb\" ><a href=\"register\">Registracija</a></li>  ");
				}
		},
		error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
});

function getFormData($form){
	
	 var unindexed_array = $form.serializeArray();
	    var indexed_array = {};

	    $.map(unindexed_array, function(n, i){
	        indexed_array[n['name']] = n['value'];
	    });

	    return indexed_array;
	
}

function logout(){
	
	$.ajax({
		url: "/logout",
		type:"GET",
		success : function(data){
				top.location.href = "login.html";
		},
		error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	
	
}