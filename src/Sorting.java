//Simple cheat sheet with efficient examples for any sorting algorithm question that may come up in the exam!
//I suggest looking at the visual explanation of every algorithm before fully implementing: https://visualgo.net/en/sorting
//Anyways... thanks for using this and best of luck in your studies! :D
//I am using implementations from hello-algo as they are easy to understand and written efficiently (https://www.hello-algo.com/en/chapter_sorting/)
//(hello-algo is absouletly goated, deffo worth checking out if you wanna master DSA)

public class Sorting {

    //Main method stuff, some helper methods and testing the algorithms to see if they work correctly(in case I fuck up somewhere lol)
    public static int[] copyArray(int[] source) {
        int[] result = new int[source.length];
        for(int i=0; i<result.length; i++)
            result[i]=source[i];
        return result;
    }

    public static boolean compareArrays(int[] target, int[] sorted) {
        for(int i=0; i<target.length; i++) {
            if(sorted[i]!=target[i])
                return false;
        }
        return true;
    }

    public static void Test() {
        //Test sorting algos
        int[] test_data = {8, -1, 9, 2, 6, 1, 0, 12, 7, 22, 10, -17};
        int[] sorted_data = {-17, -1, 0, 1, 2, 6, 7, 8, 9, 10, 12, 22};

        //Selection sort
        int[] selection = copyArray(test_data);
        selectionSort(selection);
        System.out.println("Selection sort working: "+compareArrays(selection, sorted_data));

        //Bubble sort
        int[] bubble = copyArray(test_data);
        bubbleSort(bubble);
        System.out.println("Bubble sort working: "+compareArrays(bubble, sorted_data));

        //Insertion sort
        int[] insertion = copyArray(test_data);
        insertionSort(insertion);
        System.out.println("Insertion sort working: "+compareArrays(insertion, sorted_data));

        //Merge sort
        int[] merge = copyArray(test_data);
        mergeSort(merge, 0, merge.length-1);
        System.out.println("Merge sort working: "+compareArrays(merge, sorted_data));

        //Quick sort
        int[] quick = copyArray(test_data);
        quickSort(quick, 0, quick.length-1);
        System.out.println("Quicksort working: "+compareArrays(quick, sorted_data));

    }

    //SORTING ALGORITHMS *drumroll*

    //SELECTION SORT - O(n^2), select the smallest element in every iteration and swap with current element
    //Probably easiest to implement and understand out of all the sorting algos
    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n-1; i++) {
            int k=i; //Store the index of the smallest number
            for(int j=i+1; j<n; j++) { //One single iteration, find smallest number (Start at i+1, as the elements up to i are sorted)
                if(nums[j]<nums[k])
                    k=j;
            }
            //Swap elements
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    //BUBBLE SORT - O(n^2), compare elements beside each other from the end of array and swap. Do this n times
    //A lil less optimised and a lil harder to implement
    public static void bubbleSort(int[] nums) {
        for(int i=nums.length-1; i>0; i--) { //Run n iterations
            boolean swapped = false; //Check if fully sorted - a lil extra thing for optimization
            for (int j=0; j<i; j++) { //Swap elements through the entire loop
                if(nums[j]>nums[j+1]) {
                    //Swap
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped=true;
                }
            }
            if(!swapped) //If we do a full iteration and nothing had to be swapped, we are sorted :D
                break;
        }
    }

    //INSERTION SORT - O(n^2), pick a pivot element, push all sorted elements that are bigger forward and push target element back - imagine it like sorting a deck of cards
    //Quick and easy to implement but might be confusing to understand
    //https://youtu.be/na-A3oYgnbs
    public static void insertionSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int base = nums[i], j=i-1;
            while(j >= 0 && nums[j]>base) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    //THE BIG BOIS - be careful with those as they show no mercy and can catch you off-guard!!! these can also be a bitch to learn
    //MERGE SORT - O(n log n) - split array in half(partitioning) and then compare elements to each other, merge in the end
    //https://www.hello-algo.com/en/chapter_sorting/merge_sort.assets/merge_sort_overview.png
    public static void mergeSort(int[] nums, int left, int right) { //This part of the code does the splitting recursively
        if(left>=right) //If subarray length is 1 or less, just return since we have nothing to do with it
            return;
        int mid = left + (right-left)/2; //Midpoint for partitioning
        mergeSort(nums, left, mid); //Mergesort left partition
        mergeSort(nums, mid+1, right); //Aaand the right one
        merge(nums, left, mid, right); //Compare numbers in the end and merge them, this will backtrack up the tree
    }

    public static void merge(int[] nums, int left, int mid, int right) { //This one does the merging
        int[] tmp = new int[right-left+1]; //Create a temp array to store merged results
        //Indices for left and right subarrays
        int i=left;
        int j=mid+1;
        int k=0;

        //We compare each value, slide the index and store the results in the temp array
        while(i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }

        //Copy any remaining values
        while(i <= mid)
            tmp[k++] = nums[i++];
        while(j <= right)
            tmp[k++] = nums[j++];

        //Copy elements back to original array (Merging)
        for(i=0; i<tmp.length; i++)
            nums[left + i] = tmp[i];

    }

    //QUICKSORT - O(n log n) - similarly to merge sort however we recursively split the array however into a left and right partitions via a pivot, then swap in the end
    //Uses divide and conquer, i.e. split into smaller sub-problems and solve altogether
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) //If our subarrays are less than or equal to 1, we reached base case
            return;
        //Partition
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    //Helper function for quick swapping elements (You can use it with other algos if u wanna however a swap is only done once in the other algos)
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //Partitioning (Using nums[left] as pivot)
    public static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        //Swapping elements
        while(i < j) {
            while(i < j && nums[j] >= nums[left]) //Search from right to left to find the first element smaller than pivot
                j--;
            while(i < j && nums[i] <= nums[left]) //Search from left to right to find the first element greater than pivot
                i++;
            swap(nums, i, j); //Swap the elements
        }

        swap(nums, i, left); //Swap pivot to the boundary between the two subarrays
        return i;
    }

    //AAANDDD thats all folks!, these are all the algorithms you NEED to know for the exam
}