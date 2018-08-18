
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
	if(request.getSession().getAttribute(contentPage.USERSOBJ)!=null){
		bean = (memberBean)request.getSession().getAttribute(contentPage.USERSOBJ);
	}
	List<String> imageSrc = new ArrayList<String>();
	if(request.getSession().getAttribute(contentPage.ImageList)!=null){
		imageSrc = (List)request.getSession().getAttribute(contentPage.ImageList);
	}
%>
						
				<div class="main-content-inner">
					
					<div class="page-content">
						

						<div class="page-header">
						
						<table width="100%">
							<tr>
								<th><h1>Upload Photos</h1></th>
							</tr>
						</table>
							
						</div><!-- /.page-header -->

						<div class="row">
							
							<div class="col-md-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<div>
									<form action="UploadMaterial?memberID=<%=bean.getMemberId()%>" enctype="multipart/form-data"  class="dropzone well" id="dropzone" method="POST">
										<div class="fallback">
											<input name="file" type="file" multiple="" />
										</div>
									</form>
								</div>
								
								
								<div id="preview-template" class="hide">
									<div class="dz-preview dz-file-preview">
										<div class="dz-image">
											<img data-dz-thumbnail=""  id="showImg" name="showImg"  />
										</div>

										<div class="dz-details">
											<div class="dz-size">
												<span data-dz-size=""></span>
											</div>

											<div class="dz-filename">
												<span data-dz-name=""></span>
											</div>
										</div>

										<div class="dz-progress">
											<span class="dz-upload" data-dz-uploadprogress=""></span>
										</div>

										<div class="dz-error-message">
											<span data-dz-errormessage=""></span>
										</div>

										<div class="dz-success-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-check fa-stack-1x fa-inverse green"></i>
											</span>
										</div>

										<div class="dz-error-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-remove fa-stack-1x fa-inverse red"></i>
											</span>
										</div>
									</div>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div>
									<ul class="ace-thumbnails clearfix">
									<%int count = 0; %>
									<% for (Object src : imageSrc.toArray()){ 
										
										String path[] = src.toString().split("galleryImage");
										String finalPath = path[1];
										
										String imgName[] = src.toString().split("galleryImage");
										String fileName = finalPath.substring(finalPath.lastIndexOf("\\")+1);
										
									%>
									
																		
										<li id="li<%=count %>" >
											<a href="<%="galleryImage/"+finalPath %>" title="Photo Title" data-rel="colorbox">
												<img width="150" height="150" alt="150x150" src="<%="galleryImage/"+finalPath %>" />
											</a>

											<div class="tags">
												<span class="label-holder">
													<span class="label label-info">breakfast</span>
												</span>

												<span class="label-holder">
													<span class="label label-danger">fruits</span>
												</span>

												<span class="label-holder">
													<span class="label label-success">toast</span>
												</span>

												<span class="label-holder">
													<span class="label label-warning arrowed-in">diet</span>
												</span>
											</div>

											<div class="tools">
												<a href="#">
													<i class="ace-icon fa fa-link"></i>
												</a>

												<a href="#">
													<i class="ace-icon fa fa-paperclip"></i>
												</a>

												<a href="#">
													<i class="ace-icon fa fa-pencil"></i>
												</a>

												<a href="#" onclick="deleteImageByPath('<%=bean.getMemberId()%>','<%=fileName%>','<%=count%>')">
													<i class="ace-icon fa fa-times red"></i>
												</a>
											</div>
										</li>
										<%count++; %>
										<%} %>
										
										
									</ul>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
						
						
						
						
						
					</div>
					
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					
				
<script type="text/javascript">
			jQuery(function($){
			
			try {
			  Dropzone.autoDiscover = false;
			
			  var myDropzone = new Dropzone('#dropzone', {
			    previewTemplate: $('#preview-template').html(),
			    
				thumbnailHeight: 120,
			    thumbnailWidth: 120,
			    maxFilesize: 0.5,
				
				//addRemoveLinks : true,
				//dictRemoveFile: 'Remove',
				
				dictDefaultMessage :
				'<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
				<span class="smaller-80 grey">(or click)</span> <br /> \
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>'
			,
				
			    thumbnail: function(file, dataUrl) {
			      if (file.previewElement) {
			        $(file.previewElement).removeClass("dz-file-preview");
			        var images = $(file.previewElement).find("[data-dz-thumbnail]").each(function() {
						var thumbnailElement = this;
						thumbnailElement.alt = file.name;
						thumbnailElement.src = dataUrl;

					});
			        setTimeout(function() { $(file.previewElement).addClass("dz-image-preview"); }, 1);
			      }
			    }
			
			  });
			
			
			  //simulating upload progress
			  var minSteps = 6,
			      maxSteps = 60,
			      timeBetweenSteps = 100,
			      bytesPerStep = 100000;
			
			  myDropzone.uploadFiles = function(files) {
			    var self = this;
			
			    for (var i = 0; i < files.length; i++) {
			      var file = files[i];
			          totalSteps = Math.round(Math.min(maxSteps, Math.max(minSteps, file.size / bytesPerStep)));
			
			      for (var step = 0; step < totalSteps; step++) {
			        var duration = timeBetweenSteps * (step + 1);
			        setTimeout(function(file, totalSteps, step) {
			          return function() {
			            file.upload = {
			              progress: 100 * (step + 1) / totalSteps,
			              total: file.size,
			              bytesSent: (step + 1) * file.size / totalSteps
			            };
			
			            self.emit('uploadprogress', file, file.upload.progress, file.upload.bytesSent);
			            if (file.upload.progress == 100) {
			              file.status = Dropzone.SUCCESS;
			              self.emit("success", file, 'success', null);
			              self.emit("complete", file);
			              self.processQueue();

			            }
			          };
			        }(file, totalSteps, step), duration);
			      }
			    }
			   }

			  	 Dropzone.options.MyDropzone = {
					   var FormActionURL; 
					    init : function() {
					      myDropzone = this;
					        this.on("drop", function(event) {

					        });
					    }
					}; 
			  
			   //remove dropzone instance when leaving this page in ajax mode
			   $(document).one('ajaxloadstart.page', function(e) {
					try {
						myDropzone.destroy();
					} catch(e) {}
			   });
			
			} catch(e) {
			  alert('Dropzone.js does not support older browsers!');
			}
			
			});
		</script>
		
				<!-- page specific plugin scripts -->
		<script src="assets/js/jquery.colorbox.min.js"></script>
		
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
	var $overflow = '';
	var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};

	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
	
	
	$(document).one('ajaxloadstart.page', function(e) {
		$('#colorbox, #cboxOverlay').remove();
   });
})
		</script>
		
		<script type="text/javascript">	

			 function deleteImageByPath(mid, path, index){
					var removeIndex = index; 
					var result = confirm("Are you sure to delete Image?");					
					 if (result) {						
							 $.ajax({
									url : 'memberServlet?key=deleteImage&path='+path+'&memberId='+mid,		
									async:false,
									 type: "GET",
								     data: null,
								     processData: false,
								     contentType: false,					
									success : function(responseText) {															
																		   	
									}
								}).done(function() {									
									$('#li'+removeIndex).remove();										
								});
					} 
					
				}	
		
		</script>
	