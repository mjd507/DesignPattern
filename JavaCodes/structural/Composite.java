package JavaSE_Senior.DesignPattern.JavaCodes.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {

	public static void main(String[] args) {
		//准备几个大润发超市
		Market lhMarket = new RTMarket("上海-莲花国际大润发购物中心");
		Market mlMarket = new RTMarket("上海-梅陇大润发购物中心");
		//准备一个管理超市的
		Market controler = new MarketControler("大润发管理中心");
		controler.add(lhMarket);
		controler.add(mlMarket);
		System.out.println(controler.MarketName +":开始统一检查了");
		controler.AliPay();
		System.out.println(controler.MarketName +":检查完毕了");

	}

}

/**
 * 超市
 */
abstract class Market{
	
	String MarketName;
	
	public abstract void add(Market m);
	
	public abstract void AliPay();
	
}

/**
 * 大润发(单个)
 */
class RTMarket extends Market{
	
	public RTMarket(String name) {
		this.MarketName = name;
	}

	@Override
	public void add(Market m) {
		//do nothing
	}

	@Override
	public void AliPay() {
		System.out.println(MarketName + ":使用了阿里支付");
	}
	
}

/**
 * 所以超市的管理者（组合）
 */
class MarketControler extends Market{
	private List<Market> marketList = new ArrayList<>();
	
	public MarketControler(String name) {
		this.MarketName = name;
	}


	@Override
	public void add(Market m) {
		marketList.add(m);
	}

	@Override
	public void AliPay() {
		for (Market market : marketList) {
			market.AliPay();
		}
	}
	
}