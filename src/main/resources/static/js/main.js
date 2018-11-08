/*let xhr = new XMLHttpRequest();
	xhr.open('GET', '/usuario');
	
	xhr.onload = function(){
		//alert(`Loaded: ${this.status} ${this.responseText}`);
		if(this.status =! 200) console.log("Error!");
		else{
			console.log(this.responseTxt);
			let a = JSON.parse(this.responseText);
			console.log(a);
		}
	};
	
	xhr.onerror = () =>alert('error');
	xhr.send();*/

function adicionar(){
	
	function criarTabela() {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', '/usuario');
		
		xhr.onload = function(){
			
			//alert(`Loaded: ${this.status} ${this.responseText}`);
			if(this.status == 200){
	
				let a = JSON.parse(this.responseText);
				console.log(a);
				
				let tab = document.getElementById("tabela");
				
				for(let i = 0 ; i < a.content.length ; i++){
					tab.innerHTML += <tr> <th>${a.nome}</th> <th>${a.email}</th> <th>${a.senha}</th> </tr>
				}
			}
			
			
		};
		
		xhr.send();
		
	}
	
	criarTabela();
	
}

	/*xhr.setRequestHeader('Content-Type', 'application/json');

	let novo_user = {"nome": "Debora", "email": "aurea@gmail.com", "senha": "3333"};
	novo_user.nome = "debora";
	
	xhr.send(JSON.stringify(novo_user));*/