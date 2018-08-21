
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.softNice.nikah.beans.memberBean"%>
<%@page import="com.softNice.nikah.beans.memberPlanBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="com.softNice.nikah.constent.ErrorMsg"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<div class="main-content">
						
	<%
	
			ArrayList<memberPlanBean> planList = new ArrayList<memberPlanBean>();
			if(request.getAttribute(contentPage.MEMBERPLANOBJ)!=null){
				planList = (ArrayList<memberPlanBean>) request.getAttribute(contentPage.MEMBERPLANOBJ);
			}
			
			ArrayList<memberBean> memberList = new ArrayList<memberBean>();
			if(request.getAttribute(contentPage.MEMBERS)!=null){
				memberList = (ArrayList<memberBean>) request.getAttribute(contentPage.MEMBERS);
			}
			Map<Integer,Integer> map= new HashMap<Integer,Integer>();   
	
	
	%>
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1>Member Order</h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-4">
								<!-- PAGE CONTENT BEGINS -->
								<form action="FormServlet?key=addOrder" method="post" name="addRole" id="addRole" class="form-horizontal">
								<%-- <%if(modifyFlag){ %>
								<input type="hidden" id="txtId" name="txtId" value="<%=bean.getRoleId() %>" />
								<%} %> --%>
								
								<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right"> Members </label>

										<div class="col-sm-3" >
											<select  id="memberId" name="memberId" class="col-sm-12 select2" data-placeholder="Select Member..."   >
													<!-- <option value="0">Select Member</option> -->
													<%for(memberBean bean : memberList){ %>
															<option value="<%=bean.getMemberId() %>"><%=bean.getFirstName() + " "+bean.getLastName() +" - ("+ bean.getMemberId()+")" %></option>
													<%} %>
											</select>
											
										</div>
								</div>
								
								<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right" > Plans </label>
											<input type="hidden" name="txtDays"  id="txtDays" />
										<div class="col-sm-9">
											<select  id="planId" name="planId" class="col-sm-12 select2" data-placeholder="Select Plan..." >
													<!-- <option value="0">Select Plan</option> -->
													<%for(memberPlanBean planbean : planList){
															map.put(planbean.getPlanId(), planbean.getPlanValidity());
														%>
															<option value="<%=planbean.getPlanId() %>"><%=planbean.getPlanName() + " (" +planbean.getPlanValidity()+" Days)"  %></option>
													<%}%>
											</select>
										</div>
								</div>
								
								
								<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-date">Start Date</label>

								<div class="col-sm-9">
									<div class="input-medium">
										<div class="input-group col-sm-9">
											<input class="input-medium date-picker" id="txtStartDate" name="txtStartDate" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" value="" readonly="readonly" />
											<span class="input-group-addon">
												<i class="ace-icon fa fa-calendar"></i>
											</span>
										</div>
									</div>
								</div>
							</div>
															
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-date">End Date</label>

								
									<div class="col-sm-9">
											<input class="col-sm-6" type="text" id="txtEndDate" name="txtEndDate"  readonly="readonly" />
										</div>
								
							</div>
												
								<div class="clearfix form-actions" >
										<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="button" id="btnSubmit" name="btnSubmit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Submit
											</button>
											

											&nbsp; &nbsp; &nbsp;
											<!-- <a href="ContentServlet?key=role" class="btn" type="reset" id="btnBack" name="btnBack">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Back
											</a> -->
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
	    
	    var date = new Date();
	    var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());
	    
	    $("#txtStartDate").datepicker({
		    changeMonth: true,
            changeYear: true,
            autoclose: true,
            yearRange: '-100y:c+nn',
            clearBtn: true,
            startDate: today,
            todayHighlight: true,
            closeBtn: true, // close button visible
        
        });
	    
	     $('#txtStartDate').change(function(){
	       /*  //Change code!
	        var date2 = $('#txtStartDate').datepicker('getDate');
	        $('#txtDays').val($('#planId').val()); */
	      
	        getEndDate($('#txtStartDate').val(),$('#planId').val());
	        
	       
	   }); 
	    
	    
	    $('.select2').css('width','200px').select2({allowClear:true})
	   

	});
	</script>