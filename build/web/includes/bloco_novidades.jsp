<%@page import="model.Novidade"%>
<%@page import="dao.NovidadesDAO"%>
<%@page import="java.util.ArrayList"%>

<div class="span6 novidades">

    <h2>Últimas atualizações</h2>

    <%
        //Código java
        String categoria = request.getParameter("categoria");
        if(categoria == null){
            categoria = "1";
        }
        ArrayList<Novidade> lista = NovidadesDAO.listaPorCategoria( categoria );
        for( Novidade n : lista){
            out.print( n.getHTMLBlock() );
        }
    %>

</div>