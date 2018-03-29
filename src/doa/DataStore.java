package doa;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
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
	public String doPost(String uri, String reqXml) {
		HttpPost httpPost = new HttpPost(uri);
		httpPost.addHeader("Content-Type", "application/xml");
		StringEntity entity = null;
		try {
			entity = new StringEntity(reqXml, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpPost.setEntity(entity);
		return sendHttpPost(httpPost);
	}

	/**
	 * Private procedure of acting sent.
	 * 
	 * @param httpPost
	 *            HTTP Request URI
	 * @return HTTP Response
	 */
	private String sendHttpPost(HttpPost httpPost) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (httpClient != null)
					httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
}
