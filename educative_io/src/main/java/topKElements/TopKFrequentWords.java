package topKElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TopKFrequentWords {

    class Word{
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] arr, int k) {

        HashMap<String, AtomicInteger> map = new HashMap<>();

        for (String word : arr){
            if (map.containsKey(word)){
                map.get(word).getAndIncrement();
            }else {
                map.put(word, new AtomicInteger(1));
            }
        }

        PriorityQueue<Word> queue = new PriorityQueue<>((a, b) -> {
            if (b.count == a.count) return b.word.compareTo(a.word);
           return a.count - b.count;
        });

        for (Map.Entry<String, AtomicInteger> word : map.entrySet()){

            Word candidate = new Word(word.getKey(), word.getValue().get());
            if (queue.size() < k){
                queue.add(new Word(word.getKey(), word.getValue().get()));
            }else {

                Word tmp = queue.peek();
                if (queue.peek().count < candidate.count || (queue.peek().count == candidate.count && queue.peek().word.compareTo(candidate.word) > 0)){
                    queue.poll();
                    queue.add(new Word(word.getKey(), word.getValue().get()));
                }
            }
        }

        List<String> res = new LinkedList<>();

        while (!queue.isEmpty()){
            res.add(queue.poll().word);
        }

        // Replace this placeholder return statement with your code
        return res;
    }

    @Test
    public void test(){

        List<String> res = topKFrequent(new String[]{"lets", "play", "cricket", "and", "then", "lets", "play", "badminton"}, 3);
    }

}
