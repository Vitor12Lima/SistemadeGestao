	
function retornarDados() {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', '/usuario');
		
		xhr.onload = function(){
			
			// alert(`Loaded: ${this.status} ${this.responseText}`);
			if(this.status == 200){
	
				let a = JSON.parse(this.responseText);
				console.log(a);
				
				let tab = document.getElementById("tabela");
				
				for(let i = 0 ; i < a.content.length ; i++){
					
					let b = a.content[i];
					tab.innerHTML += `<tr> 
											<td>${b.nome}</td> 
											<td>${b.email}</td> 
											<td>Confidencial</td> 
									  </tr>`;
				}
			}
			
		};
		
		xhr.send();		
}
	
retornarDados();
	

function adicionarDados() {
	
	let  xhr = new XMLHttpRequest();
	xhr.open('POST', '/usuario');
	
	xhr.onload = function() {
		
		if(this.status == 200){
			// let a = JSON.parse(this.responseText);
			// console.log(a);
			
			atualizarTabela();
		}
	};
	
	xhr.setRequestHeader('Content-Type', 'application/json');
	
	let campoNome = document.getElementByClassName('nome').value;
	let campoEmail = document.getElementByClassName('email').value;
	let campoSenha = document.getElementByClassName('senha').value;
	
	let novoUsuario = {
		"nome": campoNome,
		"email": campoEmail,
		"senha": campoSenha
	};
	
	xhr.send(JSON.stringify(novoUsuario));
}

adicionarDados();

function atualizarTabela() {
	
	let xhr2 = new XMLHttpRequest();
	xhr2.open('GET', '/endereco');
	
	xhr2.onload = function() {
		
		if(this.status == 200) {
			
			let a = JSON.parse(this.responseText);
			
				let tab = document.getElementById("tabela");
				
				let b = a.content[r.content.length-1];
				console.log(a);

					tab.innerHTML += `<tr> 
										<td>${b.nome}</td> 
										<td>${b.email}</td> 
										<td>Confidencial</td> 
									</tr>`;
		}
		
	}; 
		
	xhr2.send();
	
}
