<%@page import="model.Novidade"%>
<%@page import="dao.NovidadesDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
  
  <jsp:include page="includes/head.jsp" />

  <body>

    <div class="container">

        <jsp:include page="includes/bloco_topo.jsp" />

        <div class="row">

            <jsp:include page="includes/bloco_menu.jsp" />

             <div class="span9">
                 <h2>Lista de Novidades</h2>

                 <table class="table">
                 <%
                    //Código java
                    ArrayList<Novidade> lista = NovidadesDAO.lista();
                    for( Novidade n : lista){
                        out.print("<tr>");
                            out.print("<td>" + n.getTitulo() + "</td>");

                            out.print("<td>" + n.getResumo() + "</p>" );

                            out.print("<td>");
                                String linkExcluir = "acao/del_novidade.jsp?id="+n.getId();
                                out.println("<a href=\""+linkExcluir+"\">excluir</a>" );
                            out.print("</td>");
                        out.print("</tr>");
                    }
                %>
                 </table>
             </div>
        </div>

    </div>
    
    <jsp:include page="includes/javascript.jsp" />
  </body>
</html>
