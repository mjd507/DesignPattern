package JavaSE_Senior.designPattern;

/**
 * 产品接口
 */
interface Balls{
	
}

/**
 * 具体产品
 */
class BasketBall implements Balls{
	public BasketBall() {
		System.out.println("篮球被生产了");
	}
}

class footBall implements Balls{
	public footBall() {
		System.out.println("足球被生产了");
	}
}

/**
 * 工厂接口
 */
interface Factory{
	Balls makeBalls();
}

/**
 * 具体工厂
 */
class BasketBallFactory implements Factory{

	@Override
	public Balls makeBalls() {
		return new BasketBall();
	}
}

class FootBallFactory implements Factory{

	@Override
	public Balls makeBalls() {
		return new footBall();
	}
}

public class FactoryMethod {
	public static void main(String[] args) {
		Factory factory = new FootBallFactory();
		factory.makeBalls();
	}
}


