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

public class IzdelekDAO implements DAO<DataObject, Integer> {
	
	private static final String XML_PATH="D:/IBM Integration Designer/workspace/KISFood/data/Izdelki.xml";

	@Override
	public boolean create(DataObject data) {
		boolean makeNewDoc=false;
		
		Document doc=XMLUtil.read(XML_PATH);
		if(doc!=null) {
			int id=getId(doc);
			if(id>=0) {
				izdelekDataObjectToDocument(doc, data, id);
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
				doc2.appendChild(doc2.createElement("izdelki"));
				izdelekDataObjectToDocument(doc2, data, 0);
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
		NodeList list=doc.getElementsByTagName("izdelek");
		
		DataObject izdelekDO=null;
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			int currentId=Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());
			if(currentId==id) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				izdelekDO=bof.create("http://KISFoodLib", "Izdelek");
				
				izdelekDO.set("id", id);
				
				NodeList childList=n.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						if(!att.getNodeName().equals("ocene")) {
							if(att.getNodeName().equals("kategorija")) {
								KategorijaDAO kdao=new KategorijaDAO();
								DataObject kategorija=kdao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("kategorija", kategorija);
							} else if(att.getNodeName().equals("proizvajalec")) {
								ProizvajalecDAO pdao=new ProizvajalecDAO();
								DataObject proizvajalec=pdao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("proizvajalec", proizvajalec);
							} else if(att.getNodeName().equals("drzavaIzvora")) {
								DrzavaDAO ddao=new DrzavaDAO();
								DataObject drzava=ddao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("drzavaIzvora", drzava);
							} else {
								izdelekDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
							}
						} else {
							
							ArrayList<Integer> oceneList=new ArrayList<Integer>();
							NodeList ocene=att.getChildNodes();
							for(int k=0;k<ocene.getLength();k++) {
								Node ocena=ocene.item(k);
								if(ocena.getNodeName().equals("ocena")) {
									oceneList.add(Integer.parseInt(ocena.getFirstChild().getNodeValue()));
								}
							}
							izdelekDO.set("ocene", oceneList);
						}
					}
				}
			}
			
		}
		
		return izdelekDO;
	}

	@Override
	public boolean update(Integer id, DataObject data) {
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();
		NodeList list=doc.getElementsByTagName("izdelek");
		
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
						} else if(n2.getNodeName().equals("kategorija")) {
							n2.getAttributes().getNamedItem("id").setNodeValue(Integer.toString(data.getDataObject("kategorija").getInt("id")));
						} else if(n2.getNodeName().equals("proizvajalec")) {
							n2.getAttributes().getNamedItem("id").setNodeValue(Integer.toString(data.getDataObject("proizvajalec").getInt("id")));
						} else if(n2.getNodeName().equals("drzavaIzvora")) {
							n2.getAttributes().getNamedItem("id").setNodeValue(Integer.toString(data.getDataObject("drzavaIzvora").getInt("id")));
						} else if(n2.getNodeName().equals("ocene")) {
							n2.getParentNode().removeChild(n2);
							Element e3=doc.createElement("ocene");
							n.appendChild(e3);
							
							List<Integer> ocene=data.getList("ocene");
							for(Integer l:ocene) {
								Element e2=doc.createElement("ocena");
								e2.setTextContent(Integer.toString(l));
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
		NodeList list=doc.getElementsByTagName("izdelek");
		
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
		List<DataObject> izdelki=new ArrayList<DataObject>();
		
		Document doc=XMLUtil.read(XML_PATH);
		Element e=doc.getDocumentElement();;
		NodeList list=e.getChildNodes();
		for(int i=0;i<list.getLength();i++) {
			Node izdelek=list.item(i);
			if(izdelek.getNodeName().equals("izdelek")) {
				BOFactory bof=(BOFactory)ServiceManager.INSTANCE.locateService("com/ibm/websphere/bo/BOFactory");
				DataObject izdelekDO=bof.create("http://KISFoodLib", "Izdelek");
				
				izdelekDO.set("id", Integer.parseInt(izdelek.getAttributes().getNamedItem("id").getNodeValue()));
				
				NodeList childList=izdelek.getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node att=childList.item(j);
					if(!att.getNodeName().equals("#text")) {
						if(!att.getNodeName().equals("ocene")) {
							if(att.getNodeName().equals("kategorija")) {
								KategorijaDAO kdao=new KategorijaDAO();
								DataObject kategorija=kdao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("kategorija", kategorija);
							} else if(att.getNodeName().equals("proizvajalec")) {
								ProizvajalecDAO pdao=new ProizvajalecDAO();
								DataObject proizvajalec=pdao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("proizvajalec", proizvajalec);
							} else if(att.getNodeName().equals("drzavaIzvora")) {
								DrzavaDAO ddao=new DrzavaDAO();
								DataObject drzava=ddao.read(Integer.parseInt(att.getAttributes().getNamedItem("id").getNodeValue()));
								izdelekDO.setDataObject("drzavaIzvora", drzava);
							} else {
								izdelekDO.set(att.getNodeName(), att.getFirstChild().getNodeValue());
							}
						} else {
							ArrayList<Integer> oceneList=new ArrayList<Integer>();
							NodeList ocene=att.getChildNodes();
							for(int k=0;k<ocene.getLength();k++) {
								Node ocena=ocene.item(k);
								if(ocena.getNodeName().equals("ocena")) {
									oceneList.add(Integer.parseInt(ocena.getFirstChild().getNodeValue()));
								}
							}
							izdelekDO.set("ocene", oceneList);
						}
					}
				}
				izdelki.add(izdelekDO);
			}
		}
		return izdelki;
	}
	
	private int getId(Document doc) {
		int id=-1;
		Element e=doc.getDocumentElement();
		if(doc!=null) {
			if(e.getNodeName().equals("izdelki")) {
				NodeList nl=e.getChildNodes();
				for(int i=0;i<nl.getLength();i++) {
					Node n=nl.item(i);
					if(n.getNodeName().equals("izdelek")) {
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
	
	private void izdelekDataObjectToDocument(Document doc, DataObject data, int id) {
		Element izdelek=doc.createElement("izdelek");
		izdelek.setAttribute("id", Integer.toString(id));
		
		Element e2=doc.createElement("naziv");
		e2.setTextContent(data.getString("naziv"));
		izdelek.appendChild(e2);
		
		e2=doc.createElement("kategorija");
		e2.setAttribute("id",Integer.toString((data.getDataObject("kategorija").getInt("id"))));
		izdelek.appendChild(e2);
		
		e2=doc.createElement("proizvajalec");
		e2.setAttribute("id",Integer.toString((data.getDataObject("proizvajalec").getInt("id"))));
		izdelek.appendChild(e2);
		
		e2=doc.createElement("drzavaIzvora");
		e2.setAttribute("id",Integer.toString((data.getDataObject("drzavaIzvora").getInt("id"))));
		izdelek.appendChild(e2);
		
		e2=doc.createElement("ocene");
		izdelek.appendChild(e2);
		
		Element e=doc.getDocumentElement();
		e.appendChild(izdelek);
	}

}
