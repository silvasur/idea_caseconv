package me.laria.code.idea_caseconv;

import com.intellij.openapi.editor.Document;
import org.jetbrains.annotations.NotNull;

class Replacement implements Comparable<Replacement> {
    private final int a;
    private final int b;
    private final String s;

    public Replacement(int a, int b, String s) {
        this.a = Integer.min(a, b);
        this.b = Integer.max(a, b);
        this.s = s;
    }

    public void doReplace(Document doc) {
        doc.replaceString(this.a, this.b, this.s);
    }

    @Override
    public int compareTo(@NotNull Replacement o) {
        return Integer.compare(this.a, o.a);
    }
}
