package kis.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import kis.util.XMLUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

import commonj.sdo.DataObject;

public class KategorijaDAO implements DAO<DataObject, Integer> {
	
	private static final String XML_PATH="D:/IBM Integration Designer/workspace/KISFood/data/Kategorije.xml";

	@Override
	public boolean create(DataObject data) {
		boolean makeNewDoc=false;
		
		Document doc=XMLUtil.read(XML_PATH);
		if(doc!=null) {
			int id=getId(doc);
			if(id>=0) {
				kategorijaDataObjectToDocument(doc, data, id);
				XMLUtil.write(doc, XML_PATH);
				return true;
				
			} else {
				makeNewDoc=true;
			}
		} else {
			makeNewDoc=true;
		}
		
		if(makeNewDoc) {
			try {
				DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
				DocumentBuilder db=dbf.newDocumentBuilder();
				Document doc2=db.newDocument();
				doc2.appendChild(doc2.createElement("kategorije"));
				kategorijaDataObjectToDocument(doc2, data, 0);
				XMLUtil.write(doc2, XML_PATH);
				return true;
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public DataObject read(Integer id) {
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();
		NodeList list=doc.getElementsByTagName("kategorija");
		
		DataObject proizvajalecDO=null;
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
			if(currentId==id) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				proizvajalecDO=bof.create("http://KISFoodLib", "Kategorija");
				
				proizvajalecDO.set("id", id);
				
				NodeList childList=n.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						proizvajalecDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
					}
				}
			}
			
		}
		return proizvajalecDO;
	}

	@Override
	public boolean update(Integer id, DataObject data) {
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();
		NodeList list=doc.getElementsByTagName("kategorija");
		
		DataObject proizvajalecDO=null;
		boolean found=false;
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
			if(currentId==id) {
				found=true;
				NodeList nl=n.getChildNodes();
				for(int j=0;j<nl.getLength();j++) {
					Node n2=nl.item(j);
					if(!n2.getNodeName().equals("#text")) {
						if(n2.getNodeName().equals("naziv")) {
							n2.getFirstChild().setNodeValue(data.getString("naziv"));
						}
					}
				}
				XMLUtil.write(doc, XML_PATH);
			}
		}
		return found;
	}

	@Override
	public boolean delete(Integer id) {
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();
		NodeList list=doc.getElementsByTagName("kategorija");
		
		boolean found=false;
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
			if(currentId==id) {
				found=true;
				n.getParentNode().removeChild(n);
				XMLUtil.write(doc, XML_PATH);
			}
		}
		
		return found;
	}

	@Override
	public List<DataObject> list() {
		List<DataObject> kategorije=new ArrayList<DataObject>();
		
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();;
		NodeList list=e.getChildNodes();
		for(int i=0;i<list.getLength();i++) {
			Node kategorija=list.item(i);
			if(kategorija.getNodeName().equals("kategorija")) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				DataObject kategorijaDO=bof.create("http://KISFoodLib", "Kategorija");
				
				kategorijaDO.set("id", Integer.parseInt(kategorija.getAttributes().getNamedItem("id").getNodeValue()));
				
				NodeList childList=kategorija.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						kategorijaDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
					}
				}
				kategorije.add(kategorijaDO);
			}
		}
		return kategorije;
	}
	
	private int getId(Document doc) {
		int id=-1;
		Element e=doc.getDocumentElement();
		if(doc!=null) {
			if(e.getNodeName().equals("kategorije")) {
				NodeList nl=e.getChildNodes();
				for(int i=0;i<nl.getLength();i++) {
					Node n=nl.item(i);
					if(n.getNodeName().equals("kategorija")) {
						int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
						if(currentId>=id) {
							id=currentId;
							id++;
						}
					}
				}
			}
		}
		return id;
	}
	
	private void kategorijaDataObjectToDocument(Document doc, DataObject data, int id) {
		Element kategorija=doc.createElement("kategorija");
		kategorija.setAttribute("id", Integer.toString(id));
		
		Element e2=doc.createElement("naziv");
		e2.setTextContent(data.getString("naziv"));
		kategorija.appendChild(e2);
		
		Element e=doc.getDocumentElement();
		e.appendChild(kategorija);
	}

}
