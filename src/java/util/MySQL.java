package util;

import java.io.*;
import java.sql.*; 
import javax.swing.*;

public class MySQL
{
    Statement statement;    
    String user = "root";
    String pass = "senai2011";
    String database = "na_hora";
    String host = "localhost";
   
    public MySQL()
    {
       String url = "jdbc:mysql://"+host+":3306/"+database;             

       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pass);
            statement = conn.createStatement();
        } catch (ClassNotFoundException e){
            System.out.println("Driver MySQL não encontrado.");
        } catch (SQLException e){
            System.out.println("Erro na conex�o com a base de dados: "+e);
        }        
    }

    public boolean executaInsert(String insert)
    {
        try {
            statement.execute(insert);
            return true;
        } catch (SQLException e){
            System.out.println("Erro na Inclus�o "+e);
            return false;
        }
    }
    
    public boolean executaUpdate(String insert)
    {
        try {
            statement.execute(insert);
            return true;
        } catch (SQLException e){
            System.out.println("Erro na Inclus�o "+e);
            return false;
        }
    }
    
    public boolean executaDelete(String delete)
    {
        try {
            statement.execute(delete);
            return true;
        } catch (SQLException e){
            System.out.println("Erro na exclus�o "+e);
            return false;
        }
    }
    
    public ConjuntoResultados executaSelect(String select)
    {
        try {
            ResultSet rs = statement.executeQuery(select);
            ConjuntoResultados cr = new ConjuntoResultados(rs);
            return cr;
        } catch (SQLException e){
            //JOptionPane.showMessageDialog(null, ""+e, "Erro no SELECT", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro na consulta: "+e);
            return null;
        }
    }       
    
}
