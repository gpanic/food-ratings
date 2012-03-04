package foodratings.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class DataManagerProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private foodratings.client.DataManagerExport1DataManagerHttpService _service = null;
        private foodratings.client.DataManager _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new foodratings.client.DataManagerExport1DataManagerHttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (foodratings.client.DataManagerExport1DataManagerHttpService)ctx.lookup("java:comp/env/service/DataManagerExport1_DataManagerHttpService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new foodratings.client.DataManagerExport1DataManagerHttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getDataManagerExport1DataManagerHttpPort();
        }

        public foodratings.client.DataManager getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://KISFoodLib/DataManager", "DataManagerExport1_DataManagerHttpPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public DataManagerProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(true);
    }

    public DataManagerProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(true);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public Boolean createDrzava(Drzava drzava) {
        return _getDescriptor().getProxy().createDrzava(drzava);
    }

    public Drzava readDrzava(Integer id) {
        return _getDescriptor().getProxy().readDrzava(id);
    }

    public Boolean updateDrzava(Drzava drzava) {
        return _getDescriptor().getProxy().updateDrzava(drzava);
    }

    public Boolean deleteDrzava(Integer id) {
        return _getDescriptor().getProxy().deleteDrzava(id);
    }

    public Drzave listDrzava() {
        return _getDescriptor().getProxy().listDrzava();
    }

    public Boolean createIzdelek(Izdelek izdelek) {
        return _getDescriptor().getProxy().createIzdelek(izdelek);
    }

    public Izdelek readIzdelek(Integer id) {
        return _getDescriptor().getProxy().readIzdelek(id);
    }

    public Boolean updateIzdelek(Izdelek izdelek) {
        return _getDescriptor().getProxy().updateIzdelek(izdelek);
    }

    public Boolean deleteIzdelek(Integer id) {
        return _getDescriptor().getProxy().deleteIzdelek(id);
    }

    public Izdelki listIzdelek() {
        return _getDescriptor().getProxy().listIzdelek();
    }

    public Boolean createKategorija(Kategorija kategorija) {
        return _getDescriptor().getProxy().createKategorija(kategorija);
    }

    public Kategorija readKategorija(Integer id) {
        return _getDescriptor().getProxy().readKategorija(id);
    }

    public Boolean updateKategorija(Kategorija kategorija) {
        return _getDescriptor().getProxy().updateKategorija(kategorija);
    }

    public Boolean deleteKategorija(Integer id) {
        return _getDescriptor().getProxy().deleteKategorija(id);
    }

    public Kategorije listKategorija() {
        return _getDescriptor().getProxy().listKategorija();
    }

    public Boolean createProizvajalec(Proizvajalec proizvajalec) {
        return _getDescriptor().getProxy().createProizvajalec(proizvajalec);
    }

    public Proizvajalec readProizvajalec(Integer id) {
        return _getDescriptor().getProxy().readProizvajalec(id);
    }

    public Boolean updateProizvajalec(Proizvajalec proizvajalec) {
        return _getDescriptor().getProxy().updateProizvajalec(proizvajalec);
    }

    public Boolean deleteProizvajalec(Integer id) {
        return _getDescriptor().getProxy().deleteProizvajalec(id);
    }

    public Proizvajalci listProizvajalec() {
        return _getDescriptor().getProxy().listProizvajalec();
    }

    public Boolean createUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().createUporabnik(uporabnik);
    }

    public Uporabnik readUporabnik(Integer id) {
        return _getDescriptor().getProxy().readUporabnik(id);
    }

    public Boolean updateUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().updateUporabnik(uporabnik);
    }

    public Boolean deleteUporabnik(Integer id) {
        return _getDescriptor().getProxy().deleteUporabnik(id);
    }

    public Uporabniki listUporabnik() {
        return _getDescriptor().getProxy().listUporabnik();
    }

    public Uporabnik loginUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().loginUporabnik(uporabnik);
    }

    public Boolean existsUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().existsUporabnik(uporabnik);
    }

    public Boolean isAdminUporabnik(Integer id) {
        return _getDescriptor().getProxy().isAdminUporabnik(id);
    }

}