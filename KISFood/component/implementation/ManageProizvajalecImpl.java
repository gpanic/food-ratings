package component.implementation;

import java.util.List;

import kis.dao.ProizvajalecDAO;
import commonj.sdo.DataObject;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

public class ManageProizvajalecImpl {
	/**
	 * Default constructor.
	 */
	public ManageProizvajalecImpl() {
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
	 * Method generated to support implementation of operation "createProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean createProizvajalec(DataObject proizvajalec) {
		System.out.println("MANAGEPROIZVAJALCI CREATE");
		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.create(proizvajalec);
	}

	/**
	 * Method generated to support implementation of operation "readProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject readProizvajalec(Integer id) {
		System.out.println("MANAGEPROIZVAJALCI READ");
		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "updateProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean updateProizvajalec(DataObject proizvajalec) {
		System.out.println("MANAGEPROIZVAJALCI UPDATE");
		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.update(proizvajalec.getInt("id"), proizvajalec);
	}

	/**
	 * Method generated to support implementation of operation "deleteProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteProizvajalec(Integer id) {
		System.out.println("MANAGEPROIZVAJALCI DELETE");
		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "listProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject listProizvajalec() {
		System.out.println("MANAGEPROIZVAJALCI LIST");
		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject proizvajalci = bof.create("http://KISFoodLib",
				"Proizvajalci");

		ProizvajalecDAO pdao = new ProizvajalecDAO();
		List<DataObject> list = pdao.list();
		proizvajalci.setList("proizvajalci", list);

		return proizvajalci;
	}

	/**
	 * Method generated to support implementation of operation "create" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean create(DataObject proizvajalec) {
		// To get or set attributes for DataObject proizvajalec, use the APIs as shown below:
		// To set a string attribute in proizvajalec, use proizvajalec.setString(stringAttributeName, stringValue)
		// To get a string attribute in proizvajalec, use proizvajalec.getString(stringAttributeName)
		// To set a dataObject attribute in proizvajalec, use proizvajalec.setDataObject(stringAttributeName, dataObjectValue)
		// To get a dataObject attribute in proizvajalec, use proizvajalec.getDataObject(stringAttributeName)
		System.out.println("MANAGEPROIZVAJALCI CREATE");

		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.create(proizvajalec);
	}

	/**
	 * Method generated to support implementation of operation "read" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject read(Integer id) {
		System.out.println("MANAGEPROIZVAJALCI READ");

		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "update" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean update(DataObject proizvajalec) {
		// To get or set attributes for DataObject proizvajalec, use the APIs as shown below:
		// To set a string attribute in proizvajalec, use proizvajalec.setString(stringAttributeName, stringValue)
		// To get a string attribute in proizvajalec, use proizvajalec.getString(stringAttributeName)
		// To set a dataObject attribute in proizvajalec, use proizvajalec.setDataObject(stringAttributeName, dataObjectValue)
		// To get a dataObject attribute in proizvajalec, use proizvajalec.getDataObject(stringAttributeName)
		System.out.println("MANAGEPROIZVAJALCI UPDATE");

		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.update(proizvajalec.getInt("id"), proizvajalec);
	}

	/**
	 * Method generated to support implementation of operation "delete" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean delete(Integer id) {
		ProizvajalecDAO pdao = new ProizvajalecDAO();
		return pdao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "list" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject list() {
		//TODO Needs to be implemented.
		System.out.println("MANAGEPROIZVAJALCI LIST");

		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject proizvajalci = bof.create("http://KISFoodLib",
				"Proizvajalci");

		ProizvajalecDAO pdao = new ProizvajalecDAO();
		List<DataObject> list = pdao.list();
		proizvajalci.setList("proizvajalci", list);

		return proizvajalci;
	}

}