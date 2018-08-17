
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.beans.permissionBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.softNice.nikah.beans.UserBean"%>
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				
				<%
						HashMap<String, permissionBean> map= null;
						if(request.getSession().getAttribute(contentPage.MAPOBJ)!=null){
							new HashMap<String, permissionBean>();
							map = (HashMap) request.getSession().getAttribute(contentPage.MAPOBJ);
						}		
							
	
				%>
				
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active">
						<a href="ContentServlet?key=dashboard">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li>
					<%
						permissionBean Perbean=(permissionBean) map.get("Administration");
						if(Perbean.isView()){
					%>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								Administration
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							
							<li class="">
								<a href="ContentServlet?key=user">
									<i class="menu-icon fa fa-caret-right"></i>
									Administrators
								</a>

								<b class="arrow"></b>
							</li> 

							<li class="">
								<a href="ContentServlet?key=role">
									<i class="menu-icon fa fa-caret-right"></i>
									Roles
								</a>

								<b class="arrow"></b>
							</li> 
							
						</ul>
					</li>
					<%} %>

							<!-- Members menu  -->
							
							<%
						 Perbean=(permissionBean) map.get("Members");
						if(Perbean.isView()){
					%>

	<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-users"></i>
							<span class="menu-text">
								Members
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							
							<li class="">
								<a href="ContentServlet?key=memberPlan">
									<i class="menu-icon fa fa-caret-right"></i>
									Membership plan
								</a>

								<b class="arrow"></b>
							</li> 

							<li class="">
								<a href="ContentServlet?key=membersList">
									<i class="menu-icon fa fa-caret-right"></i>
									Members
								</a>

								<b class="arrow"></b>
							</li> 
							
							<li class="">
								<a href="#">
									<i class="menu-icon fa fa-caret-right"></i>
									Messages
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="ContentServlet?key=country">
									<i class="menu-icon fa fa-caret-right"></i>
									Request
								</a>

								<b class="arrow"></b>
							</li>
							
							 <li class="">
									<a href="ContentServlet?key=searchMember">
										<i class="menu-icon fa fa-caret-right"></i>
										Search
								</a>

								<b class="arrow"></b>
							</li> 
							<li class="">
									<a href="ContentServlet?key=galleryImage">
										<i class="menu-icon fa fa-caret-right"></i>
										Gallery
								</a>

								<b class="arrow"></b>
							</li>
							
							
						</ul>
					</li>
					
					<!-- Members menu finished -->

<%} %>













					<%
						Perbean=(permissionBean) map.get("Setting");
						if(Perbean.isView()){
					%>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text">
								Settings
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							
							<li class="">
								<a href="FormServlet?key=generalSetting">
									<i class="menu-icon fa fa-caret-right"></i>
									General
								</a>

								<b class="arrow"></b>
							</li> 

							<li class="">
								<a href="FormServlet?key=emailSetting">
									<i class="menu-icon fa fa-caret-right"></i>
									Email
								</a>

								<b class="arrow"></b>
							</li> 
							
							<li class="">
								<a href="#">
									<i class="menu-icon fa fa-caret-right"></i>
									Validation
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="ContentServlet?key=country">
									<i class="menu-icon fa fa-caret-right"></i>
									Country
								</a>

								<b class="arrow"></b>
							</li>
							
								<li class="">
									<a href="ContentServlet?key=state">
										<i class="menu-icon fa fa-caret-right"></i>
										State
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
									<a href="ContentServlet?key=city">
										<i class="menu-icon fa fa-caret-right"></i>
										City
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
									<a href="ContentServlet?key=basics">
										<i class="menu-icon fa fa-caret-right"></i>
										Basic Details
								</a>

								<b class="arrow"></b>
							</li>
							
						</ul>
					</li>

				<%} %>



				<!-- 	<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Tables </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="tables.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Simple &amp; Dynamic
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="jqgrid.html">
									<i class="menu-icon fa fa-caret-right"></i>
									jqGrid plugin
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
 -->
				<!-- 	<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-pencil-square-o"></i>
							<span class="menu-text"> Forms </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="form-elements.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Form Elements
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="form-elements-2.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Form Elements 2
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="form-wizard.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Wizard &amp; Validation
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="wysiwyg.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Wysiwyg &amp; Markdown
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="dropzone.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Dropzone File Upload
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li> -->

					<!-- <li class="">
						<a href="widgets.html">
							<i class="menu-icon fa fa-list-alt"></i>
							<span class="menu-text"> Widgets </span>
						</a>

						<b class="arrow"></b>
					</li> -->

				<!-- 	<li class="">
						<a href="calendar.html">
							<i class="menu-icon fa fa-calendar"></i>

							<span class="menu-text">
								Calendar

								<span class="badge badge-transparent tooltip-error" title="2 Important Events">
									<i class="ace-icon fa fa-exclamation-triangle red bigger-130"></i>
								</span>
							</span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="gallery.html">
							<i class="menu-icon fa fa-picture-o"></i>
							<span class="menu-text"> Gallery </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-tag"></i>
							<span class="menu-text"> More Pages </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="profile.html">
									<i class="menu-icon fa fa-caret-right"></i>
									User Profile
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="inbox.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Inbox
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="pricing.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Pricing Tables
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="invoice.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Invoice
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="timeline.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Timeline
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="search.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Search Results
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="email.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Email Templates
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="login.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Login &amp; Register
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li> -->

				<!-- 	<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-file-o"></i>

							<span class="menu-text">
								Other Pages

								<span class="badge badge-primary">5</span>
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="faq.html">
									<i class="menu-icon fa fa-caret-right"></i>
									FAQ
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="error-404.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Error 404
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="error-500.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Error 500
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="grid.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Grid
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="blank.html">
									<i class="menu-icon fa fa-caret-right"></i>
									Blank Page
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li> -->
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
				
			
			</div>
