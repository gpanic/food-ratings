package component.implementation;

import java.util.List;

import kis.dao.DrzavaDAO;
import commonj.sdo.DataObject;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

public class ManageDrzavaImpl {
	/**
	 * Default constructor.
	 */
	public ManageDrzavaImpl() {
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
	 * Method generated to support implementation of operation "createDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean createDrzava(DataObject drzava) {
		System.out.println("MANAGEDRZAVA CREATE");
		DrzavaDAO ddao = new DrzavaDAO();
		return ddao.create(drzava);
	}

	/**
	 * Method generated to support implementation of operation "readDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject readDrzava(Integer id) {
		System.out.println("MANAGEDRZAVA READ");
		DrzavaDAO ddao = new DrzavaDAO();
		return ddao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "updateDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean updateDrzava(DataObject drzava) {
		System.out.println("MANAGEDRZAVA UPDATE");
		DrzavaDAO ddao = new DrzavaDAO();
		return ddao.update(drzava.getInt("id"), drzava);
	}

	/**
	 * Method generated to support implementation of operation "deleteDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteDrzava(Integer id) {
		System.out.println("MANAGEDRZAVA DELETE");
		DrzavaDAO ddao = new DrzavaDAO();
		return ddao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "listDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject listDrzava() {
		System.out.println("MANAGEDRZAVA LIST");
		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject drzave = bof.create("http://KISFoodLib", "Drzave");

		DrzavaDAO ddao = new DrzavaDAO();
		List<DataObject> list = ddao.list();
		drzave.setList("drzave", list);

		return drzave;
	}

}