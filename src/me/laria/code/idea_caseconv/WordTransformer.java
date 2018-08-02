package me.laria.code.idea_caseconv;

import java.util.Optional;

interface WordTransformer {
    Optional<String> transform(int i, String s);
}
