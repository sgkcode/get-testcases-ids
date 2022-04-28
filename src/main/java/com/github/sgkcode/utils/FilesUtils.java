package com.github.sgkcode.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilesUtils {

  public static List<File> getListOfFiles(String pathName) {
    File directory = new File(pathName);
    File[] fList = directory.listFiles();
    List<File> result = new ArrayList<>(Arrays.asList(Objects.requireNonNull(fList)));
    for (File file : fList) {
      if (file.isFile()) {
        result.add(file.getAbsoluteFile());
      } else if (file.isDirectory()) {
        result.addAll(getListOfFiles(file.getAbsolutePath()));
      }
    }
    return result.stream().filter(f -> !f.isDirectory()).collect(Collectors.toList());
  }

  public static List<File> getListOfFiles(String directoryName, String fileExtension) {
    return getListOfFiles(directoryName).stream().filter(f -> f.getAbsolutePath()
        .contains(fileExtension)).collect(Collectors.toList());
  }

  public static List<String> getAllFilesContent(String directoryName, String fileExtension) {
    List<File> files = FilesUtils.getListOfFiles(directoryName, fileExtension);
    List<String> result = new ArrayList<>();
    files.forEach(file -> result.add(getFileContent(file)));
    return result;
  }

  public static String getFileContent(File file) {
    StringBuilder result = new StringBuilder();
    try (BufferedReader input = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
      String line;
      while ((line = input.readLine()) != null) {
        result.append(line);
        result.append("/n");
      }
    } catch (IOException ex) {
      System.err.println("Can't read file");
    }
    return result.toString();
  }
}
