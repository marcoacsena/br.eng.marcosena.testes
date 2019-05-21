package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import controle.VO.Pessoa;

public class SerializacaoObjectJsonObject {

    
    public static void main(String[] args) throws FileNotFoundException {
       
//        Pessoa pessoa = new Pessoa("Marco", "Sena");
//        Gson gson = new Gson();
//        String Json = gson.toJson(pessoa);
//        
//        try{
//            
//            FileWriter fw = new FileWriter("D:\\senac\\json\\pessoa.json");
//            fw.write(Json);            
//            fw.close();
//    }catch(IOException e){
//        e.printStackTrace();
//        
//    }
    
      BufferedReader br = new BufferedReader (new FileReader("D:\\senac\\json\\pessoa.json"));  
      Gson gson = new Gson();
      Pessoa pessoa = gson.fromJson(br, Pessoa.class);
      
      System.out.println("O objeto pessoa recuperado tem os seguintes dados: " +pessoa);
        
    }
    
}
