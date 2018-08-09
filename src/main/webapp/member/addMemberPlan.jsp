
<%@page import="com.softNice.nikah.beans.memberPlanBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<div class="main-content">
						<%
							boolean modifyFlag=false;
							String key="addMemberPlan";
							memberPlanBean bean=new memberPlanBean();
								if(request.getAttribute(contentPage.MODIFYOBJ)!=null){
									bean = (memberPlanBean)request.getAttribute(contentPage.MODIFYOBJ);
									key="updateMemberPlan";
									modifyFlag=true;
								}
								
								if(request.getAttribute(contentPage.ERROR)!=null){ 
									
									bean.setPlanName(request.getParameter("txtPlanName"));
									
									if(!request.getParameter("txtCredits").equals("") ){
										bean.setCredits(Integer.parseInt(request.getParameter("txtCredits")));
									}
									
									if(!request.getParameter("txtValidity").equals("")){
										bean.setPlanValidity(Integer.parseInt(request.getParameter("txtValidity")));
									}
									
									if(!request.getParameter("txtCharges").equals("")){
										bean.setPlanCharges(Integer.parseInt(request.getParameter("txtCharges")));
									}
									if(!request.getParameter("txtOrder").equals("")){
										bean.setOrder(Integer.parseInt(request.getParameter("txtOrder")));
									}
									
									
									if(request.getParameter("PrintView").equals("Yes")){
										bean.setPrintedView(true);
									}
									if(request.getParameter("PrintView").equals("No")){
										bean.setPrintedView(false);
									}
									if(request.getParameter("photoUpload").equals("Yes")){
										bean.setPhotoUpload(true);
									}
									if(request.getParameter("photoUpload").equals("No")){
										bean.setPhotoUpload(false);
									}
									if(request.getParameter("horoscopeUpload").equals("Yes")){
										bean.setHoroscopeUpload(true);
									}
									if(request.getParameter("horoscopeUpload").equals("No")){
										bean.setHoroscopeUpload(false);
									}
									if(request.getParameter("horoscopeView").equals("Yes")){
										bean.setHoroscopeView(true);
									}
									if(request.getParameter("horoscopeView").equals("No")){
										bean.setHoroscopeView(false);
									}
									if(request.getParameter("videoUpload").equals("Yes")){
										bean.setVideoUpload(true);
									}
									if(request.getParameter("videoUpload").equals("No")){
										bean.setVideoUpload(false);
									}
									if(request.getParameter("protectPhoto").equals("Yes")){
										bean.setProtectPhoto(true);
									}
									if(request.getParameter("protectPhoto").equals("No")){
										bean.setProtectPhoto(false);
									}
									if(request.getParameter("bookmark").equals("Yes")){
										bean.setBookmark(true);
									}
									if(request.getParameter("bookmark").equals("No")){
										bean.setBookmark(false);
									}
									if(request.getParameter("messaging").equals("Yes")){
										bean.setMessaging(true);
									}
									if(request.getParameter("messaging").equals("No")){
										bean.setMessaging(false);
									}
									if(request.getParameter("serviceTex").equals("Yes")){
										bean.setMessaging(true);
									}
									if(request.getParameter("serviceTex").equals("No")){
										bean.setMessaging(false);
									}
									
								}
								
								
							%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1><%if(modifyFlag==false){ %>Add Membership Plan <%}else{ %>Add Membership Plan  <%} %>  </h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-10">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=<%=key %>" method="post" name="addRole" id="addRole" class="form-horizontal">
								<%if(modifyFlag){ %>
								<input type="hidden" id="txtId" name="txtId" value="<%=bean.getPlanId() %>" />
								<%} %>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Name </label>

										<div class="col-sm-9">
											<input type="text" id="txtPlanName" name="txtPlanName" value="<%=bean.getPlanName() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Credits </label>

										<div class="col-sm-9">
											<input type="text" id="txtCredits" name="txtCredits" value="<%=bean.getCredits()==0?"":bean.getCredits() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Plan Validity </label>

										<div class="col-sm-9">
											<input type="text" id="txtValidity" name="txtValidity" value="<%=bean.getPlanValidity()==0?"":bean.getPlanValidity() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Plan Charges </label>

										<div class="col-sm-9">
											<input type="text" id="txtCharges" name="txtCharges" value="<%=bean.getPlanCharges()==0?"0":bean.getPlanCharges() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Order </label>

										<div class="col-sm-9">
											<input type="text" id="txtOrder" name="txtOrder" value="<%=bean.getOrder()==0?"":bean.getOrder() %>" class="col-xs-10 col-sm-5" />
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Printed View </label>

										<div class="col-sm-9">
													<!-- <label>
														<input name="switch-field-1" class="ace ace-switch ace-switch-6" type="checkbox" />
														<span class="lbl"></span>
													</label> -->
											 <label class="inline">
													<input name="PrintView" id="printViewY" type="radio" class="ace" value="Yes" <%=bean.isPrintedView()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label> 

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="PrintView" id="printViewN" type="radio" class="ace" value="No" <%=bean.isPrintedView()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Photo Upload </label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="photoUpload" id="photoUploadY" type="radio" class="ace" value="Yes"  <%=bean.isPhotoUpload()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="photoUpload" id="photoUploadN" type="radio" class="ace" value="No" <%=bean.isPhotoUpload()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
										</div>
								</div>
								
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Horoscope Upload </label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="horoscopeUpload" id="horoscopeUploadY" type="radio" class="ace" value="Yes" <%=bean.isHoroscopeUpload()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="horoscopeUpload" id="horoscopeUploadN" type="radio" class="ace" value="No"  <%=bean.isHoroscopeUpload()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Horoscope View </label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="horoscopeView" id="horoscopeViewY" type="radio" class="ace" value="Yes" <%=bean.isHoroscopeView()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="horoscopeView" id="horoscopeViewN" type="radio" class="ace" value="No"   <%=bean.isHoroscopeView()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Video Upload </label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="videoUpload" id="videoUploadY" type="radio" class="ace" value="Yes" <%=bean.isVideoUpload()==true?"checked='checked'":"" %>  />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="videoUpload" id="videoUploadN" type="radio" class="ace" value="No"  <%=bean.isVideoUpload()==false?"checked='checked'":"" %>  />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Protect Photo</label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="protectPhoto" id="protectPhotoY" type="radio" class="ace" value="Yes" <%=bean.isProtectPhoto()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="protectPhoto" id="protectPhotoN" type="radio" class="ace" value="No" <%=bean.isProtectPhoto()==false?"checked='checked'":"" %>" />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Bookmark</label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="bookmark" id="bookmarkY" type="radio" class="ace" value="Yes" <%=bean.isBookmark()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="bookmark" id="bookmarkoN" type="radio" class="ace" value="No" <%=bean.isBookmark()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Messaging</label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="messaging" id="messagingY" type="radio" class="ace" value="Yes" <%=bean.isMessaging()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="messaging" id="messagingN" type="radio" class="ace" value="No" <%=bean.isMessaging()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Service Tex</label>

										<div class="col-sm-9">
										
											<label class="inline">
													<input name="serviceTex" id="serviceTexY" type="radio" class="ace" value="Yes" <%=bean.isServiceTex()==true?"checked='checked'":"" %> />
													<span class="lbl middle"> Yes</span>
											</label>

												&nbsp; &nbsp; &nbsp;
												<label class="inline">
													<input name="serviceTex" id="serviceTexN" type="radio" class="ace" value="No" <%=bean.isServiceTex()==false?"checked='checked'":"" %> />
													<span class="lbl middle"> No</span>
												</label>
											
										</div>
								</div>
								
								
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Submit
											</button>
											

											&nbsp; &nbsp; &nbsp;
											<a href="ContentServlet?key=memberPlan" class="btn" type="reset" id="btnBack" name="btnBack">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Back
											</a>
										</div>
									</div>
								
								</form>
								<div align="center" style="color: red">
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
	<script>
	
	$( document ).ready(function() {

	    $('#btnSubmit').click(function(){                   
	        
	        	$("#addRole").submit();
	       
	        
	    });
	    
	   

	});
	</script>