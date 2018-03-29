package doa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ifc.IKey;
import ifc.ISource;
import ifc.IStore;

public class Storage implements IStore {
	private static Storage storage = null;
	public static final int MAX_STORAGE = 128;
	private Map<Integer, ISource> buffer;
	private String url;

	private Storage() {
		buffer = new HashMap<Integer, ISource>(MAX_STORAGE);
		url = "https://localhost/?uploadid=";
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

	@Override
	public void add(ISource src) {
		// TODO Auto-generated method stub
		if (!buffer.containsKey(src.getSerial()) && buffer.size() < MAX_STORAGE)
			buffer.put(src.getSerial(), src);
	}

	@Override
	public void post() {
		// TODO Auto-generated method stub
		DataStore ds = DataStore.getInstance();
		List<Integer> done = new ArrayList<Integer>(buffer.size());
		for (ISource src : buffer.values())
			if (ds.doPost(url + src.getSerial(), formatSource(src)).equals(""))
				// Successfully Posted
				done.add(src.getSerial());
		for (int i : done)
			buffer.remove(i);
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
		StringBuffer buf = new StringBuffer("<gather>");
		for (Entry<IKey, String> e : src.get().entrySet()) {
			buf.append("<").append(IKey.getLabel(e.getKey())).append(">").append(e.getValue()).append("</")
					.append(IKey.getLabel(e.getKey())).append(">");
		}
		return buf.append("</gather>").toString();
	}
}
