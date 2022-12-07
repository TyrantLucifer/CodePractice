import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static final Map<Character, char[]> map = new HashMap<>();
    public static final List<List<Character>> result = new ArrayList<>();
    public static final List<Character> path = new ArrayList<>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public void letterCombinations(String digits) {
        ArrayList<char[]> collections = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            collections.add(map.get(digits.charAt(i)));
        }
        backtrace(collections, 0);
    }

    public void backtrace(ArrayList<char[]> collections, int startIndex) {
        if (path.size() == collections.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < collections.get(startIndex).length; i++) {
            path.add(collections.get(startIndex)[i]);
            backtrace(collections, startIndex + 1);
            path.remove(path.size() - 1);
        }
    }

    public void print() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.letterCombinations("23");
        test3.print();
    }
}
