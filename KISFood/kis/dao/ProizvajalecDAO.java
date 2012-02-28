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

public class ProizvajalecDAO implements DAO<DataObject, Integer> {
	
	private static final String XML_PATH="D:/IBM Integration Designer/workspace/KISFood/data/Proizvajalci.xml";

	@Override
	public boolean create(DataObject data) {
		boolean makeNewDoc=false;
		
		Document doc=XMLUtil.read(XML_PATH);
		if(doc!=null) {
			int id=getId(doc);
			if(id>=0) {
				proizvajalecDataObjectToDocument(doc, data, id);
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
				doc2.appendChild(doc2.createElement("proizvajalci"));
				proizvajalecDataObjectToDocument(doc2, data, 0);
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
		NodeList list=doc.getElementsByTagName("proizvajalec");
		
		DataObject proizvajalecDO=null;
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
			if(currentId==id) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				proizvajalecDO=bof.create("http://KISFoodLib", "Proizvajalec");
				
				proizvajalecDO.set("id", id);
				
				NodeList childList=n.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						if(!att.getNodeName().equals("ocene")) {
							proizvajalecDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
						} else {
							
							ArrayList<DataObject> oceneList=new ArrayList<DataObject>();
							NodeList ocene=att.getChildNodes();
							for(int k=0;k<ocene.getLength();k++) {
								Node ocena=ocene.item(k);
								if(ocena.getNodeName().equals("ocena")) {
									bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
									DataObject ocenaDO=bof.create("http://KISFoodLib", "Ocena");
									
									ocenaDO.setInt("idUser", Integer.parseInt(ocena.getAttributes().getNamedItem("idUser").getNodeValue()));
									ocenaDO.setInt("ocena", Integer.parseInt(ocena.getFirstChild().getNodeValue()));
									
									oceneList.add(ocenaDO);
								}
							}
							proizvajalecDO.set("ocene", oceneList);
						}
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
		NodeList list=doc.getElementsByTagName("proizvajalec");
		
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
						} else if(n2.getNodeName().equals("drzava")) {
							n2.getFirstChild().setNodeValue(data.getString("drzava"));
						} else if(n2.getNodeName().equals("mesto")) {
							n2.getFirstChild().setNodeValue(data.getString("mesto"));
						} else if(n2.getNodeName().equals("ocene")) {
							n2.getParentNode().removeChild(n2);
							Element e3=doc.createElement("ocene");
							n.appendChild(e3);
							
							List<DataObject> ocene=data.getList("ocene");
							for(DataObject dataObj:ocene) {
								Element e2=doc.createElement("ocena");
								e2.setTextContent(Integer.toString(dataObj.getInt("ocena")));
								e2.setAttribute("idUser", Integer.toString(dataObj.getInt("idUser")));
								e3.appendChild(e2);
							}
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
		NodeList list=doc.getElementsByTagName("proizvajalec");
		
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
		List<DataObject> proizvajalci=new ArrayList<DataObject>();
		
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();;
		NodeList list=e.getChildNodes();
		for(int i=0;i<list.getLength();i++) {
			Node proizvajalec=list.item(i);
			if(proizvajalec.getNodeName().equals("proizvajalec")) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				DataObject proizvajalecDO=bof.create("http://KISFoodLib", "Proizvajalec");
				
				proizvajalecDO.set("id", Integer.parseInt(proizvajalec.getAttributes().getNamedItem("id").getNodeValue()));
				
				NodeList childList=proizvajalec.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						if(!att.getNodeName().equals("ocene")) {
							proizvajalecDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
						} else {
							
							ArrayList<DataObject> oceneList=new ArrayList<DataObject>();
							NodeList ocene=att.getChildNodes();
							for(int k=0;k<ocene.getLength();k++) {
								Node ocena=ocene.item(k);
								if(ocena.getNodeName().equals("ocena")) {
									bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
									DataObject ocenaDO=bof.create("http://KISFoodLib", "Ocena");
									
									ocenaDO.setInt("idUser", Integer.parseInt(ocena.getAttributes().getNamedItem("idUser").getNodeValue()));
									ocenaDO.setInt("ocena", Integer.parseInt(ocena.getFirstChild().getNodeValue()));
									
									oceneList.add(ocenaDO);
								}
							}
							proizvajalecDO.set("ocene", oceneList);
						}
					}
				}
				proizvajalci.add(proizvajalecDO);
			}
		}
		return proizvajalci;
	}
	
	private int getId(Document doc) {
		int id=-1;
		Element e=doc.getDocumentElement();
		if(doc!=null) {
			if(e.getNodeName().equals("proizvajalci")) {
				NodeList nl=e.getChildNodes();
				for(int i=0;i<nl.getLength();i++) {
					Node n=nl.item(i);
					if(n.getNodeName().equals("proizvajalec")) {
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
	
	private void proizvajalecDataObjectToDocument(Document doc, DataObject data, int id) {
		Element proizvajalec=doc.createElement("proizvajalec");
		proizvajalec.setAttribute("id", Integer.toString(id));
		
		Element e2=doc.createElement("naziv");
		e2.setTextContent(data.getString("naziv"));
		proizvajalec.appendChild(e2);
		
		e2=doc.createElement("drzava");
		e2.setTextContent(data.getString("drzava"));
		proizvajalec.appendChild(e2);
		
		e2=doc.createElement("mesto");
		e2.setTextContent(data.getString("mesto"));
		proizvajalec.appendChild(e2);
		
		e2=doc.createElement("ocene");
		proizvajalec.appendChild(e2);
		
		Element e=doc.getDocumentElement();
		e.appendChild(proizvajalec);
	}
	
	

}
