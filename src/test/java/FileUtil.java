import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
  public static String readFileAsString(String fileName) {
    String temp = "";
    try {
      temp = new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return temp;
  }
}