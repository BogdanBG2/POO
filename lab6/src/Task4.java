import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File(args[0]);
		Scanner in = new Scanner(f);
		
		String fileContent = in.useDelimiter("\\Z").next();
		String[] result = fileContent.split("[. ]");
		System.out.println(fileContent);
		System.out.println(result.length + " (de) cuvinte");
		in.close();
	}
}
