var images=[];
var dodatneUsluge = [];
var expanded = false;
///dodato za slike
function previewFiles() {

	  var preview = document.querySelector('#preview');
	  var files   = document.querySelector('input[type=file]').files;

	  function readAndPreview(file) {

	    // Make sure `file.name` matches our extensions criteria
	    if ( /\.(jpe?g|png|gif)$/i.test(file.name) ) {
	      var reader = new FileReader();

	      reader.addEventListener("load", function () {
	        var image = new Image();
	        image.height = 100;
	        
	        image.title = file.name;
	        image.src = this.result;
	        images.push(this.result);
	        preview.appendChild( image );
	      }, false);

	      reader.readAsDataURL(file);
	    }

	  }

	  if (files) {
	    [].forEach.call(files, readAndPreview);
	  }

	}

function probas(){
	//$('#modalSlike').modal();
alert('a');
}

function dodajSliku(){
	 $('#file-input').trigger('click');
}
var i=0;


function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var divT = $('#slike');
        //divT.style="display: inline;";
    	var div = document.createElement("div");
    	div.style=" border: 2px solid brown; width: 200px; height:305px;margin: 15px; display: block; margin-left: auto; margin-right: auto";
    	//div.style="background:red;   vertical-align: middle; ";

    	var image = document.createElement("img");
    	var btn = document.createElement('input');
    	btn.setAttribute('type','button');
    	var idb="bt"+i;
     	btn.setAttribute("id",idb);
     	btn.className="w3-btn w3-brown";
     	btn.style=" margin: 15px; display: block; margin-left: auto; margin-right: auto";
    	btn.setAttribute('value','Dissmiss');
    	var ids="sl"+i;
     	image.setAttribute("id",ids);
     	image.style=" margin: 15px; display: block; margin-left: auto; margin-right: auto ";
        reader.onload = function (e) {
         //   alert(e.target.result);

            $('#'+ids)
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };
        div.append(image);
        div.append(btn);
        var idd="div"+i;
     	div.setAttribute("id",idd);

      
        divT.append(div);

        $('#'+idb).on('click',function() { 
            $('#'+idd).remove();
            });

        i=i+1;
        reader.readAsDataURL(input.files[0]);

		var slika = JSON.stringify({
			"idslike": 1,
			"urlSlike" : reader.readAsDataURL(input.files[0]),
			"idSobe" : null,
		});
        
    	$.ajax({
    		async: false,
    		url: "http://localhost:8081/agent/makingImage",
	        type: "POST",
	        contentType: "application/json",
	        data: slika,
    	    success: function (data) {
    	    	//alert('AAA');
    	    }
    	});
    }
}



function addRoom(){
	$('#modalSoba').modal();
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/sviTipoviSmestaja",
	    type: "GET",
	    success: function (data) {
	    	var divT = $('#tipSobe');
	    	divT.empty();
	    	for(var i=0;i<data.length;i++){
	    		var myOption = document.createElement("option");
	    		myOption.text =data[i];
	    		divT.append(myOption);

	    	}
	    }
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/sveKategorije",
	    type: "GET",
	    success: function (data) {
	    	var divT = $('#kategSobe');
	    	divT.empty();
	    	for(var i=0;i<data.length;i++){
	    		var myOption = document.createElement("option");
	    		myOption.text =data[i];
	    		divT.append(myOption);

	    	}
	    }
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/getDodatneUsluge",
		dataType : "json",
	    type: "GET",
	    success: function (data) {
	    	dodatneUsluge = data;
	    }
	});
}





function prikaziUsluge(){
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('divZaDodatneUsluge');
	boxes.setAttribute('id','checkboxes');
	for (i = 0; i < dodatneUsluge.length; i++) {
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',dodatneUsluge[i].id);
		var labelaNaziv = document.createElement('label');
		labelaNaziv.innerHTML = dodatneUsluge[i].naziv;
		input.setAttribute('name','usluga');
		input.setAttribute('value',dodatneUsluge[i].id);
		boxes.append(input);
		boxes.append(labelaNaziv);
		var br = document.createElement('br');
		boxes.append(br);
	}
	glavniDiv.append(boxes);
	var checkboxes = document.getElementById("checkboxes");
	  if (!expanded) {
	    checkboxes.style.display = "block";
	    expanded = true;
	  } else {
	    checkboxes.style.display = "none";
	    expanded = false;
	  }
}

