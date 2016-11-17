package JavaSE_Senior.designPattern;

public class BuilderPattern {

	public static void main(String[] args) {
		CarBuilder builder = new TuHuCarBuilder();
		CarProvider carProvider = new CarProvider(builder);
		carProvider.getCar();
	}
}

class CarProvider{
	private CarBuilder builder;
	
	public CarProvider(CarBuilder builder){
		this.builder = builder;
	}
	
	public Car getCar(){
		Car car = builder.buildFDJ().buildLunTai().buildWaiGuan().build();
		return car;
	}
	
}


interface CarBuilder{
	CarBuilder buildFDJ();
	CarBuilder buildLunTai();
	CarBuilder buildWaiGuan() ;
	Car build();
}

class TuHuCarBuilder implements CarBuilder{
	private TuHuCar car = new TuHuCar();

	@Override
	public CarBuilder buildFDJ() {
		System.out.println("设置了途虎发动机");
		return this;
	}

	@Override
	public CarBuilder buildLunTai() {
		System.out.println("设置了途虎轮胎");
		return this;
	}

	@Override
	public CarBuilder buildWaiGuan() {
		System.out.println("设置了途虎汽车造型");
		return this;
	}

	@Override
	public Car build() {
		System.out.println("汽车构造完成");
		return car;
	}

}

interface Car{
	void setFDJ();
	void setLunTai();
	void setWaiGuan();
}

class TuHuCar implements Car{

	@Override
	public void setFDJ() {
	}

	@Override
	public void setLunTai() {
	}

	@Override
	public void setWaiGuan() {
	}

}

