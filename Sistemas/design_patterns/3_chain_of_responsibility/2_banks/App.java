public class Office {
    private double capital;

    public Office() {
        Bank lastBank = null;
        List<Bank> orderedBanks = {
            new NullBank("");
            new BankC("C");
            new BankB("B");
            new BankA("A");
        };

        for (Bank bank : orderedBanks) {
            bank.setNext(lastBank);
            lastBank = bank;
        }
    }
}
