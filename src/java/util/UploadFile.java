/** Obrigado: http://www.tutorialspoint.com/jsp/jsp_file_uploading.htm */
package util;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFile {

    protected int maxFileSize;
    protected int maxMemSize;

    PageContext pageContext;
    HttpServletRequest request;

    String destino;

    ServletFileUpload upload;

    String nomeFinal;

    public UploadFile(PageContext pageContext, HttpServletRequest request, String destino){
       maxFileSize = 5000 * 1024;
       maxMemSize = 5000 * 1024;

       this.pageContext = pageContext;
       this.request = request;
       this.destino = destino;

       this.createUploadObject();
    }

    public void createUploadObject(){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));
        // Create a new file upload handler
        upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );
    }

    public String getRealPath(){
        //Pega caminho para o upload
       ServletContext context = pageContext.getServletContext();
       String filePath = context.getRealPath("/");
       return filePath;
    }

    public String getNomeFinal(){
        return this.nomeFinal;
    }

    public String getUploadPath(){
        return this.getRealPath()+this.destino+"/";
    }

    public boolean isMultipart(){
        String contentType = request.getContentType();
        return (contentType.indexOf("multipart/form-data") >= 0);
    }

    public String getOnlyFileName(String fileName){
        String s = "";
         if( fileName.lastIndexOf("\\") >= 0 ){
            s = fileName.substring( fileName.lastIndexOf("\\"));
        }else{
            s = fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        return s.substring(0, s.lastIndexOf(".")-1);
    }

    public String getExtensao(String fileName){
        String s = "";
         if( fileName.lastIndexOf("\\") >= 0 ){
            s = fileName.substring( fileName.lastIndexOf("\\"));
        }else{
            s = fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        return s.substring(s.lastIndexOf("."));
    }

    public void uploadFile(FileItem fi) throws Exception{
        Date timestamp = new Date();
        
        // Get the uploaded file parameters
        String fieldName = fi.getFieldName();
        String fileName = fi.getName();
        
        String onlyFileName = this.getOnlyFileName(fileName);
        String complement = Long.toString(timestamp.getTime());
        String ext = this.getExtensao(fileName);

        File file;
        this.nomeFinal = onlyFileName + "_" + complement + ext;
        // Write the file
        file = new File( this.getUploadPath() + this.nomeFinal);
        fi.write( file );
        System.out.println("Uploaded Filename: " + this.getUploadPath() + fileName + "<br>");
    }

    public boolean save(){
        
        if (!this.isMultipart()) {
           System.out.print("Faltou o multipart no formulário");
           return false;
        }

        try{
             // Parse the request to get file items.
             List fileItems = upload.parseRequest(request);
             // Process the uploaded file items
             Iterator i = fileItems.iterator();
             while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ){
                    this.uploadFile(fi);
                }
             }
          }catch(Exception ex) {
             System.out.println(ex);
             return false;
          }

        return true;
    }

}
