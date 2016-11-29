package JavaSE_Senior.DesignPattern.JavaCodes.creational;

public class FactoryAbstract {
	public static void main(String[] args) {
		AbsFactory factory = new NikeFactory();
		factory.makeBalls();
		factory.makeShoes();
	}
}

/**
 * 产品接口
 */
interface AbsBalls{

}
interface AbsShoes{

}

/**
 * 具体产品
 */
class NikeBall implements AbsBalls{
	public NikeBall() {
		System.out.println("Nike篮球被生产了");
	}
}
class NikeShoes implements AbsShoes{
	public NikeShoes() {
		System.out.println("Nike鞋被生产了");
	}
}

/**
 * 工厂接口
 */
interface AbsFactory{
	AbsBalls makeBalls();
	AbsShoes makeShoes();
}

/**
 * 具体工厂
 */
class NikeFactory implements AbsFactory{

	@Override
	public AbsBalls makeBalls() {
		return new NikeBall();
	}

	@Override
	public AbsShoes makeShoes() {
		return new NikeShoes();
	}
}



