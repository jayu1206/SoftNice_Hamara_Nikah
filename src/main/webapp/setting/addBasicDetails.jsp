
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.softNice.nikah.beans.masterBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<div class="main-content">
						<%
						
							int masterId= 0;
							String value = "";
							boolean modifyFlag=false;
							String key="addBasics";
							 masterBean bean=new masterBean();
								if(request.getAttribute(contentPage.LOCALOBJ)!=null){
									bean = (masterBean)request.getAttribute(contentPage.LOCALOBJ);
								}
								if(request.getAttribute(contentPage.MODIFYOBJ)!=null){
									bean = (masterBean)request.getAttribute(contentPage.MODIFYOBJ);
									key="updateBasics";
									modifyFlag=true;
								} 
								
								HashMap<Integer, String> map = new HashMap<Integer, String>();
								if(request.getSession().getAttribute(contentPage.MASTERMAPOBJ)!=null){
									map = (HashMap<Integer, String>)  request.getSession().getAttribute(contentPage.MASTERMAPOBJ);
								}
								
								if(request.getAttribute(contentPage.ERROR)!=null){
									masterId = Integer.parseInt(request.getParameter("masterName"));
									bean.setValue(request.getParameter("txtValue"));
								}
								
							%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1><%if(modifyFlag==false){ %>Add Basics <%}else{ %>Edit Basic  <%} %>  </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=<%=key %>" method="post" name="addBasic" id="addBasic" class="form-horizontal">
								<%if(modifyFlag){ %>
								<input type="hidden" id="txtId" name="txtId" value="<%=bean.getId() %>" />
								<%} %>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Basics details </label>

										<div class="col-sm-9">
												<select class="col-sm-5" id="masterName" name="masterName" >
												<option value="0">Select</option>
												<%for(Map.Entry m:map.entrySet()){   %>
												
														<%if(masterId == (int)m.getKey()){ %>
															<option selected="selected" value="<%=m.getKey() %>"><%=m.getValue() %></option>
														<%}else{ %>
															<option  value="<%=m.getKey() %>"><%=m.getValue() %></option>
												<%} }%>
												</select>
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Value </label>

										<div class="col-sm-9">
											<input type="text" id="txtValue" name="txtValue" value="<%=bean.getValue() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Submit
											</button>
											

											&nbsp; &nbsp; &nbsp;
											<a href="#" class="btn" type="reset" id="btnBack" name="btnBack">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Back
											</a>
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
	    	$("#addBasic").submit();
	    });
	    
	   

	});
	</script>