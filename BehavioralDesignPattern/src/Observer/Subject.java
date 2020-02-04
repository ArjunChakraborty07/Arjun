package Observer;

public interface Subject 
{
	public void subscribe(Observer obj);
	public void unsubscribe(Observer obj);
	public void notifyObservers();
	public Object getUpdate(Observer obj);
}
