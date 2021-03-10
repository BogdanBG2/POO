import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		int[] a = new int[26];
		Scanner in = new Scanner(System.in);
		System.out.print("input : ");
		String s = in.nextLine();
		
		for(int i = 0; i < s.length(); ++i) {
			Character c = s.charAt(i);
			if(Character.isLetter(c))
				a[Character.toLowerCase(c) - 'a']++;
		}
		for(int i = 0; i < 26; ++i)
			System.out.println("'" + (char)('a'+i) 
					+ "' apare de " + a[i] + " ori");
	
		in.close();
	
	}
}
