<%@page import="util.MySQL"%>
<%
String nome = request.getParameter("nome");
String texto = request.getParameter("texto");
String idNovidade = request.getParameter("id_novidade");

String sql = "insert into comentario ";
sql += "(nome, texto, id_novidade) ";
sql += "values (";
    sql += "\""+nome+"\",";   
    sql += "\""+texto+"\",";    
    sql += "\""+idNovidade+"\"";
sql += ")";

//Teste
//out.print(sql);

MySQL mysql = new MySQL();
String linkVoltar = "../novidade.jsp?id="+idNovidade;
if(mysql.executaInsert(sql)){
       
    response.sendRedirect(linkVoltar);
    
} else {
    
    out.print("Erro: por favor, tente novamente<br />");
    out.print("<a href=\""+linkVoltar+"\">Voltar</a>");

}
%>
