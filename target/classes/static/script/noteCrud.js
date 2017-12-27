$('document').ready(function() {
	});

function deleteNote(id) {
    console.log(id);
   
    
    $.ajax({
    	 type : 'DELETE',  
         url : "/delete/"+id,
	});
    
}

/*function addNote(){
	var note={};
	note.title= $('#title').val();
	note.description = $('#description').val();
	
	$.ajax({
		type:'POST',
		url:'addNote',
		data: JSON.stringify(note),
	success:function(result){
		console.log(result);
	}
	});
} */