function sendMessage(){
	$('#sendM').modal();	
}

function posalji(){
	var idP = document.getElementById("usr").value;
	var sad = document.getElementById("mess").value;
	var por = JSON.stringify({
		"username":idP,
		"sadrzaj":sad
	});
	
	$.ajax({
		url:"http://localhost:8081/poruke/sendMessage",
		beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
		type:"POST",
		contentType:"application/json",
		data:por,
		success:function(){
		alert("uspesno");
		document.location.reload();
		},
		error:function(){
			alert("neuspesno");
		}
	});
	
}

function messages(){
	$('#messagess').modal();
	var tab = document.getElementById("poruke")

	$.ajax({
		url:"http://localhost:8081/poruke/getAllMessagess",
		beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
		type:"GET",
		success:function(data){
			for(var i=0;i<data.length;i++){
			var kk = data[i];
			var row = tab.insertRow(i+1);
	    	var cell1 = row.insertCell(0);
	    	var cell2 = row.insertCell(1);
	    	
	    	
		    
		        cell1.innerHTML = kk.klijentPosiljalac.username;
		    	cell2.innerHTML = kk.sadrzaj;
		    	
			}
		},
		error:function(){
			
		}
	});

}


function reservations(){
	$('#modalRez').modal();
	var divT = $('#reze');
	divT.empty();
	var tabela=document.createElement("table");
	var red0=document.createElement("tr");
	var z1=document.createElement("th");
	var z2=document.createElement("th");
	var z3=document.createElement("th");
	var z4=document.createElement("th");
	var z5=document.createElement("th");
	var z6=document.createElement("th");
	var z7=document.createElement("th");

	z1.style=" border: 2px solid brown;padding:10px; ";
	z2.style=" border: 2px solid brown; padding:5px;";
	z3.style=" border: 2px solid brown;padding:5px; ";
	z4.style=" border: 2px solid brown;padding:5px; ";
	z5.style=" border: 2px solid brown;padding:5px; ";
	z6.style=" border: 2px solid brown;padding:5px; ";
	z7.style=" border: 2px solid brown;padding:5px; ";
	z1.innerHTML="Arrival date";
	z2.innerHTML="Departure date";
	z3.innerHTML="Number of persons";
	z4.innerHTML="Client username";
	z5.innerHTML="Grade";
	z6.innerHTML="Room id";
	z7.innerHTML="Realized";
	//z5.innerHTML="Ocena";

	red0.append(z1);
	red0.append(z2);
	red0.append(z3);
	red0.append(z4);
	red0.append(z5);
	red0.append(z6);
	red0.append(z7);
	tabela.append(red0);
	$.ajax({
		async: false,
		url: "http://localhost:8081/rezervacija/mojeRez",
		beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
	    type: "GET",
	    success: function (v) {
	    	console.log(v);
	    	if(v.length>0){
	    	for(var i=0;i<v.length;i++){
	    		var red1=document.createElement("tr");
				var sad1=document.createElement("td");
				var sad2=document.createElement("td");
				var sad3=document.createElement("td");
				var sad4=document.createElement("td");
				var sad5=document.createElement("td");
				var sad6=document.createElement("td");

				var sad7=document.createElement("td");
				
				sad1.style=" border: 2px solid green ";
				sad2.style=" border: 2px solid green ";
				sad3.style=" border: 2px solid green ";
				sad4.style=" border: 2px solid green ";
				sad5.style=" border: 2px solid green ";
				sad6.style=" border: 2px solid green ";
				sad7.style=" border: 2px solid green ";
				//alert()
				console.log(v[i].soba);
			     var myDate = v[i].datumDolaska;
			     var a = new Date(myDate);
			     var now = moment(myDate).format('l');
	   		     sad1.innerHTML= now;
				
				myDate = v[i].datumDolaska;
				now = moment(myDate).format('l');
				sad2.innerHTML=now;
				sad3.innerHTML=v[i].brojOsoba;
				sad4.innerHTML=v[i].krajnjiKorisnik.username;
				sad5.innerHTML = v[i].ocena;
				sad6.innerHTML = v[i].idSobe.idSoba;
				sad7.innerHTML = v[i].realizovana;
				if(v[i].ocena!=0){
				sad5.innerHTML=v[i].ocena;
				}
				
				red1.append(sad1);
				red1.append(sad2);
				red1.append(sad3);
				red1.append(sad4);
				red1.append(sad5);
				red1.append(sad6);
//				
//				$.ajax({
//					async: false,
//					url: "http://localhost:8081/agent/nadjiSobu",
//				    type: "GET",
//				    data: v[i].soba,
//				    success: function (data) {
//				    	sad6.innerHTML=data;
//				    	}
//				    });
				
				//sad6.innerHTML=v[i].soba.idSoba; //idsobe
				
			
				  var today = new Date();
				  var dd = String(today.getDate()).padStart(2, '0');
				  var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
				  var yyyy = today.getFullYear();
				today =yyyy+"-"+mm+"-"+dd;
				var b = new Date(today);
				alert(a + "  " + today);
				if(a.getFullYear() == yyyy && a.getDate() == b.getDate() && a.getMonth() == b.getMonth()  && (v[i].realizovana==false || v[i].realizovana=="" || v[i].realizovana==null)){
					var preuzmi = document.createElement("INPUT");
					preuzmi.setAttribute("type", "button");
					preuzmi.value="Realize";
					preuzmi.className="w3-btn w3-brown";
					preuzmi.setAttribute("onclick", "realizuj('"+v[i].idRezervacije+"')");
					preuzmi.style="padding:10px; margin:10px;";
					sad7.append(preuzmi);

				}else{
					alert("else");
					sad7.innerHTML=v[i].realizovana;
				}
				red1.append(sad7);


				tabela.append(red1);

	    	}
	    }
	},error:function(){alert("greska");}
	});
	divT.append(tabela);

}

