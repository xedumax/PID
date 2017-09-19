<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="esS">
<head>
<sj:head jqueryui="false" />
<sb:head includeScripts="true" includeScriptsValidation="true" />
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">


<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />

<link rel="stylesheet" href="css/bootstrapValidator.css" />
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<style>
.modal-header, h4, .close {
	background-color: #286090;
	color: white !important;
	text-align: center;
	font-size: 30px;
}
</style>

<title>OMISIL</title>
</head>
<body>
	<form id="defaultForm" accept-charset="UTF-8" action="consultaAviso"
		class="form-horizontal" method="post">
		<div class="panel-group" id="steps">
			<!-- Step 1 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#steps" href="#stepOne">CONSULTA
							DE AVISO</a>
					</h4>
				</div>
				<div id="stepOne" class="panel-collapse collapse in">
					<div class="panel-body">

						<div class="form-group">
							<label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
							<div class="col-lg-5">
								<input class="form-control" id="id_reg_nombre" name="fnombre"
									placeholder="Ingrese el Nombre" type="text" maxlength="20" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-3 control-label" for="id_reg_estado">Pais</label>
							<div class="col-lg-5">

								<s:url id="idCarga" action="listaPais" />
								<sj:select href="%{idCarga}" name="fpais" list="lstPais"
									listKey="idPais" listValue="nombre" headerKey="-1"
									headerValue=" [Seleccione] " />

							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-9 col-lg-offset-3">
								<button type="submit" class="btn btn-primary">FILTRAR</button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>

	<div class="content">

		<table id="tableAlumno" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Pais</th>
					<th>Elimina</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${lstConsulta}" var="x">
					<tr>
						<td>${x.idAviso}</td>
						<td>${x.nombre}</td>
						<td>${x.precio}</td>
						<td>${x.pais}</td>
						<td>
							<a href="eliminaAviso?id=${x.idAviso}" type='button' data-toggle='modal'
								class='btn btn-success'
								style='background-color: hsla(233, 100%, 100%, 0);'>
								<img src='images/edit.gif' id='id_update' width='auto'
									height='auto' />
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>