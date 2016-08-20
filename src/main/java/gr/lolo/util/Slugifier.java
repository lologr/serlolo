package gr.lolo.util;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

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
        return StringUtils.stripAccents(str)
                .toLowerCase()
                .replaceAll("-+"," ")
                .trim()
                .replaceAll(" +", "-")
                .chars()
                .mapToObj(i -> (char) i)
                .map(greekChar -> greekToLatinMap.getOrDefault(greekChar, String.valueOf(greekChar)))
                .collect(joining())
                .replaceAll("[^-A-Za-z0-9]", "");
    }

    public String slugify(String str, Supplier<List<String>> exclusionsSup) {
        String slugified = slugify(str);
        List<String> exclusions = exclusionsSup.get();
        if (exclusions.contains(slugified)) {
            slugified += "-";
            int idNum = 0;
            while (exclusions.contains(slugified + ++idNum));
            return slugified + idNum;
        }
        return slugified;
    }
}