function realizuj(id){
	$.ajax({
		async: false,
		url: "http://localhost:8081/rezervacija/realizacija/"+id,
	    type: "POST",
	    success: function (data) {
	    	reservations();
	    }
	    });
}

function sakriModal(){

	var adresa =document.getElementById('inpAdr').value;
	var idAdr=document.getElementById('idAdr').value;
	var nazTipa=document.getElementById('tipSobe').value;
	var nazKateg=document.getElementById('kategSobe').value;
	var brSobe=document.getElementById('brSobe').value;
	var brKreveta=document.getElementById('brKreveta').value;
	if(adresa=="" || adresa==null){
		toastr["warning"]("You must enter all the fields marked with a star!");
	}else if(brSobe=="" || brKreveta==""){
		toastr["warning"]("You must enter all the fields marked with a star!");
	}else{ 
		

		var opis=document.getElementById('opis').value;
		
		var dodatneUsluge = [];
	    $.each($("input[name='usluga']:checked"), function(){            
	    	dodatneUsluge.push($(this).val());
	    });
		var tipSmestaja=null;
		var kategorija=null;
		var adr=null;
		var usluge = [];

		$.ajax({
			async: false,
			url: "http://localhost:8081/agent/typeRoomNaziv/"+nazTipa,
		    type: "GET",
		    dataType: "json",
		    contentType: "application/json",
		    success: function (data) {
		    	tipSmestaja=data.idTipa;
	    }
		});
		
		
		$.ajax({
			async: false,
			url: "http://localhost:8081/agent/CategNaziv/"+nazKateg,
		    type: "GET",
		    dataType: "json",
		    contentType: "application/json",
		    success: function (data) {
		    	kategorija=data.id;
	    }
		});

		var soba = JSON.stringify({
			"broj_sobe": brSobe,
			"broj_kreveta" : brKreveta,
			"opis" : opis,
			"adresa" : idAdr,
			"tipSmestaja" : tipSmestaja,
			"kategorija":kategorija,
			"dodatneUsluge" : dodatneUsluge
		});
		
		if(images.length>0){
			$('#modalSoba').modal('hide');
		$.ajax({
			async: false,
			url: "http://localhost:8081/agent/addRoom",
	        type: "POST",
	        beforeSend: function(request) {
			    request.setRequestHeader("Authorization", localStorage.getItem('token'));
			},
	        contentType: "application/json",
	        data: soba,
	        success: function (data) {
	        	console.log(data)


	    		console.log($('#browse')[0].files[0]);

	    		var formData = new FormData();
	    		formData.append('file', $('#browse')[0].files[0])

	    		$.ajax({
	    		       url : 'http://localhost:8081/slika/' + data.idSoba,
	    		       headers: {'Authorization' : localStorage.getItem('token')},
	    		       contentType: false,
	    		       async: false,
	    		       type : 'post',
	    		       data : formData,
	    		       processData: false,  // tell jQuery not to process the data
	    		       contentType: false,  // tell jQuery not to set contentType
	    		       success : function(data) {
	    		           console.log('success');
	    		           //alert(data);
	    		       }, error: function(data) {
	    		    	   console.log('error');
	    		    	   console.log(data);
	    		       }
	    		});
	        }//,
//	        error: function (jqxhr, textStatus, errorThrown) {
//	            
//	        }
		});
	}else{
		toastr["warning"]("You must add an image!");
	}
	}
	
}

