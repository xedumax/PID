<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validacliente.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

</head>
<body>
<h1>Lista de Usuarios</h1>
<s:a action="listaUsuario">Lista Usuario</s:a>

 
  <div class="content">
 <table id="tableUsuario" class="table table-striped table-bordered" >
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Imagen</th>
			</tr>
		</thead>
		<tbody>	
            <s:iterator value="data" var="aux" >
             <tr class="active">
                <td><s:property value="#aux.idUsuario" /></td>
                <td><s:property value="#aux.nombre" /></td>
                <td><s:property value="#aux.apellido" /></td>
                <td><s:property value="#aux.email" /></td>
                <td>
                	<img alt="Imagen" src="verFoto?idCodigo=<s:property value="#aux.idUsuario" />" width="50px" height="50px">   
                </td>
 	         </tr>
            </s:iterator>
        </tbody>
</table>
</div>

</body>
</html>

<script type="text/javascript">
$(document).ready(function() {
    $('#tableUsuario').DataTable();
} );

</script>

