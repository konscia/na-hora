<%@page import="model.Novidade"%>
<%@page import="dao.NovidadesDAO"%>
<%@page import="java.util.ArrayList"%>

<div class="span6 novidades">

    <h2>Últimas atualizações</h2>

    <%
        //Código java
        ArrayList<Novidade> lista = NovidadesDAO.lista();
        for( Novidade n : lista){
            out.print( n.getHTMLBlock() );
        }
    %>

</div>