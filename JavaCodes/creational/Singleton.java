package JavaSE_Senior.DesignPattern.JavaCodes.creational;

public class Singleton {
	private static Singleton instance = null;

	private Singleton(){
	}

	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
