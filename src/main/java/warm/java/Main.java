package warm.java;

public class Main {

	public static void main(String[] args) {
		System.out.println(Math.pow(2, 2));
	}

	private static Exception print(int i) {
		if (i > 0) {
			return new Exception();
		} else {
			return new RuntimeException();
		}

	}
}
