package warm.java;

public class DString {

	private String dString;

	public DString(String dString) {
		this.dString = dString;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public int indexOf(String pattern) {
		if (dString.length() < pattern.length())
			return -1;

		int end = dString.length() - pattern.length();

		for (int i = 0; i <= end; i++) {
			int j = i;
			int p = 0;
			while (j < dString.length() && dString.charAt(j) != pattern.charAt(p)) {
				j++;
			}
			i = j;
			while (j < dString.length() && p < pattern.length() && dString.charAt(j) == pattern.charAt(p)) {
				System.out.println(j + " " + p + " " + dString.charAt(j) + " " + pattern.charAt(p));
				j++;
				p++;
			}
			System.out.println("i " + i + " p " + p);
			if (p == pattern.length())
				return i;
		}
		return -1;
	}

	// TODO
	public int lastIndexOf(String pattern) {

		return -1;
	}

	public String subString(int start, int end) {

		return "";
	}

	public static void main(String[] args) {

		DString dString = new DString("AACTOR");
		// System.out.println("ACT " + dString.indexOf("ACT"));
		// System.out.println("CT " + dString.indexOf("CT"));
		// System.out.println("TK " + dString.indexOf("TK"));
		// System.out.println("ACTOR " + dString.indexOf("ACTOR"));
		System.out.println("ACTOR " + dString.indexOf("ACTOR"));
		System.out.println("A " + dString.indexOf("A"));
		System.out.println("AA " + dString.indexOf("AA"));
		System.out.println("TT " + dString.indexOf("TT"));
	}
}
