package com.softNice.nikah.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadMaterial
 */
public class UploadMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadMaterial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 Logger log = Logger.getLogger(UploadMaterial.class.getName());
			ServletContext servletContext = this.getServletConfig().getServletContext();
			//User user = (User) request.getSession().getAttribute(SessionAttributes.CURR_USER_OBJ);
			String fileName = "";
			//String requestFrom = "";
			String fileUrl = "";
			String filePath = "D:/Sahil/Project/SoftNice_Hamara_Nikah/SoftNice_Hamara_Nikah/src/main/webapp/galleryImage";
			String memberId = request.getParameter("memberID");
			
			try{
				
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
			
				List<FileItem> items = upload.parseRequest(request);
				filePath = filePath +"\\"+ memberId;
				//filePath = getServletContext().getRealPath("/") + File.separator + filePath +"\\"+ memberId;/*save uploaded files to a 'Upload' directory in the web app*/
		        if (!(new File(filePath)).exists()) {
		            (new File(filePath)).mkdir();    // creates the directory if it does not exist        
		        }
		        if((new File(filePath)).exists()){		        	
		        		for (FileItem item : items) {
				             if (!item.isFormField()) {
				                     File file = new File(filePath, item.getName());
				                     item.write(file);		                     
				                     System.out.println("File uploaded success");
				             }
				         }
		        }

//		         for (FileItem item : items) {
//		             if (!item.isFormField()) {
//		                     File file = new File(filePath, item.getName());
//		                     item.write(file);		                     
//		                     System.out.println("uploaded");
//		             }
//		         }
				

//				Iterator<FileItem> iter = items.iterator();
//				
//				while(iter.hasNext()){
//					FileItem item = iter.next();
//					if (item.isFormField()) {
//
//						String name = item.getFieldName();
//						String value = item.getString();
//
//					}else {
//						
//						String fieldName = item.getFieldName();
//						fileName = item.getName();
//						
//						if(null != fileName && fileName.contains("\\")){
//							fileName = fileName.substring(fileName.lastIndexOf("\\")+1, fileName.length());
//							
//							
//						}
//						
//						
//					}
//					
//					
//				}
				
//				response.getWriter().print(fileUrl);
				
			}catch(Exception e){
				log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
	}

}
