package ifc;

import java.util.Map;

public abstract class ISourceTest implements ISource {
	public abstract void set(Map<IKey, String> map);

	public abstract void add(IKey key, String str);

	public abstract void remove(IKey key);

}
