package org.example.hashing;

import java.util.*;

public class BasicHashing {

    public static List<List<Integer>> countFrequencies(int[] nums) {
        // Your code goes here

        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> a: entries ){

            list.add(List.of(a.getKey(), a.getValue()));

        }


        return list;

    }

    public static int mostFrequentElement(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();

        int ans = nums[0];
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> a: map.entrySet()) {
            if (a.getValue() > max) {
                ans = a.getKey();
                max = a.getValue();
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        System.out.println(countFrequencies(new int[]{1, 2, 2, 1, 3}));
        System.out.println(mostFrequentElement(new int[]{1, 2, 2, 3, 3, 3}));
    }
}
