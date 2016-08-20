package gr.lolo.util;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;


@Component
public class Slugifier {
    private static final ImmutableMap<Character, String> greekToLatinMap =  ImmutableMap.<Character, String>builder()
            .put('α', "a")
            .put('β', "b")
            .put('γ', "g")
            .put('δ', "d")
            .put('ε', "e")
            .put('ζ', "z")
            .put('η', "h")
            .put('θ', "th")
            .put('ι', "i")
            .put('κ', "k")
            .put('λ', "l")
            .put('μ', "m")
            .put('ν', "n")
            .put('ξ', "ks")
            .put('ο', "o")
            .put('π', "p")
            .put('ρ', "r")
            .put('σ', "s")
            .put('ς', "s")
            .put('τ', "t")
            .put('υ', "u")
            .put('φ', "f")
            .put('χ', "x")
            .put('ψ', "ps")
            .put('ω', "w")
            .build();

    public String slugify(String str) {
        String slugified = StringUtils.stripAccents(str)
                .toLowerCase()
                .replace(' ', '-')
                .chars()
                .mapToObj(i -> (char) i)
                .map(greekChar -> greekToLatinMap.getOrDefault(greekChar, String.valueOf(greekChar)))
                .collect(joining());
        try {
            return UriUtils.encode(slugified, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // should never happen
            throw new IllegalArgumentException(e);
        }
    }

    public String slugify(String str, Supplier<List<String>> exclusionsSup) {
        String slugified = slugify(str);
        List<String> exclusions = exclusionsSup.get();
        if (exclusions.contains(slugified)) {
            slugified += "-";
            int idNum = getMinExcludedIdNum(exclusions);
            while (exclusions.contains(slugified + ++idNum));
            return slugified + idNum;
        }
        return slugified;
    }

    private int getMinExcludedIdNum(List<String> exclusions) {
        return exclusions.stream()
                .map(s -> {
                    int dashIndx = s.lastIndexOf('-');
                    if (dashIndx > -1) {
                        String possibleNum = s.substring(++dashIndx);
                        if (StringUtils.isNumeric(possibleNum)) {
                            return Integer.parseInt(possibleNum);
                        }
                    }
                    return 0;
                })
                .min(Integer::compareTo)
                .orElse(0);
    }
}
