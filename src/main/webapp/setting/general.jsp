

<div class="main-content">
						
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1>General Setting </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=updateSetting" method="post" name="updateGeneral" id="updateGeneral" class="form-horizontal" enctype="multipart/form-data" >
								<%-- <%if(modifyFlag){ %>
								<input type="hidden" id="txtId" name="txtId" value="<%=bean.getRoleId() %>" />
								<%} %> --%>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> App Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtAppName" name="txtAppName" value="" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Footer Copy Right </label>

										<div class="col-sm-9">
											<input type="text" id="txtAppName" name="txtAppName" value="" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Logo </label>

										<div class="col-sm-9">
											<input type="file" id="txtImage" name="txtImage"   />
										</div>
								</div>
								
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Change
											</button>
											

											<!-- &nbsp; &nbsp; &nbsp;
											<a href="ContentServlet?key=role" class="btn" type="reset" id="btnBack" name="btnBack">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Back
											</a> -->
										</div>
									</div>
								
								</form>
								<%-- <div align="center" style="color: red">
												<%
												 String str="";
												if(request.getAttribute(contentPage.ERROR)!=null){ 
													str=((ErrorMsg)request.getAttribute(contentPage.ERROR)).getError();
												
												} %>
												
												<label><%=str %> </label>
									
								</div> --%>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
	<script>
	
	$( document ).ready(function() {

	    $('#btnSubmit').click(function(){                   
	        if( $("#updateGeneral").val().lenght == 0) {
	            $("#updateGeneral").focus();
	            return false;
	        }else{
	        	//alert("submit");
	        //	$("#addRole").submit();
	        	
	        }
	        
	    });
	    
	   

	});
	</script>