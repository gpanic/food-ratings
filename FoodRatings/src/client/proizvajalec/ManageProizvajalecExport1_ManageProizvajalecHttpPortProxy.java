package client.proizvajalec;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class ManageProizvajalecExport1_ManageProizvajalecHttpPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private client.proizvajalec.ManageProizvajalecExport1ManageProizvajalecHttpService _service = null;
        private client.proizvajalec.ManageProizvajalec _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new client.proizvajalec.ManageProizvajalecExport1ManageProizvajalecHttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (client.proizvajalec.ManageProizvajalecExport1ManageProizvajalecHttpService)ctx.lookup("java:comp/env/service/ManageProizvajalecExport1_ManageProizvajalecHttpService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new client.proizvajalec.ManageProizvajalecExport1ManageProizvajalecHttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getManageProizvajalecExport1ManageProizvajalecHttpPort();
        }

        public client.proizvajalec.ManageProizvajalec getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://KISFoodLib/ManageProizvajalec", "ManageProizvajalecExport1_ManageProizvajalecHttpPort");
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

    public ManageProizvajalecExport1_ManageProizvajalecHttpPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(true);
    }

    public ManageProizvajalecExport1_ManageProizvajalecHttpPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(true);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
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

}