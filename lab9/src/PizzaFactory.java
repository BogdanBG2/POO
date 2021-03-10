import java.util.ArrayList;

public class PizzaFactory {

	private static PizzaFactory instance;
	
	public static PizzaFactory getInstance() {
		if(instance == null)
			instance = new PizzaFactory();
		return instance;
	}
	
	public Pizza create(PizzaType type, int size, int price) {
		Pizza pizza = null;
		if(type.equals(PizzaType.Diavola))
			pizza =  new Diavola(size, price);
		else if (type.equals(PizzaType.Capriciosa)) 
			pizza =  new Capriciosa(size, price);
		else if (type.equals(PizzaType.Margherita)) 
			pizza = new Margherita(size, price);
		else if(type.equals(PizzaType.Focaccia))
			pizza = new Focaccia(size, price);
		return pizza;
	}
	public static void main(String[] args) {
		ArrayList<Pizza> v = new ArrayList<Pizza>();
		PizzaFactory pf = PizzaFactory.getInstance();;
		v.add(pf.create(PizzaType.Capriciosa, 12, 19));
		v.add(pf.create(PizzaType.Diavola, 14, 22));
		v.add(pf.create(PizzaType.Margherita, 25, 27));
		v.add(pf.create(PizzaType.Focaccia, 14, 16));
		
		for(Pizza p : v)
			System.out.println(p.toString());
	}
}
