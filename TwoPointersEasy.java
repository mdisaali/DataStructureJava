package datastructure.practice.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoPointersEasy {

    public static void main(String[] args) {
        TwoPointersEasy t1 = new TwoPointersEasy();
        //t1.setDay(Days.SATURDAY);
        //t1.totalDigits(13);
        //squaredSortedArray(new int[]{-20,-5,-1,3,8,15});
        //removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        //removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        //strStr("mississippi", "pi");

        //System.out.println(t1.getDay().getMessage() + " " + t1.getDay().action());
    }

    //Shuffle a given array using O(n/2)
    int[] shuffleArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int tempIndex = 0;
        for (int i = 0; i < n / 2; i++) {
            temp[tempIndex] = nums[i];
            temp[tempIndex + 1] = nums[n / 2 + i];
            tempIndex = tempIndex + 2;
        }
        return temp;
    }

    //total digits for a given total page
    int totalDigits(int totalPages) {
        int totalDigits = 0;
        for (int i = 1; i <= 9; i++) {
            if (totalPages < Math.pow(10, i)) {
                int numberToBeAdded = 0;
                for (int j = 1; j < i; j++) {
                    numberToBeAdded = (int) (numberToBeAdded + (j * Math.pow(10, j - 1) * 9));
                }
                totalDigits = (int) (numberToBeAdded + (totalPages - (Math.pow(10, i - 1)) + 1) * i);
                break;
            }
        }
        return totalDigits;
    }


    //print pattern if 
    static void printPattern(int n) {
        if (n == 0 || n < 0) {
            System.out.print(n + " ");
            return;

        }
        System.out.print(n + " ");
        printPattern(n - 5);

        System.out.print(n + " ");


    }

    //return a sorted array containing squares of all the elements of a agiven sorted array. 
    static int[] squaredSortedArray(int[] arr) {
        int[] squaredArray = new int[arr.length];

        int i = 0;
        int j = arr.length - 1;
        int k = squaredArray.length - 1;
        int tempLesserNumber;

        while (i != j) {
            if (Math.pow(arr[i], 2) > Math.pow(arr[j], 2)) {
                squaredArray[k] = (int) Math.pow(arr[i], 2);
                i++;
                k--;
            } else if (Math.pow(arr[i], 2) < Math.pow(arr[j], 2)) {
                squaredArray[k] = (int) Math.pow(arr[j], 2);
                j--;
                k--;
            } else {
                squaredArray[k] = (int) Math.pow(arr[i], 2);
                i++;
                j--;
                k--;
            }
        }

        return squaredArray;
    }

    //remove duplicate number , modify the array and return the length 
    static int removeDuplicates(int[] nums) {
        int lengthWithoutDuplicates = 1;

        //two pointers
        int i = 0;
        int j = 1;

        //right side pointer goes upto end of the array
        while (j < nums.length) {

            //if both numbers have same value, move the right side index by 1
            if (nums[i] == nums[j]) {
                j++;
            }
            //if numbers have different values, increment left pointer by 1 and swap with right pointer
            else {
                nums[++i] = nums[j];
                lengthWithoutDuplicates++;
            }

        }
        return lengthWithoutDuplicates;
    }


    //remove elements of array having same value as a given value
    public static int removeElement(int[] nums, int val) {
        int i = nums.length - 1;
        int j = nums.length - 1;
        int newLen = 0;

        while (j >= 0) {
            if (nums[i] == val) {
                i--;
                j--;
            }
            if (nums[j] == val) {
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
                i--;
                j--;
            } else {
                j--;
                newLen++;
            }
        }
        return newLen;
    }

    //return the index of haystack where the needle starts, return -1 if it does not contain and 0 if both are same.  
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (j == needle.length()) {
                return i - j;
            }
            if (haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    i = i - j;
                    j = 0;
                }
                i++;

            } else {
                i++;
                j++;
            }
        }
        if (j == needle.length()) {
            return haystack.length() - j;
        }
        return -1;
    }

    //merge two sorted arrays O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m + n - 1;
        m--;
        n--;

        while (i >= 0) {
            if (m == -1) {
                nums1[i--] = nums2[n--];
                continue;
            }

            if (n == -1) {
                nums1[i--] = nums1[m--];
                continue;
            }

            if (nums1[m] <= nums2[n]) {
                nums1[i--] = nums2[n--];
            } else {
                nums1[i--] = nums1[m--];
            }
        }

    }

    //valid palindrome two pointers
    public boolean isPalindrome(String s) {

        if (s == null) return false;
        if (s.length() == 0) return true;

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i++;
                continue;
            }

            if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j--;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //floyd's algorithm to find cycle in a linked list
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //two sum problem two pointer technique
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return null;
    }

    //move zeros to the end
    public void moveZeroes1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] == 0) {
                for (int k = i; k < j; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[j--] = 0;
            } else i++;
        }
    }

    //move zeros to the end faster
    public void moveZeroes2(int[] nums) {
        int flag = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[i] = nums[++flag] + nums[i];
                nums[flag] = nums[i] - nums[flag];
                nums[i] = nums[i] - nums[flag];
            }
        }
    }

    //reverse a string keeping in place and O[n)
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char c;
        while (i < j) {
            c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }

    //reverse the vowels of a string
    public String reverseVowels(String s) {
        char[] cArr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char c;

        while (i < j) {
            if (!checkVowel(s.charAt(i))) {
                i++;
                continue;
            }
            if (!checkVowel(s.charAt(j))) {
                j--;
                continue;
            }
            c = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = c;
            i++;
            j--;
        }
        return String.valueOf(cArr);
    }

    private boolean checkVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    //intersection of two arrays using hashset
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }

    //using ArrayList and two pointers
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            int arr[] = new int[0];
            return arr;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int arr[] = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }

        return arr;
    }

    //backspace string compare : '#' is backspace
    public boolean backspaceCompare(String S, String T) {
        String A = getString(S);
        String B = getString(T);
        return A.contentEquals(B);
    }

    private String getString(String A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (sb.length() > 0 && A.charAt(i) == '#') {
                sb.setLength(sb.length() - 1);
            } else if (A.charAt(i) != '#') {
                sb.append(A.charAt(i));
            }
        }


        return sb.toString();
    }

    //k-diff pairs of an array
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j >= i + 2 && nums[j - 1] == nums[j]) {
                    continue;
                }
                if (Math.abs(n - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}


