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

            <div class="span6 novidades">

            <h2>Resultado da Busca:</h2>

            <%
                //Código java
                String textoBusca = request.getParameter("texto_busca");

                ArrayList<Novidade> lista = NovidadesDAO.busca(textoBusca);
                for( Novidade n : lista){
                    out.print("<div class=\"bloco-novidade\">");
                        out.print("<h3>");
                            out.print( n.getTitulo() );
                            out.print("<small>Publicado em "+n.getData()+"</small>");
                        out.print("</h3>");
                        out.print("<p>" + n.getResumo() + "</p>" );
                        out.print("<a href=\"#\">veja mais.</a>" );
                    out.print("</div>");
                }
            %>

            </div>
            
        </div>
    </div>
    
    <jsp:include page="includes/javascript.jsp" />
  </body>
</html>
