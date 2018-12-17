//////////////////////////////////////

function cadastrarTarefa(){
	
	let tarefa = {
		"dataInicial": document.getElementById("firstName").value,
		"dataTermino": document.getElementById("lastName").value,
		"descricao": document.getElementById("comment").value
	};
	
	fetch("/tarefa", {
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(tarefa)
		
	}). then(function(response){
		
		criarTabelaTarefas();
		document.location = 'principal.html';
		
	}).catch(function(error){
		console.log(error);
	});
	
}

//////////////////////////////////////
function atualizarTarefa(id){
	
	//document.location = 'cadastrartarefas.html';
	
	let tarefa = {
			"dataInicial": document.getElementById("firstName").value,
			"dataTermino": document.getElementById("lastName").value,
			"descricao": document.getElementById("comment").value
		};
	
	fetch("/tarefa/"+id, {
		method: "PUT",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(tarefa)
		
	}).then(function(response){
		
		criarTabelaTarefas();
		document.location = 'index.html';
		
	}).catch(function(error){
		console.log(error);
	});
	
}

//////////////////////////////////////
function apagarTarefa(id){
	
	fetch("/tarefa/"+id, {
		
		method: "DELETE",
		
	}).then(function(response){
		
		criarTabelaTarefas();
		
	}).catch(function(error){
		console.log(error);
	});
}

//////////////////////////////////////
function criarTabelaTarefas(){
	
	fetch("/tarefa"). then(function(response){
		
		if(response.status >= 200 && response.status <= 300){
			
			response.json(). then(function(data){
				
				let tabTarefa = document.getElementById("tarefas");
				
				tabTarefa.innerHTML = '';
				
				tabTarefa.innerHTML = "<tr><td></td><td></td><td></td><td></td><td></td></tr>";
					 
				for(let i = 0 ; i < data.content.length ; i++){
					let b = data.content[i];
					
					tabTarefa.innerHTML += `<tr><td>${b.dataInicial}</td><td>${b.dataTermino}</td><td>${b.descricao}</td><td><i class="fas fa-edit" id="editar" onClick="atualizarTarefa(${b.id})"></i></td><td><i class="fas fa-trash" id="apagar" onClick="apagarTarefa(${b.id})"></i></td></tr>`;
					
				}
				
			})
			
		}
		
	}).catch(function(error){
		console.log(error);
	});
	
}

//////////////////////////////////////

criarTabelaTarefas();

