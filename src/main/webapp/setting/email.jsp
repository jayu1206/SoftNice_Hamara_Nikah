

<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="com.softNice.nikah.beans.emailSetting"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.softNice.nikah.beans.settingBean"%>
<%@page import="com.google.gson.Gson"%>

<div class="main-content">
						<%
								settingBean bean= null;
								emailSetting mailbean= new emailSetting();
								if(request.getAttribute(contentPage.SETTING)!=null){
									bean = (settingBean) request.getAttribute(contentPage.SETTING);
									
									ObjectMapper mapperObj = new ObjectMapper();
									if(bean.getValue()!=null){
										mailbean = new Gson().fromJson(bean.getValue(),emailSetting.class);
									}
									
								}
						%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1>Email Setting </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=emailSetting" method="post" name="updateEmail" id="updateEmail" class="form-horizontal"  >
								<%-- <%if(modifyFlag){ %>
								<input type="hidden" id="txtId" name="txtId" value="<%=bean.getRoleId() %>" />
								<%} %> --%>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Email Type </label>

										<div class="col-sm-9">
											<input type="text" id="txtEmailType" name="txtEmailType"  value="<%=mailbean.getEmail_type() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Server Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtServerName" name="txtServerName" value="<%=mailbean.getServer_name() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> User Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtUserName" name="txtUserName" value="<%=mailbean.getUserName() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Password </label>

										<div class="col-sm-9">
											<input type="text" id="txtPassword" name="txtPassword" value="<%=mailbean.getPassword() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Port </label>

										<div class="col-sm-9">
											<input type="text" id="txtPort" name="txtPort" value="<%=mailbean.getPort() %>" class="col-xs-10 col-sm-5" />
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
								 <div align="center" style="color: red">
												<%
												 String str="";
												if(request.getAttribute(contentPage.ERROR)!=null){ 
													str=((ErrorMsg)request.getAttribute(contentPage.ERROR)).getError();
												
												} %>
												
												<label><%=str %> </label>
									
								</div> 
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
	<script>
	
	$( document ).ready(function() {

	    $('#btnSubmit').click(function(){                   
	    	$("#updateEmail").submit();
	    });
	    
	   

	});
	</script>