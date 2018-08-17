<%@page import="com.softNice.nikah.beans.permissionBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.softNice.nikah.beans.memberBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%



%>
<div class="main-content">
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1> Members List  </h1></th>
								<!-- <th align="right"><a href="FormServlet?key=addRole" class="btn btn-info"  style="margin-left: 85%;" >Add New</a></th> -->
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<div class="row">
									<div class="col-xs-12">
											<div class="form-group">
													<!--  <label class="col-sm-1 control-label " for="form-field-first">Age </label>  -->

													<%-- <div class="col-sm-2">
														<label class="inline">
															
															<select class="col-sm-3" id="ageFrom" name="ageFrom" >
																<%for(int i = 0 ; i<=50 ; i++ ){ %>
																	<option <%=i==1?"selected":"" %> value="<%=i %>"><%=i %></option>
																<% }%>
																
															</select>
															&nbsp;&nbsp;
															<span class="lbl middle"> Age</span>
														</label>
													</div> --%>
													
													<div class="form-group">
														<div class="col-sm-9">
																<table  class="table table-striped table-bordered table-hover" cellspacing="0">
																	<thead>
																		<tr align="center">
																			<th >Age</th>
																			<th class="hidden-100" >
																				<select class="col-sm-3" id="ageFrom" name="ageFrom" style=" margin-right: 10%;" >
																					<option  value="0">From</option>
																					<%for(int i = 0 ; i<=50 ; i++ ){ %>
																						<option  value="<%=i %>"><%=i %></option>
																					<% }%>
																					
																				</select>
																				
																			
																				<select class="col-sm-3" id="ageTo" name="ageTo" >
																					<option  value="0">To</option>
																					<%for(int i = 0 ; i<=50 ; i++ ){ %>
																						<option value="<%=i %>"><%=i %></option>
																					<% }%>
																					
																				</select>
																			</th>
																			 <th>
																			 
																			 	<select class="col-sm-6" id="ageTo" name="ageTo" > 
																			 			<option value="0">MotherTougue </option>
																			 	</select>
																			 </th>
																			<th>
																				 <span class="block input-icon input-icon-right">

																					<input name="gender" id="female" type="radio"  value="female"  />
																					<span class="lbl"> Bride</span>
																					&nbsp;&nbsp;
																					
																					
																					<input name="gender" id="male" type="radio"  value="male"  />
																					<span class="lbl"> Groom</span>
																				</span>
																			
																			</th>
																			<th>Mobile</th>
																			<th>Email</th> 
																			
																		</tr>
																	</thead>
				
																</table>
															</div>
														</div>
												
											</div>
									</div>
								</div>
								
								
								
								
								
								
								
								<div class="row">
									<div class="col-xs-12">
										
										<div>
									
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr align="center">
														<th >Member ID</th>
														<th>Name</th>
														<th>Gender</th>
														<th>Package</th>
														<th>Mobile</th>
														<th>Email</th>
														<th class="hidden-480">Status</th>
														<th></th>
													</tr>
												</thead>

												<tbody>
												
									
												</tbody>
											</table>
										
									<!-- 	<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													 <tr>
														 <th></th> 
													</tr> 
												</thead>
										</table> -->
										
										</div>
									</div>
								</div>						
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
			
	<script type="text/javascript">
	
	$(document).ready(function(){
	    $('#dynamic-table').dataTable();
	   
	});
	
			function deleteDilog(id){
				/* var result = confirm("Are you sure to delete role?");
				if (result) {
					//window.location.href = 'ContentServlet?key=deleteRole&id='+id;
				}
				 */
			}		
		</script>
