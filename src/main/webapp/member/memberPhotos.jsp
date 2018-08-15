
<%@page import="com.softNice.nikah.utility.EncrypitDecrypit"%>
<%@page import="com.softNice.nikah.beans.memberBean"%>
<%@page import="com.softNice.nikah.beans.masterBean"%>
<%@page import="com.softNice.nikah.utility.validation"%>
<%@page import="com.softNice.nikah.beans.roleBean"%>
<%@page import="java.util.ArrayList"%>
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
	