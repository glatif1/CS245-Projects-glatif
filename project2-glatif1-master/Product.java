public class Product {

    //TODO: Declare/initialize instance members
    private String asin;
    private int[] rating;

    //TODO: Create constructor(s)
    public Product(String asin, int[] ratings) {
        //ensure you get correct key
        this.asin = asin;
        rating = new int[ratings.length];
        System.arraycopy(ratings, 0, rating, 0, ratings.length);
    }

    public float averageRating() {
        if(rating.length == 0){
            return 0;
        }
        float avg = 0;
        //add all ratings together
        for (int i = 0; i < rating.length; i++) {
            avg += rating[i];
        }
        //divide by total length
        avg = avg / rating.length;
        return avg;
    }

    @Override
    public String toString() {
        return asin;
    }
}

