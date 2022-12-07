import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static final List<Integer> path = new ArrayList<>();
    public static final List<List<Integer>> result = new ArrayList<>();

    public void backtrace(int[] collection, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < collection.length; i++) {
            sum += collection[i];
            path.add(collection[i]);
            backtrace(collection, target, sum);
            sum -= collection[i];
            path.remove(path.size() - 1);
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] collection = {2, 3, 6, 7};
        Test4 test4 = new Test4();
        test4.backtrace(collection, 7, 0);
        test4.print();
    }
}
