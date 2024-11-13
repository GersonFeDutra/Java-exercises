public class GuessStatisticsMessage {
    String number;
    String verb;
    char pluralModifier;
    bool before;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);

        if (info.before)
            return String.format("%s %s %s%c",
                    number,
                    verb,
                    entity, pluralModifier);
        else
            return String.format("%s %s %s%c",
                    verb,
                    number,
                    entity, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        switch (count) {
            case 0:
                thereAreNoLetters();
            break;
            case 1:
                thereIsOneLetter();
            break;
            default:
                thereAreManyLetters(count);
            break;
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(n);
        verb = "têm";
        pluralModifier = 's';
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "há";
        pluralModifier = 0;
    }

    private void thereAreNoLetters() {
        number = "não";
        verb = "há";
        pluralModifier = 's';
    }
}
