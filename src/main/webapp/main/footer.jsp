
<%@page import="com.google.gson.Gson"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="com.softNice.nikah.beans.generalSettingBean"%>
<%@page import="com.softNice.nikah.beans.settingBean"%>
<%@page import="com.softNice.nikah.constent.contentPage"%>
<%
settingBean settingbean= null;
			generalSettingBean mailbean= new generalSettingBean();
			if(request.getSession().getAttribute(contentPage.SETTING)!=null){
				settingbean = (settingBean) request.getSession().getAttribute(contentPage.SETTING);
				
				ObjectMapper mapperObj = new ObjectMapper();
				if(settingbean.getValue()!=null){
					mailbean = new Gson().fromJson(settingbean.getValue(),generalSettingBean.class);
				}
				
			}
	%>		
<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder"><%=mailbean.getCmpName() %></span>
							 <!-- &copy; --> <%=mailbean.getCopyRight() %>
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>