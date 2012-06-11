<%@page import="model.Novidade"%>
<%@page import="dao.NovidadesDAO"%>
<%@page import="java.util.ArrayList"%>

<div class="span6 novidades">

    <h2>Últimas atualizações</h2>

    <%
        //Código java
        ArrayList<Novidade> lista = NovidadesDAO.lista();
        for( Novidade n : lista){
            out.print("<div class=\"bloco-novidade\">");
                out.print("<h3>");
                    out.print( n.getTitulo() );
                    out.print("<small>Publicado em "+n.getData()+"</small>");
                out.print("</h3>");
                out.print("<p>" + n.getResumo() + "</p>" );
                out.print("<a href=\""+n.getLinkToPage()+"\">veja mais.</a>" );
            out.print("</div>");
        }
    %>

</div>