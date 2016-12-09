package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

public class Mediator {

	public static void main(String[] args) {
		//初始化 一个 中介者 chatRoom
		ChatRoom chatRoom = new TencentChatRoom();
		//初始化 两个 同事 norMember VIPMember
		Member norMember = new NormalMember();
		Member VIPMember = new VIPMember();

		// 两个 同事 设置 同一个 中介者
		norMember.setChatRoom(chatRoom);
		VIPMember.setChatRoom(chatRoom);

		// norMember 同事 通过 chatRoom 发送消息，VIPMember 通过 chatRoom 接受消息
		norMember.sendMsg();
		String norMsg = chatRoom.getMessage();
		VIPMember.receiveMsg(norMsg);

		// VIPMember 同事 通过 chatRoom 发送消息，norMember 通过 chatRoom 接受消息
		VIPMember.sendMsg();
		String VIPMsg = chatRoom.getMessage();
		norMember.receiveMsg(VIPMsg);

	}

}

/**
 * 聊天室
 */
interface ChatRoom{
	void sendMessage(String msg);
	String getMessage();
}

/**
 * 腾讯聊天室
 */
class TencentChatRoom implements ChatRoom{
	private String msg;

	@Override
	public void sendMessage(String msg) {
		this.msg = msg;
		System.out.println(msg);
	}


	@Override
	public String getMessage() {
		return msg;
	}

}

/**
 * 用户
 */
interface Member{
	void setChatRoom(ChatRoom chatRoom);
	void sendMsg();
	void receiveMsg(String msg);

}

/**
 * 普通用户
 */
class NormalMember implements Member{
	private ChatRoom chatRoom;

	@Override
	public void setChatRoom(ChatRoom mediator) {
		this.chatRoom = mediator;
	}

	@Override
	public void sendMsg() {
		String msg = "你们好，我是该聊天室的普通成员，请大家多多关照！";
		chatRoom.sendMessage(msg);
	}

	@Override
	public void receiveMsg(String msg) {
		String str = chatRoom.getMessage();
		System.out.println("普通用户收到了消息："+ str);
	}

}

/**
 * VIP 用户
 */
class VIPMember implements Member{
	private ChatRoom chatRoom;

	@Override
	public void setChatRoom(ChatRoom mediator) {
		this.chatRoom = mediator;
	}

	@Override
	public void sendMsg() {
		String msg = "你们好，我是该聊天室的 VIP 成员，有问题可以问我！";
		chatRoom.sendMessage(msg);
	}

	@Override
	public void receiveMsg(String msg) {
		String str = chatRoom.getMessage();
		System.out.println("VIP 用户收到了消息："+ str);
	}

}


