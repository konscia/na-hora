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

public class MultipartForm {

    protected int maxFileSize;
    protected int maxMemSize;

    PageContext pageContext;
    HttpServletRequest request;

    ServletFileUpload upload;

    List fileItems;

    public MultipartForm(PageContext pageContext, HttpServletRequest request){
       maxFileSize = 5000 * 1024;
       maxMemSize = 5000 * 1024;

       this.pageContext = pageContext;
       this.request = request;
       this.createUploadObject();

       if (!this.isMultipart()) {
           System.out.print("Faltou o multipart no formulário.");
           return;
        }

       // Parse the request to get file items.
       try {
             this.fileItems = upload.parseRequest(request);
       }catch(Exception ex) {
             System.out.println(ex);
       }
    }

    private void createUploadObject(){
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

    private String getUploadPath(String destino){
        return this.getRealPath()+destino+"/";
    }

    private boolean isMultipart(){
        String contentType = request.getContentType();
        return (contentType.indexOf("multipart/form-data") >= 0);
    }

    private String getOnlyFileName(String fileName){
        String s = "";
         if( fileName.lastIndexOf("\\") >= 0 ){
            s = fileName.substring( fileName.lastIndexOf("\\"));
        }else{
            s = fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        return s.substring(0, s.lastIndexOf(".")-1);
    }

    private String getExtensao(String fileName){
        String s = "";
         if( fileName.lastIndexOf("\\") >= 0 ){
            s = fileName.substring( fileName.lastIndexOf("\\"));
        }else{
            s = fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        return s.substring(s.lastIndexOf("."));
    }

    private File uploadFile(FileItem fi, String destino){
        Date timestamp = new Date();
        
        // Get the uploaded file parameters
        String fieldName = fi.getFieldName();
        String fileName = fi.getName();
        
        String onlyFileName = this.getOnlyFileName(fileName);
        String complement = Long.toString(timestamp.getTime());
        String ext = this.getExtensao(fileName);

        File file;
        String nomeFinal = onlyFileName + "_" + complement + ext;
        // Write the file
        file = new File( this.getUploadPath(destino) + nomeFinal);
        try {
            fi.write(file);
            System.out.println("Uploaded Filename: " + this.getUploadPath(destino) + fileName + "<br>");
            return file;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String getValue(String fieldName){
         Iterator i = fileItems.iterator();
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( fi.isFormField() && fi.getFieldName().equals(fieldName) ){
                return fi.getString();
            }
        }

        return null;
    }

    public File saveFile(String fieldName, String destino){
        // Process the uploaded file items
         Iterator i = fileItems.iterator();
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField() && fi.getFieldName().equals(fieldName) ){
                return uploadFile(fi, destino);
            }
        }

        return null;
    }

    public List<FileItem> getItems(){
        return fileItems;
    }

}
