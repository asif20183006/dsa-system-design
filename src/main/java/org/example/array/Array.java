package org.example.array;

import java.util.*;

public class Array {

    public static int binarySearch(int []arr, int num) {

        /*

        we will check util l < h

        get the mid element
        if mid element is equal to num return index of mid
        if mid element is < num then new l will be mid index +1
        if mid element is > num then new h will be mid - 1

         */

        int l=0,h= arr.length - 1;

        while(l<=h) {

            int mid = (l+h)/2;
            if (arr[mid] == num) {
                return mid;
            }

            if (arr[mid] < num) {
                l = mid+1;
            } else {
                h=mid-1;
            }

        }

        return -1;

    }

    public static int[] firstAndLastOccurrenceOfDuplicateSortedArray1(int []arr, int e) {

        /*

        1,2,2,3,3,4
        0,1,2,3,4,5

       l=0,h=5,m=2
       l=3,h=5,m=4, 3,3,4

      if am=ele
      l=m-1
      h=m+1
            while (ele==




         */


        int l=0,h=arr.length-1;


        int []ans = new int[2];

        while (l<=h) {

            int m = l + (h-l)/2;
            if (arr[m] == e) {

                l=m;h=m;

                while (l<arr.length && arr[l] == e ) {

                    ans[1]=l;
                    l++;
                }

                while (h>=0 && arr[h] == e) {
                    ans[0]=h;
                    h--;
                }
                return ans;
            } else
            if (arr[m] < e) {
                l = m+1;
            } else {
                h=m-1;
            }

        }
        return ans;

    }

    public static int firstAndLastOccurrenceOfDuplicateSortedArray2(int []arr, int e, boolean startIndex) {

        /*

        1,2,2,3,3,4
        0,1,2,3,4,5

       l=0,h=5,m=2
       l=3,h=5,m=4, 3,3,4

      if am=ele
      l=m-1
      h=m+1
            while (ele==




         */


        int l=0,h=arr.length-1;


        int ans=-1;

        while (l<=h) {

            int m = l + (h-l)/2;
            if (arr[m] == e) {

                ans=m;
               if (startIndex) {
                   h=m-1;
               } else {
                   l = m+1;
               }

            } else
            if (arr[m] < e) {
                l = m+1;
            } else {
                h=m-1;
            }

        }
        return ans;

    }



  /*  Input: nums = [3, 3, 6, 1]

    Output: 6

    Explanation: The largest element in array is 6

    Input: nums = [3, 3, 0, 99, -40]

    Output: 99

    Explanation: The largest element in array is 99

     solution 1

     ans = 3;




    */

    public static int largestElement(int[] nums) {

        int max=nums[0];

        for(int i=0;i< nums.length;i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }

        return max;

    }


    /*Input: nums = [8, 8, 7, 6, 5]

    Output: 7

    Explanation: The largest value in nums is 8, the second largest is 7

    Input: nums = [10, 10, 10, 10, 10]

    Output: -1
*/

    public static int secondLargestElement(int[] nums) {


        int firstLargest = nums[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i<nums.length; i++) {

            if (nums[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = nums[i];

            } else if(nums[i] > secondLargest && nums[i] != firstLargest) {
                secondLargest = nums[i];
            }

        }

        if (secondLargest == Integer.MIN_VALUE) return -1;

        return secondLargest;



    }
/*

    Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.


    Examples:
    Input : nums = [1, 2, 3, 4, 5]

    Output : true

    Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

    Input : nums = [1, 2, 1, 4, 5]

    Output : false

    Explanation : For i == 2 it does not hold nums[i] <= nums[i+1], hence it is not sorted and we return false.

*/


    public static boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here

        int pre = nums.get(0);
        for (int i: nums) {
            if (i < pre) {
                return false;
            }

            pre = i;
        }

        return true;


    }


    /*
  Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once. Return the number of unique elements in the array.



If the number of unique elements be k, then,

Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
The remaining elements, as well as the size of the array does not matter in terms of correctness.


An array sorted in non-decreasing order is an array where every element to the right of an element is either equal to or greater in value than that element.


Examples:
Input: nums = [0, 0, 3, 3, 5, 6]

Output: 4

Explanation: Resulting array = [0, 3, 5, 6, _, _]

There are 4 distinct elements in nums and the elements marked as _ can have any value.

Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]

Output: 4

Explanation: Resulting array = [-2, 2, 4, 5, _, _, _, _]

There are 4 distinct elements in nums and the elements marked as _ can have any value.

algo:
will be assiging a = nums[0]
if a== nums[i] then dont do anything just go ahead
else c++; a=a[i]

return c;




     */






