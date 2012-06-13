
package model;

public class Comentario {
  protected String id;
  protected String nome; 
  protected String texto;
  protected String idNovidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdNovidade() {
        return idNovidade;
    }

    public void setIdNovidade(String idNovidade) {
        this.idNovidade = idNovidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getHTMLBlock(){
        String s = "";
        s += "<div class=\"bloco-comentario\">";
            s += "<h4>"+this.getNome()+"</h4>";;        
            s += "<p>" + this.getTexto() + "</p>" ;
        s+="</div>";
        return s;
    }
  
  
}
