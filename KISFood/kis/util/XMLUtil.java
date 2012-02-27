package kis.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLUtil {
	
	public static Document read(String path) {
		Document doc=null;
		try {
			File file=new File(path);
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			if(file.length()!=0) {
				doc=db.parse(file);
			} else {
				return null;
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public static boolean write(Document doc, String path) {
		boolean result=false;

		try {
			DOMSource inputDoc=new DOMSource(doc);
			StreamResult sr=new StreamResult(path);
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t=tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(inputDoc, sr);
			result=true;
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
