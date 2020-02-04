package com.bridgelabz.observer;

import java.util.*;

public class Product implements Subject 
{
	private List<Observer> observers = new ArrayList<Observer>();
	private String message;
	private boolean changed;
	@Override
	public void subscribe(Observer obj) 
	{
		if(obj==null)
			throw new NullPointerException("no observer");
		else
		{
			observers.add(obj);
		}
	}

	@Override
	public void unsubscribe(Observer obj) 
	{
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() 
	{
		for (Observer obj : observers) 
		{
			obj.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj)
	{
		return this.message;
	}
	public void postMessage(String msg)
	{
		System.out.println("Message Posted to observer:"+msg);
		this.message=msg;
		this.changed=true;
		System.out.println(this.changed);
		notifyObservers();
	}
	
}
