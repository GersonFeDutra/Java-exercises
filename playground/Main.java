package playground;

public class Main {
    public String hello;

    private class InnerStructure {
        public int[] data;
    }
    private InnerStructure str;

    public void someExternalMethod(String[] args) {}

    public static void main(String[] args) {
        Main instance = new Main();

        System.out.printf("%s\n", instance.hello);

        for (auto arg : args)
            System.out.println(arg);
    }
}
