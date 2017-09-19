<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 30px;
	}
</style>     

<title>Canchita</title>
</head>
<body>

 <div class="container">
 <h1>Crud de Usuario</h1>
		 <div class="col-md-23" >  
				
				
				
		       <form accept-charset="UTF-8"  action="consultaUsuario" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label class="control-label" for="id_nonbre_filtro">NOMBRE</label>
							  	<input class="form-control" id="id_nonbre_filtro"  name="filtro" placeholder="Ingrese el nombre" type="text" maxlength="30"/>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >Filtra Usuario</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" data-toggle='modal' onclick="registrar();"  class='btn btn-success' id="validateBtnw2" >Registra Usuario</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="tableAlumno" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>Email</th>
												<th>Nombres</th>
												<th>Apellidos</th>
												<th>Sexo</th>
												<th>Fecha Nac</th>
												<th>Actualiza </th>
											</tr>
										</thead>
										<tbody>
												   
												<c:forEach items="${usuarios}" var="x">
													<tr>
														<td>${x.email}</td>
														<td>${x.nombre}</td>
														<td>${x.apellido}</td>
														<td>${x.sexo}</td>
														<td>${x.fecha}</td>
														<td>
															<button type='button' data-toggle='modal' onclick="editar('${x.email}','${x.nombre}','${x.apellido}','${x.sexo}','${x.fotosBytes}','${x.fecha}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																<img src='images/edit.gif' id='id_update' width='auto' height='auto' />
															</button>
														</td>
													</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  	 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Usuario</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8" action="registraUsuario" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos del Usuario</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_email">Email</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_email" name="email" placeholder="Ingrese el Email" type="text" maxlength="20"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_password">Password</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_password" name="password" placeholder="Ingrese password" type="text" maxlength="10"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_nombre" name="nombre" placeholder="Ingrese el nombre" type="text" maxlength="10"/>
		                                        </div>
		                                    </div>    
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_apellido">Apellido</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_apellido" name="apellido" placeholder="Ingrese el apellido" type="text" maxlength="10"/>
		                                        </div>
		                                    </div> 
		                                     <div class="form-group">
		                                      <label class="col-lg-3 control-label" for="id_sexo">Sexo</label>
			                                    <div class="col-lg-5">
														<s:radio 		name="sexo" list="#{'1':'Mujer','2':'Hombre'}" 
																value="1"  label="Sexo" 
																tooltip="Selecciona Hombre o Mujer" />
			                                     </div>
			                                  </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_fechaNac">Fecha de Nacimiento</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_fechaNac" name="fecha" type="date"  	displayFormat="dd-mm-yyyy" 
																 />
		                                        </div>
		                                    </div>  
		                                     
		                                   <div class="form-group">
		                                    <label 	name="status" type="hidden" value="Activo"></label>
		                                    </div>
		                                    
											<div class="form-group">
		                                        <label class="col-lg-3 control-label" for="idDep">Departamento</label>
		                                        <div class="col-lg-5">	
												<s:url id="idDep" action="cargaUbigeo" />	
												<sj:select href="%{idDep}"
														   list="lstDepartamento"
														   listKey="departamento"
														   listValue="departamento"
														   headerKey=" "
														   headerValue=" [ Seleccione ]"
														   name="departamento"  
														   onChangeTopics="topicoProvincia,topicoDistrito"/><br>	
												</div>	   
											</div>
									
											<div class="form-group">
		                                      <label class="col-lg-3 control-label" for="idProv">Provincia</label>
												<div class="col-lg-5">
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
													</div>	   
											</div>
									
											<div class="form-group">
		                                      <label class="col-lg-3 control-label" for="idDis">Distrito</label>		
		                                      <div class="col-lg-5">			
												<s:url id="idDis" action="cargaUbigeo" />
												<sj:select href="%{idDis}"
														   list="lstDistrito"
														   listKey="distrito"
														   listValue="distrito"
														   headerKey=" "
														   headerValue=" [ Seleccione ]"
														   reloadTopics="topicoDistrito"
														   name="distrito"/><br>		   
													</div>	   
											</div>				
		
		
		
		
		
									<s:file 		name="fotos" label="Seleciona una Foto" />
		                                    
		                                    
		                                    
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">REGISTRAR</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
	</div>
  
	
	 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Usuario</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8"  action="actualizaUsuario" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                
		                                
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_email">Email</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_email" name="email" placeholder="Ingrese el Email" type="text" maxlength="20"/>
		                                        </div>
		                                    </div>
		                                    
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_nombre" name="nombre" placeholder="Ingrese el nombre" type="text" maxlength="10"/>
		                                        </div>
		                                    </div>    
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_apellido">Apellido</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_apellido" name="apellido" placeholder="Ingrese el apellido" type="text" maxlength="10"/>
		                                        </div>
		                                    </div> 
		                                     <div class="form-group">
		                                      <label class="col-lg-3 control-label" for="id_sexo">Sexo</label>
			                                    <div class="col-lg-5">
														<s:radio 		name="sexo" list="#{'1':'Mujer','2':'Hombre'}" 
																value="1"  label="Sexo" 
																tooltip="Selecciona Hombre o Mujer" />
			                                     </div>
			                                  </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_fechaNac">Fecha de Nacimiento</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_fechaNac" name="fecha" type="date"  	displayFormat="dd-mm-yyyy" 
																 />
		                                        </div>
		                                    </div>  
		                                     
		                                   		
		
		
		
		
											<s:file 		name="fotos" label="Seleciona una Foto" />
		                                    
		                                    
		                                    
		                                    
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">ACTUALIZA USUARIO</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
	</div>

</div>

<script type="text/javascript">

function registrar(){	
	$('#idModalRegistra').modal("show");
}
	

	
function editar(email,nombre,apellido,sexo,fotosBytes,fecha){	
	$('input[id=id_email]').val(email);
	$('input[id=id_nombre]').val(nombre);
	$('input[id=id_paellido]').val(apellido);
	$('select[id=id_sexo]').val(sexo);
	$('input[id=id_fotosBytes]').val(fotosBytes);
	$('input[id=id_fecha]').val(fecha);
	
	$('#idModalActualiza').modal("show");
}

$(document).ready(function() {
    $('#tableAlumno').DataTable();
} );


</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           
       	}    
     }).on('error.form.bv', function(e) {
            console.log('error');

            // Active the panel element containing the first invalid element
            var $form         = $(e.target),
                validator     = $form.data('bootstrapValidator'),
                $invalidField = validator.getInvalidFields().eq(0),
                $collapse     = $invalidField.parents('.collapse');

            $collapse.collapse('show');
    });
});
</script>
    
</body>
</html> 