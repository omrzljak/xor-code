
package com.osmanmrzljak.tools.xorcoding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * testing XOREncoderDecoderTest
 * 
 * @author mrzlo00
 */
public class XOREncoderDecoderTest {

	@Test
	public void decode() {
		XOREncoderDecoder decoder = new XOREncoderDecoder();
		String decoded = decoder.decode("{xor}b2kzMjw6");
		assertEquals("encoded value should be equal", "06lmce", decoded);
	}

	@Test
	public void encode() {
		XOREncoderDecoder encoder = new XOREncoderDecoder();
		String encoded = encoder.encode("06lmce");
		assertEquals("encoded value should be equal", "{xor}b2kzMjw6", encoded);
	}

	@Test
	public void testSymetirc() {
		XOREncoderDecoder decode_encode = new XOREncoderDecoder();
		String input = "lpo67ik%dd";
		String result = decode_encode.decode(decode_encode.encode(input));
		assertEquals("shoud be same after encoding and decoding", input, result);
	}

}
