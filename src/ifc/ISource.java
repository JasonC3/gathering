package ifc;

import java.io.Serializable;
import java.util.Map;

/**
 * Define the gathering container.<br>
 * Step 1: gather data from web;<br>
 * Step 2: return the datum by <code>IKey</code>.
 * 
 * @author Jason Chen
 * @version 0.10a 3/29/18
 */
public interface ISource extends Serializable {
	/**
	 * Serialized it.
	 * 
	 * @return Identity
	 */
	public int getSerial();

	/**
	 * Get the whole informations.
	 * 
	 * @return Map of label & content pairs.
	 */
	public Map<IKey, String> get();

	/**
	 * Gather from the hyper-reference <i>'src'</i>.
	 * 
	 * @param src
	 *            hyper-reference
	 */
	public void gather(String src);
}
