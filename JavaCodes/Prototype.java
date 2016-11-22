package JavaSE_Senior.DesignPattern.JavaCodes;

public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		TuHUCarProto carProto = new TuHUCarProto();
		TuHUCarProto clone = (TuHUCarProto) carProto.clone();
		clone.show();
		System.out.println(carProto == clone);
	}
}


class CarProto implements Cloneable{  
	
	@Override
	public CarProto clone()  {
		CarProto clone = null;
		try {
			clone = (CarProto)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}  

class TuHUCarProto extends CarProto{
	public void show(){
		System.out.println("this is a tuhu car proto");
	}
}

