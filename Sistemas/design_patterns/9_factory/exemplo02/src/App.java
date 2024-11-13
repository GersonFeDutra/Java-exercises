public class App {
	public static void main(String[] args) throws Exception {
		BankAccountFactory f = new BankAccountFactory();
		// BankAccount[] accounts = {
		f.createAccount(BankAccountFactory.BankType.CHECKING);// ,
		f.createAccount(BankAccountFactory.BankType.LEGAL);// ,
		f.createAccount(BankAccountFactory.BankType.SAVINGS);// ,
		// };
	}
}
