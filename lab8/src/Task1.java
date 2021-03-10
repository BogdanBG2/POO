import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {

	public static void main(String[] args) throws FileNotFoundException {
		TreeSet<String> set = new TreeSet<String>();
		File f = new File("src/input");
		Scanner in = new Scanner(f);
		
		String fileContent =in.useDelimiter("\\Z").next();
		String[] result = fileContent.split("[\n?!., ]");
		for(String str : result)
			set.add(str);
		
		for(String str : set)
			if(!str.equals(""))
				System.out.println(str);
		in.close();
	}

}
