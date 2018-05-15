<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
	<h4>Management Person</h4><br>
	<div id="action"></div>
		<div class="panel panel-default">
		<div class="panel-heading">Person</div>
		<div class="panel-body">
		<form id="command" action="searchItem" method="GET">
			<div class="row">
				<div class="col-md-1 col-md-offset-1"><spring:message code="label.person.attributei" text="AttributeI"/>:</div>
				<div class="col-md-10"><input id="attributeI" name="attributeI" value="${person.attributei}" size="20"   type="text" ></div>
		
			</div>
			<div class="row">
				<div class="col-md-1 col-md-offset-1"><spring:message code="label.person.attributeii" text="AttributeII"/>:</div>
				<div class="col-md-10"><input id="attributeII" name="attributeII" value="${person.attributeii}" size="20"   type="text" ></div>
		
			</div>
			<div class="row">
		
			</div>
			<div class="row">
		
			</div>
			<div class="row">
		
			</div>
			<div class="row">
		
			</div>
			<div class="row">
		
			</div>
			<div class="row">
		
			</div>
		    <div class="row">
				<div class="col-md-1 col-md-offset-10"><input class="btn btn-primary" type="reset" value="<spring:message code="button.reset" text="Reset"/>"></div>
				<div class="col-md-1"><input type="submit" class="btn btn-primary" value="Search"></div>
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
						onClick="create();"> Create</a></td>
				</tr>
			</tbody>
		</table>
	</div>
		<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
								<th>AttributeI</th>
								<th>AttributeII</th>
								<th>age</th>
								<th>dateOfBirth</th>
								<th>emails</th>
								<th>firstName</th>
								<th>name</th>
								<th>salary</th>
							<th>Action on Row</th>
	                        <th>Action on Row</th>
						</tr>
					</thead>
					<tbody>
	
					</tbody>
				</table>
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
			<div class="col-md-1 col-md-offset-1"><spring:message code="label.person.attributei" text="AttributeI"/>:</div>
			<div class="col-md-0"><input id="attributei" name="attributei" value="${person.attributei}" size="20"   type="text" ></div>
	
			<div class="col-md-1 col-md-offset-1"><spring:message code="label.person.attributeii" text="AttributeII"/>:</div>
			<div class="col-md-0"><input id="attributeii" name="attributeii" value="${person.attributeii}" size="20"   type="text" ></div>
	
	
	
	
			</div>
			<div class="row">
	
	
	
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onClick="doAjaxPost()">Save</button>
						</div>
					</div>
				</div>
			</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/managePerson.js"></script>
