<%@page import="com.softNice.nikah.constent.contentPage"%>

<%if(request.getAttribute(contentPage.CONTENT_PAGE) != null){%>
	
	<!-- Include the actual page contents-->
	<jsp:include page="<%= (String)request.getAttribute(contentPage.CONTENT_PAGE) %>" flush="false"></jsp:include>
	
<%}%>