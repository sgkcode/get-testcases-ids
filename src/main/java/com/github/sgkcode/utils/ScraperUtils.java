package com.github.sgkcode.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScraperUtils {

  public static final Pattern TEST_CASE_PATTERN = Pattern.compile("EPMCHRTMIS-(\\d*)");

  public static Set<Integer> findTestCasesIds(List<String> files) {
    Set<Integer> idList = new HashSet<>();
    files.forEach(file -> {
      Matcher m = TEST_CASE_PATTERN.matcher(file);
      while (m.find()) {
        idList.add(Integer.parseInt(m.group(1)));
      }
    });
    return idList;
  }
}
