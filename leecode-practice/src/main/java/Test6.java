import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6 {
    public static final List<List<Character>> result = new ArrayList<>();
    public static final List<Character> path = new ArrayList<>();

    public void backtrace(char[] collection, int itemCount, int startIndex, boolean[] used) {
        if (path.size() == itemCount) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < collection.length; i++) {
            if (i > 0 && collection[i - 1] == collection[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(collection[i]);
            backtrace(collection, itemCount, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public boolean isPalindrome(List<Character> characters) {
        for (int i = 0, j = characters.size() - 1; i < j; i++, j--) {
            if (characters.get(i) != characters.get(j)) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        result.removeIf(characters -> !isPalindrome(characters));
        System.out.println(result);
    }

    public static void main(String[] args) {
        char[] collection = {'a', 'a', 'b'};
        boolean[] used = new boolean[collection.length];
        Arrays.fill(used, false);
        Test6 test6 = new Test6();
        for (int i = 1; i <= collection.length; i++) {
            test6.backtrace(collection, i, 0, used);
        }
        test6.print();
    }
}
