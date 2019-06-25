package me.laria.code.idea_caseconv;

public class LowerCaseAction extends SelectionReplacerAction {
    @Override
    protected String replace(String s) {
        return s.toLowerCase();
    }
}
