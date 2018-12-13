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
						
						alert("usuario" + `${a.id} + " - " + localStorage);
						document.location = 'index.html';
					}
				}
			});
			
		}
		
	}).catch(function(error){
		console.log(error);
	});
	
}