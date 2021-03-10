import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task3 {
	public static void main(String[] args) throws FileNotFoundException {
		int n = 0;
		Scanner s = new Scanner(System.in);
		File f = new File(s.nextLine());
		File g = new File(s.nextLine());
		
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter(g);
		String buffer;
		while (in.hasNext()) {
			buffer = in.next();
			out.print(buffer);
			System.out.println(buffer);
			n += buffer.length();
		}
		System.out.println(n + " bytes");
		in.close();
		out.close();
		s.close();
	}
}
