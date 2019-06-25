package me.laria.code.idea_caseconv;

public class UpperCaseAction extends SelectionReplacerAction {
    @Override
    protected String replace(String s) {
        return s.toUpperCase();
    }
}
