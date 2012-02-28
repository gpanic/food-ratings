package component.implementation;

import com.ibm.websphere.sca.Service;
import com.ibm.websphere.sca.Ticket;
import commonj.sdo.DataObject;
import com.ibm.websphere.sca.ServiceManager;

public class DataManagerImpl {
	/**
	 * Default constructor.
	 */
	public DataManagerImpl() {
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
	 * named "ManageKategorijaPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _ManageKategorijaPartner = null;

	public Service locateService_ManageKategorijaPartner() {
		if (_ManageKategorijaPartner == null) {
			_ManageKategorijaPartner = (Service) ServiceManager.INSTANCE
					.locateService("ManageKategorijaPartner");
		}
		return _ManageKategorijaPartner;
	}

	/**
	 * This method is used to locate the service for the reference
	 * named "ManageDrzavaPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _ManageDrzavaPartner = null;

	public Service locateService_ManageDrzavaPartner() {
		if (_ManageDrzavaPartner == null) {
			_ManageDrzavaPartner = (Service) ServiceManager.INSTANCE
					.locateService("ManageDrzavaPartner");
		}
		return _ManageDrzavaPartner;
	}

	/**
	 * This method is used to locate the service for the reference
	 * named "ManageIzdelekPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _ManageIzdelekPartner = null;

	public Service locateService_ManageIzdelekPartner() {
		if (_ManageIzdelekPartner == null) {
			_ManageIzdelekPartner = (Service) ServiceManager.INSTANCE
					.locateService("ManageIzdelekPartner");
		}
		return _ManageIzdelekPartner;
	}

	/**
	 * This method is used to locate the service for the reference
	 * named "ManageUporabnikPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _ManageUporabnikPartner = null;

	public Service locateService_ManageUporabnikPartner() {
		if (_ManageUporabnikPartner == null) {
			_ManageUporabnikPartner = (Service) ServiceManager.INSTANCE
					.locateService("ManageUporabnikPartner");
		}
		return _ManageUporabnikPartner;
	}

	/**
	 * This method is used to locate the service for the reference
	 * named "ManageProizvajalecPartner".  This will return an instance of 
	 * {@link com.ibm.websphere.sca.Service}.  This is the dynamic
	 * interface which is used to invoke operations on the reference service
	 * either synchronously or asynchronously.  You will need to pass the operation
	 * name in order to invoke an operation on the service.
	 *
	 * @generated (com.ibm.wbit.java)
	 *
	 * @return Service
	 */
	private Service _ManageProizvajalecPartner = null;

	public Service locateService_ManageProizvajalecPartner() {
		if (_ManageProizvajalecPartner == null) {
			_ManageProizvajalecPartner = (Service) ServiceManager.INSTANCE
					.locateService("ManageProizvajalecPartner");
		}
		return _ManageProizvajalecPartner;
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
		DataObject response = (DataObject) this
				.locateService_ManageDrzavaPartner().invoke("createDrzava",
						drzava);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageDrzavaPartner().invoke("readDrzava", id);
		return response.getDataObject("drzava");
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
		DataObject response = (DataObject) this
				.locateService_ManageDrzavaPartner().invoke("updateDrzava",
						drzava);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "deleteDrzava" defined for WSDL port type 
	 * named "ManageDrzava".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteDrzava(Integer id) {
		DataObject response = (DataObject) this
				.locateService_ManageDrzavaPartner().invoke("deleteDrzava", id);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageDrzavaPartner().invoke("listDrzava", null);
		return response.getDataObject("drzave");
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
		DataObject response = (DataObject) this
				.locateService_ManageIzdelekPartner().invoke("createIzdelek",
						izdelek);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageIzdelekPartner().invoke("readIzdelek", id);
		return response.getDataObject("izdelek");
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
		DataObject response = (DataObject) this
				.locateService_ManageIzdelekPartner().invoke("updateIzdelek",
						izdelek);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "deleteIzdelek" defined for WSDL port type 
	 * named "ManageIzdelek".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteIzdelek(Integer id) {
		DataObject response = (DataObject) this
				.locateService_ManageIzdelekPartner().invoke("deleteIzdelek",
						id);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageIzdelekPartner().invoke("listIzdelek",
						null);
		return response.getDataObject("izdelki");
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
		DataObject response = (DataObject) this
				.locateService_ManageKategorijaPartner().invoke(
						"createKategorija", kategorija);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageKategorijaPartner().invoke(
						"readKategorija", id);
		return response.getDataObject("kategorija");
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
		DataObject response = (DataObject) this
				.locateService_ManageKategorijaPartner().invoke(
						"updateKategorija", kategorija);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "deleteKategorija" defined for WSDL port type 
	 * named "ManageKategorija".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteKategorija(Integer id) {
		DataObject response = (DataObject) this
				.locateService_ManageKategorijaPartner().invoke(
						"deleteKategorija", id);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageKategorijaPartner().invoke(
						"listKategorija", null);
		return response.getDataObject("kategorije");
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
		DataObject response = (DataObject) this
				.locateService_ManageProizvajalecPartner().invoke(
						"createProizvajalec", proizvajalec);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageProizvajalecPartner().invoke(
						"readProizvajalec", id);
		return response.getDataObject("proizvajalec");
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
		DataObject response = (DataObject) this
				.locateService_ManageProizvajalecPartner().invoke(
						"updateProizvajalec", proizvajalec);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "deleteProizvajalec" defined for WSDL port type 
	 * named "ManageProizvajalec".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteProizvajalec(Integer id) {
		DataObject response = (DataObject) this
				.locateService_ManageProizvajalecPartner().invoke(
						"deleteProizvajalec", id);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageProizvajalecPartner().invoke(
						"listProizvajalec", null);
		return response.getDataObject("proizvajalci");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke(
						"createUporabnik", uporabnik);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke("readUporabnik",
						id);
		return response.getDataObject("uporabnik");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke(
						"updateUporabnik", uporabnik);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "deleteUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean deleteUporabnik(Integer id) {
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke(
						"deleteUporabnik", id);
		return response.getBoolean("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke("listUporabnik",
						null);
		return response.getDataObject("uporabniki");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke(
						"loginUporabnik", uporabnik);
		return response.getDataObject("result");
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
		DataObject response = (DataObject) this
				.locateService_ManageUporabnikPartner().invoke(
						"existsUporabnik", uporabnik);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support implementation of operation "isAdminUporabnik" defined for WSDL port type 
	 * named "ManageUporabnik".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public Boolean isAdminUporabnik(Integer id) {
		DataObject response=(DataObject) this
			.locateService_ManageUporabnikPartner().invoke(
					"isAdminUporabnik", id);
		return response.getBoolean("result");
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageKategorija#createKategorija(DataObject kategorija)"
	 * of wsdl interface "ManageKategorija"	
	 */
	public void onCreateKategorijaResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageKategorija#readKategorija(Integer id)"
	 * of wsdl interface "ManageKategorija"	
	 */
	public void onReadKategorijaResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageKategorija#updateKategorija(DataObject kategorija)"
	 * of wsdl interface "ManageKategorija"	
	 */
	public void onUpdateKategorijaResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageKategorija#deleteKategorija(Integer id)"
	 * of wsdl interface "ManageKategorija"	
	 */
	public void onDeleteKategorijaResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageKategorija#listKategorija()"
	 * of wsdl interface "ManageKategorija"	
	 */
	public void onListKategorijaResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageDrzava#createDrzava(DataObject drzava)"
	 * of wsdl interface "ManageDrzava"	
	 */
	public void onCreateDrzavaResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageDrzava#readDrzava(Integer id)"
	 * of wsdl interface "ManageDrzava"	
	 */
	public void onReadDrzavaResponse(Ticket __ticket, DataObject returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageDrzava#updateDrzava(DataObject drzava)"
	 * of wsdl interface "ManageDrzava"	
	 */
	public void onUpdateDrzavaResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageDrzava#deleteDrzava(Integer id)"
	 * of wsdl interface "ManageDrzava"	
	 */
	public void onDeleteDrzavaResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageDrzava#listDrzava()"
	 * of wsdl interface "ManageDrzava"	
	 */
	public void onListDrzavaResponse(Ticket __ticket, DataObject returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageIzdelek#createIzdelek(DataObject izdelek)"
	 * of wsdl interface "ManageIzdelek"	
	 */
	public void onCreateIzdelekResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageIzdelek#readIzdelek(Integer id)"
	 * of wsdl interface "ManageIzdelek"	
	 */
	public void onReadIzdelekResponse(Ticket __ticket, DataObject returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageIzdelek#updateIzdelek(DataObject izdelek)"
	 * of wsdl interface "ManageIzdelek"	
	 */
	public void onUpdateIzdelekResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageIzdelek#deleteIzdelek(Integer id)"
	 * of wsdl interface "ManageIzdelek"	
	 */
	public void onDeleteIzdelekResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageIzdelek#listIzdelek()"
	 * of wsdl interface "ManageIzdelek"	
	 */
	public void onListIzdelekResponse(Ticket __ticket, DataObject returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#createUporabnik(DataObject uporabnik)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onCreateUporabnikResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#readUporabnik(Integer id)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onReadUporabnikResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#updateUporabnik(DataObject uporabnik)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onUpdateUporabnikResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#deleteUporabnik(Integer id)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onDeleteUporabnikResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#listUporabnik()"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onListUporabnikResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#loginUporabnik(DataObject uporabnik)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onLoginUporabnikResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#existsUporabnik(DataObject uporabnik)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onExistsUporabnikResponse(Ticket __ticket, Boolean returnValue,
			Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageUporabnik#isAdminUporabnik(Integer id)"
	 * of wsdl interface "ManageUporabnik"	
	 */
	public void onIsAdminUporabnikResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageProizvajalec#createProizvajalec(DataObject proizvajalec)"
	 * of wsdl interface "ManageProizvajalec"	
	 */
	public void onCreateProizvajalecResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageProizvajalec#readProizvajalec(Integer id)"
	 * of wsdl interface "ManageProizvajalec"	
	 */
	public void onReadProizvajalecResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageProizvajalec#updateProizvajalec(DataObject proizvajalec)"
	 * of wsdl interface "ManageProizvajalec"	
	 */
	public void onUpdateProizvajalecResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageProizvajalec#deleteProizvajalec(Integer id)"
	 * of wsdl interface "ManageProizvajalec"	
	 */
	public void onDeleteProizvajalecResponse(Ticket __ticket,
			Boolean returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

	/**
	 * Method generated to support the async implementation using callback
	 * for the operation "ManageProizvajalec#listProizvajalec()"
	 * of wsdl interface "ManageProizvajalec"	
	 */
	public void onListProizvajalecResponse(Ticket __ticket,
			DataObject returnValue, Exception exception) {
		//TODO Needs to be implemented.
	}

}