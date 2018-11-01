package des.pat;

public class RedheadDuck implements Quackable {
	Observable observable;

	public RedheadDuck () {
		observable = new Observable (this);
	}

	public void quack () {
		System.out.println ("RedheadDuck Quack");
		notifyObservers ();
	}

	public void registerObserver (Observer observer) {
		observable.registerObserver (observer);
	}

	public void notifyObservers () {
		observable.notifyObservers ();
	}

	public String toString () {
		return "Redhead Duck";
	}
}