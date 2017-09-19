<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html>
<html lang="es">
<head>

<!-- En jquery es true y en bootstrap es false -->
<sj:head jqueryui="false"/>
<sb:head includeScripts="true" includeScriptsValidation="true"/>
<meta charset="utf-8"/>
<title>Red Social</title>
</head>
<body>
<h1>Consulta de avisos por país</h1>
<h2>
<a href="listaAviso">
	Lista de avisos
</a> 
</h2>

<table  class="table table-hover"> 
	<s:iterator value="lstAviso" var="quino" >
		<tr class="active">  
			<td><s:property value="#quino.idAviso" /></td>
			<td><s:property value="#quino.descripcion" /></td>
			<td><s:property value="#quino.precio" /></td>
			<td><s:property value="#quino.pais.nombre" /></td>
		</tr>
	</s:iterator>
</table>


</body>
</html>


