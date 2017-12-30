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
	alert("##title-->"+note.title);
	note.description = $('#description').val();
	alert("##description-->"+note.description);
	
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
	alert("id "+id);
	console.log("ABC");
	alert("##title-->"+note.title);
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

function update(){
	var note={};
	note.title = $('#titl').val();
	alert("##title-->"+note.title);
	
	note.description = $('#des').val();
	alert("##description-->"+note.description);
	
	$.ajax({
		type:'POST',
		url:'addNote',
		data: {
			'title' : note.title,
			'description' : note.description
		},
	success:function(result){
		$('#editModal').modal('hide'),
		console.log(result);
	}
	});
}


var showSideBar=false;
function openNav() {
	if(showSideBar==false){
		showSideBar=true;
    document.getElementById("mySidenav").style.paddingLeft = "250px";
    document.getElementById("myNote").style.paddingLeft = "260px";
    }
	else{
		showSideBar=false;
		 document.getElementById("mySidenav").style.paddingLeft = "250px";
		    document.getElementById("myNote").style.paddingLeft = "260px";
	   /* document.getElementById("mySidenav").style.paddingLeft = "0";
	    document.getElementById("myNote").style.paddingLeft = "10px";*/
	}
	
}
