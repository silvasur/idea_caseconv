package me.laria.code.idea_caseconv;

public class FlipCaseAction extends SelectionReplacerAction {
    @Override
    protected String replace(String s) {
        StringBuilder builder = new StringBuilder();

        s.codePoints().forEach(c -> builder.appendCodePoint(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c)));

        return builder.toString();
    }
}
