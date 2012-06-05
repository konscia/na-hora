package dao;

import java.util.ArrayList;
import model.Novidade;
import util.*;

public class NovidadesDAO {

    public static ArrayList<Novidade> lista(){
        
        ArrayList<Novidade> lista = new ArrayList<Novidade>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from novidades order by id desc";
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);
       
        while(linhas.next()){            
            Novidade n = new Novidade();
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
