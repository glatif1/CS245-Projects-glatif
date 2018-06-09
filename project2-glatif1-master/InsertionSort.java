public class InsertionSort {

    public static void InsertionSort(ArrayBasedList<Product> plist) {

        int size = plist.size();

        for (int i = 1; i < size; i++) {
            float key = plist.get(i).averageRating();
            Product product = plist.get(i);

            int j = i-1;

            while (j >= 0 && plist.get(j).averageRating() < key) {
                plist.set(j+1, plist.get(j));
                j--;
            }

            plist.set(j+1, product);


        }

    }



}

