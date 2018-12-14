function verificarLogin() {
	
	let email = document.getElementById('inputEmail').value;
	let senha = document.getElementById('inputPassword').value;
	
	fetch("/usuario").then(function(response){
		
		if(response.status >= 200 && response.status <= 300) {
			
			response.json().then(function(data){
				for(let i = 0 ; i < data.content.length ; i++) {
					let a = data.content[i];
					
					if(`${a.email}` == email && `${a.senha}` == senha) {
						localStorage.setItem("user", a.id);
						
						console.log(localStorage);
						
						//alert("usuario: " + `${a.id}` + " - " + localStorage);
						document.location = 'index.html';
					}
				}
			});
			
		}
		
	}).catch(function(error){
		console.log(error);
	});
	
}

function login2(){
	
	let email = document.getElementById('inputEmail').value;
	let senha = document.getElementById('inputPassword').value;
	
	let data = {
		"email": email,
		"senha": senha
	};
	
	fetch("/login",{
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(data)
	}).then(function(response){
		
		response.json().then(function(usuario){
			
			localStorage.setItem("usuario", usuario.id);
			
			console.log(localStorage);
			document.location = 'index.html';
			
		});
		
	}).catch(function(error){
		console.log(error);
	});
	
}