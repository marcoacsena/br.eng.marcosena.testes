package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.VO.Cliente;

public class GravaELerObjetos {

   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
//       Cliente cliente = new Cliente ("Marco Sena", 'M', "001.002.003-00");
//       
//       FileOutputStream criacaoDoArquivo = new FileOutputStream("D:\\senac\\objetos\\cliente.txt");
//       ObjectOutputStream ObjetoCliente = new ObjectOutputStream(criacaoDoArquivo);
//       ObjetoCliente.writeObject(cliente);
//       
//       ObjetoCliente.flush();
//       ObjetoCliente.close();
//       criacaoDoArquivo.flush();;
//       criacaoDoArquivo.close();
//       System.out.println("O arquivo foi gravado com sucesso!");
       
       System.out.println("Agora, faremos a leitura do arquivo!");
       
       FileInputStream encontraArquivo = new FileInputStream("D:\\senac\\objetos\\cliente.txt");
       ObjectInputStream objetoCliente = new ObjectInputStream(encontraArquivo);
       Object objetoRecuperado = objetoCliente.readObject();
       
       System.out.println("O objeto recuperado tem os seguintes dados: " +objetoRecuperado);
       
       
    }
    
}
