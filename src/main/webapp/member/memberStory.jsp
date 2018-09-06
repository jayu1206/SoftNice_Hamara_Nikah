
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
		memberBean bean = new memberBean();
		String familyStatus = "";
		int culture = 0;
		int height = 0;
		int weight = 0;
		int built = 0;
		int complexion = 0;
		int diet = 0;
		int drink = 0;
		int smoke = 0;
		String about = "";
		int education = 0;
		int profession = 0;
		int income = 0;
		String visa = "";
		if (request.getSession().getAttribute(contentPage.MEMBERS) != null) {
			bean = (memberBean) request.getSession().getAttribute(contentPage.MEMBERS);

		}

		String brideName = "", groomName = "", memberId = "", partnerMemberId = "", email = "", engDate = "",
				marriageDate = "", imgUrl = "", address = "", countryCode = "", phone = "", sussessStory = "";

		int country = 0;

		ArrayList<countryBean> countryList = new ArrayList<countryBean>();
		if (request.getAttribute(contentPage.COUNTRYOBJ) != null) {
			countryList = (ArrayList<countryBean>) request.getAttribute(contentPage.COUNTRYOBJ);
		}

		if (request.getAttribute(contentPage.ERROR) != null) {

			brideName = request.getParameter("txtBrideName");
			groomName = request.getParameter("txtGroomName");
			memberId = request.getParameter("txtMemberId");
			partnerMemberId = request.getParameter("txtPartnerMemberId");
			email = request.getParameter("txtEmail");
			engDate = request.getParameter("txtEngDate") == null ? "" : request.getParameter("txtEngDate");
			marriageDate = request.getParameter("txtMarriageDate") == null
					? ""
					: request.getParameter("txtMarriageDate");
			imgUrl = request.getParameter("txtImgUrl");
			address = request.getParameter("txtAddress");
			country = request.getParameter("country") != null
					? Integer.parseInt(request.getParameter("country"))
					: 0;
			countryCode = request.getParameter("txtCountryCode");
			phone = request.getParameter("txtPhone");
			sussessStory = request.getParameter("txtSussessStory");

		}
		if (bean.getGender().equalsIgnoreCase("male")) {
			groomName = bean.getFirstName();
		} else {
			brideName = bean.getFirstName();
		}
	%>

	<div class="main-content-inner">

		<div class="page-content">
			<div class="page-header">

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="main-content">
							<div class="main-content-inner">
								<div class="page-content">
									<div class="page-header">
										<h1>
											Add Story <small> <i
												class="ace-icon fa fa-angle-double-right"></i> Member's Stories
											</small>
										</h1>
									</div>
									<!-- /.page-header -->
									<div class="row">
										<div class="col-xs-12">
											<form class="form-horizontal"
												action="ContentServlet?key=addMemberStory"
												enctype="multipart/form-data" method="post"
												name="memberStoryForm" id="memberStoryForm">
												<fieldset>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Groom Name </label>

														<div class="col-sm-9">
															<input type="text" id="txtGroomName" name="txtGroomName"
																class="form-control" value="<%=groomName%>"
																placeholder="Groom Name" class="col-xs-10 col-sm-5" />
														</div>
													</div>


													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Bride Name </label>

														<div class="col-sm-9">
															<input type="text" id="txtBrideName" name="txtBrideName"
																class="form-control" value="<%=brideName%>"
																placeholder="Bride Name" class="col-xs-10 col-sm-5" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Member Id </label>

														<div class="col-sm-9">
															<input type="text" id="txtMemberId" name="txtMemberId"
																class="form-control" value="<%=bean.getMemberId()%>"
																placeholder="Member Id" class="col-xs-10 col-sm-5"
																readonly="readonly" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Partner Member Id </label>

														<div class="col-sm-9">
															<input type="text" id="txtPartnerMemberId"
																name="txtPartnerMemberId" class="form-control"
																value="<%=partnerMemberId%>"
																placeholder="Partner Member Id"
																class="col-xs-10 col-sm-5" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Email </label>

														<div class="col-sm-9">
															<input type="text" id="txtEmail" name="txtEmail"
																class="form-control" value="<%=email%>"
																placeholder="Email" class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Engagement Date </label>

														<div class="col-sm-9">
															<input id="txtEngDate" name="txtEngDate"
																value="<%=engDate%>" type="text"
																data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy"
																readonly="readonly" class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Marriage Date </label>

														<div class="col-sm-9">
															<input id="txtMarriageDate" name="txtMarriageDate"
																value="<%=marriageDate%>" type="text"
																data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy"
																readonly="readonly" class="col-xs-10 col-sm-5" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Select Country </label>

														<div class="col-sm-9">
															<select class="col-sm-12" id="country" name="country">
																<option value="0">Country</option>
																<%
																	for (countryBean countrybean : countryList) {
																		if (country == countrybean.getId()) {
																%>
																<option selected="selected"
																	value="<%=countrybean.getName()%>"><%=countrybean.getName()%></option>
																<%
																	} else {
																%>
																<option value="<%=countrybean.getName()%>"><%=countrybean.getName()%></option>
																<%
																	}
																	}
																%>

															</select>
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Address </label>

														<div class="col-sm-9">
															<input type="text" id="txtAddress" name="txtAddress"
																class="form-control" value="<%=address%>"
																placeholder="Address" class="col-xs-10 col-sm-5" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Phone </label>

														<div class="col-sm-9">
															<input type="text" id="txtPhone" name="txtPhone"
																class="form-control" value="<%=phone%>"
																placeholder="Phone" class="col-xs-10 col-sm-5" />
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Success Story </label>

														<div class="col-sm-9">
															<textarea class="form-control" id="txtSussessStory"
																name="txtSussessStory" value="<%=sussessStory%>"
																placeholder="Success Story"></textarea>
														</div>
													</div>

													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> Image </label>

														<div class="col-sm-9">
															<input type="file" name="imgUrl" id="imgUrl" />
														</div>
													</div>
													<div class="clearfix form-actions">
														<div class="col-md-offset-3 col-md-9">
															<button class="btn btn-info" type="submit">
																<i class="ace-icon fa fa-check bigger-110"></i> Submit
															</button>

															&nbsp; &nbsp; &nbsp;
															<button class="btn" type="reset">
																<i class="ace-icon fa fa-undo bigger-110"></i> Reset
															</button>
														</div>
													</div>

													<div class="space-4"></div>

													<div align="center" style="color: red">
														<%
															String str = "";
															if (request.getAttribute(contentPage.ERROR) != null) {
																str = ((ErrorMsg) request.getAttribute(contentPage.ERROR)).getError();

															}
														%>

														<label><%=str%> </label>

													</div>
												</fieldset>
											</form>
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

<script>

$(document).ready(function($){


   <%--  getState('<%=country %>','<%=state %>');
	getCity('<%=state %>','<%=city %>')  --%>
	
	
	    $('#btnSubmit').click(function(){ 
	        	$("#memberStoryForm").submit();
	    });
	    
	/*    $('#btnRegister').click(function(){ 
	    	$("#key").val("register");
        	$("#memberForm").submit();
    }); */
	    
	    $("#txtEngDate").datepicker({
		    changeMonth: true,
            changeYear: true,
            autoclose: true,
            yearRange: '-100y:c+nn',
            clearBtn: true,
            endDate:'-20y', //'12-06-1990' ,
            closeBtn: true, // close button visible
        
        });

	    $("#txtMarriageDate").datepicker({
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


