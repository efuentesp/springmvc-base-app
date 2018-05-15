<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<h4>Management Employee</h4>
	<br>
	<div id="action"></div>
	<form id="command" action="searchEmployee" method="GET">

		<div class="row">
			<div class="col-md-11 col-md-offset-1">Name:<input id="name" name="name" type="text" value="${employee.name}" />
			</div>

		</div>
		<div class="row">
			<div class="col-md-1 col-md-offset-1 text-right">Address:</div>
			<div class="col-md-1"><input id="address" name="adress" type="text" value="${employee.address}" />
			</div>

		</div>
		<div class="row">
			<div class="col-md-1 col-md-offset-1 text-right">Age:</div>
			<div class="col-md-1"><input id="age" name="age" type="text" value="${employee.age}" />
			</div>

		</div>
		<div class="row">
			<div class="col-md-1 col-md-offset-1 text-right">Salary:</div>
			<div class="col-md-1"><input id="salary" name="salary" type="text" value="${employee.salary}" />
			</div>

		</div>


		<div class="row">
			<div class="col-md-1 col-md-offset-8"><input class="btn btn-primary" type="reset" value="Reset"></div> 
			<div class="col-md-1"><input type="submit" class="btn btn-primary" value="Search"></div> 
			<div class="col-md-1 col-md-offset-1"><a href="#" class="btn btn-primary" role="button" data-toggle="modal" data-target="#myModal" onClick="save();"> Create</a></div>
		</div>
	</form>
	<br>
	
	
	<div class="table-responsive">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Age</th>
					<th>Salary</th>
					<th>Action on Row</th>
					<th>Action on Row</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.name}"></c:out></td>
						<td><c:out value="${employee.address}"></c:out>
						<td><c:out value="${employee.age}"></c:out></td>
						<td><c:out value="${employee.salary}"></c:out></td>
						<td align="center"><a href="#" data-toggle="modal"
							data-target="#myModal"
							onclick="edit('${employee.id}','${employee.name}','${employee.address}','${employee.age}','${employee.salary}');">
								<span class="glyphicon glyphicon-edit"></span>
						</a></td>

						<td align="center"><a href="#" data-toggle="modal"
							data-target="#confirmDelete" onClick="erase('${employee.id}')">
								<span class="glyphicon glyphicon-trash"></span>
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
							<td>Name:</td>
							<td><input type="text" id="namemodal"></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><input type="text" id="addressmodal"></td>
						</tr>
						<tr>
							<td>Age:</td>
							<td><input type="text" id="agemodal"></td>
						</tr>
						<tr>
							<td>Salary:</td>
							<td><input type="text" id="salarymodal"></td>
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
	src="${pageContext.request.contextPath}/resources/js/manageEmployee.js"></script>
