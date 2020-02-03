package com.bridgelabz.factory;

public class ComputerFactory {

	public void call(String input) {
		if (input.equalsIgnoreCase("server")) {
			Server obj = new Server();
			obj.developer();
		}
		if (input.equalsIgnoreCase("PC")) {
			PC obj = new PC();
			obj.developer();
		}
	}
}
