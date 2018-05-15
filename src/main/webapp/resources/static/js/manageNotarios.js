	$("#action").val('entrando');

	function edit(varid,varnombre, varrfccurp, varhsectiondireccion, varnotaria, varradio, varejcheck, vararea) {

		$("#title").text("Edit");
		$('#idmodal').val(varid);
        $('#nombremodal').val(varnombre);
        $('#rfccurpmodal').val(varrfccurp);
        $('#hsectiondireccionmodal').val(varhsectiondireccion);
        $('#notariamodal').val(varnotaria);
        $('#radiomodal').val(varradio);
        $('#ejcheckmodal').val(varejcheck);
        $('#areamodal').val(vararea);
		$("#action").val('editNotarios');

	}
	function save() {

		$("#title").text("New");
		$('#idmodal').val('');
        $('#nombremodal').val('');
        $('#rfccurpmodal').val('');
        $('#hsectiondireccionmodal').val('');
        $('#notariamodal').val('');
        $('#radiomodal').val('');
        $('#ejcheckmodal').val('');
        $('#areamodal').val('');
		$("#action").val('saveNotarios');

	}

	function erase(a1) {
		$('#idmodal').val(a1);
	}

	function doAjaxPost(action) {

		var idmodal = $('#idmodal').val();
        var nombremodal = $('#nombremodal').val();
        var rfccurpmodal = $('#rfccurpmodal').val();
        var hsectiondireccionmodal = $('#hsectiondireccionmodal').val();
        var notariamodal = $('#notariamodal').val();
        var radiomodal = $('#radiomodal').val();
        var ejcheckmodal = $('#ejcheckmodal').val();
        var areamodal = $('#areamodal').val();

		var url = contextPath + "/" + action;

		var str = "id=" + idmodal +"&nombre=" + nombremodal +"&rfccurp=" + rfccurpmodal +"&hsectiondireccion=" + hsectiondireccionmodal +"&notaria=" + notariamodal +"&radio=" + radiomodal +"&ejcheck=" + ejcheckmodal +"&area=" + areamodal ;

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
			url : contextPath + "/deleteNotarios",
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
