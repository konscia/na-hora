package dao;

import java.util.ArrayList;
import model.Novidade;
import util.*;

public class NovidadesDAO {

    public NovidadesDAO(){
    }
    
    public static ArrayList<Novidade> lista(){
        
        ArrayList<Novidade> lista = new ArrayList<Novidade>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from novidades order by id desc";
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);
       
        while(linhas.next()){            
            Novidade n = new Novidade();
            n.setId( linhas.getString("id") );
            n.setTitulo( linhas.getString("titulo") );
            n.setResumo( linhas.getString("resumo") );
            n.setTexto( linhas.getString("texto") );
            n.setData( linhas.getString("data") );
            n.setLink( linhas.getString("link") );
            lista.add( n );
        }

        return lista;        
    }
    public static ArrayList<Novidade> listaPorCategoria(String categoria){
        
        ArrayList<Novidade> lista = new ArrayList<Novidade>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from novidades ";
               sql += " where categoria="+categoria;
               sql += " order by id desc";
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);
       
        while(linhas.next()){            
            Novidade n = new Novidade();
            n.setId( linhas.getString("id") );
            n.setTitulo( linhas.getString("titulo") );
            n.setResumo( linhas.getString("resumo") );
            n.setTexto( linhas.getString("texto") );
            n.setData( linhas.getString("data") );
            n.setLink( linhas.getString("link") );
            lista.add( n );
        }

        return lista;        
    }
    

    public static Novidade pegaNovidadePeloId(String id){
        MySQL bancoDados = new MySQL();
        String sql = "select * from novidades where id = "+id;
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);

        //Se tiver pelo menos uma linha, encontrou a novidade que buscamos
        if(linhas.next()){
            //então, cria objeto para a novidade
            Novidade n = new Novidade();
            //Preenche os valores dos atributos desta novidade
            n.setData( linhas.getString("data") );
            n.setId( linhas.getString("id") );
            n.setLink( linhas.getString("link") );
            n.setResumo( linhas.getString("resumo") );
            n.setTexto( linhas.getString("texto") );
            n.setTitulo( linhas.getString("titulo"));
            //E retorna o objeto com os valores corretos
            return n;
        } else {
            //se não encontrou nada, retorna null
            return null;
        }
    }

    public static ArrayList<Novidade> busca(String texto){

        ArrayList<Novidade> lista = new ArrayList<Novidade>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from novidades";
                sql += " where ";
                    sql += " titulo like \"%Prova%\" ";
                    sql += "or resumo like \"%"+texto+"%\" ";                    
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);
        
        while(linhas.next()){
            Novidade n = new Novidade();
            n.setId( linhas.getString("id") );
            n.setTitulo( linhas.getString("titulo") );
            n.setResumo( linhas.getString("resumo") );
            n.setTexto( linhas.getString("texto") );
            n.setData( linhas.getString("data") );
            n.setLink( linhas.getString("link") );
            lista.add( n );
        }

        return lista;
    }
   
}
