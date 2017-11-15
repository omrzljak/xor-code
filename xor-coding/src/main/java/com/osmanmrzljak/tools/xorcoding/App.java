package com.osmanmrzljak.tools.xorcoding;

/**
 * Hello world!
 *
 */
public class App {
	private static final String DECODE = "decode";
	private static final String ENCODE = "encode";

	public static void main(String[] args) {
		if (args.length < 2) {
			usage();
		}
		String mode = args[0];
		String value = args[1];
		String result = null;
		XOREncoderDecoder coder = new XOREncoderDecoder();
		if (ENCODE.equals(mode)) {
			result = coder.encode(value);
		}
		if (DECODE.equals(mode)) {
			result = coder.decode(value);
		}
		System.out.println(String.format("Result of %s is %s", mode, result));

	}

	private static void usage() {
		System.err.println("Wrong usage: XOREncoderDecoder");
		System.err.println(String.format("XOREncoderDecoder <%s|%s> value", DECODE, ENCODE));
		System.exit(1);
	}
}
