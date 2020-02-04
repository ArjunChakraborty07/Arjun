package Observer;

public class ObserverRunner 
{
	public static void main(String[] args) 
	{
		Product p=new Product();
		Observer obj1=new Subscriber("obj1");
		Observer obj2=new Subscriber("obj2");
		Observer obj3=new Subscriber("obj3");
		p.subscribe(obj1);
		p.subscribe(obj2);
		p.subscribe(obj3);
		
		//attach observer to subject
		obj1.setSubject(p);
		obj2.setSubject(p);
		obj3.setSubject(p);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		p.postMessage("New Message");
	}
}
