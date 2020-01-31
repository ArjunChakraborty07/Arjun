package com.bridgelabz.singleton;

public class StaticBlock {
	private static StaticBlock instance = new StaticBlock();

	private StaticBlock() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlock();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlock getInstance() {
		return instance;
	}
}
