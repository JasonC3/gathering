package ifc;

/**
 * Define the store factor.<br>
 * Step 1: add <code>ISource</code> to <i>buffer</i>;<br>
 * Step 2: post all data from buffer.
 * 
 * @author Jason Chen
 * @version 0.10a 3/29/18
 */
public interface IStore {
	/**
	 * Add the data to buffer, if not exists the serial.
	 * 
	 * @param src
	 *            the data would be added
	 */
	public void add(ISource src);

	/**
	 * Remove the data at key marked <i>'serial'</i>.
	 * 
	 * @param serial
	 *            key of ISource
	 */
	public void remove(int serial);

	/**
	 * Sent data to Storage.
	 */
	public void post();

	/**
	 * Remove of all data.
	 */
	public void clear();

	/**
	 * Get the token.
	 * 
	 * @return Token
	 */
	public String getToken();

	/**
	 * Set the token.
	 * 
	 * @param token
	 */
	public void setToken(String token);
}
