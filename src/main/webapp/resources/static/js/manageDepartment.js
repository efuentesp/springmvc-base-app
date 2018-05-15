	$("#action").val('entrando');

	function edit(varid,varname, varsections, vararea) {

		$("#title").text("Edit");
		$('#idmodal').val(varid);
        $('#namemodal').val(varname);
        $('#sectionsmodal').val(varsections);
        $('#areamodal').val(vararea);
		$("#action").val('editDepartment');

	}
	function save() {

		$("#title").text("New");
		$('#idmodal').val('');
        $('#namemodal').val('');
        $('#sectionsmodal').val('');
        $('#areamodal').val('');
		$("#action").val('saveDepartment');

	}

	function erase(a1) {
		$('#idmodal').val(a1);
	}

	function doAjaxPost(action) {

		var idmodal = $('#idmodal').val();
        var namemodal = $('#namemodal').val();
        var sectionsmodal = $('#sectionsmodal').val();
        var areamodal = $('#areamodal').val();

		var url = contextPath + "/" + action;

		var str = "id=" + idmodal +"&name=" + namemodal +"&sections=" + sectionsmodal +"&area=" + areamodal ;

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
			url : contextPath + "/deleteDepartment",
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
