package me.laria.code.idea_caseconv;

import java.util.Optional;

public class DashCaseAction extends SelectionReplacerAction {

    public static String replaceString(String s) {
        return WordSplitConverter.convert(s, "-", (i, s1) -> Optional.of(s1.toLowerCase()));
    }

    @Override
    protected String replace(String s) {
        return replaceString(s);
    }
}
