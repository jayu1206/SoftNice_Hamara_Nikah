<%@page import="com.softNice.nikah.beans.dashboard"%>
<%@page import="com.softNice.nikah.beans.memberPlanBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.softNice.nikah.beans.generalSettingBean"%>
<%@page import="com.softNice.nikah.beans.settingBean"%>

<%

ArrayList<memberPlanBean> list=new ArrayList<memberPlanBean>();
if(request.getAttribute(contentPage.MEMBERPLANOBJ)!=null){
	list = (ArrayList<memberPlanBean>)request.getAttribute(contentPage.MEMBERPLANOBJ);
}

ArrayList<dashboard> dashboardList =new ArrayList<dashboard>();
if(request.getSession().getAttribute(contentPage.DASHBOARD)!=null){
	dashboardList = (ArrayList<dashboard>) request.getSession().getAttribute(contentPage.DASHBOARD);
	 
}

int totalMember=0;
int active=0;
int inactive=0;
int toalGender=0;
int male=0;
int female=0;

for(dashboard daBean : dashboardList){
	
		if(daBean.getName().equals("totalMembers"))
			totalMember = daBean.getValue();
		
		if(daBean.getName().equals("active"))
			active = daBean.getValue();
		
		if(daBean.getName().equals("inactive"))
			inactive = daBean.getValue();
		
		if(daBean.getName().equals("totalGender"))
			toalGender = daBean.getValue();
		
		if(daBean.getName().equals("male"))
			male = daBean.getValue();
		
		if(daBean.getName().equals("female"))
			female = daBean.getValue();
				
	
}


%>

<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
					<!-- 	<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div>/.pull-left

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div>/.pull-left
							</div>/.ace-settings-box
						</div>/.ace-settings-container -->

						<div class="page-header">
							<h1>
								Dashboard
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									overview &amp; stats
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- <div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-check green"></i>

									Welcome to
									<strong class="green">
										Ace
										<small>(v1.4)</small>
									</strong>,	
								</div> -->

								<div class="row">
									<div class="space-6"></div>
 
					
									<div class="vspace-12-sm"></div>

						
								</div><!-- /.row -->
								
									<div class="col-xs-6 col-sm-3 pricing-box">
										<div class="widget-box widget-color-red3">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Members</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													
													<table id="dynamic-table" class="table table-striped table-bordered table-hover">

													<thead>
														<tr>
															<th>Specification</th>
															<th>Result</th>
															<th>Link</th>
														</tr>
													</thead>
													<tbody>
													<%%>
														<tr>
															<td>Total</td>
															<td><%=totalMember %> Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Active</td>
															<td><%=active %>  Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Inactive</td>
															<td><%=inactive %> Members</td>
															<td><a href="#">View </a></td>
														</tr>
													</tbody>

													</table>
												</div>

												
											</div>
										</div>
									</div>
									
										<div class="col-xs-6 col-sm-3 pricing-box">
										<div class="widget-box widget-color-grey">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Orders</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													
													<table id="dynamic-table" class="table table-striped table-bordered table-hover">

													<thead>
														<tr>
															<th>Specification</th>
															<th>Result</th>
															<th>Link</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Total</td>
															<td>82 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Paid</td>
															<td>79 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Unpaid</td>
															<td>3 Members</td>
															<td><a href="#">View </a></td>
														</tr>
													</tbody>

													</table>
												</div>

												
											</div>
										</div>
									</div>
									
									
									
										<div class="col-xs-6 col-sm-3 pricing-box">
										<div class="widget-box widget-color-blue">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Gender</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													
													<table id="dynamic-table" class="table table-striped table-bordered table-hover">

													<thead>
														<tr>
															<th>Specification</th>
															<th>Result</th>
															<th>Link</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Total</td>
															<td><%=toalGender %> Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Groom (Male)</td>
															<td><%=male %> Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Bride (Female)</td>
															<td><%=female %> Members</td>
															<td><a href="#">View </a></td>
														</tr>
													</tbody>

													</table>
												</div>

												
											</div>
										</div>
									</div>
									
										<div class="col-xs-6 col-sm-3 pricing-box">
										<div class="widget-box widget-color-orange">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Membership Plan</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													
													<table id="dynamic-table" class="table table-striped table-bordered table-hover">

													<thead>
														<tr>
															<th>Specification</th>
															<th>Result</th>
															<th>Link</th>
														</tr>
													</thead>
													<tbody>
														
														<tr>
															<td>Free</td>
															<td>47 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Silver</td>
															<td>3 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Gold</td>
															<td>4 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Dimond</td>
															<td>28 Members</td>
															<td><a href="#">View </a></td>
														</tr>
														<tr>
															<td>Pletinum</td>
															<td>0 Members</td>
															<td><a href="#">View </a></td>
														</tr>
													</tbody>

													</table>
												</div>

												
											</div>
										</div>
									</div>
									
									<h4 class="header blue bolder smaller"> &nbsp;</h4>
									
