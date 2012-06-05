<%@page import="util.MySQL"%>
<%
String titulo = request.getParameter("titulo");
String texto = request.getParameter("texto");
String resumo = request.getParameter("resumo");
String link = request.getParameter("link");

String sql = "insert into novidades ";
sql += "(titulo, data, texto, resumo, link) ";
sql += "values (";
    sql += "\""+titulo+"\",";
    sql += "now(),";
    sql += "\""+texto+"\",";
    sql += "\""+resumo+"\",";
    sql += "\""+link+"\"";
sql += ")";

//Teste
//out.print(sql);

MySQL mysql = new MySQL();
if(mysql.executaInsert(sql)){
    
    response.sendRedirect("../sucesso.jsp");
    
} else {
    
    out.print("Erro: por favor, tente novamente<br />");
    out.print("<a href=\"../cad_novidade.jsp\">Voltar</a>");
}
%>
