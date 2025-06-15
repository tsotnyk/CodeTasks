package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        if (fruits.length <= 2) return fruits.length;

        AtomicInteger result = new AtomicInteger(0);

        for (int i = 0; i < fruits.length-2; ){

            i = countFruits(fruits, i, result);
        }

        return result.get();
    }

    public int countFruits(int[] fruits, int index, AtomicInteger counter){

        HashSet<Integer> set = new HashSet<>();
        set.add(fruits[index++]);
        int tmpCounter = 1;
        int secondIndex = index;
        while (index < fruits.length){
            if (set.contains(fruits[index])){
                tmpCounter++;
                index++;
                continue;
            }
            if (set.size() < 2){
                set.add(fruits[index]);
                tmpCounter++;
                secondIndex = index;
                index++;
            }else {
                if (counter.get() < tmpCounter){
                    counter.set(tmpCounter);
                }
                return secondIndex;
            }
        }

        if (counter.get() < tmpCounter){
            counter.set(tmpCounter);
        }

        return index == fruits.length ? index : secondIndex;
    }

    @Test
    public void test(){

        Assert.assertEquals(totalFruit(new int[]{1,2,1}), 3);
        Assert.assertEquals(totalFruit(new int[]{0,1,2,2}), 3);
        Assert.assertEquals(totalFruit(new int[]{1,2,3,2,2}), 4);
    }
}
