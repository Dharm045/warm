package warm.array;


public class DecodePattern {

	public static void main(String[] args) {

		String patterns[] = new String[21];
		patterns[0] = "1";
		for (int i = 1; i < patterns.length; i++) {
			patterns[i] = getNextPatteren(patterns[i - 1]);
		}
		for (int i = 0; i < patterns.length; i++) {
			System.out.println(patterns[i]);
		}
//		System.out.println(Character.getType('A'));
//		System.out.println(Character.getType('N'));
//		System.out.println(Character.getType('9'));
//		System.out.println(Character.getType('1'));
	}

	static String getNextPatteren(String current) {
		StringBuffer next = new StringBuffer();
		char c = current.charAt(0);
		int freq = 1;
		for (int i = 1; i < current.length(); i++) {
			if (c == current.charAt(i)) {
				freq++;
			} else {
				next.append(freq).append(c);
				c = current.charAt(i);
				freq = 1;
			}
		}
		next.append(freq).append(c);
		return new String(next);
	}
}
