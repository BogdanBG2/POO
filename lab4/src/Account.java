
public class Account {
	static String nume;
	static double sum;
	static double interest;
	
	public Account(String n, double s, double i) {
		nume = n;
		sum = s;
		interest = i;
	}
	
	public String getName() {
		return nume;
	}
	public double getSum() {
		return sum;
	}
	public double getInterest() {
		return interest;
	}
	
	static class Transaction {
		public void withdraw() {
			sum -= interest;
		}
		public void deposit() {
			sum += interest;
		}
	}
	
	public void displaySum() {
		System.out.println("Suma(lei) = " + sum);
	}
	
	public static void main(String[] args) {
		Account a = new Account("Vasile", 0, 2);
		Account.Transaction t = new Transaction();
		t.deposit();
		t.deposit();
		t.withdraw();
		a.displaySum();
		
		Account b = new Account(a.getName(), a.getSum(), a.getInterest()) {
			public void displaySum() {
				System.out.println("Suma(euro) = " + (sum / 4.75));
			}
		};
		b.displaySum();
	}
}
