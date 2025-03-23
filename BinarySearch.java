import java.util.Scanner;

public class BinarySearch {

    static int binarysearch(int[] arr, int left, int right, int target)
    {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target)
            return binarysearch(arr, mid + 1, right, target);
        else
            return binarysearch(arr, left, mid - 1, target);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n;
        System.out.println("Enter the no of elements in array: ");
        n = s.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int target;
        System.out.println("Enter the element you want to search: ");
        target = s.nextInt();

        int found = binarysearch(arr,0,n-1,target);

        if (found != -1) {
            System.out.println("Element found at index: " + found);
        } else {
            System.out.println("Element not found in the array.");
        }

    }
}
