import java.util.Scanner;

public class Person {
	String name;
	String CNP;
	public Person() {
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		CNP = in.nextLine();
	}
	
	boolean verify() {
		class CheckPerson {
			boolean check() {
				if(CNP.length() == 13 && (CNP.charAt(0) == '1' || CNP.charAt(0) == '2') 
					&& Character.isUpperCase(name.charAt(0)))
					return true;
				return false;
			}
		}
		CheckPerson chk = new CheckPerson();
		return chk.check();
	}
	
	public static void main(String[] args) {
		Person a = new Person();
		System.out.println("Is A valid? Answer: " + a.verify());

		Person b = new Person();	
		System.out.println("Is B valid? Answer: " + b.verify());
	}
}
