<%@page import="com.softNice.nikah.utility.validation"%>
<%@page import="com.softNice.nikah.beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%

ArrayList<UserBean> list=new ArrayList<UserBean>();
	if(request.getAttribute(contentPage.LOCALOBJ)!=null){
		list = (ArrayList<UserBean>)request.getAttribute(contentPage.LOCALOBJ);
	}

%>
<div class="main-content">
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1> Users List  </h1></th>
								<th align="right"><a href="FormServlet?key=addUser" class="btn btn-info"  style="margin-left: 85%;" >Add New</a></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<div class="row">
									<div class="col-xs-12">
										
										<div>
										<% if(list.size()>0){%>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>User Id</th>
														<th>User Name</th>
														<th>Phone</th>
														<th>Email</th>
														<th>Gender</th>
														<th>Role</th>
														<th>DOB</th>
														<th>Country</th>
														<th>State</th>
														<th>City</th>
														<th>Created By</th>
														<th class="hidden-480">Status</th>
														<th></th>
													</tr>
												</thead>

												<tbody>
												<% for(UserBean user: list){ %>
													<tr>
														<td><%=user.getUserName() %></td>
														<td><%=user.getFirstName() + user.getLastName() %></td>
														<td><%=user.getPhno() %></td>
														<td><%=user.getEmail() %></td>
														<td><%=user.getGender() %></td>
														<td><%=user.getRoleName() %></td>
														<td><%=validation.convertDateToString(user.getDob()) %></td>
														<td><%=user.getCountryName() %></td>
														<td><%=user.getStateName() %></td>
														<td><%=user.getCityName() %></td>
														<td><%=user.getCreatedBy() %></td>
														
														
														<td class="hidden-480">
															<span class="label label-sm label-warning"><%=user.isStatus() %></span>
														</td>

														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																
																
																<a class="green" href="ContentServlet?key=updateUser&id=<%=user.getId() %>">
																	<i class="ace-icon fa fa-pencil bigger-130"></i>
																</a>

																<a class="red" href="#" onclick="deleteDilog('<%=user.getId() %>')" >
																	<i class="ace-icon fa fa-trash-o bigger-130"></i>
																</a>
																
																
															</div>

															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
																		<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																	</button>

																	<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		<li>
																			<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																				<span class="blue">
																					<i class="ace-icon fa fa-search-plus bigger-120"></i>
																				</span>
																			</a>
																		</li>

																		<li>
																			<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
																			</a>
																		</li>

																		<li>
																			<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="ace-icon fa fa-trash-o bigger-120"></i>
																				</span>
																			</a>
																		</li>
																	</ul>
																</div>
															</div>
														</td>
													</tr>
									<%}%>
									
												</tbody>
											</table>
										<%}else{ %>
										<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													 <tr>
														 <th></th> 
													</tr> 
												</thead>
										</table>
										<%} %>
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
		var result = confirm("Are you sure to delete user?");
		if (result) {
			window.location.href = 'ContentServlet?key=deleteUser&id='+id;
		}
		
	}	
		</script>
