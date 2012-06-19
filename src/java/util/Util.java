
package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {
    
    public static void vericaLogin( HttpSession vsession, HttpServletResponse vresponse){
        
        String usuario = (String)vsession.getAttribute("usuario");
        String senha = (String)vsession.getAttribute("senha");

        if(usuario == null || senha == null){
            
            try {
                vresponse.sendRedirect("login.jsp");
            } catch (IOException ex) {
                System.out.print("Erro no redirecionamento");
            }            
            return;
        }

        if( !(  usuario.equals("admin") 
                && senha.equals("12345")   ) ){
            try {
                //Os dados em sessão são diferentes da senha e do nome de usuário.
                //Isso é util quando quisermos mudar a senha e automaticamente impedir qualquer acesso com a senha antiga
                vresponse.sendRedirect("login.jsp");
            } catch (IOException ex) {
               System.out.print("Erro no redirecionamento");
            }            
           return;
        }
    }
}
