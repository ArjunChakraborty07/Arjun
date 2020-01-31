package com.bridgelabz.singleton;

public class Test {
		public static void main(String[] args) {
			Eager obj=Eager.getInstance();
			Eager obj2=Eager.getInstance();
			System.out.println(obj+" "+obj2);
			BillPugh bp=BillPugh.getInstance();
			System.out.println(bp);
			Lazy l=Lazy.getInstance();
			System.out.println(l);
			StaticBlock s=StaticBlock.getInstance();
			System.out.println(s);
			System.out.println(ThreadSafe.getInstance());
			System.out.println(SerializedSingleton.getInstance());
			System.out.println(EnumSingleton.INSTANCE);
			Reflection.main(args);
		}
}
