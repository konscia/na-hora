package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Novidade {
    
    protected String id;
    protected String titulo;
    protected String texto;
    protected String resumo;
    protected String data;
    protected String link;

    public Novidade() {
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getData() {
        //Formato de data americano
        SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
        //Transforma objeto dasta em String para um objeto Date
        Date novaData;
        try {
            novaData = formatIso.parse(data);
        } catch (ParseException ex) {
            System.out.println("Data não pode ser formatada corretamente.");
            //Retorna um texto qualquer para não travar a execução do software.
            //ISTO é tratamento de exceção. Se algo der errado, o programa continua.
            return "--/--/----";
        }

        //Cria objeto responsável por formatar a data
        //http://javafree.uol.com.br/topic-11822-Como-converter-Data-para-o-Formato-Brasileiro.html
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //Converte a data atual em formato inglês para o formato acima
        String dataFormatada = df.format(novaData);

        //retorna a nova data formatada
        return dataFormatada;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTexto() {
        //Converte todas as quebras de linha de texto para quebra de linha em HTML
        //Quando pressionamos enter em um campo de texto, a quebra de linha é feita com \n
        String textoComBR = texto.replaceAll("\n","<br />");
        //Retorna novo texto
        return textoComBR;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinkToPage(){
        return "novidade.jsp?id="+this.id;
    }

    public String getHTMLBlock(){
        String s = "";
        s += "<div class=\"bloco-novidade\">";
            s += "<h3>";
               s += this.getTitulo();
               s += "<small>Publicado em "+this.getData()+"</small>";
            s += "</h3>";
            s += "<p>" + this.getResumo() + "</p>" ;
            s += "<a href=\""+this.getLinkToPage()+"\">veja mais.</a>";
        s+="</div>";
        return s;
    }
}
