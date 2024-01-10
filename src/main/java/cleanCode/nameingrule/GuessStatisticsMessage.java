package cleanCode.nameingrule;

public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;
    
    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        if ( count == 0 ) {
            thereAreNoLetters();
        } else if ( count == 1 ) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
    }

    private void thereIsOneLetter() {
        
        
    }

    private void thereAreNoLetters() {
        
    }
}
