import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Driver {

    public static void main(String[] args) {
        ArrayBasedList<Product> plist = new ArrayBasedList<Product>();
    //TODO: Read .csv file from command line and parse into ArrayBasedList<Product>
    // You should not need to declare another ArrayBasedList<Product> in main
        String file = args[0];
        String line;
        System.out.println(args[0]);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] CurrentLine = line.split(",");
                int[] tempArr = new int[CurrentLine.length - 1];
                for (int a = 1; a < CurrentLine.length; a++) {
                    String temp = CurrentLine[a].replaceAll("[^a-zA-Z0-9]", "");
                    int x = Integer.parseInt(temp);
                    tempArr[a - 1] = x;
                }
                Product newProduct = new Product(CurrentLine[0], tempArr);
                plist.add(newProduct);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }




        try {
    // This will test the certain edge case and accuracy of your sorts.
    // This is NOT comprehensive and your own tests need to done in
    // addition to this test.
    //
    // TODO: To look the timing of your sorts, uncomment printTiming in the
    // Test.java file. Large samples will take a long time to complete though.
            Test.test(plist, args);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException | IOException e) {
            System.out.println("Test could not run/finish.");
        }
        //TODO: Sort based on averageRating from highest to lowest.

    //TODO: Write to a new .csv file named whatever the file being read is with "_sorted"
    //      added to it. So if the file being read is called ratings_Stuff.csv, your file
    //      will be called ratings_Stuff_sorted.csv. For this part, use any of your sorts.
    //      The file will have one ASIN per line.

        String endFile = args[0];
        // Create file name for sorted plist
        endFile = endFile.substring(0, endFile.lastIndexOf('.'));
        endFile += "_sorted.csv";
        try {
            PrintWriter pw = new PrintWriter(endFile);
            String input;

            for (int i = 0; i < plist.size(); i++) {
                input = plist.get(i).toString();
                input += '\n';
                pw.write(input);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//            try {
//    // Requires both result and sorted files to be in current directory
//                Test.testFile(args);
//            } catch (IOException e1) {
//                System.out.println("----------------------------------------");
//                System.out.println("!! File Test: Could not read file. Check file naming.");
//            } catch (IndexOutOfBoundsException e2) {
//                System.out.println("----------------------------------------");
//                System.out.println("!! File Test: Missing command line argument");
//            }
    }

}