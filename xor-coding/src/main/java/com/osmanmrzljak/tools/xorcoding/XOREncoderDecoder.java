
package com.osmanmrzljak.tools.xorcoding;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * XOR encoding and decoding
 * 
 * @author mrzlo00
 */
public class XOREncoderDecoder {
	/**
	 * key used in Websphere Application Server tools
	 */
	private static final char KEY = '_';
	public static final String XOR_PREFIX = "{xor}";

	/**
	 * decodes xor encoded string
	 * 
	 * @param encodeValue
	 * @return if encodeValue is empty than null otherwise xor decoded string
	 */
	public String decode(String encodeValue) {
		if (isEmpty(encodeValue)) {
			return null;
		}

		String base64 = substringAfter(encodeValue, XOR_PREFIX);
		byte[] bytesXor = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.ISO_8859_1));

		return new String(xorBytes(bytesXor), StandardCharsets.ISO_8859_1);
	}

	/**
	 * @param from
	 * @param separator
	 * @return
	 */
	private String substringAfter(String from, String separator) {

		if (isEmpty(from)) {
			return from;
		}
		if (separator == null) {
			return "";
		}
		final int pos = from.indexOf(separator);
		if (pos == -1) {
			return "";
		}
		return from.substring(pos + separator.length());
	}

	/**
	 * To avoid dependency from apache commons we implement it self.
	 * 
	 * @param val
	 * @return
	 */
	private boolean isEmpty(String val) {
		return val == null || val.length() == 0;
	}

	/**
	 * encodes with xor key '_' (like websphere does)
	 * 
	 * @param decodedValue
	 *            plain string
	 * @return encoded value if decodedValue is not empty otehrwise a null
	 */
	public String encode(String decodedValue) {
		if (isEmpty(decodedValue)) {
			return null;
		}
		byte[] decodedBytes = decodedValue.getBytes(StandardCharsets.ISO_8859_1);
		byte[] encodedBytes = Base64.getEncoder().encode(xorBytes(decodedBytes));
		return XOR_PREFIX + new String(encodedBytes, StandardCharsets.ISO_8859_1);
	}

	/**
	 * executes xor with Key on any byte array
	 * 
	 * @param decodedValue
	 * @return
	 */
	private byte[] xorBytes(byte[] toXor) {

		byte[] xorBytes = new byte[toXor.length];

		for (int i = 0; i < toXor.length; i++) {
			xorBytes[i] = (byte) (toXor[i] ^ KEY);
		}
		return xorBytes;
	}

}
