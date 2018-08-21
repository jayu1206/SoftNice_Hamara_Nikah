<%@page import="java.util.HashMap"%>
<%@page import="com.softNice.nikah.beans.permissionBean"%>
<%@page import="com.softNice.nikah.beans.memberPlanBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%

ArrayList<memberPlanBean> list=new ArrayList<memberPlanBean>();
	if(request.getAttribute(contentPage.MEMBERPLANOBJ)!=null){
		list = (ArrayList<memberPlanBean>)request.getAttribute(contentPage.MEMBERPLANOBJ);
	}
	
	HashMap<String, permissionBean> map= null;
	if(request.getSession().getAttribute(contentPage.MAPOBJ)!=null){
		new HashMap<String, permissionBean>();
		map = (HashMap) request.getSession().getAttribute(contentPage.MAPOBJ);
	}

%>
<div class="main-content">
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
					<%
						permissionBean Perbean=(permissionBean) map.get("Members");
						if(Perbean.isView() && Perbean.isAdd()){
					%>
						<table width="100%">
							<tr>
								<th><h1> Membership Plan List  </h1></th>
								<th align="right"><a href="FormServlet?key=addMemberPlan" class="btn btn-info"  style="margin-left: 70%;" >Add New</a></th>
							</tr>
						</table>
					<%} %>
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
														<th>Name</th>
														<th>Creadit</th>
														<th>Plan Validity</th>
														<th>Plan Charges</th>
														<th>Order</th>
														<th>Print view</th>
														<th>Photo Upload</th>
														<th>Horoscope Upload</th>
														<th>Horoscope View</th>
														<th>Video Upload</th>
														<th>Protect Photo</th>
														<th>Bookmark</th>
														<th>Messaging</th>
														<th>Service Tax</th>
														<th class="hidden-480">Status</th>

														<th></th>
													</tr>
												</thead>

												<tbody>
												<% for(memberPlanBean plan: list){ %>
													<tr>
														<td><%=plan.getPlanName() %></td>
														<td><%=plan.getCredits() %></td>
														<td><%=plan.getPlanValidity() %></td>
														<td><%=plan.getPlanCharges() %></td>
														<td><%=plan.getOrder() %></td>
														
														<%if(plan.isPrintedView()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isPhotoUpload()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isHoroscopeUpload()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isHoroscopeView()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isVideoUpload()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isProtectPhoto()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isBookmark()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isMessaging()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														<%if(plan.isServiceTex()){ %>
															<td><i class=" green ace-icon fa fa-check-circle"></i></td>
														<%}else{ %>
															<td><i class="red ace-icon fa fa-times-circle"></i></td>
														<%} %>
														
														
														<td class="hidden-480">
															<span class="label label-sm label-warning"><%=plan.isStatus() %></span>
														</td>

														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																
																
																<%-- <a class="green" href="ContentServlet?key=updateRole&id=<%=plan.getPlanId() %>">
																	<i class="ace-icon fa fa-pencil bigger-130"></i>
																</a> --%>
															<%if(Perbean.isView() && Perbean.isDelete()){ %>
																<a class="red" href="#" onclick="deleteDilog('<%=plan.getPlanId() %>')">
																	<i class="ace-icon fa fa-trash-o bigger-130"></i>
																</a>
																
															<%} %>	
															
																<%-- 
																<a class="blue" href="ContentServlet?key=permission&id=<%=plan.getPlanId() %>">
																	<i class="ace-icon fa fa-search-plus bigger-100">Permission</i>
																</a> --%>
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
				var result = confirm("Are you sure to delete Plan?");
				if (result) {
					window.location.href = 'ContentServlet?key=deletePlan&id='+id;
				}
				
			}		
		</script>
