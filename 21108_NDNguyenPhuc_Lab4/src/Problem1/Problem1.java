package Problem1;

public class Problem1 {

    static int puzzle(int base, int limit){
        // base and limit are non-negative numbers
        if (base > limit) {
            return -1;
        } else if (base == limit) {
            return 1;
        }else{
            return base * puzzle(base+1, limit);
        }
    }

    public static void main(String[] args) {
        /*
        1. the base cases of function puzzle
        when base >= limit, which is divided
        into two cases
        Case 1: base > limit --> return -1
        puzzle(14,10) --> return -1
        Case 2: base == limit --> return 1
        puzzle(0,0) --> return 1
        */

        /*
        2. the recursive cases of function puzzle
        when base < limit such as
        puzzle(4,7) -->  return 120
        */

        System.out.println(puzzle(4,7));
        System.out.println(puzzle(0,0));
        System.out.println(puzzle(14,10));
    }
}
