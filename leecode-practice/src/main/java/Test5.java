import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {
    public static final List<Integer> path = new ArrayList<>();
    public static final List<List<Integer>> result = new ArrayList<>();

    public void backtrace(int[] collection, int target, int sum, int startIndex, int[] used) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < collection.length; i++) {
            if (i > 0 && collection[i - 1] == collection[i] && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            sum += collection[i];
            path.add(collection[i]);
            backtrace(collection, target, sum, i + 1, used);
            used[i] = 0;
            sum -= collection[i];
            path.remove(path.size() - 1);
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] collection = {10,1,2,7,6,1,5};
        int[] used = new int[collection.length];
        Arrays.sort(collection);
        Arrays.fill(used, 0);
        Test5 test4 = new Test5();
        test4.backtrace(collection, 8, 0, 0, used);
        test4.print();
    }
}
