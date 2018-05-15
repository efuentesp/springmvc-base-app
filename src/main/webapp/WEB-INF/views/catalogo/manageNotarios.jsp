

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<h4>Management Notarios</h4>
	<br>
	<div id="action"></div>

	<div class="panel panel-default">
		<div class="panel-heading">Notarios</div>
		<div class="panel-body">
			<form id="command" action="searchNotarios" method="GET">

				<div class="row">
					<div class="col-md-1 col-md-offset-1">Area:</div>
					<div class="col-md-5">
						<textarea id="area" name="area" rows="4" cols="60">${notarios.area}</textarea>
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Todos:</div>
					<div class="col-md-2">
						<input id="ejcheck" name="ejcheck" value="${notarios.ejcheck}"
							type="checkbox">
					</div>
				</div>

				<div class="row">
					<div class="col-md-1 col-md-offset-1">Colonia:</div>
					<div class="col-md-4">
						<input id="lookupColonia" name="" value="" type="text"> <a
							href="#" data-toggle="modal" data-target="#lookupDireccion"
							onclick=""> <span class="glyphicon glyphicon-search"></span></a>
					</div>
				</div>
				<hr>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Calleynumero:</div>
					<div class="col-md-2">
						<input id="calleynumero" name="calleynumero"
							value="${direccion.calleynumero}" size="45" type="text">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Colonia:</div>
					<div class="col-md-2">
						<input id="colonia" name="colonia" value="${direccion.colonia}"
							size="20" type="text">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Cp:</div>
					<div class="col-md-2">
						<input id="cp" name="cp" value="${direccion.cp}" size="20"
							type="text">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Estado:</div>
					<div class="col-md-2">
						<select>
							<option value="DF">DF</option>
						</select>
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Pais:</div>
					<div class="col-md-2">
						<select>
							<option value="MEXICO">MEXICO</option>
							<option value="EUA">EUA</option>
						</select>
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Poblacion:</div>
					<div class="col-md-2">
						<input id="poblacion" name="poblacion"
							value="${direccion.poblacion}" size="20" type="text">
					</div>
				</div>




				<hr>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Nombre:</div>
					<div class="col-md-2">
						<input id="nombre" name="nombre" value="${notarios.nombre}"
							size="45" type="text">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">Notaria:</div>
					<div class="col-md-2">
						<input id="notaria" name="notaria" value="${notarios.notaria}"
							size="45" type="text">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">SEXO</div>
					<div class="col-md-1 col-md-offset-1">Masculino:</div>
					<div class="col-md-2">
						<input id="radio" name="radio" value="${notarios.radio}"
							type="radio">
					</div>
					<div class="col-md-1 col-md-offset-1">Femenino:</div>
					<div class="col-md-2">
						<input id="radio" name="radio" value="${notarios.radio}"
							type="radio">
					</div>
				</div>


				<div class="row">
					<div class="col-md-1 col-md-offset-1">RfcCurp:</div>
					<div class="col-md-2">
						<input id="rfccurp" name="rfccurp" value="${notarios.rfccurp}"
							size="20" type="text">
					</div>
				</div>

				<div class="row">
					<div class="col-md-1 col-md-offset-10">
						<input class="btn btn-primary" type="reset" value="Reset">
					</div>
					<div class="col-md-1">
						<input type="submit" class="btn btn-primary" value="Search">
					</div>
				</div>

			</form>
		</div>
	</div>






	<div class="table-responsive">
		<table style="width: 100%">
			<tbody>
				<tr>
					<td align="right"><a href="#" class="btn btn-primary"
						role="button" data-toggle="modal" data-target="#Create"
						onClick="save();"> Create</a></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="table-responsive">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Sexo</th>
					<th>Nombre</th>
					<th>Area</th>
					<th>Notaria</th>
					<th>Ejcheck</th>
					<th>RfcCurp</th>
					<th>Action on Row</th>
					<th>Action on Row</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${notarioss}" var="notarios">
					<tr>
						<td><c:out value="${notarios.radio}"></c:out></td>
						<td><c:out value="${notarios.nombre}"></c:out></td>
						<td><c:out value="${notarios.area}"></c:out></td>
						<td><c:out value="${notarios.notaria}"></c:out></td>
						<td><c:out value="${notarios.ejcheck}"></c:out></td>
						<td><c:out value="${notarios.rfccurp}"></c:out></td>
						<td align="center"><a href="#" data-toggle="modal"
							data-target="#deleteModal" onclick="delete('${notarios}');">
								<span class="glyphicon glyphicon-edit"></span>
						</a></td>
						<td align="center"><a href="#" data-toggle="modal"
							data-target="#editModal" onclick="edit('${notarios}');"> <span
								class="glyphicon glyphicon-edit"></span>
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="table-responsive">
		<table style="width: 100%">
			<tr>
				<td align="right">
					<ul class="pagination pagination-sm">
						<li><a href="#">&lt;&lt;</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&gt;&gt;</a></li>

					</ul>
				</td>
			<tr>
		</table>
		<br> <br>
	</div>

	<div class="modal fade" id="Create" tabindex="-1" role="dialog"
		aria-labelledby="CreateLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="CreateLabel">
						<label>Create</label>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-2 col-md-offset-1">Sexo:</div>
						<div class="col-md-2">
							<input id="radio" name="radio" value="${notarios.radio}"
								type="radio">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2 col-md-offset-1">Nombre:</div>
						<div class="col-md-2">
							<input id="nombre" name="nombre" value="${notarios.nombre}"
								size="45" type="text">
						</div>
					</div>



					<div class="row">
						<div class="col-md-2 col-md-offset-1">Notaria:</div>
						<div class="col-md-2">
							<input id="notaria" name="notaria" value="${notarios.notaria}"
								size="45" type="text">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2 col-md-offset-1">Ejcheck:</div>
						<div class="col-md-2">
							<input id="ejcheck" name="ejcheck" value="${notarios.ejcheck}"
								type="checkbox">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2 col-md-offset-1">RfcCurp:</div>
						<div class="col-md-2">
							<input id="rfccurp" name="rfccurp" value="${notarios.rfccurp}"
								size="20" type="text">
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary"
						onClick="doAjaxPostCreate()">Save</button>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="lookupDireccion" tabindex="-1"
		role="dialog" aria-labelledby="CreateLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="CreateLabel">
						<label>Lookup Dirección</label>
					</h4>
				</div>
				<div class="modal-body">

					<div class="row">
						<div class="col-md-2 col-md-offset-1">Colonia:</div>
						<div class="col-md-2">
							<input id="colonia" name="colonia" value="${direccion.colonia}"
								size="20" type="text">
						</div>
					</div>


					<div class="row">
						<div class="col-md-2 col-md-offset-1">Cp:</div>
						<div class="col-md-2">
							<input id="cp" name="cp" value="${direccion.cp}" size="20"
								type="text">
						</div>
					</div>


					<div class="row">
						<div class="col-md-2 col-md-offset-1">Estado:</div>
						<div class="col-md-2">
							<select>
								<option value="DF">DF</option>
							</select>
						</div>
					</div>


					<div class="row">
						<div class="col-md-2 col-md-offset-1">Pais:</div>
						<div class="col-md-2">
							<select>
								<option value="MEXICO">MEXICO</option>
								<option value="EUA">EUA</option>
							</select>
						</div>
					</div>


					<div class="row">
						<div class="col-md-2 col-md-offset-1">Poblacion:</div>
						<div class="col-md-2">
							<input id="poblacion" name="poblacion"
								value="${direccion.poblacion}" size="20" type="text">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2 col-md-offset-9">
							<button type="button" class="btn btn-primary"
								onClick="lookupBuscar()">Buscar</button>
						</div>
					</div>

				</div>
				<div id="lookupfooter" class="modal-footer" hidden="true">
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Colonia</th>
									<th>CP</th>
									<th>Select</th>


								</tr>
							</thead>
							<tbody>


								<tr>
									<td>Roma Norte</td>
									<td>77777</td>
									<td align="center"><a href="#" onclick="closeLookup('1');">
											<span class="glyphicon glyphicon-ok"></span>
									</a></td>
								</tr>
								<tr>
									<td>Roma Sur</td>
									<td>66666</td>
									<td align="center"><a href="#" onclick="closeLookup('2');">
											<span class="glyphicon glyphicon-ok"></span>
									</a></td>
								</tr>
								<tr>
									<td>Roma Centro</td>
									<td>55555</td>
									<td align="center"><a href="#" onclick="closeLookup('3');">
											<span class="glyphicon glyphicon-ok"></span>
									</a></td>
								</tr>

							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>


		<div class="modal fade" id="delete" tabindex="-1" role="dialog"
			aria-labelledby="deleteLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="deleteLabel">
							<label>Delete Permanently</label>
						</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure about this ?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary"
							onClick="doAjaxPostdelete()">Save</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		function lookupBuscar() {
			$("#lookupfooter").show();
		}
		function closeLookup(a) {
			
			if (a=='1'){
				$("#lookupColonia").val("Roma Norte");
			}
			if (a=='2'){
				$("#lookupColonia").val("Roma Sur");
			}
			if (a=='3'){
				$("#lookupColonia").val("Roma Centro");
			}
			$("#lookupDireccion").modal('hide');
			$("#lookupfooter").hide();

		}
		
	</script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/manageNotarios.js"></script>