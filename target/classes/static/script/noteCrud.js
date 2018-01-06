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
	
	
	$.ajax({
        url : "/note/"+id,
       
	success:function(result){
		console.log();
		console.log(result);
		$("#noteModalHolder").html(result);
		$("#noteModal").modal("show");
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


var showSideBar=true;
function openNav() {
	/*if(screen.width>1000){*/
	if(showSideBar==false){
		showSideBar=true;
    document.getElementById("mySidenav").style.paddingLeft = "250px";
    document.getElementById("myNote").style.paddingLeft = "260px";
    }
	else{
		showSideBar=false;
		 document.getElementById("mySidenav").style.paddingLeft = "250px";
		    document.getElementById("myNote").style.paddingLeft = "260px";
	    document.getElementById("mySidenav").style.paddingLeft = "0";
	    document.getElementById("myNote").style.paddingLeft = "10px";
	}
	/*}*/
	
}

function addReminder(id){
	var reminder=$('#datepicker').val();
	$.ajax({
        url : "/reminder/"+id,
        data:{
        	'reminder':reminder
        },
	success:function(result){
		console.log("SA");
		console.log(result);
		
	}
	});
	
}
function laterToday(id){
	var date=new Date();
	var month=date.getMonth()+1;
	var year=date.getFullYear();
	var tommorow=date.getDate()+1;
	var tommorowDate=(tommorow+"/"+month+"/"+year);
	var reminder=tommorowDate+" 8:00AM";
	console.log("Reminder --> "+reminder);
	$.ajax({
        url : "/reminder/"+id,
        data:{
        	'reminder':reminder
        },
	success:function(result){
	}
	});
	
}


function addColor(color){
	console.log("color"+color);
}

var colors=[
	
	{
		"color":'#ffffff',
		"path":'images/white.png'
	},
	
	{
		"color":'#1a53ff',
		"path":'images/darkblue.png'
	},
	{
		"color":'#9966ff',
		"path":'images/purple.png'
	},
	{
		"color":'#ff99cc',
		"path":'images/pink.png'
	},
	{
		"color":'#d9b38c',
		"path":'images/brown.png'
	},
	{
		"color":'#e74c3c',
		"path":'images/Red.png'
	},
	{
		"color":'#ff8c1a',
		"path":'images/orange.png'
	},
	{
		"color":'#fcff77',
		"path":'images/yellow.png'
	},
	{
		"color":'#80ff80',
		"path":'images/green.png'
	},
	{
		"color":'#99ffff',
		"path":'images/skyblue.png'
	},
	{
		"color":'#0099ff',
		"path":'images/blue.png'
	},
	{
		"color":'#bfbfbf',
		"path":'images/grey.png'
	}
];
