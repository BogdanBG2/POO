import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) throws FileNotFoundException {
		int[] a = new int[26];
		Scanner sc = new Scanner(System.in);
		File f = new File(sc.nextLine());
		Scanner in = new Scanner(f);
		String s = in.nextLine();

		for(int i = 0; i < s.length(); ++i) 
			if(Character.isLetter(s.charAt(i)))
				a[Character.toLowerCase(s.charAt(i)) - 'a']++;
		int max = a[0];
		for(int i = 1; i < 26; ++i)
			if(max <= a[i]) 
				max = a[i];
		
		for(int i = 0; i < 26; ++i)
			if(a[i] == max)
		System.out.println("Caracterul '" + (char)(i + 'a') 
				+ "' apare de " + max + " ori in '" + s + "'.");
		in.close();
		sc.close();
	}
}
