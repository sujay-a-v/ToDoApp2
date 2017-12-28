$('document').ready(function() {
	});

function deleteNote(id) {
    console.log(id);
   
    
    $.ajax({
    	 type : 'DELETE',  
         url : "/delete/"+id,
	});
    
}

function addNote(){
	var note={};
	note.title= $('#title').val();
	note.description = $('#description').val();
	
	$.ajax({
		type:'POST',
		url:'addNote',
		data: {
			'title' : note.title,
			'description' : note.description
		},
	success:function(result){
		$('#myModal').modal('hide'),
		console.log(result);
	}
	});
} 


function edit(id) {
	console.log(id);
	console.log("ABC");
	var title=$('#tit').val();
	var description = $('#des').val();
	
	$.ajax({
   	 type : 'POST',  
        url : "/edit/"+id,
        data: {
			
		},
	success:function(result){
		
		console.log(result.note);
	}
	});
	
}
