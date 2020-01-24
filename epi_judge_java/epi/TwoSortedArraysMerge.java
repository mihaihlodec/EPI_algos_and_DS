package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class TwoSortedArraysMerge {

  public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                          List<Integer> B, int n) {
    int indexA = m-1;
    int indexB = n-1;
    int writeIndex = (m + n) - 1;

    // we can fill the first array from its end, having spare space
    while (indexA >= 0 && indexB >=0) {
      A.set(writeIndex--, A.get(indexA) >= B.get(indexB) ? A.get(indexA--) : B.get(indexB--));
    }
    while (indexB >= 0) {
      A.set(writeIndex--, B.get(indexB--));
    }

  }

  @EpiTest(testDataFile = "two_sorted_arrays_merge.tsv")
  public static List<Integer>
  mergeTwoSortedArraysWrapper(List<Integer> A, int m, List<Integer> B, int n) {
    mergeTwoSortedArrays(A, m, B, n);
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TwoSortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
