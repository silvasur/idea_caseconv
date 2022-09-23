package me.laria.code.idea_caseconv;

import java.util.Optional;

public class SentenceCaseAction extends SelectionReplacerAction {

    public static String replaceString(String s) {
        return WordSplitConverter.convert(
                s,
                " ",
                (i, part) -> Optional.of(i == 0 ?
                        CamelCaseAction.ucfirst(part)
                        : part
                )
        );
    }

    @Override
    protected String replace(String s) {
        return replaceString(s);
    }
}
