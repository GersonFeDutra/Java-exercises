public class App {
	public static void main(String[] args) throws Exception {
		Duck duck = new TurkeyDuckAdapter();

		duck.fly();
		duck.honk();
	}
}
