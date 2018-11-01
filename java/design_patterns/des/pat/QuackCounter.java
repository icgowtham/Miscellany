package des.pat;

/* Decorator Class */
public class QuackCounter implements Quackable {
	Observable observable;
	Quackable duck;
	static int numberOfQuacks;

	public QuackCounter (Quackable duck) {
		this.duck = duck;
		observable = new Observable (this);
	}

	public void quack () {
		duck.quack ();
		numberOfQuacks++;
		notifyObservers ();
	}

	public void registerObserver (Observer observer) {
		observable.registerObserver (observer);
	}

	public void notifyObservers () {
		observable.notifyObservers ();
	}
	public static int getQuacks () {
		return numberOfQuacks;
	}

	public String toString () {
		return "QuackCounter->" + duck.toString ();
	}
}