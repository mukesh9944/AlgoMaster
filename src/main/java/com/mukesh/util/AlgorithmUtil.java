package com.mukesh.util;

import java.util.Arrays;
import java.util.List;

public class AlgorithmUtil {

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
}
