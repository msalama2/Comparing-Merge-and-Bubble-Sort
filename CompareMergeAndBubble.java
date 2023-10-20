package ComparingImplementMergeSortandBubbleSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CompareMergeAndBubble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Length for Array:\n");
        int ALength = scanner.nextInt();

        ArrayList<Integer> Alist = createRandomArray(ALength);

        ArrayList<Integer> AListMergeS = new ArrayList<>(Alist);
        ArrayList<Integer> AListBubbleS = new ArrayList<>(Alist);

        long STimeMergeS = System.currentTimeMillis();
        mergeSort(AListMergeS);
        long ETimeMergeSort = System.currentTimeMillis();
        long MergeSortTime = ETimeMergeSort - STimeMergeS;

        long STimeBubbleS = System.currentTimeMillis();
        bubbleSort(AListBubbleS);
        long ETimeBubbleSort = System.currentTimeMillis();
        long BubbleSortTime = ETimeBubbleSort - STimeBubbleS;

        System.out.println("\nImplemented MergeSort Time is " + MergeSortTime + " milliseconds\n");
        System.out.println("\nImplemented BubbleSort Time is " + BubbleSortTime + " milliseconds\n");
    
        scanner.close();

    }

    private static ArrayList<Integer> createRandomArray(int arrayLength) {
        Random random = new Random();
        ArrayList<Integer> randomArray = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            randomArray.add(random.nextInt(101)); // Random integers between 0 and 100
        }

        return randomArray;
    }

    private static void bubbleSort(ArrayList<Integer> aListBubbleS) {
        int n = aListBubbleS.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (aListBubbleS.get(j) > aListBubbleS.get(j + 1)) {
                    int temp = aListBubbleS.get(j);
                    aListBubbleS.set(j, aListBubbleS.get(j + 1));
                    aListBubbleS.set(j + 1, temp);
                }
            }
        }
    }

    private static void mergeSort(ArrayList<Integer> aListMergeS) {
        if (aListMergeS.size() <= 1) {
            return;
        }

        int middleArray = aListMergeS.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(aListMergeS.subList(0, middleArray));
        ArrayList<Integer> right = new ArrayList<>(aListMergeS.subList(middleArray, aListMergeS.size()));

        mergeSort(left);
        mergeSort(right);
        merge(aListMergeS, left, right);
    }

    private static void merge(ArrayList<Integer> aListMergeS, ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                aListMergeS.set(arrayIndex++, left.get(leftIndex++));
            } else {
                aListMergeS.set(arrayIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            aListMergeS.set(arrayIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            aListMergeS.set(arrayIndex++, right.get(rightIndex++));
        }
    }
}
