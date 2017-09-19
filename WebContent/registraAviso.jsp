<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html>
<html lang="es">
<head>

<!-- En jquery es true y en bootstrap es false -->
<sj:head jqueryui="false"/><!-- Se anula el jquery -->
<sb:head includeScripts="true" includeScriptsValidation="true"/>

<meta charset="utf-8"/>
<title>Registro de Aviso</title>
</head>

<BODY>
<h1>Red Social</h1>

<hr>
 	<div class="container-fluid">
	<s:form id="validationForm" action="registraAviso" 
			 theme="bootstrap" 
			 cssClass="well form-vertical" 
			 method="POST" >
			  
		<s:textfield 	name="descripcion" label="Descripción"/>

		<s:textfield 	name="precio" label="Precio"/>
						
		
		<s:url id="idCarga" action="listaPais"/>					
		<sj:select href="%{idCarga}" name="pais" list="lstPais" listKey="idPais" listValue="nombre" label="Pais" />
		
		<div class="form-actions">
			<sj:submit cssClass="btn btn-primary" 
						value="Registrar"
						formIds="validationForm" 
						validate="true" 
						validateFunction="bootstrapValidation" />
		</div>
			
	</s:form>
</div>


</BODY>