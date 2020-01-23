package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntersectSortedArrays {
  @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    List<Integer> result = new ArrayList<>();

    int indexA = 0;
    int indexB = 0;
    while (indexA != A.size() && indexB != B.size()) {
      int valA = A.get(indexA);
      int valB = B.get(indexB);
      if (valA == valB) {
        result.add(valA);
        while (indexA != A.size() && A.get(indexA) == valA) {
          indexA++;
        }
        while (indexB != B.size() && B.get(indexB) == valB) {
          indexB++;
        }
      } else if (valA < valB) {
        while (indexA != A.size() && A.get(indexA) < B.get(indexB) ) {
          indexA++;
        }
      } else if (valB < valA) {
        while (indexB != B.size() && B.get(indexB) < A.get(indexA)) {
          indexB++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