    public static int linearSearch(int nums[], int target) {
        for (int i =0;i<nums.length;i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int removeDuplicates(int[] nums) {

        int c=1;
        int a=nums[0];

        for(int i=0;i<nums.length;i++) {

            if (a != nums[i]) {
                a=nums[i];
                nums[c] = a;
                c++;

            }


        }

        for (int i =0; i< c; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        System.out.println(c);
        return c;
    }

    /*

    Given an integer array nums, rotate the array to the left by one.



Note: There is no need to return anything, just modify the given array.


Examples:
Input: nums = [1, 2, 3, 4, 5]

Output: [2, 3, 4, 5, 1]

Explanation: Initially, nums = [1, 2, 3, 4, 5]

Rotating once to left -> nums = [2, 3, 4, 5, 1]

Input: nums = [-1, 0, 3, 6]

Output: [0, 3, 6, -1]

Explanation: Initially, nums = [-1, 0, 3, 6]

Rotating once to left -> nums = [0, 3, 6, -1]
     */



    public static void rotateArrayByOne(int[] nums) {

        int a = nums[0];
        for (int i = 1; i<nums.length; i++ ) {
            nums[i-1] = nums[i];
        }

        nums[nums.length - 1] = a;

        for (int i = 0; i<nums.length; i++ ) {
            System.out.print(nums[i] + " " );
        }

    }

    /*

    Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.


Examples:
Input: nums = [1, 2, 3, 4, 5, 6], k = 2

Output: nums = [3, 4, 5, 6, 1, 2]

Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]

rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]


     */
    public static void rotateArray1(int[] nums, int k) {

        int n= nums.length;

        k = k%n;
        int [] a = new int[k];

        for (int i = 0; i < k; i++) {

            a[i] = nums[i];
        }



        for (int i = k; i<n; i++) {

            nums[i-k] = nums[i];
        }

        for (int i=n-k; i< n;i++) {
            nums[i] = a[i - (n-k)];
        }



        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void rotateArray2(int[] nums, int k) {

        int n= nums.length;

        k = k%n;
        // 1, 2, 3, 4, 5 --> 2,1 --> 5,4,3 --> 3,4,5,1,2
        // 3,4,5,1,2


        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, n-1);
        reverseArray(nums, 0, n-1);


        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }

    }


    public static void reverseArray(int []nums, int s, int e) {

        while (s <= e) {

            int temp = nums[e];
            nums[e] = nums[s];
            nums[s] = temp;

            s++;e--;
        }

        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

    }


    /*


    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

     */


    public static void rotate(int[] nums, int k) {
        int n= nums.length;

        k = k%n;




        int []a = new int[k];

        for(int i = n-k; i< n; i ++) {
            a[i - (n-k)] = nums[i];
        }

        for (int i = n-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }

        for(int i = 0; i<a.length;i++) {
            nums[i] = a[i];
        }

        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }


    }


    public static void rotate1(int[] nums, int k) {
        int n= nums.length;

        k = k%n;



        reverseArray(nums, 0, k);
        reverseArray(nums, k+1, n-1);
        reverseArray(nums, 0, n-1);
        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }


    }

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.



Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

 */


    public static int findMaxConsecutiveOnes(int[] nums) {

        int max=0;
        int c=0;
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] == 1) {
                c++;
                max = Math.max(c, max);
            } else {
                c =0;
            }
        }

        return max;


    }

/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

 */


    public static void moveZeroes(int[] nums) {

        // find fist zero index then from the next indx check if it is non zero swap it and move j;

        int j = -1;

        for(int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) {
                j= i;
                break;
            }
        }

        for(int i = j+1; i< nums.length; i++) {
            if (nums[i] != 0){

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                j++;
            }
        }
        for (int i =0; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }

/*
Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.



The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.


Examples:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

Output: [1, 2, 3, 4, 5, 7]

Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]

Output: [1, 3, 4, 5, 6, 7, 8, 9]

Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2
 */
    public static int[] unionArray(int[] nums1, int[] nums2) {

        // will itrate in both the array nums[i]<nums2[j] ans[i] i++ else j++;


        int ans[] = new int[nums1.length + nums2.length];

        int i =0,j=0;

        int m = nums1.length;
        int n = nums2.length;

        int k = 0;



        while(i < m && j < n) {

            if(nums1[i] <= nums2[j]) {

                if (k == 0 || ans[k-1] != nums1[i]) {
                    ans[k++] = nums1[i];
                }

                i++;

            } else {
                if(k == 0 || ans[k-1] != nums2[j]) {
                    ans[k++] = nums2[j];
                }
                j++;

            }
        }

        while (i<m) {

            if (k == 0 || ans[k-1] != nums1[i]) ans[k++] = nums1[i];
            i++;

        }

        while (j<n) {

            if (k == 0 || ans[k-1] != nums2[j]) {
                ans[k++] = nums2[j];
            }

            j++;


        }

        return ans;

    }

/*
Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.



 */

    public static int missingNumber(int[] nums) {

        int temp[] = new int[nums.length + 1];

        for (int i = 0; i<nums.length; i++) {
            temp[nums[i]] = 1;
        }

        for (int i =0;i<temp.length; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }

        return -1;


    }


    public static int missingNumber1(int[] nums) {

       int n  = nums.length;
       int totalSum  = n*(n+1)/2;

       int sum = 0;

        for (int i = 0; i<nums.length; i++) {
            sum+=nums[i];
        }

        return totalSum - sum;


    }
/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1




 */

    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int c= map.get(nums[i]) +1;
                map.put(nums[i], c);
            } else {
                map.put(nums[i], 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() <= 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int singleNumber1(int[] nums) {

        int xor = 0;
        for (int i = 0; i<nums.length; i++) {
           xor = xor^nums[i];
        }
        return xor;
    }


    public static void printAllSubArray(int []nums) {


        for(int i = 0; i< nums.length; i++) {
            for (int j = i ; j<nums.length; j++) {
                for (int k = i ;k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();

            }
        }


    }

/*

Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.

 */

    public static int longestSubArray(int[] nums, int k) {


        int ans = 0;
        for(int i = 0; i< nums.length; i++) {
            for (int j = i ; j<nums.length; j++) {
                int s = 0;
                for (int l = i ;l <= j; l++) {
                    s+=nums[l];
                }
                if (s==k) ans = Math.max(ans, j-i+1);


            }
        }
        return ans;
    }


    public static int longestSubArray1(int[] nums, int k) {


        int ans = 0;
        for(int i = 0; i< nums.length; i++) {
            int s = 0;
            for (int j = i ; j<nums.length; j++) {
                s+=nums[j];
                if (s==k) ans = Math.max(ans, j-i+1);

            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(longestSubArray1(new int[]{10, 5, 2, 7, 1, 9}, 15));


    }
}
