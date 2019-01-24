package algorithmTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, return all pairs of two numbers such that they add up to a specific target.
 *
 * Given numbers = [2, 7, 1, 8, 11, 15], target = 9
 * Result: [[2, 7], [1, 8]]
 */
public class App 
{
    /**
     * Immutable class that represents task's data
     */
    static class TaskData {
        private final int[] numbers;
        private final int target;

        private int[] copyArray(int[] source) {
            int[] result = new int[source.length];
            System.arraycopy(source, 0, result, 0, source.length);
            return result;
        }

        public TaskData(int[] numbers, int target) {
            this.numbers = copyArray(numbers);
            this.target = target;
        }

        public int[] getNumbers() {
            return copyArray(numbers);
        }

        public int getTarget() {
            return target;
        }
    }


    /**
     * Success resolution of the problem v1
     * as I know it should be O(n) complexity
     */
    static class Resolution {
        static private final int FLAG_EXIST = 1;
        static private final int FLAG_THERE_IS_NO = 0;

        public static List<int[]> resolve(int[] numbers, int target) {
            List<int[]> result = new ArrayList<>();

            int[] pivot = new int[target+1];

            for (int i = 0; i<numbers.length; i++) {
                if (numbers[i] <= target) {
                    pivot[numbers[i]] = FLAG_EXIST;
                }
            }

            for (int i=0; i<pivot.length/2; i++) {
                if (pivot[target-i] == FLAG_EXIST) {
                    result.add(new int[] {i, target-i});
                }
            }

            return result;
        }
    }

    /**
     * Task runner
     * @param args
     */
    public static void main( String[] args )
    {
        TaskData data = new TaskData(new int[]{2, 7, 1, 8, 11, 15}, 9);
        TaskData data1 = new TaskData(new int[]{13, 5, 6, 1, 8, 10, 15, 4, 9, 0}, 9);

        resolveAndPrettyPrint(data);
        resolveAndPrettyPrint(data1);
    }

    /**
     * Util method for printing the results
     * @param data
     */
    private static void resolveAndPrettyPrint(TaskData data) {
        System.out.println("===============RESOLVER===============");
        System.out.println("Array: " + Arrays.toString(data.getNumbers()));
        System.out.println("Target: " + data.getTarget());
        Resolution.resolve(data.getNumbers(), data.getTarget()).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
