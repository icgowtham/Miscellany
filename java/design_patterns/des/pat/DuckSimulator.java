package des.pat;

public class DuckSimulator {
	public static void main (String[] args) {
		AbstractDuckFactory duckFactory = new CountingDuckFactory ();
		DuckSimulator simulator = new DuckSimulator ();
		simulator.simulate (duckFactory);
	}

	void simulate (AbstractDuckFactory duckFactory) {
		Quackable redheadDuck = duckFactory.createRedheadDuck ();
		Quackable mallardDuck = duckFactory.createMallardDuck ();

		Quackologist quackologist = new Quackologist ();
		redheadDuck.registerObserver (quackologist);

		simulate (redheadDuck);
		simulate (mallardDuck);

		System.out.println ("Ducks quacked " + QuackCounter.getQuacks () + " times.");
	}

	void simulate (Quackable duck) {
		duck.quack ();
	}
}