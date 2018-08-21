
<%@page import="com.softNice.nikah.utility.EncrypitDecrypit"%>
<%@page import="com.softNice.nikah.beans.memberBean"%>
<%@page import="com.softNice.nikah.beans.masterBean"%>
<%@page import="com.softNice.nikah.utility.validation"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.softNice.nikah.beans.countryBean"%>
<%@page import="com.softNice.nikah.beans.UserBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>


<div class="main-content">

	<% 
		memberBean bean= new memberBean();
		if(request.getSession().getAttribute(contentPage.MEMBERS)!=null){
			bean = (memberBean)request.getSession().getAttribute(contentPage.MEMBERS);
		}		
		
		
	%>

	<div class="main-content-inner">

		<div class="page-content">
			<div class="page-header">

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div>
							<div id="user-profile-1" class="user-profile row">
								<div class="col-xs-12 col-sm-3 center">
									<div>
										<span class="profile-picture"> <img id="avatar"
											class="editable img-responsive" alt="Alex's Avatar"
											src="assets/images/avatars/profile-pic.jpg" />
										</span>

										<div class="space-4"></div>

										<div
											class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
											<div class="inline position-relative">
												<a href="#" class="user-title-label dropdown-toggle"
													data-toggle="dropdown"> <i
													class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
													class="white"><%=bean.getFirstName() +' '+ bean.getLastName() %></span>
												</a>

											</div>
										</div>
									</div>
									<div class="hr hr16 dotted"></div>
								</div>

								<div class="col-xs-12 col-sm-9">
									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-row">
											<div class="profile-info-name">Name</div>

											<div class="profile-info-value">
												<span class="editable" id="username"><%=bean.getFirstName() +' '+ bean.getLastName()%></span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Email</div>

											<div class="profile-info-value">
												<span class="editable" id="username"><%=bean.getEmail()%></span>
											</div>
										</div>
										
										<div class="profile-info-row">
											<div class="profile-info-name">City</div>
											<div class="profile-info-value">
												<span class="editable" id="username"><%=bean.getCityName()%></span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">State</div>
											<div class="profile-info-value">
												<span class="editable" id="username"><%=bean.getStateName()%></span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Country</div>

											<div class="profile-info-value">
												<i class="fa fa-map-marker light-orange bigger-110"></i> <span
													class="editable" id="country"><%=bean.getCountryName() %></span> 
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Age</div>

											<div class="profile-info-value">
												<span class="editable" id="age"><%=bean.getAge() %></span>
											</div>
										</div>
										
									</div>
								</div>
							</div>
						</div>



						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->

			<!-- /.page-header -->
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->


