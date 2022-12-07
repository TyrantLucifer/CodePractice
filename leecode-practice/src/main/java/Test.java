import java.util.ArrayList;

public class Test {
    private final ArrayList<Integer> path = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public void backtrace(int n, int num, int startIndex) {
        if (path.size() == num) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrace(n, num, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int n = 4;
        int num = 4;
        Test test = new Test();
        for (int i = 0; i <= num; i++) {
            test.backtrace(n, i, 1);
        }
        test.print();
    }
}
