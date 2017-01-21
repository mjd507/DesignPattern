public class Visitor {

	public static void main(String[] args) {
		Books books = new Books("Android", 99);
		Toys toys = new Toys("Tom-Cat", 199);
		
		ShopCarVisitor visitor = new MyShopCar();
		
		books.accept(visitor);
		toys.accept(visitor);
		
	}

}

/**
 * 商品
 */
abstract class Goods{
	protected String name;
	protected int price;
	
	public Goods(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract void accept(ShopCarVisitor visitor);
}

class Books extends Goods{
	public Books(String name, int price) {
		super(name, price);
	}

	@Override
	public void accept(ShopCarVisitor visitor) {
		visitor.visit(this);
	}
}

class Toys extends Goods{

	public Toys(String name, int price) {
		super(name, price);
	}

	@Override
	public void accept(ShopCarVisitor visitor) {
		visitor.visit(this);
	}
	
}

/**
 * 购物车（访问者）
 */
interface ShopCarVisitor{
	void visit(Books books);
	void visit(Toys toys);
}

class MyShopCar implements ShopCarVisitor{

	@Override
	public void visit(Books books) {
		String str = "书名："+ books.name+", 价格："+ books.price;
		System.out.println("入手了 "+ str);
	}

	@Override
	public void visit(Toys toys) {
		String str = "玩具："+ toys.name+", 价格："+ toys.price;
		System.out.println("入手了 "+ str);
	}
	
}

