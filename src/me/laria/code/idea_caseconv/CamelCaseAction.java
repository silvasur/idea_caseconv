package me.laria.code.idea_caseconv;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CamelCaseAction extends SelectionReplacerAction {
    @NotNull
    public static String ucfirst(String s) {
        s = s.toLowerCase();
        return s.substring(0, 1).toUpperCase().concat(s.substring(1));
    }

    @Override
    protected String replace(String s) {
        return WordSplitConverter.convert(s, "", (i, part) -> Optional.of(i == 0 ? part.toLowerCase() : ucfirst(part)));
    }
}
