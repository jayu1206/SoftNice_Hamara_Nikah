
<%@page import="com.softNice.nikah.utility.EncrypitDecrypit"%>
<%@page import="com.softNice.nikah.beans.memberBean"%>
<%@page import="com.softNice.nikah.beans.masterBean"%>
<%@page import="com.softNice.nikah.beans.memberDetailsBean"%>
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
		String familyStatus="";
		int culture = 0;
		int height = 0;
		int weight = 0;
		int built = 0;
		int complexion = 0;
		int diet= 0;
		int drink = 0 ;
		int smoke = 0;
		String about = "";
		int education = 0;
		int profession = 0;
		int income = 0;
		String visa = "";
		if(request.getSession().getAttribute(contentPage.MEMBERS)!=null){
			bean = (memberBean)request.getSession().getAttribute(contentPage.MEMBERS);
			
		}	
		for(memberDetailsBean memberDetailbean : bean.getDetails()){
			familyStatus = memberDetailbean.getFamilyStatus();
			culture = memberDetailbean.getCulture();
			height = memberDetailbean.getHeight();
			weight = memberDetailbean.getWeight();
			built = memberDetailbean.getBuilt();
			complexion = memberDetailbean.getComplexion();		
			diet = memberDetailbean.getDiet();
			drink = memberDetailbean.getDrink();
			smoke = memberDetailbean.getSmoke();
			about = memberDetailbean.getAbout();
			education = memberDetailbean.getEducation();
			profession = memberDetailbean.getProfession();
			income = memberDetailbean.getIncome();
			visa = memberDetailbean.getVisaStatus();
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
											<%=familyStatus %>
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
										
										<div class="profile-info-row">
											<div class="profile-info-name">Family Status</div>

											<div class="profile-info-value">
												<span class="editable" id="age"><%=familyStatus%></span> 
											</div>
										</div>
										
										<div class="profile-info-row">
											<div class="profile-info-name">Culture</div>

											<div class="profile-info-value">
												<span class="editable" id="age"><%=culture%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Culture</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=height%></span> 
											</div>
										</div>
										
										<div class="profile-info-row">
											<div class="profile-info-name">Weight</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=weight%></span> 
											</div>
										</div>
										
										<div class="profile-info-row">
											<div class="profile-info-name">Built</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=built%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Complexion</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=complexion%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Diet</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=diet%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Drink</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=drink%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Smoke</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=smoke%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">About me</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=about%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Education Details</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=education%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Profession</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=profession%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Income</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=income%></span> 
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name">Visa Status</div>
											<div class="profile-info-value">
												<span class="editable" id="age"><%=visa%></span> 
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


