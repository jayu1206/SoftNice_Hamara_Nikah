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



<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="white"
									id="id-text2">Application</span>
							</h1>

						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="signup-box"
								class="signup-box widget-box no-border visible">
								<div class="widget-body">
									<div class="widget-main">

										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="row">

													<div class="col-sm-6">
														<div class="tabbable">
															<ul class="nav nav-tabs" id="myTab">
																<li class="active"><a data-toggle="tab"
																	href="#home"> <i
																		class="green ace-icon fa fa-home bigger-120"></i> Home
																</a></li>

																<li><a data-toggle="tab" href="#messages">
																		Messages <span class="badge badge-danger">4</span>
																</a></li>

																<li class="dropdown"><a data-toggle="dropdown"
																	class="dropdown-toggle" href="#"> Dropdown &nbsp; <i
																		class="ace-icon fa fa-caret-down bigger-110 width-auto"></i>
																</a>

																	<ul class="dropdown-menu dropdown-info">
																		<li><a data-toggle="tab" href="#dropdown1">@fat</a>
																		</li>

																		<li><a data-toggle="tab" href="#dropdown2">@mdo</a>
																		</li>
																	</ul></li>
															</ul>

															<div class="tab-content">
																<div id="home" class="tab-pane fade in active">
																	<p>Raw denim you probably haven't heard of them
																		jean shorts Austin.</p>
																</div>

																<div id="messages" class="tab-pane fade">
																	<p>Food truck fixie locavore, accusamus mcsweeney's
																		marfa nulla single-origin coffee squid.</p>
																</div>

																<div id="dropdown1" class="tab-pane fade">
																	<p>Etsy mixtape wayfarers, ethical wes anderson
																		tofu before they sold out mcsweeney's organic lomo
																		retro fanny pack lo-fi farm-to-table readymade.</p>
																</div>

																<div id="dropdown2" class="tab-pane fade">
																	<p>Trust fund seitan letterpress, keytar raw denim
																		keffiyeh etsy art party before they sold out master
																		cleanse gluten-free squid scenester freegan cosby
																		sweater. Fanny pack portland seitan DIY, art party
																		locavore wolf cliche high life echo park Austin.</p>
																</div>
															</div>
														</div>
													</div>
													<!-- /.col -->

												</div>
											</div>
										</div>




										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-users blue"></i> Registration Free
										</h4>

										<div class="space-6"></div>

										<form action="memberServlet?key=newRegister" method="post"
											name="memberForm" id="memberForm">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" id="txtFirstName" name="txtFirstName"
														class="form-control" value="" placeholder="First Name" />
														<i class="ace-icon fa fa-user"></i>
												</span>

												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" id="txtLastName" name="txtLastName"
														class="form-control" value="" placeholder="Last Name" />
														<i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <label
													class="col-sm-12 control-label no-padding-right">I
														am looking for</label>
												</label> <label class="block clearfix"> <!-- 	<input type="radio" name="gender" id="male"  class="ace" value="male" />
									<span class="lbl"> Bride</span>
									<input type="radio" name="gender" id="female"  class="ace" value="female" />
									<span class="lbl"> Groom</span>
									
									
									    /* z-index: -100!important; */
    width: 1px!important;
    height: 1px!important;
    /* clip: rect(1px,1px,1px,1px); */
    position: absolute;
									
									
									 -->

												</label>

												<div class="space"></div>

												<label class="block clearfix"> Date of birth </label> <label
													class="block clearfix"> <!-- <div class="col-sm-24"> -->
													<input class="input-medium date-picker" id="txtDob"
													name="txtDob" value="" type="text"
													data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy"
													readonly="readonly" /> <i class="ace-icon fa fa-calendar"></i>
													<!-- </div> -->

												</label> <label class="block clearfix"> <select
													class="col-sm-12" id="state" name="state"
													onchange="getCity(this.value,0);">
														<option value="0">State</option>
												</select>
												</label> <label class="block clearfix"> <select
													class="col-sm-12" id="city" name="city">
														<option value="0">City</option>
												</select>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" id="txtEmail" name="txtEmail" value=""
														class="form-control" placeholder="Email" /> <i
														class="ace-icon fa fa-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" id="txtPsw" name="txtPsw" value=""
														class="form-control" placeholder="Password" /> <i
														class="ace-icon fa fa-lock"></i>
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
														<i class="ace-icon fa fa-refresh"></i> <span
															class="bigger-110">Reset</span>
													</button>

													<button type="button" id="btnSubmit" name="btnSubmit"
														class="width-65 pull-right btn btn-sm btn-success">
														<span class="bigger-110">Register</span> <i
															class="ace-icon fa fa-arrow-right icon-on-right"></i>
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

												<div align="center" style="color: red"></div>
											</fieldset>
										</form>


									</div>
									<div class="toolbar center">
										<a href="memberServlet" data-target="#login-box"
											class="back-to-login-link"> <i
											class="ace-icon fa fa-arrow-left"></i> Back to login
										</a>
									</div>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.main-content -->
					</div>
					<!-- /.main-container -->
				</div>
			</div>
		</div>
	</div>
	
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/spin.js"></script>

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				/**
				$('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  //console.log(e.target.getAttribute("href"));
				})
					
				$('#accordion').on('shown.bs.collapse', function (e) {
					//console.log($(e.target).is('#collapseTwo'))
				});
				*/
				
				$('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
					//if($(e.target).attr('href') == "#home") doSomethingNow();
				})
			
				
				/**
					//go to next tab, without user clicking
					$('#myTab > .active').next().find('> a').trigger('click');
				*/
			
			
				$('#accordion-style').on('click', function(ev){
					var target = $('input', ev.target);
					var which = parseInt(target.val());
					if(which == 2) $('#accordion').addClass('accordion-style2');
					 else $('#accordion').removeClass('accordion-style2');
				});
				
				//$('[href="#collapseTwo"]').trigger('click');
			
			
				$('.easy-pie-chart.percentage').each(function(){
					$(this).easyPieChart({
						barColor: $(this).data('color'),
						trackColor: '#EEEEEE',
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: 8,
						animate: ace.vars['old_ie'] ? false : 1000,
						size:75
					}).css('color', $(this).data('color'));
				});
			
				$('[data-rel=tooltip]').tooltip();
				$('[data-rel=popover]').popover({html:true});
			
			
				$('#gritter-regular').on(ace.click_event, function(){
					$.gritter.add({
						title: 'This is a regular notice!',
						text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="blue">magnis dis parturient</a> montes, nascetur ridiculus mus.',
						image: 'assets/images/avatars/avatar1.png', //in Ace demo ./dist will be replaced by correct assets path
						sticky: false,
						time: '',
						class_name: (!$('#gritter-light').get(0).checked ? 'gritter-light' : '')
					});
			
					return false;
				});
			
				$('#gritter-sticky').on(ace.click_event, function(){
					var unique_id = $.gritter.add({
						title: 'This is a sticky notice!',
						text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="red">magnis dis parturient</a> montes, nascetur ridiculus mus.',
						image: 'assets/images/avatars/avatar.png',
						sticky: true,
						time: '',
						class_name: 'gritter-info' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
				});
			
			
				$('#gritter-without-image').on(ace.click_event, function(){
					$.gritter.add({
						// (string | mandatory) the heading of the notification
						title: 'This is a notice without an image!',
						// (string | mandatory) the text inside the notification
						text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="orange">magnis dis parturient</a> montes, nascetur ridiculus mus.',
						class_name: 'gritter-success' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
				});
			
			
				$('#gritter-max3').on(ace.click_event, function(){
					$.gritter.add({
						title: 'This is a notice with a max of 3 on screen at one time!',
						text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="green">magnis dis parturient</a> montes, nascetur ridiculus mus.',
						image: 'assets/images/avatars/avatar3.png', //in Ace demo ./dist will be replaced by correct assets path
						sticky: false,
						before_open: function(){
							if($('.gritter-item-wrapper').length >= 3)
							{
								return false;
							}
						},
						class_name: 'gritter-warning' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
				});
			
			
				$('#gritter-center').on(ace.click_event, function(){
					$.gritter.add({
						title: 'This is a centered notification',
						text: 'Just add a "gritter-center" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
						class_name: 'gritter-info gritter-center' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
				});
				
				$('#gritter-error').on(ace.click_event, function(){
					$.gritter.add({
						title: 'This is a warning notification',
						text: 'Just add a "gritter-light" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
						class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
					});
			
					return false;
				});
					
			
				$("#gritter-remove").on(ace.click_event, function(){
					$.gritter.removeAll();
					return false;
				});
					
			
				///////
			
			
				$("#bootbox-regular").on(ace.click_event, function() {
					bootbox.prompt("What is your name?", function(result) {
						if (result === null) {
							
						} else {
							
						}
					});
				});
					
				$("#bootbox-confirm").on(ace.click_event, function() {
					bootbox.confirm("Are you sure?", function(result) {
						if(result) {
							//
						}
					});
				});
				
			/**
				$("#bootbox-confirm").on(ace.click_event, function() {
					bootbox.confirm({
						message: "Are you sure?",
						buttons: {
						  confirm: {
							 label: "OK",
							 className: "btn-primary btn-sm",
						  },
						  cancel: {
							 label: "Cancel",
							 className: "btn-sm",
						  }
						},
						callback: function(result) {
							if(result) alert(1)
						}
					  }
					);
				});
			**/
				
			
				$("#bootbox-options").on(ace.click_event, function() {
					bootbox.dialog({
						message: "<span class='bigger-110'>I am a custom dialog with smaller buttons</span>",
						buttons:
						{
							"success" :
							 {
								"label" : "<i class='ace-icon fa fa-check'></i> Success!",
								"className" : "btn-sm btn-success",
								"callback": function() {
									//Example.show("great success");
								}
							},
							"danger" :
							{
								"label" : "Danger!",
								"className" : "btn-sm btn-danger",
								"callback": function() {
									//Example.show("uh oh, look out!");
								}
							}, 
							"click" :
							{
								"label" : "Click ME!",
								"className" : "btn-sm btn-primary",
								"callback": function() {
									//Example.show("Primary button");
								}
							}, 
							"button" :
							{
								"label" : "Just a button...",
								"className" : "btn-sm"
							}
						}
					});
				});
			
			
			
				$('#spinner-opts small').css({display:'inline-block', width:'60px'})
			
				var slide_styles = ['', 'green','red','purple','orange', 'dark'];
				var ii = 0;
				$("#spinner-opts input[type=text]").each(function() {
					var $this = $(this);
					$this.hide().after('<span />');
					$this.next().addClass('ui-slider-small').
					addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length]).
					css('width','125px').slider({
						value:parseInt($this.val()),
						range: "min",
						animate:true,
						min: parseInt($this.attr('data-min')),
						max: parseInt($this.attr('data-max')),
						step: parseFloat($this.attr('data-step')) || 1,
						slide: function( event, ui ) {
							$this.val(ui.value);
							spinner_update();
						}
					});
				});
			
			
			
				//CSS3 spinner
				$.fn.spin = function(opts) {
					this.each(function() {
					  var $this = $(this),
						  data = $this.data();
			
					  if (data.spinner) {
						data.spinner.stop();
						delete data.spinner;
					  }
					  if (opts !== false) {
						data.spinner = new Spinner($.extend({color: $this.css('color')}, opts)).spin(this);
					  }
					});
					return this;
				};
			
				function spinner_update() {
					var opts = {};
					$('#spinner-opts input[type=text]').each(function() {
						opts[this.name] = parseFloat(this.value);
					});
					opts['left'] = 'auto';
					$('#spinner-preview').spin(opts);
				}
			
			
			
				$('#id-pills-stacked').removeAttr('checked').on('click', function(){
					$('.nav-pills').toggleClass('nav-stacked');
				});
			
				
				
				
				
				
				///////////
				$(document).one('ajaxloadstart.page', function(e) {
					$.gritter.removeAll();
					$('.modal').modal('hide');
				});
			
			});
		</script>
</body>
</html>
