import java.util.ArrayList;

public class Test2 {
    private static final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private static final ArrayList<Integer> path = new ArrayList<>();

    public void backtrace(int n, int num, int sum, int startIndex) {
        if (path.size() == num) {
            Integer reduce = path.stream().reduce(0, Integer::sum);
            if (reduce == sum) {
                result.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrace(n, num, sum, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.backtrace(9, 3, 9, 1);
        test2.print();
    }
}
