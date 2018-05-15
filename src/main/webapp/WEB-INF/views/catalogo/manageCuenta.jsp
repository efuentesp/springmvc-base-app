

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
		<h4>Management Cuenta</h4>
		<br>
		<div id="action"></div>
		
        		
        		
        		<div class="panel panel-default">
        		<div class="panel-heading">Cuenta</div>
        		<div class="panel-body">
        		<form:form action="searchCuenta" method="GET">
        			<div class="row">
        		   
        		        				
        				<div class="col-md-1 col-md-offset-1 text-right">Fecha:</div>
        			    <div class="col-md-1">
        					<input id="fecha" name="fecha" value="${cuenta.fecha}"   type="date" >	
        				</div>
        		   
        		   
        		        				
        				<div class="col-md-1 col-md-offset-1 text-right">Titular:</div>
        			    <div class="col-md-1">
        					<input id="titular" name="titular" value="${cuenta.titular}"   size="20" type="text" >	
        				</div>
        			</div>
        			<div class="row">           
        		   
        		        				
        				<div class="col-md-1 col-md-offset-1 text-right">Saldo:</div>
        			    <div class="col-md-1">
        					<input id="saldo" name="saldo" value="${cuenta.saldo}"  type="number"  >	
        				</div>
        		   
        		        				
        				<div class="col-md-1 col-md-offset-1 text-right">Banco:</div>
        			    <div class="col-md-1">
        					<input id="banco" name="banco" value="${cuenta.banco}"   size="20" type="text" >	
        				</div>
        		   
        			</div>
        			<div class="row">           
        		   
        		   
        		        				
        				<div class="col-md-1 col-md-offset-1 text-right">Tipo:</div>
        			    <div class="col-md-1">
        					<input id="tipo" name="tipo" value="${cuenta.tipo}"   size="20" type="text" >	
        				</div>
        			</div>
        					<div class="row">
        						<div class="col-md-1 col-md-offset-10"><input class="btn btn-primary" type="reset" value="Reset"></div>
        						<div class="col-md-1"><input type="submit" class="btn btn-primary" value="Buscar"></div>
        					</div>
        		     
        				</form:form>
        		    </div></div>
        		
<br>
			<div class="table-responsive">
				<table style="width: 100%">
					<tbody>
						<tr>
							<td colspan="2" align="right">
							<input class="btn btn-primary" type="reset" value="Reset">
							<input type="submit"
								class="btn btn-primary" value="Search"></td>
							<td align="center"><a href="#" class="btn btn-primary"
								role="button" data-toggle="modal" data-target="#myModal"
								onClick="save();"> Create</a></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
                        <th>Fecha</th>
                        <th>#columnsGrid</th>
                        <th>Titular</th>
                        <th>Saldo</th>
                        <th>Banco</th>
                        <th>Codigo</th>
                        <th>Cotitular</th>
                        <th>Tipo</th>
                             <th>Action on Row</th>
                             <th>Action on Row</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${cuentas}" var="cuenta">
						<tr>
                            <td><c:out value="${cuenta.fecha}"></c:out></td>
                            <td><c:out value="4"></c:out></td>
                            <td><c:out value="${cuenta.titular}"></c:out></td>
                            <td><c:out value="${cuenta.saldo}"></c:out></td>
                            <td><c:out value="${cuenta.banco}"></c:out></td>
                            <td><c:out value="${cuenta.codigo}"></c:out></td>
                            <td><c:out value="${cuenta.cotitular}"></c:out></td>
                            <td><c:out value="${cuenta.tipo}"></c:out></td>
							<td align="center">
							<a href="#" data-toggle="modal" data-target="#myModal" onclick="edit('${cuenta}');">
									<span class="glyphicon glyphicon-edit"></span>
							</a></td>
							<td align="center">
							<a href="#" data-toggle="modal" data-target="#deleteModal" onclick="delete('${cuenta}');">
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
		<br>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
                        <th>Titular</th>
                        <th>Tipo</th>
                        <th>Saldo</th>
                        <th>Banco</th>
                        <th>Codigo</th>
                        <th>Cotitular</th>
                        <th>Fecha</th>
                        <th>#columnsGrid</th>
						<th>Action on Row</th>
						<th>Action on Row</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${cuentas}" var="cuenta">
						<tr>
                            <td><c:out value="${cuenta.titular}"></c:out></td>
                            <td><c:out value="${cuenta.tipo}"></c:out></td>
                            <td><c:out value="${cuenta.saldo}"></c:out></td>
                            <td><c:out value="${cuenta.banco}"></c:out></td>
                            <td><c:out value="${cuenta.codigo}"></c:out></td>
                            <td><c:out value="${cuenta.cotitular}"></c:out></td>
                            <td><c:out value="${cuenta.fecha}"></c:out></td>
                            <td><c:out value="4"></c:out></td>
							<td align="center"><a href="#" data-toggle="modal"
								data-target="#myModal"
								onclick="edit('${cuenta.id}','${cuenta.titular}','${cuenta.tipo}','${cuenta.saldo}','${cuenta.banco}','${cuenta.codigo}','${cuenta.cotitular}','${cuenta.fecha}','4');">
									<span class="glyphicon glyphicon-edit"></span>
							</a></td>

							<td align="center"><a href="#" data-toggle="modal"
								data-target="#confirmDelete" onClick="erase('${cuenta.id}')"> <span
									class="glyphicon glyphicon-trash"></span></a></td>
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
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							<label id="title"></label>
						</h4>
					</div>
					<div class="modal-body">
						<table>
							<tr>
								<td></td>
								<td><input type="text" hidden="true" id="idmodal"></td>
							</tr>
                            <tr>
								<td>Titular:</td>
								<td><input type="text" id="titularmodal"></td>
							</tr>
                            <tr>
								<td>Tipo:</td>
								<td><input type="text" id="tipomodal"></td>
							</tr>
                            <tr>
								<td>Saldo:</td>
								<td><input type="text" id="saldomodal"></td>
							</tr>
                            <tr>
								<td>Banco:</td>
								<td><input type="text" id="bancomodal"></td>
							</tr>
                            <tr>
								<td>Codigo:</td>
								<td><input type="text" id="codigomodal"></td>
							</tr>
                            <tr>
								<td>Cotitular:</td>
								<td><input type="text" id="cotitularmodal"></td>
							</tr>
                            <tr>
								<td>Fecha:</td>
								<td><input type="text" id="fechamodal"></td>
							</tr>
                            <tr>
								<td>#columnsGrid:</td>
								<td><input type="text" id="4"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary"
							onClick="doAjaxPost($('#action').val())">Save</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="confirmDelete" tabindex="-1" role="dialog"
			aria-labelledby="confirmDeleteLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="confirmDeleteLabel">Delete
							Permanently</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure about this ?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-danger"
							onClick="deleteAjaxPost()">Delete</button>
					</div>
				</div>
			</div>

		</div>
	</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/manageCuenta.js"></script>

