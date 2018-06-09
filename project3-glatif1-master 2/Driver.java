import java.util.*;
import java.io.*;


public class Driver {

    //initialize local variables
    private static int _minRating;
    private static int _userId;

    //initialize HashMap to store connected nodes
    private static HashMap<Integer, ArrayList<Connector>> adjacentList = new HashMap<>();

    //Initialize the Visited Array to store all visited values for DFS
    private static ArrayList<Float> AverageArray = new ArrayList<Float>();



    public Driver(int userId, int minRating){
        this._minRating = minRating;
        this._userId = userId;
    }


    //read and parse file
    //and then put all connected values in a hashmap
    public void fileFilter(String fileName) {
        String name = fileName;
        BufferedReader br = null;

        try{
            String currentLine;
            br = new BufferedReader(new FileReader(name));



            //read and parse the CSV file
            while((currentLine = br.readLine()) != null){
                String[] line = currentLine.split(",");
                int startNode = Integer.parseInt(line[0]);
                int endNode = Integer.parseInt(line[1]);
                int rating = Integer.parseInt(line[2]);

                //connector object to story the info
                Connector c = new Connector(startNode,endNode, rating);


                //create a temporary list for value of hashmap
                ArrayList<Connector> currentList = new ArrayList<Connector>();


                boolean check = true;
                while(check){
                    if(true) {

                        if (adjacentList.containsKey(startNode)) {
                            //if start node is already a key then add endnode to value
                            ArrayList<Connector> temp = adjacentList.get(c.getStartNode());
                            temp.add(c);
                            adjacentList.put(startNode, temp);
                            //System.out.println("Updated Current List: " + temp);
                            check = false;
                        } else {
                            //add new Key if start node isnt a key
                            currentList.add(c);
                            adjacentList.put(startNode, currentList);
                            //System.out.println("Key: " + startNode + "  Connected Node: " + currentList);
                            check = false;

                        }
                    }else{
                        check = false;
                    }

                }
            }
            br.close();

        }catch(FileNotFoundException e){
            System.out.println(e);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }



    //This computes the average for the temporary paths that are being visited, by using the connector object
    public static float computeAverage(ArrayList<Connector> paths){
        float sum = 0;
        float length = paths.size();
        for(Connector node : paths){
            sum += node.getRating();
        }
        float Average = sum/length;
        return Average;
    }


    //This function computes the total average from an array of Averages
    public static float computeTotalAverage(ArrayList<Float> Array){
        float sum = 0;
        float length = Array.size();
        for(float node : Array){
            sum += node;
        }
        float Average = sum/length;
        return Average;
    }


    //this function assists with DFS Function call
    public static void DFSCall(int s, int d)
    {
        ArrayList<Integer> Visited = new ArrayList<>();
        ArrayList<Connector> pathList = new ArrayList<Connector>();

        //add source to path[]
        Visited.add(s);

        //Call recursive utility
        DFS(s, d, Visited, pathList);
    }


    //Prints all the connected nodes using the depth first search algorithm
    private static void DFS(Integer node, Integer endNode, ArrayList<Integer> Visited, ArrayList<Connector> pathList) {
            // Mark the current node
            Visited.add(node);
            if (adjacentList.containsKey(node)) {
                for (Connector i : adjacentList.get(node)) {
                    if (i.getNode() != endNode && !Visited.contains(i.getNode())) {
                        System.out.println("From--->  " + i.getStartNode() + "  ----to---->  " + i.getNode() + "  Not end node!" + "   Rating: " + i.getRating());
                        // store current node to path list
                        pathList.add(i);

                        //recursive call
                        DFS(i.getNode(), endNode, Visited, pathList);


                        //remove the current element from current path list and visited list to reset the path
                        pathList.remove(i);
                        Visited.remove(new Integer(i.getNode()));


                    } else if (i.getNode() == endNode) {
                        //add the end node to the path list as well to get the final rating
                        pathList.add(i);
                        AverageArray.add(computeAverage(pathList));
                        System.out.println("From--->  " + i.getStartNode() + "  ----to---->  " + i.getNode() + " End node found!" + "   Rating: " + i.getRating());
                        System.out.println("Path Average: " + computeAverage(pathList));
                        pathList.remove(i);
                    }

                }
            }


    }








    //Main function call
    public static void main(String[] args){
        //read in file Name
        String FileName = args[0];

        //user inputs the Start Node and End Node
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a User ID: ");
        int userId = reader.nextInt();
        System.out.println("Enter End Node: ");
        int endNode = reader.nextInt();

        //create new driver object with given ID and Rating
        Driver d = new Driver(userId,endNode);

        //function calls
        d.fileFilter(FileName);
        DFSCall(userId, endNode);
        if (AverageArray.size() >0){
            System.out.println("|----------------------|");
            System.out.println("| Total Average: " + computeTotalAverage(AverageArray)+"  |");
            System.out.println("|----------------------|");
        }else{
           System.out.println("End Node not found");
        }

    }

}




