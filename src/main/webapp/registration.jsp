<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="java.util.ArrayList"%>
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
		<title>Registration Page - Hamara Nikah</title>


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
		 
		 <script src="assets/js/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jquery.hotkeys.index.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
		
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/interface/softNiceUtilityData.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script src='js/softnice.js?v=" + Date.now() + "' type="text/javascript" charset="utf-8"></script>
		 


	
	</head>
	 
	<%
				String firstName="",lastName="",gender="",dob="",email="",psw="";
				int country=0,state=0,city=0;
	
				settingBean settingbean= null;
				generalSettingBean mailbean= new generalSettingBean();
				if(getServletContext().getAttribute(contentPage.SETTING)!=null){
					settingbean = (settingBean) getServletContext().getAttribute(contentPage.SETTING);
					
					ObjectMapper mapperObj = new ObjectMapper();
					if(settingbean.getValue()!=null){
						mailbean = new Gson().fromJson(settingbean.getValue(),generalSettingBean.class);
					}
					
				}
				
				ArrayList<countryBean> countryList=new ArrayList<countryBean>();
				if(request.getAttribute(contentPage.COUNTRYOBJ)!=null){
					countryList = (ArrayList<countryBean>)request.getAttribute(contentPage.COUNTRYOBJ);
				}
				
				if(request.getAttribute(contentPage.ERROR)!=null){ 
					
					 firstName=request.getParameter("txtFirstName");
					 lastName=request.getParameter("txtLastName");
					 dob=request.getParameter("txtDob")==null?"":request.getParameter("txtDob");
					 gender=request.getParameter("gender")==null?"":request.getParameter("gender");
					 country=request.getParameter("country")!=null?Integer.parseInt(request.getParameter("country")):0;
					 state=request.getParameter("state")!=null?Integer.parseInt(request.getParameter("state")):0;
					 city=request.getParameter("city")!=null?Integer.parseInt(request.getParameter("city")):0;
					 email=request.getParameter("txtEmail");
					 psw=request.getParameter("txtPsw");
					
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
								<div id="signup-box" class="signup-box widget-box no-border visible">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												Registration Free
											</h4>

											<div class="space-6"></div>

					<form action="memberServlet?key=newRegister" method="post" name="memberForm" id="memberForm" >
								<fieldset>
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="text" id="txtFirstName" name="txtFirstName" class="form-control" value="<%=firstName %>" placeholder="First Name" />
											<i class="ace-icon fa fa-user"></i>
										</span>
										
									</label>
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="text" id="txtLastName" name="txtLastName" class="form-control" value="<%=lastName %>" placeholder="Last Name" />
											<i class="ace-icon fa fa-user"></i>
										</span>
									 </label>
									
									<label class="block clearfix"> 
											<label class="col-sm-12 control-label no-padding-right">I am looking for</label>
									</label>
									<label class="block clearfix"> 
									
								<!-- 	<input type="radio" name="gender" id="male"  class="ace" value="male" />
									<span class="lbl"> Bride</span>
									<input type="radio" name="gender" id="female"  class="ace" value="female" />
									<span class="lbl"> Groom</span>
									
									
									    /* z-index: -100!important; */
    width: 1px!important;
    height: 1px!important;
    /* clip: rect(1px,1px,1px,1px); */
    position: absolute;
									
									
									 -->
										 <span class="block input-icon input-icon-right">

											<%if(gender.equalsIgnoreCase("male")){ %>
												<input name="gender" id="male" type="radio"  value="male" checked="checked"  />
											<%}else{ %>
												<input name="gender" id="male" type="radio"  value="male"  />
											<%} %>
											<span class="lbl"> Bride</span>
											&nbsp;&nbsp;
											
											<%if(gender.equalsIgnoreCase("female")){ %>
												<input name="gender" id="female" type="radio"  value="female" checked="checked"  />
											<%}else{ %>
												<input name="gender" id="female" type="radio"  value="female" />
											<%} %>
											<span class="lbl"> Groom</span>
										</span> 
									</label>

									<div class="space"></div>
									
									<label class="block clearfix"> 
										Date of birth
									</label>
									<label class="block clearfix"> 
											 <!-- <div class="col-sm-24"> -->
											<input class="input-medium date-picker"  id="txtDob" name="txtDob" value="<%=dob %>" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy"  readonly="readonly" />
											<i class="ace-icon fa fa-calendar"></i>
											<!-- </div> -->
											  
									</label>
									
									<label class="block clearfix"> 
										<select class="col-sm-12" id="country" name="country" onchange="getState(this.value,0);">
												<option value="0">Country</option>
													<%for(countryBean countrybean : countryList){ 
															if(country == countrybean.getId()){
													%>
															<option selected="selected" value="<%=countrybean.getId() %>" ><%=countrybean.getName() %></option>
													<%}else{ %>
															<option value="<%=countrybean.getId() %>" ><%=countrybean.getName() %></option>
													<%}} %>
													
										</select>
									</label>
									<label class="block clearfix">  
										<select class="col-sm-12" id="state" name="state" onchange="getCity(this.value,0);">
											<option value="0">State</option>
										</select>
									</label>
									
									<label class="block clearfix">  
										<select class="col-sm-12" id="city" name="city" >
											<option value="0">City</option>
										</select>
									</label>
									
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="text" id="txtEmail" name="txtEmail" value="<%=email %>" class="form-control" placeholder="Email" />
											<i class="ace-icon fa fa-envelope"></i>
										</span>
									 </label>
									 
									 
									 <label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="password" id="txtPsw" name="txtPsw" value="<%=psw %>" class="form-control" placeholder="Password" />
											<i class="ace-icon fa fa-lock"></i>
										</span>
									 </label>
									 
									<!-- <label class="block">
										<input type="checkbox" class="ace" />
										<span class="lbl">
											I accept the
											<a href="#">User Agreement</a>
										</span>
									</label> -->

									<div class="space-24"></div>

									<div class="clearfix">
										<button type="reset" class="width-30 pull-left btn btn-sm">
											<i class="ace-icon fa fa-refresh"></i>
											<span class="bigger-110">Reset</span>
										</button>

										<button type="button" id="btnSubmit"  name="btnSubmit" class="width-65 pull-right btn btn-sm btn-success">
											<span class="bigger-110">Register</span>
											<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
										</button>
									</div>
					<!-- 
									<div class="clearfix">
										<label class="inline">
											<input type="checkbox" class="ace" />
											<span class="lbl"> Remember Me</span>
										</label>
										
										<button type="button" class="width-35 pull-left btn btn-sm btn-primary" id="btnRegister"  name="btnRegister" >
											<i class="ace-icon fa fa-key"></i>
											<span class="bigger-110">Register</span>
										</button>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="btnSubmit"  name="btnSubmit">
											<i class="ace-icon fa fa-key"></i>
											<span class="bigger-110">Login</span>
										</button>
										
										<input type="submit" value="Login" >
									</div> -->

									<div class="space-4"></div>
									
									<div align="center" style="color: red">
										<%
										 String str="";
										if(request.getAttribute(contentPage.ERROR)!=null){ 
											str=((ErrorMsg)request.getAttribute(contentPage.ERROR)).getError();
										
										} %>
										
										<label><%=str  %> </label>
					
								</div>
								</fieldset>
						</form>

											
						</div>
						<div class="toolbar center">
							<a href="memberServlet" data-target="#login-box" class="back-to-login-link">
								<i class="ace-icon fa fa-arrow-left"></i>
								Back to login
							</a>
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->
	</div>
	</div>
</div>
</div>
		
<script>
$(document).ready(function($){
		
	
	getState('<%=country %>','<%=state %>');
	getCity('<%=state %>','<%=city %>')
	
	
	    $('#btnSubmit').click(function(){ 
	        	$("#memberForm").submit();
	    });
	    
	/*    $('#btnRegister').click(function(){ 
	    	$("#key").val("register");
        	$("#memberForm").submit();
    }); */
	    
	    $("#txtDob").datepicker({
		    changeMonth: true,
            changeYear: true,
            autoclose: true,
            yearRange: '-100y:c+nn',
            clearBtn: true,
            endDate:'-20y', //'12-06-1990' ,
            closeBtn: true, // close button visible
        
        });

	});
</script>

		
		<%
			request.getSession().invalidate();
		%>
</body>
</html>
