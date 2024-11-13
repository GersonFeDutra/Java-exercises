package playground;

public class Main {
    public String hello;

    private class InnerStructure {
        public int[] data;
    }
    private InnerStructure str;

    public static void nameSpacedMethod(Object reference) {}

    private static void unityScopedMethod(Main self) {}

    protected static void namespaceScopedMethod(Main self) {}

    private void someInternalMethod(String[] args) {}

    public Main someExternalMethod() { return new Main(); }

    public static void main(String[] args) {
        Main instance = new Main();

        System.out.printf("%s\n", instance.hello);

        for (auto arg : args)
            System.out.println(arg);

        playground.Main.nameSpacedMethod();
    }
}
