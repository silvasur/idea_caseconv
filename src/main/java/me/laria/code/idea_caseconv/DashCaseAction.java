package me.laria.code.idea_caseconv;

import java.util.Optional;

public class DashCaseAction extends SelectionReplacerAction {
    @Override
    protected String replace(String s) {
        return WordSplitConverter.convert(s, "-", (i, s1) -> Optional.of(s1.toLowerCase()));
    }
}
