package JavaSE_Senior.DesignPattern.JavaCodes;

import java.util.Vector;

public class Observer {
	public static void main(String[] args) {
		WeChatSubscriber personA = new PersonA();
		WeChatSubjectPublisher publisher = new NBAPublisher();
		publisher.addUser(personA);
		publisher.operation();
		publisher.notifyUser();
	}
}

/**
 * 微信公众号订阅者
 */
interface  WeChatSubscriber{
	String update();
}

class PersonA implements WeChatSubscriber{

	@Override
	public String update() {
		return null;
	}
}


/**
 * 微信公众号主题发布者
 */
interface WeChatSubjectPublisher{
	void addUser(WeChatSubscriber subscriber);
	void delUser(WeChatSubscriber subscriber);
	void notifyUser();
	void operation();
}

/**
 * 抽象主题，封装添加用户，删除用户，通知用户的公共方法
 */
abstract class Subject implements WeChatSubjectPublisher{
	private Vector<WeChatSubscriber> subscribersList = new Vector<>();

	@Override
	public void addUser(WeChatSubscriber subscriber) {
		subscribersList.add(subscriber);
	}

	@Override
	public void delUser(WeChatSubscriber subscriber) {
		subscribersList.remove(subscriber);
	}

	@Override
	public void notifyUser(){
		for (WeChatSubscriber weChatSubscriber : subscribersList) {
			weChatSubscriber.update();
		}
	}
}

class NBAPublisher extends Subject{

	@Override
	public void operation() {
		System.out.println("勇士 VS 骑士，猛戳直播地址");
		notifyUser();
	}


}

