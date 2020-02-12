interface Operations{
	void add();
	void mul();
}
class Operations1 implements Operations{
	//int x;
	//int y;
@Override
public void add() {
	System.out.println("addition of two numbers");
}
	
@Override
public void mul() {
	System.out.println("multiplication of two numbers");
}

}
class Operations2 implements Operations{
	@Override
	public void add() {
		System.out.println("addition of operations1 variables");
	}
	@Override
	public void mul() {
		System.out.println("multiplication of operations2 variables");
	}
	public void div() {
		System.out.println("divison of variables");
	}
}
public class OperationsOp {
	public static void main(String [] args) {
		Operations op[]=new Operations[2];
		op[0]=new Operations1();
		op[1]=new Operations2();
		for(Operations val:op) {
			val.add();
			val.mul();
		if(val instanceof Operations2) {
			((Operations2)val).div();
		}
		}

		
	}
}