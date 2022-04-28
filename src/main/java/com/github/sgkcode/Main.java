package com.github.sgkcode;

import com.github.sgkcode.models.TestCase;
import com.github.sgkcode.utils.FilesUtils;
import com.github.sgkcode.utils.ScraperUtils;
import java.util.List;
import java.util.Set;

public class Main {

  public static final String PATH = "D:\\Path";
  public static final String FILE_EXTENSION = ".java";

  public static void main(String[] args) {
    List<String> files = FilesUtils.getAllFilesContent(PATH, FILE_EXTENSION);
    Set<Integer> idList = ScraperUtils.findTestCasesIds(files);
    List<TestCase> testCases = TestCase.generateModels(idList);
    System.out.println(testCases.toString() + "\nsize: " + testCases.size());
  }
}
