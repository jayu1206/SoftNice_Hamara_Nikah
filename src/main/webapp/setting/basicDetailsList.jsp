<%@page import="com.softNice.nikah.beans.masterBean"%>
<%@page import="java.util.Map"%>
<%@page import="com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>

<%
			 HashMap<Integer, String> map = new HashMap<Integer, String>();
			if(request.getSession().getAttribute(contentPage.MASTERMAPOBJ)!=null){
				map = (HashMap<Integer, String>)  request.getSession().getAttribute(contentPage.MASTERMAPOBJ);
			} 
			
			ArrayList<masterBean> list=new ArrayList<masterBean>();
			if(request.getAttribute(contentPage.MASTERMAPOBJ)!=null){
				list = (ArrayList<masterBean>) request.getAttribute(contentPage.MASTERMAPOBJ);
			}
			
%>



<div class="main-content">
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1> Basic Details List  </h1></th>
								<th align="right"><a href="FormServlet?key=addBasics" class="btn btn-info"  style="margin-left: 82%;" >Add New</a></th>
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
														<th>Id</th>
														<th>Detail Name</th>
														<th>Value</th>
														<th class="hidden-480">Status</th>

														<th></th>
													</tr>
												</thead>

												<tbody>
											 	<% for(masterBean master: list){ %> 
											 		<tr>
														<td><%=master.getMasterId() %></td>
														<td ><%=map.get(master.getMasterId()) %></td>
														<td><%=master.getValue() %></td>
														<td class="hidden-480">
															<span class="label label-sm label-warning"><%=master.isStatus() %></span>
														</td>

														<td>
															<div class="hidden-sm hidden-xs action-buttons">

																<a class="red" href="#" onclick="deleteDilog('<%=master.getId() %>')">
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
									<<div align="center" style="color: red">
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
				var result = confirm("Are you sure to delete ?");
				if (result) {
					window.location.href = 'ContentServlet?key=deleteBasic&id='+id;
				}
				
			}		
		</script>
