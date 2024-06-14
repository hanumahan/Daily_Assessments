package week2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 10,   
                 maxRequestSize = 1024 * 1024 * 50) 
public class FileUploadServlet extends HttpServlet {
    private static final String SAVE_DIRECTORY = "uploads"; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        String appPath = request.getServletContext().getRealPath("");
        
        String savePath = appPath + File.separator + SAVE_DIRECTORY;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part part = request.getPart("file");
        String fileName = extractFileName(part);

        if (fileName != null && !fileName.isEmpty()) {
           
            part.write(savePath + File.separator + fileName);
            String uploadMessage = "File " + fileName + " has been uploaded successfully!";
            request.setAttribute("message", uploadMessage);
            getServletContext().getRequestDispatcher("/fileUploadSuccess.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Please select a file to upload!");
            getServletContext().getRequestDispatcher("/fileUploadFail.jsp").forward(request, response);
        }
    }

    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length()-1);
            }
        }
        return null;
    }
}

