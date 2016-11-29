package JavaSE_Senior.DesignPattern.JavaCodes.structural;

public class Facade {

	public static void main(String[] args) {
		//原始状态 途虎自己的卡片
		CarMaintenanceCard.refreshLingQuan();
		
		//设配阿里
		CarMaintenaceCardRefresher.isUseAliStyle =true;
		CarMaintenaceCardRefresher.refreshLingQuan();
		
		//自如切换到途虎
		CarMaintenaceCardRefresher.isUseAliStyle =false;
		CarMaintenaceCardRefresher.refreshLingQuan();
	}

}


/**
 * 背景：途虎与阿里合作，阿里 YunOs 的行车记录仪系统将 搭载 途虎养车 的车载应用
 * 途虎养车应用有两个桌面 widget，样式等都是由自己定义，开始都没什么问题
 * 后来，yunOs 车载系统 搭载的应用增多，阿里需要自己管理 widget 卡片风格，看我们途虎应用是如何调整的
 */

/**
 * 途虎应用 保养卡片
 */
class CarMaintenanceCard{
	public static void refreshLingQuan(){
		System.out.println("检查到了优惠券，刷新途虎自定义的优惠券页面");
	};
	public static void refreshSpecialState(){
		System.out.println("未检查到用户信息，刷新途虎自定义的提示用户登录页面");
	}
	public static void refreshMilesState(){
		System.out.println("用户距离上次保养已经又行驶了10000km了，刷新途虎自定义的里程状态页面");
	}
}

//------  阿里 YunOs 卡片增多，为同一卡片风格，需要自己管理卡片样式，但是逻辑还是途虎定义的逻辑

/**
 * 途虎应用为阿里进行了调整，增加了一个为阿里的保养卡片类
 */
class CarMaintenanceCardForAli{
	public static void refreshLingQuan(){
		System.out.println("检查到了优惠券，发送intent通知阿里刷新优惠券页面");
	};
	public static void refreshSpecialState(){
		System.out.println("未检查到用户信息，发送intent通知阿里刷新提示用户登录页面");
	}
	public static void refreshMilesState(){
		System.out.println("用户距离上次保养已经又行驶了10000km了，发送intent通知阿里刷新里程状态页面");
	}

}

//途虎应用在需要刷新卡片的点，采用门面模式，调用为阿里适配的保养卡片类, 这样原来的系统也不受到影响

/**
 * 汽车保养卡片的门面
 */
class CarMaintenaceCardRefresher{
	public static boolean isUseAliStyle = true;

	public static void refreshLingQuan(){
		if(isUseAliStyle){
			CarMaintenanceCardForAli.refreshLingQuan();
		}else{
			CarMaintenanceCard.refreshLingQuan();
		}
	};
	public static void refreshSpecialState(){
		if(isUseAliStyle){
			CarMaintenanceCardForAli.refreshSpecialState();
		}else{
			CarMaintenanceCard.refreshSpecialState();
		}
	}
	public static void refreshMilesState(){
		if(isUseAliStyle){
			CarMaintenanceCardForAli.refreshMilesState();
		}else{
			CarMaintenanceCard.refreshMilesState();
		}
	}

}




