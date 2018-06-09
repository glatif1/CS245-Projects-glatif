public class QuickSort {


    public static int partition(ArrayBasedList<Product> plist, int low, int high) {
        // track of avg rating & Product of pivot element
        Product firstPivot = plist.get(high);
        float secondPivote = firstPivot.averageRating();

        int i = low - 1;

        for (int j = low; j < high; j++) {
            float currentRating = plist.get(j).averageRating();
            if (currentRating >= secondPivote) {
                i++;
                // Swap the elements at i and j)
                Product iProduct = plist.get(i);
                Product currenProduct= plist.get(j);
                plist.set(i, currenProduct);
                plist.set(j, iProduct);
            }
        }

        Product temp = plist.get(i+1);
        plist.set(i+1, firstPivot);
        plist.set(high, temp);

        return i+1;
    }

    public static void sort(ArrayBasedList<Product> plist, int indexLow, int indexHigh) {
        if (indexLow < indexHigh) {
            int part = partition(plist, indexLow, indexHigh);
            sort(plist, indexLow, part - 1);
            sort(plist, part + 1, indexHigh);
        }
    }
}

