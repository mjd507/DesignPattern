package JavaSE_Senior.DesignPattern.JavaCodes.structural;

public class Proxy {
	public static void main(String[] args) {
		Women women = new WangPo();
		women.happyWithMan();
	}
}

interface Women{
	void happyWithMan();
}

class PanJinLian implements Women{

	@Override
	public void happyWithMan() {
		System.out.println("make love with ximenqi");
	}
	
}

class WangPo implements Women{
	private Women woman;
	
	public WangPo() {
		this.woman = new PanJinLian();
	}
	
	public WangPo(Women woman) {
		this.woman = woman;
	}

	@Override
	public void happyWithMan() {
		woman.happyWithMan();
	}
	
}