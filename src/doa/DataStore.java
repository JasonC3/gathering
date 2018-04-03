package doa;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Singleton of stored instance, use for HTTP POST.
 * 
 * @author Jason Chen
 * @version 0.10a 3/30/18
 */
public class DataStore {
	private static DataStore dataStore = null;

	private DataStore() {
	}

	public static DataStore getInstance() {
		if (dataStore == null) {
			synchronized (DataStore.class) {
				if (dataStore == null)
					dataStore = new DataStore();
			}
		}
		return dataStore;
	}

	/**
	 * Acting sent.
	 * 
	 * @param uri
	 *            hyper-reference
	 * @param reqXml
	 *            XMLDoc string
	 * @return HTTP Response
	 */
	public String doPost(String url, String data) {
		HttpPost req = new HttpPost(url);
		req.addHeader("Content-Type", "text/json");
		StringEntity entity = null;
		try {
			entity = new StringEntity(data, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setEntity(entity);
		return sendHttpRequest(req);
	}
	
	public String doGet(String url) {
		HttpGet req=new HttpGet(url);
		return sendHttpRequest(req);
	}

	/**
	 * Private procedure of acting sent.
	 * 
	 * @param httpPost
	 *            HTTP Request URI
	 * @return HTTP Response
	 */
	private String sendHttpRequest(HttpUriRequest request) {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String content = null;
		try {
			client = HttpClients.createDefault();
			response = client.execute(request);
			entity = response.getEntity();
			content = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
}
