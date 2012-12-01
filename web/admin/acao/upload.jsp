
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="util.MultipartForm"%>
<%
    //Cria objeto da classe usada para ler formulários Multipart
    MultipartForm form = new MultipartForm(pageContext, request);

    /** DEBUG - Exibe todos os campos do formulário, informando se é texto ou arquivo **/
    /** Comente este código quando finalizar seu trabalho **/

    //Passo 1 - Pega todos os itens do formulário
    List<FileItem> items = form.getItems();

    //Passo 2 - Percorre cada item, exibindo o nome do campo
    for(FileItem f : items){
        out.println(f.getFieldName());

        //Passo 3 - Exibe se é campo de formulário ou arquivo
        if(f.isFormField()){
            out.println(" - é campo de formulário");
            out.println("<br />Valor = "+f.getString());
        } else {
            out.println(" - provavelmente é arquivo");
            //O "getString" de campos do tipo arquvo retornam o binário do arquivo. Experimente se quiser..
            //out.println("<br />Binário = "+f.getString());
        }
        
        out.println("<br /><br />");
    }
    /** FIM DEBUG **/

    //Salva Arquivo do campo com nome "file" na pasta fotos.
    File arquivoSalvo = form.saveFile("file", "fotos");
    if(arquivoSalvo != null){
        out.print("<br />Arquivo "+arquivoSalvo.getPath()+" carregado com sucesso");
    } else {
        out.print("<br />Ops..ocorreu algum erro neste upload do arquivo 1");
        out.print("<br />Um dos erros mais comuns é colocar como destino uma pasta que não existe.");
        out.print("<br />O arquivo também pode ser menor ou maior que o máximo permitido.");
    }

    //Salva Arquivo do campo com nome "file2" na pasta csv.
    File arquivoSalvo2 = form.saveFile("file2", "csv");
    if(arquivoSalvo2 != null){
        out.print("<br />Arquivo "+arquivoSalvo2.getPath()+" carregado com sucesso");
    } else {
        out.print("<br />Ops..ocorreu algum erro neste upload do arquivo 2");
        out.print("<br />Um dos erros mais comuns é colocar como destino uma pasta que não existe.");
        out.print("<br />O arquivo também pode ser menor ou maior que o máximo permitido.");
    }

    String texto = form.getValue("texto");
    out.print("<br />Texto: "+texto);

/*
   if(carregador.save()){
       out.print("Sucesso. Arquivo carregado na pasta indicada com o nome: "+carregador.getNomeFinal());
   } else {
       out.println("Bug..veja a saída do glassfish no netbeans");
   }
 */
%>