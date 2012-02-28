package foodratings.client.uporabnik;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class ManageUporabnikProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private foodratings.client.uporabnik.ManageUporabnikExport1ManageUporabnikHttpService _service = null;
        private foodratings.client.uporabnik.ManageUporabnik _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new foodratings.client.uporabnik.ManageUporabnikExport1ManageUporabnikHttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (foodratings.client.uporabnik.ManageUporabnikExport1ManageUporabnikHttpService)ctx.lookup("java:comp/env/service/ManageUporabnikExport1_ManageUporabnikHttpService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new foodratings.client.uporabnik.ManageUporabnikExport1ManageUporabnikHttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getManageUporabnikExport1ManageUporabnikHttpPort();
        }

        public foodratings.client.uporabnik.ManageUporabnik getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://KISFoodLib/ManageUporabnik", "ManageUporabnikExport1_ManageUporabnikHttpPort");
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

    public ManageUporabnikProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(true);
    }

    public ManageUporabnikProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(true);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
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

    public Boolean loginUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().loginUporabnik(uporabnik);
    }

    public Boolean existsUporabnik(Uporabnik uporabnik) {
        return _getDescriptor().getProxy().existsUporabnik(uporabnik);
    }

    public Boolean isAdminUporabnik(Integer id) {
        return _getDescriptor().getProxy().isAdminUporabnik(id);
    }

}