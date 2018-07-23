<%@page import="com.softNice.nikah.impl.administratorImpl"%>
<%@page import="com.softNice.nikah.dao.administratorDAO"%>
<%@page import="com.softNice.nikah.beans.permissionBean"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.softNice.nikah.beans.permissionnamesBean"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<permissionnamesBean> permissionNameList =(ArrayList<permissionnamesBean>) request.getSession().getAttribute(contentPage.PERMISSIONNAME);

/* permissionBean permission=null;
if(request.getAttribute(contentPage.MODIFYOBJ)!=null){
	rolebean = (roleBean)request.getAttribute(contentPage.MODIFYOBJ);
	permission =(permissionBean) rolebean.getPermissions().iterator().next();
} */


int id = 0;
try{
if(request.getParameter("id")!=null){
	id=Integer.parseInt(request.getParameter("id"));
}
}catch(Exception e){
	e.printStackTrace();
}

%>
<div class="main-content">
				<div class="main-content-inner">
	<form action="FormServlet?key=savePermission" method="post" name="permission" id="permission" class="form-horizontal">	
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1> Permissions  </h1></th>
								<th align="right"><button class="btn btn-info" id="btnSubmit" name="btnSubmit" style="margin-left: 80%;width: 20%;" >Save</button></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<input type="hidden" >
								<div class="row">
									<div class="col-xs-12">
										<input type="hidden" id="roleId" name="roleId" value="<%=id %>">
										<div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>Permission Name</th>
														<th>Add</th>
														<th>Update</th>
														<th>Delete</th>
														<th>View</th>
														
													</tr>
												</thead>

												<tbody>
												<%
													administratorDAO dao=new administratorImpl();
												
												for(permissionnamesBean bean : permissionNameList ){
													permissionBean checkBean = dao.getExistingPermisstion(id,bean);
												
												%>
															
													<tr>
														
														<td width="30%"><%=bean.getName() %></td>
														<%if(checkBean.isAdd()) {%>
															<td class="hidden-480"><input type="checkbox" checked="checked" id="chkAdd_<%=bean.getId() %>" name="chkAdd_<%=bean.getId() %>" value="add"/> </td>
														<%}else{ %>
															<td class="hidden-480"><input type="checkbox" id="chkAdd_<%=bean.getId() %>" name="chkAdd_<%=bean.getId() %>" value="add"/> </td>
														<%} %>
														
														<%if(checkBean.isUpdate()) {%>
															<td class="hidden-480"><input type="checkbox" checked="checked" id="chkUpdate_<%=bean.getId() %>" name="chkUpdate_<%=bean.getId() %>" value="update"/> </td>
														<%}else{ %>
															<td class="hidden-480"><input type="checkbox" id="chkUpdate_<%=bean.getId() %>" name="chkUpdate_<%=bean.getId() %>" value="update"/> </td>
														<%} %>
														
														<%if(checkBean.isDelete()) {%>
															<td class="hidden-480"><input type="checkbox" checked="checked" id="chkDelete_<%=bean.getId() %>" name="chkDelete_<%=bean.getId() %>" value="delete"/> </td>
														<%}else{ %>
															<td class="hidden-480"><input type="checkbox"   id="chkDelete_<%=bean.getId() %>" name="chkDelete_<%=bean.getId() %>" value="delete"/> </td>
														<%} %>
														
														<%if(checkBean.isView()) {%>
															<td class="hidden-480"><input type="checkbox" checked="checked" id="chkView_<%=bean.getId() %>" name="chkView_<%=bean.getId() %>" value="view"/> </td>
														<%}else{ %>
															<td class="hidden-480"><input type="checkbox" id="chkView_<%=bean.getId() %>" name="chkView_<%=bean.getId() %>" value="view"/> </td>
														<%} %>
														
														
														

													</tr>
											<%} %>
												</tbody>
											</table>
										</div>
									</div>
								</div>						
									
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
	
					</div><!-- /.page-content -->
			</form>
				</div>
			</div><!-- /.main-content -->
			
			<script>
	
	$( document ).ready(function() {

	    $('#btnSubmit').click(function(){                   
	        	$("#permission").submit();
	    });
	    
	   

	});
	</script>