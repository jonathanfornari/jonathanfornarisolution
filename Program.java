import java.util.*;

class Program {

    public static void main(String[] args) {

        //in real world scenario test cases would never go in main method, just for the sake of keeping everything in one class

        //test case 1
        testCase(new int[] {7 , 6,  4, -1, 1 ,2}, 16, new int[]{7, 6, 4, -1}, new int[] {7, 6, 1, 2});
        //test case 2
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7}, 10, new int[]{1, 2, 3, 4});
        //test case 3
        testCase(new int[] {5, -5, -2, 2, 3, -3}, 0, new int[]{5, -5, -2, 2}, new int[] {5, -5, 3, -3}, new int[] {-2, 2, 3, -3});
        //test case 4
        testCase(new int[] {-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, new int[]{-2, -1, 1, 6}, new int[] {-2, 1, 2, 3}, new int[] {-2, -1, 2, 5}, new int[]{-2, -1, 3, 4});
        //test case 5
        testCase(new int[] {-1, 22, 18, 4, 7, 11, 2, -5, -3}, 30, new int[]{-1, 22, 7, 2}, new int[] {22, 4, 7, -3}, new int[] {-1, 18, 11, 2}, new int[]{18, 4, 11, -3}, new int[] {22, 11, 2, -5});

        //custom test case
        testCase(new int[] {1, 5, 10, 20, 20}, 100);
    }

    private static void testCase(int[] array, int targetSum, int[]... expectedOutput) {

        System.out.println("input array: " + Arrays.toString(array) + " targetSum: " + targetSum);

        List<Integer[]> result = fourNumberSum(array, targetSum);

        System.out.println("Expected output: ");
        for(int[] res : expectedOutput) {
            System.out.println(Arrays.toString(res));
        }
        System.out.println("Actual output: ");
        for(Integer[] res : result) {
            System.out.println(Arrays.toString(res));
        }
        System.out.println("------------------");
    }

    //this can be improved to run faster using a data structure like a hashset to store the sum of two elements and them check for pairs if the missing from target is equal to one of the sums stored
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        List<Integer[]> solution = new ArrayList<>();

        for(int i = 0; i<array.length; i++) {
            for(int j = i + 1; j<array.length; j++) {
                for(int k = j + 1; k<array.length; k++) {
                    for(int l = k + 1; l<array.length; l++) {
                        int sum = array[i] + array[j] + array[k] + array[l];
                        if(sum == targetSum) {
                            solution.add(new Integer[]{ array[i], array[j], array[k], array[l] });
                        }
                    }
                }
            }
        }

        return solution;
    }
}

