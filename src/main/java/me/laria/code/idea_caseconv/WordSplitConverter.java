package me.laria.code.idea_caseconv;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class WordSplitConverter {
    private static List<String> split(String s) {
        Pattern decamelize = Pattern.compile("(?<![A-Z])[A-Z]");
        s = decamelize.matcher(s).replaceAll(" $0");

        String[] all_parts = s.split("[\\s_-]");
        ArrayList<String> parts = new ArrayList<>();
        for (String p : all_parts) {
            p = p.trim();
            if (!p.equals("")) {
                parts.add(p.toLowerCase());
            }
        }

        return parts;
    }

    public static String convert(String in, String glue, WordTransformer transform) {
        List<String> partsIn = split(in);
        ArrayList<String> partsOut = new ArrayList<>();

        int i = 0;
        for (String part : partsIn) {
            transform.transform(i, part).ifPresent(partsOut::add);
            i++;
        }

        return String.join(glue, partsOut);
    }
}
