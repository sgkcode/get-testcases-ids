package com.github.sgkcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

  public static List<Path> getListOfFiles(String path) {
    List<Path> result = null;
    try {
      result = Files.walk(Paths.get(path))
          .filter(Files::isRegularFile)
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static List<Path> getListOfFiles(String path, String fileExtension) {
    return getListOfFiles(path).stream()
        .filter(p -> p.getFileName().toString().endsWith(fileExtension))
        .collect(Collectors.toList());
  }

  public static String getFileContents(Path path) {
    String result = null;
    try {
      result = Files.readString(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static List<String> getFilesContents(List<Path> paths) {
    return paths.stream().map(FileUtils::getFileContents).collect(Collectors.toList());
  }

  public static List<String> getFilesContents(String path, String fileExtension) {
    return getFilesContents(FileUtils.getListOfFiles(path, fileExtension));
  }
}
