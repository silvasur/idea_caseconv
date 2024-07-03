package me.laria.code.idea_caseconv;

public class LowerCaseAction extends SelectionReplacerAction {

    public static String replaceString(String s) {
        return s.toLowerCase();
    }

    @Override
    protected String replace(String s) {
        return replaceString(s);
    }
}
