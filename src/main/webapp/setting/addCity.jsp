
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<div class="main-content">
					<%
							int country=0;
							int state=0;
							String city="";
							ArrayList<countryBean> countryList=new ArrayList<countryBean>();
							if(request.getAttribute(contentPage.COUNTRYOBJ)!=null){
								countryList = (ArrayList<countryBean>)request.getAttribute(contentPage.COUNTRYOBJ);
							}
							
							if(request.getAttribute(contentPage.ERROR)!=null){ 
								country = Integer.parseInt(request.getParameter("country"));
								state = Integer.parseInt(request.getParameter("state"));
								city = request.getParameter("txtCity");
								
							}
					%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1>Add City  </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=addCity" method="post" name="addRole" id="addRole" class="form-horizontal">
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1">  Country Name </label>

										<div class="col-sm-9">
											<select class="col-sm-5" id="country" name="country" onchange="getState(this.value,0);">
												<option value="0">Select</option>
													<%for(countryBean countrybean : countryList){ 
															if(country == countrybean.getId()){
													%>
															<option selected="selected" value="<%=countrybean.getId() %>" ><%=countrybean.getName() %></option>
													<%}else{ %>
															<option value="<%=countrybean.getId() %>" ><%=countrybean.getName() %></option>
													<%}} %>
													
													
												</select>
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1">  State Name </label>

										<div class="col-sm-9">
												<select class="col-sm-5" id="state" name="state" onchange="getCity(this.value,0);">
													<option value="0">Select</option>
												</select>
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> City Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtCity" name="txtCity" value="<%=city %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
							
								
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Submit
											</button>
											

											&nbsp; &nbsp; &nbsp;
											<a href="ContentServlet?key=city" class="btn" type="reset" id="btnBack" name="btnBack">
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

		getState('<%=country %>','<%=state %>');
		
	    $('#btnSubmit').click(function(){                   
	    	$("#addRole").submit();
	        
	    });
	    
	   

	});
	</script>