package com.hackathon.api.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

  private FileUtil() {
    // restrict instantiation
  }

  public static final String folderPath =  "/Users/4559169/Documents/workspace-spring-tool-suite-4-4.15.2.RELEASE/api/src/main/resources/files//";
  public static final Path filePath = Paths.get(folderPath);

}