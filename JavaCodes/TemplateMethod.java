package JavaSE_Senior.DesignPattern.JavaCodes;

public class TemplateMethod {
	public static void main(String[] args) {
		BaseActivity activity = new Activity1();
		activity.onCreate();
		activity.onStart();
		activity.onResume();
	}
}

abstract class BaseActivity{
	
	public void onCreate(){
		initView();
	}

	public void onStart(){
		initData();
	}
	
	public void onResume(){
		initListener();
	}
	
	abstract void initView();
	abstract void initData();
	abstract void initListener();
}

class Activity1 extends BaseActivity{

	@Override
	void initView() {
		System.out.println("activity1 init view");
	}

	@Override
	void initData() {
		System.out.println("activity1 init data");
	}

	@Override
	void initListener() {
		System.out.println("activity1 init listener");
	}
	
}