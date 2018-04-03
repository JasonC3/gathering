package service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import ifc.IKey;
import ifc.ISource;
import ifc.ISourceTest;

public class GatherZhihu extends ISourceTest implements ISource {
	private Map<IKey, String> content;
	private URL url;
	private int magnitude;
	private int serial;

	public GatherZhihu() {
		content = new HashMap<IKey, String>();
		magnitude = 1;
		serial = -1;
	}

	@Override
	public void set(Map<IKey, String> map) {
		content.clear();
		content.putAll(map);
		int l = 0;
		for (String s : content.values()) {
			l += s.length();
		}
		magnitude = (int) (Math.log(l)) + 1;
	}

	@Override
	public void add(IKey key, String str) {
		content.put(key, str);
		magnitude = (int) (Math.max(magnitude, Math.log(str.length())) + 1);
	}

	@Override
	public void remove(IKey key) {
		magnitude -= Math.log(content.get(key).length());
		if (magnitude < 1)
			magnitude = 1;
		content.remove(key);
	}

	@Override
	public int getSerial() {
		// TODO Auto-generated method stub
		return serial;
	}

	@Override
	public Map<IKey, String> get() {
		// TODO Auto-generated method stub
		return content;
	}

	@Override
	public int gather(String url) {
		// TODO Auto-generated method stub
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// URL invalid protocal
			return STAT_INVALID_URL;
		} catch (Exception e) {
			return STAT_UNKNOWED_ERR;
		}
		this.url.getHost();
		return STAT_DONE;
	}

	@Override
	public int getMagnitude() {
		// TODO Auto-generated method stub
		return magnitude;
	}

}
