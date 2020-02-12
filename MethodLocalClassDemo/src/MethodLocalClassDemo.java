class Outer{
	      int v;
	      void some() {
double d=76.99;
class Inner{
	//outer.v=965;
	void work() {
System.out.println("Inside Inner's work..."+d);
	}
}
new Inner().work();
}
}
class MethodLocalClassDemo {
public static void main(String[] args) {
new Outer().some();	
	}

}
