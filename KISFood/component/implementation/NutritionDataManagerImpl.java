package component.implementation;

import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.ibm.websphere.sca.ServiceManager;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class NutritionDataManagerImpl {
	/**
	 * Default constructor.
	 */
	public NutritionDataManagerImpl() {
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
	 * Method generated to support implementation of operation "getKalorije" defined for WSDL port type 
	 * named "NutritionDataManager".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 * @throws Exception 
	 */
	public Double getKalorije(String engName) throws Exception {
		
		Client c=new Client();
		WebResource wr=c.resource("http://api.esha.com/foods");
		MultivaluedMap<String, String> queryParams=new MultivaluedMapImpl();
		queryParams.add("apikey", "hjy4zrm2wrab78uvjdk9kb9j");
		queryParams.add("query", engName);
		String s=wr.queryParams(queryParams).get(String.class);

		JSONObject root=(JSONObject)JSONValue.parse(s);
		JSONArray items=(JSONArray)root.get("items");
		if(items.size()>0) {
			JSONObject product=(JSONObject)items.get(0);
			String productId=(String)product.get("id");
			
			JSONObject item=new JSONObject();
			item.put("id", productId);
			item.put("quantity", "100");
			item.put("unit", "urn:uuid:d3be684c-ebfa-4861-924f-8840600d1e84");
			JSONArray items2=new JSONArray();
			items2.add(item);
			JSONObject reqRoot=new JSONObject();
			reqRoot.put("items", items2);
			
			WebResource wr2=c.resource("http://api.esha.com/analysis");
			MultivaluedMap<String, String> queryParams2=new MultivaluedMapImpl();
			queryParams2.add("apikey", "hjy4zrm2wrab78uvjdk9kb9j");
			queryParams2.add("n", "urn:uuid:a4d01e46-5df2-4cb3-ad2c-6b438e79e5b9");
			String s2=wr2.queryParams(queryParams2).type("application/vnd.com.esha.data.Foods+json").post(String.class, reqRoot.toJSONString());
			
			JSONObject response=(JSONObject)JSONValue.parse(s2);
			JSONArray results=(JSONArray)response.get("results");
			JSONObject result=(JSONObject)results.get(0);
			if(result.get("value") instanceof Double) {
				return (Double) result.get("value");
			} else if(result.get("value") instanceof Long) {
				long resL=(Long) result.get("value");
				return (double) resL;
			}
			
		}
		return -1.0;
	}

}