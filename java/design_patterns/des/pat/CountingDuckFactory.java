package des.pat;

public class CountingDuckFactory extends AbstractDuckFactory {
	public Quackable createRedheadDuck () {
		return new QuackCounter (new RedheadDuck ());
	}

	public Quackable createMallardDuck () {
		return new QuackCounter (new MallardDuck ());
	}
}