function getAdrese(){
	$('#modalAdrese').modal();
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/sveAdrese",
	    type: "GET",
	    success: function (data) {
	    	console.log(data);
	    	var divT = $('#adrese');
	    	divT.empty();
	    	var tabela=document.createElement("table");
			var red0=document.createElement("tr");
			var z1=document.createElement("th");
			var z2=document.createElement("th");
			var z3=document.createElement("th");
			z1.style=" border: 2px solid; padding: 15px ";
			z2.style=" border: 2px solid; padding: 15px ";
			z3.style=" border: 2px solid; padding: 15px ";
			z1.className="w3-text-brown";
			z2.className="w3-text-brown";
			z3.className="w3-text-brown";

			z1.innerHTML="State";
			z2.innerHTML="City";
			z3.innerHTML="Address and number";

			red0.append(z1);
			red0.append(z2);
			red0.append(z3);

			tabela.append(red0);
	    	for(var i=0;i<data.length;i++){
				
				var red1=document.createElement("tr");
				var sad1=document.createElement("td");
				var sad2=document.createElement("td");
				var sad3=document.createElement("td");
				
				sad1.style=" border: 2px solid; padding: 15px ";
				sad2.style=" border: 2px solid; padding: 15px ";
				sad3.style=" border: 2px solid; padding: 15px ";
				sad1.className="w3-text-brown";
				sad2.className="w3-text-brown";
				sad3.className="w3-text-brown";
				
				sad1.innerHTML=data[i].drzava;
				sad2.innerHTML=data[i].grad;
				sad3.innerHTML=data[i].ulicaIBroj;
				
				red1.append(sad1);
				red1.append(sad2);
				red1.append(sad3);
				red1.onmouseover = function() 
				{
				    this.style.backgroundColor = "lightblue";
				}
				red1.onmouseout = function() 
				{
				    this.style.backgroundColor = "white";
				}
				//red1.setAttribute("onclick", "izabranaAdresa('"+data[i].id"')");
				var slanje=data[i].drzava+"+"+data[i].grad+"+"+data[i].ulicaIBroj+"+"+data[i].id;
				red1.setAttribute("onclick", "izabranaAdresa('"+slanje+"')");

				tabela.append(red1);

	    	}
	    	divT.append(tabela);
	    }
	});

}

function izabranaAdresa(slanje){
	  $('#modalAdrese').modal('hide');
	 // alert(id);
	  var num= slanje.indexOf('+');
	  var drzava = slanje.substring(0, num);
	  slanje=slanje.substring(num+1, slanje.length);
	  num= slanje.indexOf('+');
	  var grad = slanje.substring(0, num);
	  slanje=slanje.substring(num+1, slanje.length);
	  num= slanje.indexOf('+');
	  var ulicaibroj = slanje.substring(0, num);
	  var id=slanje.substring(num+1, slanje.length);
	  if(ulicaibroj=="null"){
		  ulicaibroj="";
	  }
	  if(grad=="null"){
		  grad="";
	  }
	  if(drzava=="null"){
		  drzava="";
	  }
	 // alert(drzava+grad+ulicaibroj+" / "+id);
	  document.getElementById('inpAdr').value=ulicaibroj+" "+grad+" "+drzava;
	  document.getElementById('idAdr').value=id;

}

function numbersonly(myfield, e)
{
    var key;
    var keychar;

    if (window.event)
        key = window.event.keyCode;
    else if (e)
        key = e.which;
    else
        return true;

    keychar = String.fromCharCode(key);

    // control keys
    if ((key==null) || (key==0) || (key==8) || (key==9) || (key==13) || (key==27) )
        return true;

    // numbers
    else if ((("0123456789").indexOf(keychar) > -1))
        return true;

    else
        return false;
}
$(document).ready(function(){
	
	

});