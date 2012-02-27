package component.implementation;

import java.util.List;

import kis.dao.KategorijaDAO;
import commonj.sdo.DataObject;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

public class ManageKategorijaImpl {
	/**
	 * Default constructor.
	 */
	public ManageKategorijaImpl() {
		super();
	}

	/**
	 * Return a reference to the component service instance for this implementation
	 * class.  This method should be used when passing this service to a partner reference
	 * or if you want to invoke this component service asynchronously.    
	 *
	 * @generated (com.ibm.wbit.java)
	 */
	@SuppressWarnings("unused")
	private Object getMyService() {
		return (Object) ServiceManager.INSTANCE.locateService("self");
	}

	/**
	 * Method generated to support implementation of operation "createKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean createKategorija(DataObject kategorija) {
		System.out.println("MANAGEKATEGORIJA CREATE");
		KategorijaDAO kdao = new KategorijaDAO();
		return kdao.create(kategorija);
	}

	/**
	 * Method generated to support implementation of operation "readKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject readKategorija(Integer id) {
		System.out.println("MANAGEKATEGORIJA READ");
		KategorijaDAO kdao = new KategorijaDAO();
		return kdao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "updateKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean updateKategorija(DataObject kategorija) {
		System.out.println("MANAGEKATEGORIJA UPDATE");
		KategorijaDAO kdao = new KategorijaDAO();
		return kdao.update(kategorija.getInt("id"), kategorija);
	}

	/**
	 * Method generated to support implementation of operation "deleteKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteKategorija(Integer id) {
		System.out.println("MANAGEKATEGORIJA DELETE");
		KategorijaDAO kdao = new KategorijaDAO();
		return kdao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "listKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject listKategorija() {
		System.out.println("MANAGEKATEGORIJA LIST");
		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject kategorije = bof.create("http://KISFoodLib", "Kategorije");

		KategorijaDAO kdao = new KategorijaDAO();
		List<DataObject> list = kdao.list();
		kategorije.setList("kategorije", list);

		return kategorije;
	}

}