package JavaSE_Senior.DesignPattern.JavaCodes;

public class Decorator {
	public static void main(String[] args) {
		House house = new MyHouse();
		HouseDecorator decorator = new HouseDecorator(house);
		decorator.build();
		decorator.design();
		decorator.futureServices();
	}
}

interface House{
	void build(); 
	void design(); 
}

class MyHouse implements House{

	@Override
	public void build() {
		System.out.println("我的房子得有三室一厅...");
	}

	@Override
	public void design() {
		System.out.println("我的房子要装修成这样....");
	}
}

/**
 * 装饰者：专注房屋装修
 */
class HouseDecorator implements House{
	private House house;
	public HouseDecorator(House house){
		this.house = house;
	}

	@Override
	public void build() {
		System.out.println("构造前，专业团队先分析一下....");
		house.build();
		System.out.println("构造后，专业团队再检验一下....");
	}

	@Override
	public void design() {
		System.out.println("装修前，专业团队先分析一下....");
		house.design();
		System.out.println("装修后，专业团队再检验一下....");
	}
	
	//我们装修者还提供了售后服务
	public void futureServices(){
		System.out.println("3年以内任何问题，免费上门服务");
	}
}

