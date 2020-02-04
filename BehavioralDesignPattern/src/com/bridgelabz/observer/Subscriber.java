package com.bridgelabz.observer;

public class Subscriber implements Observer
{
	private String name;
	private Subject topic;
	
	public Subscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() 
	{
		String msg=(String) topic.getUpdate(this);
		if(msg==null)
			System.out.println(this.name+" no new updates");
		else
			System.out.println(this.name+" consuming message "+msg);
		
	}

	@Override
	public void setSubject(Subject sub) 
	{
		this.topic=sub;
	}
	
}
