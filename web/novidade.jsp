<%@page import="util.HTMLUtil"%>
<%@page import="model.Novidade"%>
<%@page import="dao.NovidadesDAO"%>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="includes/head.jsp" />
  <body>

    <div class="container">
        <jsp:include page="includes/bloco_topo.jsp" />

        <div class="row">
            <div class="span6 offset3">
                <%
                //Pega parâmetro da URL. Ex: novidades.jsp?id=3
                String id = request.getParameter("id");

                //Pega objeto Noticia do Banco de Dados correspondente ao ID
                Novidade n = NovidadesDAO.pegaNovidadePeloId(id);
                if(n == null){
                    //Nao encontrou o objeto. O Id não existe no Banco
                    //Então, redireciona para a página de erro.
                    response.sendRedirect("erro.jsp");
                }
                
                

                //Se esta tudo bem, continua desenhando a página.
                %>
                <h2 class="page-header">
                       
                    <%=n.getTitulo()%>
                    
                    <small>Publicado em <%=n.getData()%></small>
                </h2>

                <p><%=n.getTexto()%></p>
                <%
                if(n.getLink() != null){
                   // out.print("<a href=\""+n.getLink()+"\">"+n.getLink()+"</a>");
                    //String textoLink = HTMLUtil.link(n.getLink(), n.getLink());
                    out.print( HTMLUtil.link(n.getLink(), "Acessar link") );
                }
                %>
                
                <div class="comentarios">        
                    <h3>Comentários</h3>
                    
                    <jsp:include page="includes/comentarios_novidade.jsp" />
                    <jsp:include page="includes/comentario_novidade.jsp" />
                    
                </div>
            </div>                        
        </div>
            
            
        

    </div>
    
    <jsp:include page="includes/javascript.jsp" />
  </body>
</html>
