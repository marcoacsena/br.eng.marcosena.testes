
package app;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlArquivo {
    
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        
        //lerXml();
        criarXml();
        
        }        
        
        public static void lerXml() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
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

    private static void criarXml() throws ParserConfigurationException, TransformerException, FileNotFoundException, IOException {
        
       DocumentBuilder Builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       Document documento = Builder.newDocument();
       Element avicenarootTag = documento.createElement("avicena");

        //for (Estado e : estados) {
        
        for (int i =0; i < 2; i++) {
            Element especialidade = documento.createElement("especialidade");
            especialidade.setAttribute("id", "nome" +i);
//            estado.setAttribute("nome", e.getNome());
//            for (Cidade c : e.getCidades()) {
                Element medico = documento.createElement("medico");

                Element nome = documento.createElement("nome");
                medico.appendChild(nome);
                //nome.setTextContent(c.getNome());

                Element CRM = documento.createElement("CRM");
                medico.appendChild(CRM);
                //populacao.setTextContent(String.valueOf(c.getPopulacao()));

                Element celular = documento.createElement("celular");
                medico.appendChild(celular);
                //pib.setTextContent(String.valueOf(c.getPib()));

                Element email = documento.createElement("email");
                medico.appendChild(email);
                //area.setTextContent(String.valueOf(c.getArea()));

                especialidade.appendChild(medico);

            //}
            avicenarootTag.appendChild(especialidade);
        }
            

       // }

        //firstLevel.setTextContent("Text content of a tag element");
        documento.appendChild(avicenarootTag);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource domSource = new DOMSource(documento);
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);
        System.out.println(sw.toString());

        File f = new File("D:\\senac\\modeloXml.xml");
        FileOutputStream fout = new FileOutputStream(f);
        DataOutputStream dout = new DataOutputStream(fout);
        dout.write(sw.toString().getBytes());
        dout.close();
        fout.close(); 
        
    }
    

}
