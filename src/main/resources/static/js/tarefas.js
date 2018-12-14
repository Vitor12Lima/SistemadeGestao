
//////////////////////////////////////
function criarTabelaTarefas(){
	
	fetch('/tarefa').then(function(response){
		
		if(response.status >= 200 && response.status <= 300){
			
			response.json().then(function(data)){
				
				let tabela = document.getElementById("usuario");
				tabela.innerHTML = '';
				
				for(let i = 0; i < data.content.lenght; i++){
					let b = data.content[i];
					tabela.innerHTML += 
				}
				
				
				
			})
			
		}).catch(function(error){
		console.log(error);
	});
	
	
}