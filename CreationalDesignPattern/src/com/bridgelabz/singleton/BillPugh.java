package com.bridgelabz.singleton;

public class BillPugh {
	private BillPugh(){}
    
    private static class Helper{		//private inner static class 
        private static final BillPugh INSTANCE = new BillPugh();// This class is created only at the time of declaration
    }
    
    public static BillPugh getInstance(){
        return Helper.INSTANCE;
    }
}
