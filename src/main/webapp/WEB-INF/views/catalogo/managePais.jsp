

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
		<h4>Management Pais</h4>
		<br>
	<div id="action"></div>
	
	<div class="panel panel-default">
	<div class="panel-heading">Pais</div>
	<div class="panel-body">
	<form id="command" action="searchPais" method="GET">
	        
	<div class="row">
		<div class="col-md-1 col-md-offset-1">Clave:</div>
		<div class="col-md-2"><input id="clave" name="clave" value="${pais.clave}" size="20"   type="text" >	
		</div>
	</div>
			
	        
	<div class="row">
		<div class="col-md-1 col-md-offset-1">Estados:</div>
		<div class="col-md-2">
		<select>
	  		<option value="DF">DF</option>
		</select>
		</div>
	</div>
			
	        
	<div class="row">
		<div class="col-md-1 col-md-offset-1">Nombre:</div>
		<div class="col-md-2"><input id="nombre" name="nombre" value="${pais.nombre}" size="20"   type="text" >	
		</div>
	</div>
			
				<div class="row">
					<div class="col-md-1 col-md-offset-10"><input class="btn btn-primary" type="reset" value="Reset"></div>
					<div class="col-md-1"><input type="submit" class="btn btn-primary" value="Search"></div>
				</div>
	     
			</form>
	        </div></div>
	
	
	



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
                        <th>Nombre</th>
                        <th>Clave</th>
                        <th>Estados</th>
                             <th>Action on Row</th>
                             <th>Action on Row</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${paiss}" var="pais">
						<tr>
                            <td><c:out value="${pais.nombre}"></c:out></td>
                            <td><c:out value="${pais.clave}"></c:out></td>
                            <td><c:out value="${pais.estados}"></c:out></td>
							<td align="center">
							<a href="#" data-toggle="modal" data-target="#deleteModal" onclick="delete('${pais}');">
									<span class="glyphicon glyphicon-edit"></span>
							</a></td>
							<td align="center">
							<a href="#" data-toggle="modal" data-target="#editModal" onclick="edit('${pais}');">
									<span class="glyphicon glyphicon-edit"></span>
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
								<div class="col-md-2 col-md-offset-1">Nombre:</div>
								<div class="col-md-2"><input id="nombre" name="nombre" value="${pais.nombre}" size="20"   type="text" >	
								</div>
							</div>

							<div class="row">
								<div class="col-md-2 col-md-offset-1">Clave:</div>
								<div class="col-md-2"><input id="clave" name="clave" value="${pais.clave}" size="20"   type="text" >	
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

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/managePais.js"></script>

