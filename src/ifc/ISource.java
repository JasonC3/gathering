package ifc;

import java.util.Map;

/**
 * Define the gathering container.<br>
 * Step 1: gather data from web;<br>
 * Step 2: return the datum by <code>IKey</code>.
 * 
 * @author Jason Chen
 * @version 0.10a 3/29/18
 */
public interface ISource {
	public static final int STAT_INVALID_URL = -1;
	public static final int STAT_UNKNOWED_ERR = -2;
	public static final int STAT_TIMEOUT = -4;
	public static final int STAT_DONE = 2;

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
	 * Gather from the uniform resource locator.
	 * 
	 * @param url
	 *            hyper-reference
	 */
	public int gather(String url);

	/**
	 * Get the estimate size of data.
	 * 
	 * @return Order of magnitude, power of 2
	 */
	public int getMagnitude();
}
