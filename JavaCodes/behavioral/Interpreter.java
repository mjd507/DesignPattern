package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

public class Interpreter {

	public static void main(String[] args) {  
		Expression notValue1 = new Not(true);
		Expression notValue2 = new Not(false);
		System.out.println(notValue1.interpret() + "  "+ notValue2.interpret());
		
		Expression and = new And(notValue1, notValue2);
		System.out.println(and.interpret());
		
		Expression or = new Or(notValue1, notValue2);
		System.out.println(or.interpret());
		
	}  

}

interface Expression {  
	boolean interpret();  
}  

class And implements Expression {  

	private Expression left,right;  

	public And(Expression left,Expression right){  
		this.left=left;  
		this.right=right;  
	}  

	public boolean interpret() {  
		return left.interpret() && right.interpret();  
	}  
}

class Or implements Expression {  
	private Expression left, right;  
	public Or(Expression left, Expression right) {  
		this.left = left;  
		this.right = right;  
	}  

	public boolean interpret() {  
		return left.interpret() || right.interpret();  
	}  
}

class Not implements Expression{  

	private boolean value;  

	public Not(boolean value){  
		this.value= value;  
	}  

	public boolean interpret() {  
		return !value;  
	}  
}
