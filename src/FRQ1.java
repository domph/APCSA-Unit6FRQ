public class FRQ1 {
	public static void main(String[] args) {
		// Test
		String[] words = {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};

		for (String Word : words) {
			if (Word.substring(Word.length() - 3).equals("ing")) {
				System.out.println(Word);
			}
		}
	}
}
