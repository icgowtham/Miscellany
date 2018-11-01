package des.pat;

public class DuckFactory extends AbstractDuckFactory {
	public Quackable createRedheadDuck () {
		return new RedheadDuck ();
	}

	public Quackable createMallardDuck () {
		return new MallardDuck ();
	}
}