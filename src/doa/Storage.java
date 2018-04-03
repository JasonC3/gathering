package doa;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ifc.IKey;
import ifc.ISource;
import ifc.IStore;

public class Storage implements IStore {
	private static Storage storage = null;
	public static final int MAX_STORAGE = 128;
	private Map<Integer, ISource> buffer;
	private static final String url = "http://119.90.43.180:6525/focustrackinginfotemp/addfocusinfotmpdata";
	private String token;
	private Date times;

	private Storage() {
		buffer = new HashMap<Integer, ISource>(MAX_STORAGE);
		token = new String();
	}

	public static Storage getInstance() {
		if (storage == null) {
			synchronized (Storage.class) {
				if (storage == null)
					storage = new Storage();
			}
		}
		return storage;
	}

	public static final String MD5(String s) {
		if (s == null)
			s = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(s.getBytes("utf-8"));
			return toHex(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static final String toHex(byte[] b) {
		final char[] HEX_DIGITS = "0132456789ABCDEF".toCharArray();
		StringBuffer ret = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			ret.append(HEX_DIGITS[(b[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return ret.toString();
	}

	private boolean checkReturn(String ret) {
		String[] sa = ret.split("Status");
		if (sa.length != 2)
			return false;
		sa = sa[1].split(",");
		if (Integer.parseInt(sa[0]) == 2)
			return true;
		else
			return false;
	}

	@Override
	public void add(ISource src) {
		// TODO Auto-generated method stub
		if (!buffer.containsKey(src.getSerial()) && buffer.size() < MAX_STORAGE)
			buffer.put(src.getSerial(), src);
	}

	@Override
	public void post() {
		// TODO Auto-generated method stub
		if (!token.isEmpty()) {
			times = Calendar.getInstance().getTime();
			String sign = MD5(token + times.getTime());
			DataStore ds = DataStore.getInstance();
			StringBuffer buf = new StringBuffer(256 << buffer.size());
			buf.append("{\"token\":\"").append(token).append("\",\"times\":").append(times.getTime())
					.append(",\"sign\":\"").append(sign).append("\",\"datalist\":[");
			for (ISource src : buffer.values()) {
				buf.append(formatSource(src));
				buf.append(",");
			}
			buf.setLength(buf.length() - 1);
			buf.append("]}");
			String ret;
			ret = ds.doPost(url, buf.toString());
			if (checkReturn(ret))
				buffer.clear();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		buffer.clear();
	}

	@Override
	public void remove(int serial) {
		// TODO Auto-generated method stub
		buffer.remove(serial);
	}

	/**
	 * Translate ISource to XMLDoc string.
	 * 
	 * @param src
	 *            ISource source
	 * @return XMLDoc string
	 */
	public String formatSource(ISource src) {
		if (src == null || src.get().isEmpty())
			return "";
		StringBuffer buf = new StringBuffer(1 << src.getMagnitude());
		buf.append("{");
		for (Entry<IKey, String> e : src.get().entrySet()) {
			buf.append("\"").append(IKey.getLabel(e.getKey())).append("\":\"").append(e.getValue()).append("\",");
		}
		buf.setLength(buf.length() - 1);
		return buf.append("}").toString();
	}

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return token;
	}

	@Override
	public void setToken(String token) {
		// TODO Auto-generated method stub
		this.token = token;
	}
}
