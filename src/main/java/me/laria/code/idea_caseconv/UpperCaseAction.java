package me.laria.code.idea_caseconv;

public class UpperCaseAction extends SelectionReplacerAction {

    public static String replaceString(String s) {
        return s.toUpperCase();
    }

    @Override
    protected String replace(String s) {
        return replaceString(s);
    }
}
