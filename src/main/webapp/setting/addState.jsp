
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<div class="main-content">
						<%
						
							int countryId = 0;
							String state="";
							boolean modifyFlag=false;
							String key="addState";
							ArrayList<countryBean> list  = new ArrayList<countryBean>();
							
								if(request.getAttribute(contentPage.COUNTRYOBJ)!=null){
									list = (ArrayList<countryBean>)request.getAttribute(contentPage.COUNTRYOBJ);
								}
								
								if(request.getAttribute(contentPage.ERROR)!=null){ 
									countryId = Integer.parseInt(request.getParameter("country"));
									state= request.getParameter("txtStateName");
									
								/* 	
									bean.setName(request.getParameter("txtCountryName"));
									bean.setSortname(request.getParameter("txtShortName"));
									if(request.getParameter("txtPhCode")!=null && request.getParameter("txtPhCode").length() > 0){
										bean.setPhonecode(Integer.parseInt(request.getParameter("txtPhCode")));
									} */
									
								}
								
								
							%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1><%if(modifyFlag==false){ %>Add State <%}else{ %>Edit State  <%} %>  </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=<%=key %>" method="post" name="addRole" id="addRole" class="form-horizontal">
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Country Name </label>

										<div class="col-sm-9">
											<select class="col-sm-5" id="country" name="country" >
													<option value="0">Select</option>
													<%for(countryBean bean : list){ %>
													
														<%if(countryId == bean.getId()){ %>
																<option selected="selected" value="<%=bean.getId() %>"><%=bean.getName() %></option>
														<%}else{ %>
																<option  value="<%=bean.getId() %>"><%=bean.getName() %></option>
														<%} %>
													<%} %>
											</select>
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> State Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtStateName" name="txtStateName" value="<%=state %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
							
								
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Submit
											</button>
											

											&nbsp; &nbsp; &nbsp;
											<a href="ContentServlet?key=country" class="btn" type="reset" id="btnBack" name="btnBack">
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
	    	$("#addRole").submit();
	        
	    });
	    
	   

	});
	</script>