package component.implementation;

import java.util.List;

import kis.dao.UporabnikDAO;
import commonj.sdo.DataObject;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

public class ManageUporabnikImpl {
	/**
	 * Default constructor.
	 */
	public ManageUporabnikImpl() {
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
	 * Method generated to support implementation of operation "createUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean createUporabnik(DataObject uporabnik) {
		System.out.println("MANAGEUPORABNIK CREATE");
		UporabnikDAO udao = new UporabnikDAO();
		return udao.create(uporabnik);
	}

	/**
	 * Method generated to support implementation of operation "readUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject readUporabnik(Integer id) {
		System.out.println("MANAGEUPORABNIK READ");
		UporabnikDAO udao = new UporabnikDAO();
		return udao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "updateUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean updateUporabnik(DataObject uporabnik) {
		System.out.println("MANAGEUPORABNIK UPDATE");
		UporabnikDAO udao = new UporabnikDAO();
		return udao.update(uporabnik.getInt("id"), uporabnik);
	}

	/**
	 * Method generated to support implementation of operation "deleteUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteUporabnik(Integer id) {
		System.out.println("MANAGEUPORABNIK DELETE");
		UporabnikDAO udao = new UporabnikDAO();
		return udao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "listUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject listUporabnik() {
		System.out.println("MANAGEKATEGORIJA LIST");
		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject uporabniki = bof.create("http://KISFoodLib", "Uporabniki");

		UporabnikDAO udao = new UporabnikDAO();
		List<DataObject> list = udao.list();
		uporabniki.setList("uporabniki", list);

		return uporabniki;
	}

	/**
	 * Method generated to support implementation of operation "loginUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject loginUporabnik(DataObject uporabnik) {
		System.out.println("MANAGEUPORABNIK LOGIN");
		UporabnikDAO udao = new UporabnikDAO();
		List<DataObject> list = udao.list();
		for (DataObject dataObject : list) {
			if (dataObject.getString("username").equals(
					uporabnik.getString("username"))
					&& dataObject.getString("password").equals(
							uporabnik.getString("password"))) {
				return dataObject;
			}
		}
		return null;
	}

	/**
	 * Method generated to support implementation of operation "existsUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean existsUporabnik(DataObject uporabnik) {
		System.out.println("MANAGEUPORABNIK EXISTS");
		UporabnikDAO udao = new UporabnikDAO();
		List<DataObject> list = udao.list();
		for (DataObject dataObject : list) {
			if (dataObject.getString("username").equals(
					uporabnik.getString("username"))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method generated to support implementation of operation "isAdminUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean isAdminUporabnik(Integer id) {
		UporabnikDAO udao=new UporabnikDAO();
		DataObject uporabnik=udao.read(id);
		if(uporabnik.getString("role").equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

}