<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:form="http://www.springframework.org/tags/form" version="2.0"
	xmlns:field="urn:jsptagdir:/WEB-INF/tags/form/fields">
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<jsp:output omit-xml-declaration="yes" />

	<spring:url value="/resourcesApl/mfidweb/fiduciario/js/administracion/participante/cuenta/cuenta.js"
		var="cuenta_js" />
	<script src="${cuenta_js}" type="text/javascript">
		;
	</script>

	<div id="contenido">
		<div id="infoPantalla">
			<div class="titulo consultaSaldos" id="tituloPantalla">Cuenta</div>
			<div class="breadcrumb">
				<spring:message code="admin.cuenta.pathPadre" /> <span><spring:message code="admin.cuenta.pathFinal" /></span>
			</div>
		</div>



		<form:form method="POST" commandName="command"
			action="${pageContext.request.contextPath}/menuAdministracion/control/cuenta/inicio/buscar" cssClass="yCommonForm">


						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.fecha" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="fecha" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="1"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.banco" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="banco" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="2"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.titular" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="titular" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="3"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.titular" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="titular" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="4"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.tipo" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="tipo" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="5"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.codigo" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="codigo" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="6"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.saldo" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="saldo" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="7"/>	
 					</div>	 
				</div>	 
			</div>	 

						<div class="row col-xs-12 subrayado">	 
				<div class="col-xs-3">	 
					<label class="label pull-right"><spring:message code="admin.cuenta.cotitular" /> </label>	 
				</div>	 
				<div class="col-xs-3">	 
					<div class="label pull-left">	 
						<form:input path="cotitular" 
 	 		cssClass="required"	 data-required="true" 
							data-navigation-y="8"/>	
 					</div>	 
				</div>	 
			</div>	 

			<div class="row col-xs-12 subrayado"> 
				<div class="textAlignCen botones"> 
				<button class="btn_peq btn_cancelar btnAccion " id="yBtnRegresar" data-navigation-y="8"><spring:message code="common.btn.general.regresar" /> </button> 
					<button 
						class="btn_peq btn_cancelar btnAccion" 
						id="yBtnBorrar" data-navigation-y="9"> 
						<spring:message code="common.btn.general.borrar" /> 
					</button> 
					<button class="btn_peq btnAccion btnDeshabilitado" id="yBtnGuardar" style="pointer-events: none;" data-navigation-y="10"> 
						<spring:message code="common.btn.general.guardar" /> 
					</button> 
				</div> 
			</div>              
		</form:form>
	</div>
</jsp:root>
