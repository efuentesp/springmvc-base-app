
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jaas-all.min.js"></script>

<div class="container">

	<div class="page-header">
		<h1>
			<small>MASTER DETAIL</small>
		</h1>
	</div>


	<!-- Detail Grids - START -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Master Grid</h3>
					</div>
					<div class="panel-body">
						<div id="grid1"></div>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12 col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Details Grid</h3>
					</div>
					<div class="panel-body">
						<div id="grid2"></div>
						<span id="hint" class="label label-warning">Select a row
							from Master Grid to populate details grid.</span>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		jQuery(function($) {
			function createFirstGridData(count) {
				var data = [];
				for (var i = 0; i < count; i++) {
					data.push({
						id : i,
						year : 2000 + i,
						price : 1000 - i
					});
				}
				return data;
			}

			function createSecondGridData(count) {
				var data = [];
				for (var i = 0; i < count; i++) {
					for (var j = 0; j < count; j++) {
						data.push({
							id : j + i,
							productcount : (j + i + i),
							parentid : i
						});
					}
				}
				return data;
			}

			$("#grid1")
					.shieldGrid(
							{
								dataSource : {
									data : createFirstGridData(10)
								},
								paging : {
									pageSize : 5
								},
								selection : {
									type : "row",
									multiple : false
								},
								events : {
									selectionChanged : function(e) {
										$("#hint").hide();

										var selectedItemID = $("#grid1")
												.swidget().contentTable.find(
												".sui-selected").get(0).cells[0].innerHTML;
										var secondGrid = $("#grid2").swidget();
										if (secondGrid) {
											secondGrid.dataSource.filter.value = selectedItemID;
											secondGrid.refresh();
										} else {
											$("#grid2")
													.shieldGrid(
															{
																dataSource : {
																	data : createSecondGridData(10),
																	filter : {
																		path : "id",
																		filter : "eq",
																		value : selectedItemID
																	}
																},
																paging : true,
																columns : [
																		{
																			field : "id",
																			width : "100px",
																			title : "ID"
																		},
			{ field:"productcount", title: "ProductCount"}, { field:"parentid", title: "ParentID"}
]
															});
										}
									}
								},
								columns : [ {
									field : "id",
									width : "70px",
									title : "ID"
								}, { field:"year", title: "Year"}, { field:"price", title: "Price"}
								 ]
							});
		});
	</script>
	<!-- Detail Grids - END -->

</div>
