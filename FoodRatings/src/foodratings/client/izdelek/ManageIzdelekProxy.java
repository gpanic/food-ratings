package foodratings.client.izdelek;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class ManageIzdelekProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private foodratings.client.izdelek.ManageIzdelekExport1ManageIzdelekHttpService _service = null;
        private foodratings.client.izdelek.ManageIzdelek _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new foodratings.client.izdelek.ManageIzdelekExport1ManageIzdelekHttpService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (foodratings.client.izdelek.ManageIzdelekExport1ManageIzdelekHttpService)ctx.lookup("java:comp/env/service/ManageIzdelekExport1_ManageIzdelekHttpService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new foodratings.client.izdelek.ManageIzdelekExport1ManageIzdelekHttpService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getManageIzdelekExport1ManageIzdelekHttpPort();
        }

        public foodratings.client.izdelek.ManageIzdelek getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://KISFoodLib/ManageIzdelek", "ManageIzdelekExport1_ManageIzdelekHttpPort");
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

    public ManageIzdelekProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(true);
    }

    public ManageIzdelekProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(true);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
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

}