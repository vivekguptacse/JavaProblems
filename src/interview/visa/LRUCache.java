package interview.visa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author : Vivek Kumar Gupta
 * @since : 10/10/21
 */
public class LRUCache {

    private Map<String, String> cache;

    private Queue<String> queue;

    private int size;

    private int counter = 0;

    public LRUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>(size);
        this.queue = new LinkedList<String>();
    }

    public void add(String key, String value) {
        if(cache.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
        } else {
            if(counter >= size) {
                cache.remove(queue.remove());
            } else {
                queue.remove(key);
            }

            queue.offer(key);
            cache.put(key,value);
            counter++;
        }
    }

    public String remove(String key) {
        String result = "Key Not present";
        if(cache.containsKey(key)) {
            queue.remove(key);
            result = cache.remove(key);
            counter--;
        }

        return result;
    }

    public String get(String key) {
        return cache.getOrDefault(key,"This value is not cached");
    }


    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.add("test","value");
        lru.add("test2","value2");
        lru.add("test3","value3");
        lru.add("test1","value1");
        System.out.println(lru.get("test2"));
        System.out.println(lru.get("test3"));
        System.out.println(lru.remove("test3"));
        System.out.println(lru.get("test3"));


    }
}
