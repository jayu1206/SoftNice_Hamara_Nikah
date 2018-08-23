<%@page import="com.google.gson.Gson"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="com.softNice.nikah.beans.generalSettingBean"%>
<%@page import="com.softNice.nikah.beans.settingBean"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Login Page - Hamara Nikah</title>

<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script> -->
<script src="assets/js/jquery-1.11.3.min.js"></script>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		 <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" /> 


		<!-- text fonts -->
		 <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" /> 

		<!-- ace styles -->
		 <link rel="stylesheet" href="assets/css/ace.min.css" /> 

		 <link rel="stylesheet" href="assets/css/ace-rtl.min.css" /> 
		 
	<!-- 	 <script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/jquery.sparkline.index.min.js"></script>
		<script src="assets/js/jquery.flot.min.js"></script>
		<script src="assets/js/jquery.flot.pie.min.js"></script>
		<script src="assets/js/jquery.flot.resize.min.js"></script> -->

	
	</head>
	 
	<%
	
	
				settingBean settingbean= null;
				generalSettingBean mailbean= new generalSettingBean();
				if(getServletContext().getAttribute(contentPage.SETTING)!=null){
					settingbean = (settingBean) getServletContext().getAttribute(contentPage.SETTING);
					
					ObjectMapper mapperObj = new ObjectMapper();
					if(settingbean.getValue()!=null){
						mailbean = new Gson().fromJson(settingbean.getValue(),generalSettingBean.class);
					}
					
				}
		%>
	
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red"><%=mailbean.getApp_name() %></span>
									<span class="white" id="id-text2">Application</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; <%=mailbean.getCmpName() %></h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Member Information
											</h4>

											<div class="space-6"></div>

					<form action="memberServlet" method="post" name="memberForm" id="memberForm" >
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="txtUserName" name="txtUserName" class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<input type="hidden" id="key" name="key" value="" />
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="txtPsw" name="txtPsw" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<!-- <label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label> -->
														
														<!-- <button type="button" class="width-35 pull-left btn btn-sm btn-primary" id="btnRegister"  name="btnRegister" >
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Register</span>
														</button> -->
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="btnSubmit"  name="btnSubmit">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Login</span>
														</button> 
														
														<!-- <input type="submit" value="Login" > -->
													</div>

													<div class="space-4"></div>
													
													<div align="center" style="color: red">
														<%
														 String str="";
														if(request.getAttribute(contentPage.ERROR)!=null){ 
															str=((ErrorMsg)request.getAttribute(contentPage.ERROR)).getError();
														
														} %>
														
														<label><%=str %> </label>
									
												</div>
												</fieldset>
								</form>

											
						</div>
					</div><!-- /.col -->
					<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													I forgot my password
												</a>
											</div>

											<div>
												<a href="memberServlet?key=register" data-target="#signup-box" class="user-signup-link">
													I want to free register
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
											
											
				</div>
				
								<div> 
				
									<div style="text-align: center;">
										<a href="memberServlet?key=addStory" data-target="#forgot-box" class="forgot-password-link">
											Post your success story here
											<i class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
				
							<div> 
				
								<div style="text-align: center;">
									<a href="memberServlet?key=viewStory" data-target="#forgot-box" class="forgot-password-link">
										Show Stories
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</div>
						</div>
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->
		
<script>
$(document).ready(function($){
		
	    $('#btnSubmit').click(function(){ 
	    		$("#key").val("login");
	        	$("#memberForm").submit();
	    });
	    
	    $('#btnRegister').click(function(){ 
	    	$("#key").val("register");
        	$("#memberForm").submit();
    });
	    
	   

	});
</script>

		
		<%
			request.getSession().invalidate();
		%>
</body>
</html>
