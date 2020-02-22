package cts.sudhir;

public class LambdaFunctionsExamples {

	public static void main(String[] args) {
		
		MyAdd lambdaMyadd = (int x, int y) -> x + y;
		
	}
	
	public interface MyAdd {
		int adds(int a, int b);
	}
}
