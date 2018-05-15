
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">

	<div class="panel panel-default">
  		<div class="panel-heading">Section Generic</div>
		<div class="panel-body">
			
			    Nombre<br>
			
			    Importe<br>
			
			    Asignacion<br>
			
			    Tipo<br>
		</div>
	</div>

	<ul class="nav nav-tabs" role="tablist">
		<li><a data-toggle="tab" href="#sectionDocumentos">Documentos</a></li>
		<li><a data-toggle="tab" href="#sectionSolicitante">Solicitante</a></li>
		<li><a data-toggle="tab" href="#sectionImpuesto">Impuesto</a></li>
	</ul>

            <br><br><br>
	<div class="tab-content">

			<div id="sectionDocumentos" class="tab-pane fade"> 
            <div class="table-responsive">
  <table style="width: 100%">
					<tbody>           
<tr>
							<td align="right">Tipo:</td>
							<td><input type="text" value="" /></td>
						</tr>

</tbody>
</table>
</div>

            </div>

			<div id="sectionSolicitante" class="tab-pane fade"> 
            <div class="table-responsive">
  <table style="width: 100%">
					<tbody>           
<tr>
							<td align="right">Nombre:</td>
							<td><input type="text" value="" /></td>
						</tr>

<tr>
							<td align="right">Edad:</td>
							<td><input type="text" value="" /></td>
						</tr>

</tbody>
</table>
</div>

            </div>

			<div id="sectionImpuesto" class="tab-pane fade"> 
            <div class="table-responsive">
  <table style="width: 100%">
					<tbody>           
<tr>
							<td align="right">Monto:</td>
							<td><input type="text" value="" /></td>
						</tr>

</tbody>
</table>
</div>

            </div>
<br>
	</div>
	<table>
		<tr>
			<td align="right"><input class="btn btn-primary"
				type="reset" value="Reset"> <input type="submit"
				class="btn btn-primary" value="Submit"></td>
			
		</tr>
	</table>
</div>
