package faang.apple;

import java.util.HashMap;

public class FibonacciNumber {

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        int num = 2;
        while (num < n){
            map.put(num, map.get(num-1)+map.get(num-2));
            num++;
        }

        return map.get(n-1)+map.get(n-2);
    }
}
