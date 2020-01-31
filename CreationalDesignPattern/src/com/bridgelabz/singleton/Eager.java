package com.bridgelabz.singleton;

public class Eager {
	private static final Eager instance = new Eager();

	Eager() {
	}

	public static Eager getInstance() {
		return instance;
	}
}
