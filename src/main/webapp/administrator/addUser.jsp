
<%@page import="com.softNice.nikah.utility.validation"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="com.softNice.nikah.beans.UserBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>

<div class="main-content">
						<%
						
						String userName="";
						String firstName="";
						String lastName="";
						String dob="";
						String gender="";
						int country=0;
						int state=0;
						int city=0;
						String email="";
						String phno="";
						int role=0;
						String psw="";
						String confPsw="";
						
						
							boolean modifyFlag=false;
							String key="addUser";
							UserBean bean= new UserBean();
							ArrayList<countryBean> countryList=new ArrayList<countryBean>();
								if(request.getAttribute(contentPage.LOCALOBJ)!=null){
									bean = (UserBean)request.getAttribute(contentPage.LOCALOBJ);
								}
								if(request.getAttribute(contentPage.MODIFYOBJ)!=null){
									bean = (UserBean)request.getAttribute(contentPage.MODIFYOBJ);
									key="updateUser";
									modifyFlag=true;
									
									 userName=bean.getUserName();
									 firstName=bean.getFirstName();
									 lastName=bean.getLastName();
									 dob=bean.getDob()==null?"":validation.convertDateToString(bean.getDob());
									 gender=bean.getGender()==null?"":bean.getGender();
									 country=bean.getCountry();
									 state=bean.getState();
									 city=bean.getCity();
									 email=bean.getEmail();
									 phno=bean.getPhno();
									 role=bean.getRoleId();
									 psw=bean.getPassword();
									 confPsw=bean.getPassword();
									
									
									
								}
								if(request.getAttribute(contentPage.COUNTRYOBJ)!=null){
									countryList = (ArrayList<countryBean>)request.getAttribute(contentPage.COUNTRYOBJ);
								}
								
								ArrayList<roleBean> rolelist=new ArrayList<roleBean>();
								if(request.getAttribute(contentPage.ROLEOBJ)!=null){
									rolelist = (ArrayList<roleBean>)request.getAttribute(contentPage.ROLEOBJ);
								}
								
							%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1><%if(modifyFlag==false){ %>Add User <%}else{ %>Edit User  <%} %>  </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<!-- <div class="hide"> -->
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-1 col-sm-10">

											<form class="form-horizontal" id="addUser" name="addUser" action="FormServlet?key=<%=key %>" method="post">
											<%if(modifyFlag){ %>
													<input type="hidden" id="txtId" name="txtId" value="<%=bean.getId() %>" />
											<%} %>
												<div class="tabbable">
													<ul class="nav nav-tabs padding-16">
														<li class="active">
															<a data-toggle="tab" href="#edit-basic">
																<i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
																Basic Info
															</a>
														</li>

													<!-- 	<li>
															<a data-toggle="tab" href="#edit-settings">
																<i class="purple ace-icon fa fa-cog bigger-125"></i>
																Settings
															</a>
														</li> -->

														<li>
															<a data-toggle="tab" href="#edit-password">
																<i class="blue ace-icon fa fa-key bigger-125"></i>
																Password
															</a>
														</li>
													</ul>
											<div class="space-4"></div>
											<div align="center" style="color: red">
												<%
												 String str="";
												if(request.getAttribute(contentPage.ERROR)!=null){ 
													str=((ErrorMsg)request.getAttribute(contentPage.ERROR)).getError();
													try{
														 userName=request.getParameter("txtUserName");
														 firstName=request.getParameter("txtFirstName");
														 lastName=request.getParameter("txtLastName");
														 dob=request.getParameter("txtDob")==null?"":request.getParameter("txtDob");
														 gender=request.getParameter("gender")==null?"":request.getParameter("gender");
														 country=request.getParameter("country")!=null?Integer.parseInt(request.getParameter("country")):0;
														 state=request.getParameter("state")!=null?Integer.parseInt(request.getParameter("state")):0;
														 city=request.getParameter("city")!=null?Integer.parseInt(request.getParameter("city")):0;
														 email=request.getParameter("txtEmail");
														 phno=request.getParameter("txtPhno");
														 role=Integer.parseInt(request.getParameter("role"));
														 psw=request.getParameter("txtPsw");
														 confPsw=request.getParameter("txtConfPsw");
													}catch(Exception e){
														
													}
												
												} %>
												
												<label><%=str %> </label>
									
											</div>
											
													<div class="tab-content profile-edit-tab-content">
														<div id="edit-basic" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General</h4>

															<div class="row">
																<!-- <div class="col-xs-12 col-sm-4">
																	<input type="file" />
																</div> -->

																<div class="vspace-12-sm"></div>

																<div class="col-xs-12 col-sm-8">
																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right" for="form-field-username">User name</label>

																		<div class="col-sm-8">
																			<input class="col-xs-12 col-sm-10" type="text" id="txtUserName" name="txtUserName" placeholder="User Name" value="<%=userName %>" />
																		</div>
																	</div>

																	<div class="space-4"></div>

																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right" for="form-field-first">Name</label>

																		<div class="col-sm-8">
																			<input class="input-small" type="text" id="txtFirstName" name="txtFirstName" placeholder="First Name" value="<%=firstName %>" />
																			<input class="input-small" type="text" id="txtLastName" name="txtLastName" placeholder="Last Name" value="<%=lastName %>" />
																		</div>
																	</div>
																</div>
															</div>

															<hr />
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-date">Birth Date</label>

																<div class="col-sm-9">
																	<div class="input-medium">
																		<div class="input-group">
																			<input class="input-medium date-picker" id="txtDob" name="txtDob" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" value="<%=dob==null?"":dob %>" readonly="readonly" />
																			<span class="input-group-addon">
																				<i class="ace-icon fa fa-calendar"></i>
																			</span>
																		</div>
																	</div>
																</div>
															</div>
											
								
															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">Gender</label>

																<div class="col-sm-9">
																	<label class="inline">
																		<%if(gender.equalsIgnoreCase("male")){ %>
																			<input name="gender" id="male" type="radio" class="ace" value="male" checked="checked" />
																		<%}else{ %>
																			<input name="gender" id="male" type="radio" class="ace" value="male" />
																		<%} %>
																		<span class="lbl middle"> Male</span>
																	</label>

																	&nbsp; &nbsp; &nbsp;
																	<label class="inline">
																		<%if(gender.equalsIgnoreCase("female")){ %>
																			<input name="gender" id="female" type="radio" class="ace" value="female" checked="checked"/>
																		<%}else{ %>
																			<input name="gender" id="female" type="radio" class="ace" value="female"/>
																		<%} %>
																		
																		<span class="lbl middle"> Female</span>
																	</label>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">Country</label>

																<div class="col-sm-9">
																	<select class="col-sm-3" id="country" name="country" onchange="getState(this.value,0);">
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
																<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">State</label>

																<div class="col-sm-9">
																	<select class="col-sm-3" id="state" name="state" onchange="getCity(this.value,0);">
																	<option value="0">Select</option>
																	</select>
																</div>
															</div>
															
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">City</label>

																<div class="col-sm-9">
																	<select class="col-sm-3" id="city" name="city" >
																	<option value="0">Select</option>
																	</select>
																</div>
															</div>

															<div class="space"></div>
															<h4 class="header blue bolder smaller">Contact</h4>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input type="email" id="txtEmail" name="txtEmail" placeholder="abc@domain.com"  value="<%=email %>" />
																		<i class="ace-icon fa fa-envelope"></i>
																	</span>
																</div>
															</div>

															

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">Phone</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input class="input-medium input-mask-phone" type="text" id="txtPhno" name="txtPhno" value="<%=phno %>"/>
																		<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																	</span>
																</div>
															</div>

															<div class="space"></div>
															

															<h4 class="header blue bolder smaller">Role</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">Role</label>

																<div class="col-sm-9">
																	<select class="col-sm-3" id="role" name="role">
																		<option value="0">Select</option>
																		<%for(roleBean rolebean : rolelist){ 
																				if(role == rolebean.getRoleId()){
																		%>
																			<option selected="selected" value="<%=rolebean.getRoleId() %>" ><%=rolebean.getRoleName() %></option>
																		<%}else{ %>
																				<option value="<%=rolebean.getRoleId() %>" ><%=rolebean.getRoleName() %></option>
																		<%} }%>
																	</select>
																</div>
															</div>
															
															
														</div>

													<!-- 
															//  setting tab pane content
															
														<div id="edit-settings" class="tab-pane">
															<div class="space-10"></div>

															<div>
																<label class="inline">
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Make my profile public</span>
																</label>
															</div>

															<div class="space-8"></div>

															<div>
																<label class="inline">
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Email me new updates</span>
																</label>
															</div>

															<div class="space-8"></div>

															<div>
																<label>
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Keep a history of my conversations</span>
																</label>

																<label>
																	<span class="space-2 block"></span>

																	for
																	<input type="text" class="input-mini" maxlength="3" />
																	days
																</label>
															</div>
														</div> -->

														<div id="edit-password" class="tab-pane">
															<div class="space-10"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">New Password</label>

																<div class="col-sm-9">
																	<input type="password" id="txtPsw" name="txtPsw" value="<%=psw %>" />
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-pass2">Confirm Password</label>

																<div class="col-sm-9">
																	<input type="password" id="form-field-pass2" id="txtConfPsw" name="txtConfPsw" value="<%=confPsw %>" />
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="clearfix form-actions">
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
										</div><!-- /.span -->
									</div><!-- /.user-profile -->
								<!-- </div> -->
								
								
								
								
								
								
								
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
	<script>
	$( document ).ready(function() {

		getState('<%=country %>','<%=state %>');
		getCity('<%=state %>','<%=city %>')
		
		  $("#txtDob").datepicker({
	            changeMonth: true,
	            changeYear: true,
	            yearRange: '-100y:c+nn',
	            maxDate: '-1d'
	        });
		
	    $('#btnSubmit').click(function(){                   
	        	$("#addUser").submit();
	    });
	    
	   

	});
	</script>