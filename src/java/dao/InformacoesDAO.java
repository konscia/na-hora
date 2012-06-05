/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Informacao;
import util.ConjuntoResultados;
import util.MySQL;

public class InformacoesDAO {
    
    public static ArrayList<Informacao> lista(){
        ArrayList<Informacao> lista = new ArrayList<Informacao>();
        MySQL bancoDados = new MySQL();
        String sql = "select * from informacaoes";
        ConjuntoResultados linhas = bancoDados.executaSelect(sql);

        while(linhas.next()){
            Informacao n = new Informacao();
            n.setTitulo( linhas.getString("titulo") );
            n.setResumo( linhas.getString("resumo") );
            n.setTexto( linhas.getString("texto") );
            n.setImagem( linhas.getString("imagem") );
            n.setLink( linhas.getString("link") );
            lista.add( n );
        }

        return lista;
    }
}
