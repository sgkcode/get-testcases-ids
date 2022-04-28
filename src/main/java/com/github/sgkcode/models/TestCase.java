package com.github.sgkcode.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestCase {

  private final int id;

  public TestCase(int id) {
    this.id = id;
  }

  public static List<TestCase> generateModels(Set<Integer> idList)  {
    List<TestCase> testcases = new ArrayList<>();
    idList.forEach(id-> testcases.add(new TestCase(id)));
    return testcases;
  }

  @Override
  public String toString() {
    return "TestCase{" +
        "id=" + id +
        '}';
  }
}
