	$("#action").val('entrando');

	function edit(varid,varclave, varnombre, varestados) {

		$("#title").text("Edit");
		$('#idmodal').val(varid);
        $('#clavemodal').val(varclave);
        $('#nombremodal').val(varnombre);
        $('#estadosmodal').val(varestados);
		$("#action").val('editPais');

	}
	function save() {

		$("#title").text("New");
		$('#idmodal').val('');
        $('#clavemodal').val('');
        $('#nombremodal').val('');
        $('#estadosmodal').val('');
		$("#action").val('savePais');

	}

	function erase(a1) {
		$('#idmodal').val(a1);
	}

	function doAjaxPost(action) {

		var idmodal = $('#idmodal').val();
        var clavemodal = $('#clavemodal').val();
        var nombremodal = $('#nombremodal').val();
        var estadosmodal = $('#estadosmodal').val();

		var url = contextPath + "/" + action;

		var str = "id=" + idmodal +"&clave=" + clavemodal +"&nombre=" + nombremodal +"&estados=" + estadosmodal ;

		$.ajax({
			type : "POST",
			url : url,
			data : str,
			success : function(response) {
				$("#myModal").modal('hide');
				location.reload();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function deleteAjaxPost() {
		var idmodal = $('#idmodal').val();

		$.ajax({
			type : "POST",
			url : contextPath + "/deletePais",
			data : "id=" + idmodal,
			success : function(response) {
				$("#confirmDelete").modal('hide');
				location.reload();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