<%if(list.size()>0){  %>
					<div class="row">
				
						<div class="col-xs-4 col-sm-2 pricing-span-header">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Package Name</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table-header">
														<li>Creadit</li>
														<li>Plan Validity</li>
														<li>Order</li>
														<li>Print view</li>
														<li>Photo Upload</li>
														<li>Horoscope Upload</li>
														<li>Horoscope View</li>
														<li>Video Upload</li>
														<li>Protect Photo</li>
														<li>Bookmark</li>
														<li>Messaging</li>
														<li>Service Tax</li>
														<li>Plan Charges</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-8 col-sm-9 pricing-span-body">
									<%  for(memberPlanBean plan: list){
									
									String str="";
									if(plan.getPlanName().equalsIgnoreCase("free")){
										str="red3";
									}
									if(plan.getPlanName().equalsIgnoreCase("Dimond")){
										str="orange";
									}
									
									if(plan.getPlanName().equalsIgnoreCase("Gold")){
										str="blue";								
									}
									if(plan.getPlanName().equalsIgnoreCase("Platinum")){
										str="green";	
									}
									if(plan.getPlanName().equalsIgnoreCase("Silver")){
										str="grey";
									}
									
									%>
									
										
										<div class="pricing-span">
											
											<div class="widget-box pricing-box-small widget-color-<%=str %>">
												<div class="widget-header" align="center" >
													<h5 class="widget-title bigger lighter"  ><%=plan.getPlanName() %></h5>
												</div>

												<div class="widget-body">
													<div class="widget-main no-padding">
														<ul class="list-unstyled list-striped pricing-table">
															<li> <%=plan.getCredits() %></li>
															<li> <%=plan.getPlanValidity() + " Days"  %> </li>
															<li> <%=plan.getOrder() %> </li>
														
														<%if(plan.isPrintedView()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isPhotoUpload()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isHoroscopeUpload()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isHoroscopeView()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isVideoUpload()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isProtectPhoto()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isBookmark()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isMessaging()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
														
														<%if(plan.isServiceTex()){ %>
															<li><i class=" green ace-icon fa fa-check-circle"></i></li>
														<%}else{ %>
															<li><i class="red ace-icon fa fa-times-circle"></i></li>
														<%} %>
	
														<li><div class="price">
															<span class="label label-lg label-inverse arrowed-in arrowed-in-right">
																<small><%=plan.getPlanCharges() + " Rs" %></small>
															</span>
														</div></li>
															
														</ul>

													</div>

													<div>
														<a href="#" class="btn btn-block btn-sm btn-danger">
															<span>Buy</span>
														</a>
													</div>
												</div>
											</div>
										</div>

								<%} %>

									</div>
							</div>
							
							
							<%} %>
							
							
							
									
									
									
							
							
							
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->