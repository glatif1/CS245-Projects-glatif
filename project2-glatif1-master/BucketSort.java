
public class BucketSort {

    public static void sort(ArrayBasedList<Product> plist, int n) {
        //TODO: Implement bucket sort.
        //n is the number of buckets
        int bucketCount = n;
        //find the minimum value in the list
        InsertionSort iSort = new InsertionSort();
        float minVal = plist.get(0).averageRating();


        for (int i =0; i < plist.size(); i++){
            if (minVal > plist.get(i).averageRating()){
                minVal = plist.get(i).averageRating();
            }

        }
        //The buckets are being initialized
        ArrayBasedList<ArrayBasedList<Product>> buckets = new ArrayBasedList<ArrayBasedList<Product>>();
        for(int i = 0; i < plist.size(); i++){
            buckets.add(new ArrayBasedList<Product>());
        }

        //placing the values of plist into correct buckets
        for (int i = 0; i < plist.size(); i++){
            int divider = (int) Math.floor((plist.get(i).averageRating()-minVal)/bucketCount);
            buckets.get(divider).add(plist.get(i));
        }
        //call insertion sort on each subarray and set the sub-array to corresponding index within plist
        //Call InsertionSort on each bucket
        int index = 0;
        for(int i = 0; i < plist.size(); i++){
            iSort.InsertionSort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++){
                plist.set(index, buckets.get(i).get(j));
                index++;
            }

        }

        System.out.println(plist);

    }

}
