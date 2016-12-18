package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

public class Memento {

	public static void main(String[] args) {
		Message msg = new Message("原始短信");
		System.out.println("短信的状态为："+ msg.getState());
		
		//备份短信
		MementoMsg mementoMsg = msg.createMsg();
		StorageMsg storageMsg = new StorageMsg(mementoMsg);
		
		//更改短信状态
		msg.setState("编辑后的短信");
		System.out.println("短信的状态为："+ msg.getState());
		
		//查看备份短信的状态
		MementoMsg recoverMsg = storageMsg.getMsg();
		System.out.println("短信的状态为："+ recoverMsg.getState());
	}
}

class Message{
	private String state;  
	  
    public Message(String state) {  
        this.state = state;  
    }  
  
    public String getState() {  
        return state;  
    }  
  
    public void setState(String state) {  
        this.state = state;  
    }  
  
    //创建备忘录
    public MementoMsg createMsg() {  
        return new MementoMsg(state);  
    }  
  
}

//备份的 bean
class MementoMsg {  
    private String state;  
  
    public MementoMsg(String state) {  
        this.state = state;  
    }  
  
    public String getState() {  
        return state;  
    }  
  
    public void setState(String state) {  
        this.state = state;  
    }  
}  

class StorageMsg {
    private MementoMsg msg;  

    public StorageMsg(MementoMsg msg) {  
        this.msg = msg;  
    }  
  
    public MementoMsg getMsg() {  
        return msg;  
    }  
}  
 