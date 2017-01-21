public class State {
	public static void main(String[] args) {
		//创建一个状态控制环境
		ElevatorContext context = new ElevatorContext();
		//切换到 A 电梯，打开门，然后跑，然后停止
		context.setCurrentState(ElevatorContext.STATEA);
		context.running();
		context.stop();
		//切换状态，让电梯B 去跑
		context.setCurrentState(ElevatorContext.STATEB);
		context.running();
	}

}

/**
 * 电梯状态
 */
abstract class ElevatorState{
	
	protected ElevatorContext context;
	
	public void setElvatorContext(ElevatorContext context){
		this.context = context;
	}
	
	public abstract void open();
	
	public abstract void running();
	
	public abstract void stop();
	
}

class ElevatorA extends ElevatorState{

	@Override
	public void open() {
		System.out.println("电梯A 开了....");
	}

	@Override
	public void running() {
		System.out.println("电梯A 正在跑....");
	}

	@Override
	public void stop() {
		System.out.println("电梯A 停了....");
	}
	
}

class ElevatorB extends ElevatorState{

	@Override
	public void open() {
		System.out.println("电梯B 开了....");
	}

	@Override
	public void running() {
		System.out.println("电梯B 正在跑....");
	}

	@Override
	public void stop() {
		System.out.println("电梯B 停了....");
	}
	
}

/**
 * 控制电梯运行状态的环境
 */
class ElevatorContext{
	public final static ElevatorState STATEA = new ElevatorA();
	public final static ElevatorState STATEB = new ElevatorB();
	
	//当前状态
	private ElevatorState CurrentState;
	
	public ElevatorState getCurrentState() {
		return CurrentState;
	}
	
	public void setCurrentState(ElevatorState currentState) {
		this.CurrentState = currentState;
		this.CurrentState.setElvatorContext(this);
	}
	
	public void open(){
		this.CurrentState.open();
	}
	
	public void running(){
		this.CurrentState.running();
	}
	
	public void stop(){
		this.CurrentState.stop();
	}
	
}

