	$("#action").val('entrando');

	function edit(a1, a2, a3, a4, a5) {

		$("#title").text("Edit");
		$('#idmodal').val(a1);
		$('#namemodal').val(a2);
		$('#addressmodal').val(a3);
		$('#agemodal').val(a4);
		$('#salarymodal').val(a5);
		$("#action").val('editEmployee');

	}
	function save() {

		$("#title").text("New");
		$('#idmodal').val('');
		$('#namemodal').val('');
		$('#addressmodal').val('');
		$('#agemodal').val('');
		$('#salarymodal').val('');
		$("#action").val('saveEmployee');

	}

	function erase(a1) {
		$('#idmodal').val(a1);
	}

	function doAjaxPost(action) {

		var idmodal = $('#idmodal').val();
		var namemodal = $('#namemodal').val();
		var addressmodal = $('#addressmodal').val();
		var agemodal = $('#agemodal').val();
		var salarymodal = $('#salarymodal').val();
		var agemodal = $('#agemodal').val();

		var url = contextPath + "/" + action;

		var str = "id=" + idmodal + "&name=" + namemodal + "&address="
				+ addressmodal + "&age=" + agemodal + "&salary=" + salarymodal;
		alert(url);

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
			url : contextPath + "/deleteEmployee",
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
	