import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
/*
* This is a k way merge function, 
* This program splits into k lists and merges in order though.
* */

class kWayMerge {



    static void merge(int arr[], int l, int mid, int r, int k) {
        //creates a temporary sublist
        int sublist[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sublist[i] = arr[i];
        }
        //creates an array of indexes, each element is represented as the length of the sublist
        int indexArray[] = new int[k];
        for (int i = 0; i < k; i++){
            indexArray[i] = i*(arr.length/k);
        }

        int lengthOfList = mid;
        int high = r;
        int low = l;
        int counter = 0;
        int lowIndex = 0;

        //outer while loop iterates through the whole list
        while (counter < (high-low) - 1) {
            //inner for loop iterates through the sublists comparing elements
            for (int i = 0; i < k-1; i++) {
                    //compares the elements of the sublist using the indexArray indexs as the index of the sublist
                    if (sublist[indexArray[i]] < sublist[indexArray[i+1]]) {
                        //switches out the lowest element with the new lowest
                        arr[lowIndex] = sublist[indexArray[i]];
                        indexArray[i] += 1;
                        printArray(indexArray);
                    } else if (sublist[indexArray[i+1]] < sublist[indexArray[i]]) {
                        arr[lowIndex] = sublist[indexArray[i+1]];
                        indexArray[i+1] += 1;
                        printArray(indexArray);
                    }

            }
            lowIndex++;
            counter++;
        }
    }

    static void mergeFunction(int arr[], int l, int m, int r, int k)
    {
        // Find sizes of two subarrays to be merged

        int len1 = m - l + 1;
        int len2 = r - m;


        /* Create temp arrays */
        int L[] = new int [len1];
        int R[] = new int [len2];

        for (int i=0; i<len1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<len2; ++j)
            R[j] = arr[m + 1+ j];



        int i = 0, j = 0;

        int low = l;
        while (i < len1 && j < len2)
        {
            if (L[i] <= R[j])
            {
                arr[low] = L[i];
                i++;
            }
            else
            {
                arr[low] = R[j];
                j++;
            }
            low++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < len1)
        {
            arr[low] = L[i];
            i++;
            low++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < len2)
        {
            arr[low] = R[j];
            j++;
            low++;
        }
    }



    static void mergeSort(int[] arr, int low, int high, int k)
    {
        k = 2;

        if (low < high)

        {
            // Find the middle point
            int m = (low+high)/2;
            mergeSort(arr, low, m,2);
            mergeSort(arr, m+1, high,2);
            merge(arr, low, m, high, 2);


        }

        if (low > high)
        {
            if (high - low + 1 >= k)
            {
                int sizeSubList = (high - low + 1) / k;
                if (sizeSubList % k == 0)
                {
                    for (int i = 0; i < k; i++) {
                        //System.out.println("Regular ---> i*sizeSublist = "+ i*sizeSubList);
                        mergeSort(arr, i * sizeSubList, (i + 1) * sizeSubList - 1, k);
                    }
                }else
                {
                    for (int i = 0; i < k - 1; i++)
                        {
                            //System.out.println("For the else-->  i*sizeSublist = "+ i*sizeSubList);
                            mergeSort(arr, i * sizeSubList, (i + 1) * sizeSubList - 1, k);
                        }
                    //System.out.println("Outside else-->  (k-1)*sizeSublist = "+ (k-1)*sizeSubList);
                    mergeSort(arr, (k - 1) * sizeSubList, high, k);
                }
                //System.out.println("THE MIDDDDD = " + (low+sizeSubList));
                merge(arr, low, low+sizeSubList, high , k);


            } else
                {
                merge(arr, low, 1, high - 1, k);
                }

        }


    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {

        try {
            String fileName = args[0];

            int counter = 0;
            Scanner sc = new Scanner(new File(fileName));
            int k = sc.nextInt();

            System.out.println("K is: " + k);
            while (sc.hasNextInt()) {
                counter += 1;
                int nextInt = sc.nextInt();
            }
            sc.close();

            Scanner sc1 = new Scanner(new File(fileName));
            int arr[] = new int[counter - 1];
            sc1.nextInt();
            while (counter > 1 && sc1.hasNextInt()) {
                int num = sc1.nextInt();
                counter -= 1;
                arr[counter - 1] = num;


            }
            int arr1[] = {5,4,3,2,1,0,1,2,45,6,7};

            System.out.println("Given Array");
            printArray(arr1);


            mergeSort(arr1, 0, 11, 4);

            System.out.println("\nSorted array");
            printArray(arr1);
            sc1.close();

        } catch (FileNotFoundException ex) {

            System.out.println("Unable to open file");
        }


    }

    public static void writeToFile(int[] arr, File fileName){
        try{
            File file = new File(fileName + "_sorted");
            FileWriter fw = null;
            for(int i = 0; i<arr.length; i++ ) {
                fw = new FileWriter(file);
                fw.write(arr[i] + '\n');
            }
            fw.close();
            } catch(Exception e){System.out.println(e);}

        }

}






