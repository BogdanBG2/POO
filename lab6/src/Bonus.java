import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bonus {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String cuv1 = sc.nextLine();
		String cuv2 = sc.nextLine();
		File f = new File(sc.nextLine());
		Scanner in = new Scanner(f);
		String fileContent = in.useDelimiter("\\Z").next();
		in.close();
		
		PrintWriter output = new PrintWriter(f);
		String result = fileContent.replaceAll(cuv1, cuv2);
		output.println(result);
		output.close();
		sc.close();
	}
}
