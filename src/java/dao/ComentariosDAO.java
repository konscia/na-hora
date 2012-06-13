package dao;

import java.util.ArrayList;
import model.Comentario;
import util.*;

public class ComentariosDAO {

    public static ArrayList<Comentario> lista( String idNovidade ){
        
        ArrayList<Comentario> lista = new ArrayList<Comentario>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from comentario where id_novidade = "+idNovidade;
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);
       
        while(linhas.next()){            
            Comentario c = new Comentario();
            c.setId( linhas.getString("id") );
            c.setNome( linhas.getString("nome") );            
            c.setTexto( linhas.getString("texto") );
            c.setIdNovidade( linhas.getString("idnovidade") );            
            lista.add( c );
        }

        return lista;        
    }    
   
}
