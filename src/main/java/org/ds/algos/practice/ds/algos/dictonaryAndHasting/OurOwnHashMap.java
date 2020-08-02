package org.ds.algos.practice.ds.algos.dictonaryAndHasting;

import java.util.ArrayList;
import java.util.List;

public class OurOwnHashMap {

    private static final int BUCKET_COUNT = 100;

    // Create a list of lists just like hash set in Java
    // Main List will have ${bucketCount} lists(buckets)
    // Each bucket will have unlimited value
    List<List<Integer>> data;

    public OurOwnHashMap() {
        data = new ArrayList<>();
        for(int i=0; i<BUCKET_COUNT; i++) {
            List<Integer> newList = new ArrayList<>(0);
            data.add(newList);
        }
    }

    public void add(int key) {
        int hash = hash(key);
        if(!contains(key))
            data.get(hash).add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        List<Integer> bucket = data.get(hash);
        for(int i=0; i<bucket.size(); i++) {
            if (bucket.get(i) == key)
                bucket.remove(i);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        List<Integer> bucket = data.get(hash);
        for(int i: bucket) {
            if(i == key)
                return true;
        }
        return false;
    }

    private int hash(int number) {
        return number % BUCKET_COUNT;
    }
}
