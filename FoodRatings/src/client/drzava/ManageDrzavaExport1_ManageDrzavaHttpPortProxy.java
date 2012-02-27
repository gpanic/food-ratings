package client.drzava;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class ManageDrzavaExport1_ManageDrzavaHttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private client.drzava.ManageDrzavaExport1ManageDrzavaHttpService _service = null;
        private client.drzava.ManageDrzava _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new client.drzava.ManageDrzavaExport1ManageDrzavaHttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (client.drzava.ManageDrzavaExport1ManageDrzavaHttpService)ctx.lookup("java:comp/env/service/ManageDrzavaExport1_ManageDrzavaHttpService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new client.drzava.ManageDrzavaExport1ManageDrzavaHttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getManageDrzavaExport1ManageDrzavaHttpPort();
        }

        public client.drzava.ManageDrzava getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://KISFoodLib/ManageDrzava", "ManageDrzavaExport1_ManageDrzavaHttpPort");
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

    public ManageDrzavaExport1_ManageDrzavaHttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(true);
    }

    public ManageDrzavaExport1_ManageDrzavaHttpPortProxy(URL wsdlLocation, QName serviceName) {
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

}