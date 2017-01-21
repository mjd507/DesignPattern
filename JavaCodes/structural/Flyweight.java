import java.util.HashMap;
import java.util.Map;

public class Flyweight {

	public static void main(String[] args) {
		AbsFlyWeight flyWeight = FlyWeightFactory.getFlyWeight("a");
		flyWeight.operation();
		AbsFlyWeight flyWeight2 = FlyWeightFactory.getFlyWeight("a");
		flyWeight2.operation();
	}
}

class FlyWeightFactory{
	private static Map<String, AbsFlyWeight> map = new HashMap<String, AbsFlyWeight>();

	public static AbsFlyWeight getFlyWeight(String str){
		AbsFlyWeight flyWeight = map.get(str);
		if(flyWeight == null){
			flyWeight = new ConcreteFlyWeight(str);
			map.put(str, flyWeight);
		}
		return flyWeight;
	}
}

abstract class AbsFlyWeight{
	abstract void operation();
}

class ConcreteFlyWeight extends AbsFlyWeight{

	private String intrinsicStr; //内部的字符串

	public ConcreteFlyWeight(String str) {
		this.intrinsicStr = str;
		System.out.println( intrinsicStr + " 被创建了");
	}

	@Override
	void operation() {
		System.out.println("ConcreteFlyWeight str = " + intrinsicStr);
	}

}