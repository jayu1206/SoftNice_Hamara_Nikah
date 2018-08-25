<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="com.softNice.nikah.beans.generalSettingBean"%>
<%@page import="com.softNice.nikah.beans.memberStoryBean"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.beans.settingBean"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />


<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css" />

<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<script src="assets/js/bootstrap-datepicker.min.js"></script>
<script src="assets/js/jquery.hotkeys.index.min.js"></script>
<script src="assets/js/select2.min.js"></script>

<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript'
	src='dwr/interface/softNiceUtilityData.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script src='js/softnice.js?v=" + Date.now() + "' type="text/javascript"
	charset="utf-8"></script>


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
				
				ArrayList<memberStoryBean> storyList=new ArrayList<memberStoryBean>();
				
				if(request.getAttribute(contentPage.STORIES)!=null){
					storyList = (ArrayList<memberStoryBean>)request.getAttribute(contentPage.STORIES);
				}

				
				
		%>

<body>
	<div class="main-container">
		<div class="main-content">
			<div class="center">
				<h1>
					<i class="ace-icon fa fa-leaf green"></i> <span class="red"><%=mailbean.getApp_name() %></span>
					<span class="white" id="id-text2">Application</span>
				</h1>
				<h4 class="blue" id="id-company-text">
					&copy;
					<%=mailbean.getCmpName() %></h4>
			</div>
			<!-- <div cl> -->
				<div class="page-header">
					<h1>
						Success Stories <small> <i
							class="ace-icon fa fa-angle-double-right"></i> Happy Marriages
							from Hamarah Nikah.
						</small>
					</h1>
				</div>

				<div class="col-xs-12">


					<div class="row">
						<%
														for (memberStoryBean storyBean : storyList) {
															String path[] = storyBean.getImgUrl().toString().split("temp");
															String finalPath = path[1];															
															String fileName = finalPath.substring(finalPath.lastIndexOf("\\")+1);
													%>

						<div class="col-xs-6 col-sm-4 col-md-2">
							<div class="thumbnail search-thumbnail">
								<!-- <span
																class="search-promotion label label-success arrowed-in arrowed-in-right">Sponsored</span> -->
								<% if(fileName != null || fileName.length() != 0){ %>
								<img class="media-object" style="width: 200px; height: 180px;"
									src="<%="webapp/temp/"+fileName %>"
									onerror="assets/img/No_Image_Available.png" />

								<% }else{ %>
								<img class="media-object" style="width: 200px; height: 180px;"
									src="assets/img/No_Image_Available.png" />

								<%} %>
								<div class="caption">


									<h3 class="search-title">
										<a href="#" class="blue"><%=storyBean.getGroomName() %></a>
									</h3>
									<p><%=storyBean.getSuccessStory() %></p>
								</div>
							</div>
						</div>
						<%
														}
													%>

					</div>

					<div class="space-12"></div>


				</div>

			</div>
		</div>
		<!-- /.main-content -->
	<!-- /.main-container -->
	<div class="form-actions center">
		<button type="button" class="btn btn-sm btn-success">
			<a href="memberServlet" data-target="#login-box"
				class="back-to-login-link"> <i class="ace-icon fa fa-arrow-left"></i>
				Back to login
			</a>
		</button>
	</div>

</body>
</html>
