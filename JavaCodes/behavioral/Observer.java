import java.util.Vector;

public class Observer {
	public static void main(String[] args) {
		WeChatSubscriber personA = new PersonA();
		WeChatSubjectPublisher publisher = new NBAPublisher();
		publisher.addUser(personA);
		publisher.operation();
		String content = personA.getContent();
		System.out.println(content);
	}
}

/**
 * 微信公众号订阅者
 */
interface  WeChatSubscriber{
	String update(String content);
	String getContent();
}

class PersonA implements WeChatSubscriber{

	private String content;
	
	@Override
	public String update(String content) {
		this.content = content;
		return content;
	}
	
	@Override
	public String getContent(){
		return content;
	}
}


/**
 * 微信公众号主题发布者
 */
interface WeChatSubjectPublisher{
	void addUser(WeChatSubscriber subscriber);
	void delUser(WeChatSubscriber subscriber);
	void notifyUser(String content);
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
	public void notifyUser(String content){
		for (WeChatSubscriber weChatSubscriber : subscribersList) {
			weChatSubscriber.update(content);
		}
	}
}

class NBAPublisher extends Subject{

	@Override
	public void operation() {
		String content = "勇士 VS 骑士，猛戳直播地址";
		notifyUser(content);
	}


}

