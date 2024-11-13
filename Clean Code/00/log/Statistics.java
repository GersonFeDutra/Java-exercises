package log;

public class Statistics {

    class Numerate {
        String number;
        String verb;
        char pluralModifier;
        bool before;

        private Numerate(String number, String verb, char pluralModifier, bool before) {
            this.number = number;
            this.verb = verb;
            this.pluralModifier = pluralModifier;
            this.before = before;
        }

        Numerate(int from) {
            switch (from) {
                case 0:
                    Numerate("não", "há", 's', false);
                    break;
                case 1:
                    Numerate("1", "há", 0, true);
                    break;
                default:
                    Numerate(Integer.toString(n), "têm", 's', false);
                    break;
            }
        }
    }

    public static String getMessage(String entity, int n) {
        Numerate info = new Numerate(n);

        if (info.before)
            return String.format("%s %s %s%c",
                    info.number,
                    info.verb,
                    entity, info.pluralModifier);
        else
            return String.format("%s %s %s%c",
                    info.verb,
                    info.number,
                    entity, info.pluralModifier);
    }
}
