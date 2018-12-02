	
//////////////////////////////////////

/*function retornarDados(){
	
	fetch("/usuario")
		.then(function(response){
	
			if(response.status >= 200 && response.status <= 300){
				
				response.json().then(function(data){
					
					let tab = document.getElementById("usuarios");
					tab.innerHTML = "<tr><th>#</th><th>Nome</th><th>Email</th><th>Senha</th></tr>";
					
					for(let i = 0 ; i < data.content.length ; i++){
						
						let b = data.content[i];
						tab.innerHTML += `<tr><td>${b.id}</td><td>${b.nome}</td><td>${b.email}</td><td>Confidencial</td></tr>`;	
					}
				})
			}
		}).catch(function(error){
			console.log(error);
		});
}*/

//////////////////////////////////////

function cadastrarUsuario(){
	
	let usuario = {"nome": document.getElementById("nome").value, 
			"email": document.getElementById("email").value,
			"senha": document.getElementById("senha").value};

	
	fetch("/usuario", {
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(usuario)
	}). then(function (response)
	{
		
		criarTabela();
		
	}).catch(function (error){
		
		console.log(error);
		
	});
	
}

//////////////////////////////////////

function apagarUsuario(){
	
	fetch("/usuario/"+document.getElementById("number").value,
	{
		
		method: "DELETE",
		
	}). then(function (response)
	{
		
		criarTabela();
		
	}).catch(function (error){
		console.log(error);
	});
	
	
}

function atualizarUsuario(){
	
	let usuario_atualizado = {"nome": document.getElementById("atualizaNome").value, 
			"email": document.getElementById("atualizaEmail").value,
			"senha": document.getElementById("atualizaSenha").value};
	
	fetch("/usuario/" + document.getElementById("idUser").value,{
		
		method: "PUT",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(usuario_atualizado)
	}). then(function (response){
		
		criarTabela();
		
	}).catch(function (error){
		console.log(error);
	});
	
}

//////////////////////////////////////

function criarTabela(){
	
	fetch("/usuario").then(function(response){
		
		if(response.status >= 200 && response.status <= 300){
			
			response.json().then(function(data){
				
				let tabela = document.getElementById("usuarios");
				
				tabela.innerHTML = ''
				
				tabela.innerHTML = "<tr><th>#</th><th>Nome</th><th>Email</th><th>Senha</th></tr>"
				
				for(let i = 0 ; i < data.content.length ; i++){
					
					let b = data.content[i];
					tabela.innerHTML += `<tr><td>${b.id}</td><td>${b.nome}</td><td>${b.email}</td><td>Confidencial</td></tr>`
				}
			})
		}
		
	}).catch(function(error){
		console.log(error);
	});
	
}

//////////////////////////////////////

criarTabela();
	