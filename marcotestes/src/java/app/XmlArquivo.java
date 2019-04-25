
package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlArquivo {
    
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException, SAXException{
        
        
           File arquivo = new File("D:\\senac\\agenda.xml");
           FileInputStream arquivoXml = new FileInputStream(arquivo);

           DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

           Document documento = builder.parse(arquivoXml);
           String elementoRaiz = documento.getDocumentElement().getNodeName();
           System.out.println("O elemento raiz é: " +elementoRaiz);
           
           NodeList especialidades = documento.getElementsByTagName("especialidade");
           System.out.println("O número de especialidades é: " +especialidades.getLength());
            
            for (int i = 0; i < especialidades.getLength(); i++) {
                
                String especialidade = especialidades.item(i).getAttributes().getNamedItem("id").getNodeValue();
                System.out.println("Especialidade: " +especialidade);
                                
                NodeList medicos = especialidades.item(i).getChildNodes();                  
                //System.out.println("O número de medicos é: " +medicos.getLength());                
                              
                for(int j = 0; j < medicos.getLength(); j++) {
                    
                    try {
                        NodeList medico = medicos.item(j).getChildNodes();                             

                        String nome = medico.item(1).getTextContent();
                        String CRM = medico.item(3).getTextContent();
                        String email = medico.item(5).getTextContent();
                        System.out.println("Nome: " +nome +"| " +"CRM: " +CRM +"| " +"email: " +email);                 
                
    
  }catch (Exception e) {
            e.printStackTrace();
            
            
        }
      }
    }
  }
    
}
