package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {

    Map<Character, Long> letterMap = letterText.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (char c: magazineText.toCharArray()) {
      if (letterMap.containsKey(c)) {
        letterMap.put(c, letterMap.get(c) - 1);
        if (letterMap.remove(c, 0L)) {
          if (letterMap.isEmpty()) {
            break;
          }
        }
      }
    }

    return letterMap.isEmpty();
  }

  public static boolean isLetterConstructibleFromMagazineFirstTry(String letterText,
                                                                  String magazineText) {

    Map<Character, Long> letterMap = letterText.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Character, Long> magazineTextMap = magazineText.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (Map.Entry<Character, Long> x: letterMap.entrySet()) {
      if (magazineTextMap.get(x.getKey()) == null || magazineTextMap.get(x.getKey()) < x.getValue()){
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
