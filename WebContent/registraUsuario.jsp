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
<title>Red Social</title>
</head>

<BODY>
<h1>Red Social</h1>

<hr>
 	<div class="card card-container">
	<s:form id="validationForm" action="registraUsuario" 
			 theme="bootstrap" 
			 cssClass="well form-vertical" 
			 method="POST" enctype="multipart/form-data">
			  
		<s:textfield name="email" label="Email" 
					requiredLabel="true" 
					tooltip="Escribe tu correo electronico" />

		<s:password	type="password" name="password" 
					requiredLabel="true" label="Password" 
					labelposition="center" tooltip="Escribe tu Contraseña"/>
					
		<s:textfield 	name="nombre" label="Nombre"	
						requiredLabel="true" 
						tooltip="Escribe tus Nombres"/>
						
		<s:textfield 	name="apellido" label="Apellido" 
						requiredLabel="true" 
						tooltip="Escribe tus Apellidos" />
				
		<s:radio 		name="sexo" list="#{'1':'Mujer','2':'Hombre'}" 
						value="1"  label="Sexo" 
						tooltip="Selecciona Hombre o Mujer" />
						
		<s:textfield 	name="fecha" type="date"  
						displayFormat="dd-mm-yyyy"  label="Fecha de Nacimiento"  
						requiredLabel="true" 
						tooltip="Selecciona tu Fecha de Nacimiento"/>
						
		<s:textfield 	name="status" type="hidden" value="Activo"/>
		
		
		
   Departamento
	<s:url id="idDep" action="cargaUbigeo" />
	<sj:select href="%{idDep}"
			   list="lstDepartamento"
			   listKey="departamento"
			   listValue="departamento"
			   headerKey=" "
			   headerValue=" [ Seleccione ]"
			   name="departamento"  
			   onChangeTopics="topicoProvincia,topicoDistrito"/><br>		   
	<br>
	Provincia
	<s:url id="idProv" action="cargaUbigeo" />
	<sj:select href="%{idProv}"
			   list="lstProvincia"
			   listKey="provincia"
			   listValue="provincia"
			   headerKey=" "
			   headerValue=" [ Seleccione ]"
			   reloadTopics="topicoProvincia" 
			   onChangeTopics="topicoDistrito"
			   name="provincia"/><br>		   
	<br>
	Distrito
	<s:url id="idDis" action="cargaUbigeo" />
	<sj:select href="%{idDis}"
			   list="lstDistrito"
			   listKey="distrito"
			   listValue="distrito"
			   headerKey=" "
			   headerValue=" [ Seleccione ]"
			   reloadTopics="topicoDistrito"
			   name="distrito"/><br>		   
	<br>	
		
		
		
		
		
		<s:file 		name="fotos" label="Seleciona una Foto" />
		
		
		
		
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