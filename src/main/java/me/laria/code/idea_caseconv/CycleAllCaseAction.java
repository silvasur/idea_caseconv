package me.laria.code.idea_caseconv;

public class CycleAllCaseAction extends SelectionReplacerAction {

    private static int counter = 0;

    private static String replaceString(final String s) {
        switch (ConversionType.fromValue(counter)) {

            case CAMEL:
                return CamelCaseAction.replaceString(s);
            case DASH:
                return DashCaseAction.replaceString(s);
            case DOT:
                return DotCaseAction.replaceString(s);
            case FLIP:
                return FlipCaseAction.replaceString(s);
            case LOWER:
                return LowerCaseAction.replaceString(s);
            case PASCAL:
                return PascalCaseAction.replaceString(s);
            case SCREAMING_SNAKE:
                return ScreamingSnakeCaseAction.replaceString(s);
            case SENTENCE:
                return SentenceCaseAction.replaceString(s);
            case SEPARATE_WORDS:
                return SeparateWordsAction.replaceString(s);
            case SNAKE:
                return SnakeCaseAction.replaceString(s);
            case TITLE:
                return TitleCaseAction.replaceString(s);
            case UPPER:
                return UpperCaseAction.replaceString(s);
        }

        return null;
    }

    private static void updateCounter() {
        counter = (counter + 1) % ConversionType.values().length;
    }

    @Override
    protected String replace(String s) {
        updateCounter();
        return replaceString(s);
    }
}
