package me.laria.code.idea_caseconv;

import java.util.Optional;

public class PascalCaseAction extends SelectionReplacerAction {

    public static String replaceString(String s) {
        return WordSplitConverter.convert(s, "", (i, part) -> Optional.of(CamelCaseAction.ucfirst(part)));
    }

    @Override
    protected String replace(String s) {
        return replaceString(s);
    }
}
