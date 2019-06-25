package me.laria.code.idea_caseconv;

import java.util.Optional;

public class SnakeCaseAction extends SelectionReplacerAction {
    @Override
    protected String replace(String s) {
        return WordSplitConverter.convert(s, "_", (i, part) -> Optional.of(part.toLowerCase()));
    }
}