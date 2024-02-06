package Problem8;

import java.util.ArrayList;
import java.util.List;

public class Problem8 {
    static void generateSubset(List<Integer> set, ArrayList<Integer> current, int index){
        if (index == set.size()) {
            System.out.println(current);
            return;
        }

        current.add(set.get(index));
        generateSubset(set, current, index + 1);

        current.remove(set.get(index));
        generateSubset(set, current, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1); set.add(2); set.add(3);
        ArrayList<Integer> current = new ArrayList<>();
        generateSubset(set, current, 0);
    }
}
