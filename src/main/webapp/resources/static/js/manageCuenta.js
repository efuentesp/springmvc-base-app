	$("#action").val('entrando');

function edit(varbanco, varcodigo, varfecha, varsaldo, vartipo, varcotitular, vartitular, varid) {

//	function edit(varid) {	
		
		//alert(varid);
		//alert(vartitular);
		//alert(varfecha)
		//alert($('#varid').val(saldo));	
		//alert(vartitular);
		//alert(varsaldo);
		//alert("#{varid.saldo}");
		//alert ( $('#editcotitularModal').val())
	
	
		$('#editbancoModal').val(varbanco);
		$('#editcodigoModal').val(varcodigo);
		$('#editsaldoModal').val(varsaldo);
		$('#edittipoModal').val(vartipo);
		$('#editcotitularModal').val(varcotitular);
		$('#edittitularModal').val(vartitular);
		$('#editidModal').val(varid);
		
		//$('#editcodigoModal').val(varcodigo);
		
		
		//$("#title").text("Edit");
		//$('#idmodal').val(varid);
		//$('#titularmodal').val(vartitular);
		//$('#tipomodal').val(vartipo);
		//$('#saldomodal').val(varsaldo);
		//$('#bancomodal').val(varbanco);
		//$('#codigomodal').val(varcodigo);
		//$('#cotitularmodal').val(varcotitular);
		//$('#fechamodal').val(varfecha);
		//$("#action").val('editCuenta');

	}
	function save() {

		$("#title").text("New");
		$('#idmodal').val('');
        $('#titularmodal').val('');
        $('#tipomodal').val('');
        $('#saldomodal').val('');
        $('#bancomodal').val('');
        $('#codigomodal').val('');
        $('#cotitularmodal').val('');
        $('#fechamodal').val('');
		$("#action").val('saveCuenta');
		
	}

	function erase(a1) {
		$('#deleteidModal').val(a1);
	}

	function doAjaxPost(action) {

		var idmodal = $('#idModal').val();
        var titularmodal = $('#titularModal').val();
        var tipomodal = $('#tipoModal').val();
        var saldomodal = $('#saldoModal').val();
        var bancomodal = $('#bancoModal').val();
        //alert('hu');
        var codigomodal = $('#codigoModal').val();
        var cotitularmodal = $('#cotitularModal').val();
        var fechamodal = $('#fechaModal').val();
        
        var fechafinal = fechamodal.replace(/-/g, "/"); 
		var url = contextPath + "/saveCuenta";

		//var str = "id=" + idmodal +"&titular=" + titularmodal +"&tipo=" + tipomodal +"&saldo=" + saldomodal +"&banco=" + bancomodal +"&codigo=" + codigomodal +"&cotitular=" + cotitularmodal +"&fecha=" + fechamodal ;
		var str = "id=1" + "&titular=" + encodeURIComponent(titularmodal) +
		          "&tipo=" +  encodeURIComponent(tipomodal) + "&saldo=" + encodeURIComponent(saldomodal) +	
		          "&banco=" +  encodeURIComponent(bancomodal) + "&codigo=" + encodeURIComponent(codigomodal) +
		          "&cotitular=" +  encodeURIComponent(cotitularmodal) + "&fecha=" + encodeURIComponent(fechafinal);
		
		//alert(url);
		//alert(str);
		
		$.ajax({
			type : "POST",
			url : contextPath + "/saveCuenta",
			data : str,
			success : function(response) {
				$("#myModal").modal('hide');
				location.reload();
			},
			error : function(data, textStatus, jqXHR) {
				alert('Error: ' + data.error + ' ' + jqXHR.url);
			}
		});

	}

	
	function doAjaxPostUpdate(action) {

		var idmodal = $('#editidModal').val();
        var titularmodal = $('#edittitularModal').val();
        var tipomodal = $('#edittipoModal').val();
        var saldomodal = $('#editsaldoModal').val();
        var bancomodal = $('#editbancoModal').val();
        //alert('hu');
        var codigomodal = $('#editcodigoModal').val();
        var cotitularmodal = $('#editcotitularModal').val();
        var fechamodal = $('#editfechaModal').val();
        var fechafinal = fechamodal.replace(/-/g, "/"); 
		var url = contextPath + "/editCuenta";

		//var str = "id=" + idmodal +"&titular=" + titularmodal +"&tipo=" + tipomodal +"&saldo=" + saldomodal +"&banco=" + bancomodal +"&codigo=" + codigomodal +"&cotitular=" + cotitularmodal +"&fecha=" + fechamodal ;
		var str = "id=" + encodeURIComponent(idmodal)  + "&titular=" + encodeURIComponent(titularmodal) +
		          "&tipo=" +  encodeURIComponent(tipomodal) + "&saldo=" + encodeURIComponent(saldomodal) +	
		          "&banco=" +  encodeURIComponent(bancomodal) + "&codigo=" + encodeURIComponent(codigomodal) +
		          "&cotitular=" +  encodeURIComponent(cotitularmodal);
		
		$.ajax({
			type : "POST",
			url : contextPath + "/editCuenta",
			data : str,
			success : function(response) {
				$("#myModal").modal('hide');
				location.reload();
			},
			error : function(data, textStatus, jqXHR) {
				alert('Error: ' + data.error + ' ' + jqXHR.url);
			}
		});

	}
	
	
	
	function deleteAjaxPost() {
		
		var idmodal = $('#deleteidModal').val();

		$.ajax({
			type : "POST",
			url : contextPath + "/deleteCuenta",
			data : "id=" + idmodal,
			success : function(response) {
				$("#confirmDelete").modal('hide');
				location.reload();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('Error: ' + errorThrown);
			}
		});
	}
