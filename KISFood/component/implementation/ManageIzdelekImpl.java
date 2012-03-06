package component.implementation;

import com.ibm.websphere.sca.Service;
import com.ibm.websphere.sca.Ticket;
import java.util.List;

import kis.dao.IzdelekDAO;
import commonj.sdo.DataObject;

import com.ibm.websphere.bo.BOFactory;
import com.ibm.websphere.sca.ServiceManager;

public class ManageIzdelekImpl {
	/**
	 * Default constructor.
	 */
	public ManageIzdelekImpl() {
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
	 * This method is used to locate the service for the reference
	 * named "NutritionDataManagerPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _NutritionDataManagerPartner = null;

	public Service locateService_NutritionDataManagerPartner() {
		if (_NutritionDataManagerPartner == null) {
			_NutritionDataManagerPartner = (Service) ServiceManager.INSTANCE
					.locateService("NutritionDataManagerPartner");
		}
		return _NutritionDataManagerPartner;
	}

	/**
	 * Method generated to support implementation of operation "createIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean createIzdelek(DataObject izdelek) {
		System.out.println("MANAGEIZDELEK CREATE");
		IzdelekDAO idao = new IzdelekDAO();
		return idao.create(izdelek);
	}

	/**
	 * Method generated to support implementation of operation "readIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject readIzdelek(Integer id) {
		System.out.println("MANAGEIZDELEK READ");
		IzdelekDAO idao = new IzdelekDAO();
		return idao.read(id);
	}

	/**
	 * Method generated to support implementation of operation "updateIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean updateIzdelek(DataObject izdelek) {
		System.out.println("MANAGEIZDELEK UPDATE");
		IzdelekDAO idao = new IzdelekDAO();
		return idao.update(izdelek.getInt("id"), izdelek);
	}

	/**
	 * Method generated to support implementation of operation "deleteIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteIzdelek(Integer id) {
		System.out.println("MANAGEIZDELEK DELETE");
		IzdelekDAO idao = new IzdelekDAO();
		return idao.delete(id);
	}

	/**
	 * Method generated to support implementation of operation "listIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * The presence of commonj.sdo.DataObject as the return type and/or as a parameter 
	 * type conveys that it is a complex type. Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public DataObject listIzdelek() {
		System.out.println("MANAGEIZDELEK LIST");
		BOFactory bof = (BOFactory) ServiceManager.INSTANCE
				.locateService("com/ibm/websphere/bo/BOFactory");
		DataObject izdelki = bof.create("http://KISFoodLib", "Izdelki");

		IzdelekDAO idao = new IzdelekDAO();
		List<DataObject> list = idao.list();
		izdelki.setList("izdelki", list);

		return izdelki;
	}

	/**
	 * Method generated to support implementation of operation "getKalorije" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Double getKalorije(String engName) {
		System.out.println("MANAGEIZDELEK GETKALORIJE");
		DataObject result=(DataObject)this.locateService_NutritionDataManagerPartner().invoke("getKalorije", engName);
		return result.getDouble("result");
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "NutritionDataManager#getKalorije(String engName)"
	 * of wsdl interface "NutritionDataManager"	
	 */
	public void onGetKalorijeResponse(Ticket __ticket, Double returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

}