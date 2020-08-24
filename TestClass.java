package datastructure.practice.other;

import datastructure.practice.arrays.ArrayUtils;

enum Days {
    SUNDAY("Whoah"),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY("Yayyy!!!  ") {
        public String action() {
            return "it's saturday";
        }
    };

    public String action() {
        return "DUH!!!";
    }

    public String getMessage() {
        return this.message;
    }

    Days() {
    }

    Days(String message) {
        this.message = message;
    }

    public String message;
}

class ABC {

    private Days day;

    public void setDay(Days day) {
        this.day = day;
    }

    ABC getDay(ABC abc) {
        System.out.println("deyvbynxe");
        return new ABC();
    }

}

public class TestClass extends ABC {

    public static void main(String[] args) {
        TestClass t1 = new TestClass();
        //t1.setDay(Days.SATURDAY);
        //t1.totalDigits(13);
        //squaredSortedArray(new int[]{-20,-5,-1,3,8,15});
        //removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        //removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        strStr("mississippi", "pi");

        //System.out.println(t1.getDay().getMessage() + " " + t1.getDay().action());
    }

    private TestClass getDay(TestClass t1) throws Exception {
        System.out.println("xdvgb");
        return new TestClass();
    }

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


    private int totalDigits(int totalPages) {
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


    /*public static void main(String[] args) {

        int n= 16;
        printPattern(n);

    }*/
    static void printPattern(int n) {
        if (n == 0 || n < 0) {
            System.out.print(n + " ");
            return;

        }
        System.out.print(n + " ");
        printPattern(n - 5);

        System.out.print(n + " ");


    }

    static int[] squaredSortedArray(int[] arr ){
        int[] squaredArray = new int[arr.length];

        int i=0; int j = arr.length-1; int k = squaredArray.length-1; int tempLesserNumber;

        while(i!=j){
            if(Math.pow(arr[i],2)>Math.pow(arr[j],2)){
                squaredArray[k]=(int)Math.pow(arr[i],2);
                i++; k--;
            }else if(Math.pow(arr[i],2)<Math.pow(arr[j],2)){
                squaredArray[k]=(int)Math.pow(arr[j],2);
                j--; k--;
            }else{
                squaredArray[k]=(int)Math.pow(arr[i],2);
                i++; j--; k--;
            }
        }

        return squaredArray;
    }

    //*
    static int removeDuplicates(int[] nums) {
        int lengthWithoutDuplicates = 1;

        //two pointers
        int i=0; int j=1;

        //right side pointer goes upto end of the array
        while(j<nums.length){

            //if both numbers have same value, move the right side index by 1
            if(nums[i]==nums[j]){
                j++;
            }
            //if numbers have different values, increment left pointer by 1 and swap with right pointer
            else{
                nums[++i]=nums[j];
                lengthWithoutDuplicates++;
            }

        }
        return lengthWithoutDuplicates;
    }

    public static int removeElement(int[] nums, int val) {
        int i = nums.length-1; int j = nums.length-1;
        int newLen= 0;

        while(j>=0){
            if(nums[i]==val){
                i--;j--;
            }
            if(nums[j]==val){
                 nums[i]=nums[i]+nums[j];
                 nums[j]=nums[i]-nums[j];
                 nums[i]=nums[i]-nums[j];
                i--;j--;
            }else{
                j--;
                newLen++;
            }
        }
        return newLen;
    }

    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        int i=0;
        int j=0;
        while(i < haystack.length() ){
            if(j==needle.length()){
                return i-j;
            }
            if(haystack.charAt(i) != needle.charAt(j)){
                if(j!=0){
                    i=i-j;
                    j=0;
                }
                i++;

            }
            else{
                i++;
                j++;
            }
        }
        if(j==needle.length()){
            return haystack.length()-j;
        }
        return -1;
    }
}

