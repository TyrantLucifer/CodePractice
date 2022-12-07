import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test9 {
    private static final List<List<Integer>> result = new ArrayList<>();
    private static final List<Integer> path = new ArrayList<>();

    public void backtrace(int[] collection, int num, int startIndex, boolean[] used) {
        if (path.size() == num) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < collection.length; i++) {
            if (i > 0 && collection[i - 1] == collection[i] && !used[i - 1]) {
                break;
            }
            used[i] = true;
            path.add(collection[i]);
            backtrace(collection, num, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] collection = new int[]{1,2,2};
        boolean[] used = new boolean[collection.length];
        Arrays.fill(used, false);
        Arrays.sort(collection);
        Test9 test8 = new Test9();
        for (int i = 0; i <= collection.length; i++) {
            test8.backtrace(collection, i, 0, used);
        }
        test8.print();
    }
}
