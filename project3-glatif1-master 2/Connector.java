/*
* Class of type of object. Store the endNode,
* startNode, and rating as one object. With getters
* and setters. Will mainly be used for part 2 of the project
* to access the ratings of the the connections.
 */


public class Connector {

    //initialize variables
    private int _startNode;
    private int _rating;
    private int _endNode;

    public Connector(int startNode, int endNode, int rating){
        //constructor
        this._startNode = startNode;
        this._endNode = endNode;
        this._rating = rating;
    }

    public String getAll(){
        //returns all variables
        int rate = this._rating;
        int end = this._endNode;
        int start = this._startNode;

        return " "+ start +" "+ end+ " "+rate;

    }

    public int getRating(){//returns rating
        return this._rating;
    }
    public int getNode(){//returns the endNode
        return this._endNode;
    }

    public int getStartNode(){//returns startNode
        return this._startNode;
    }


    public void set(int newNode, int newEndNode, int newRating){//Sets all the values
        this._startNode = newNode;
        this._endNode = newEndNode;
        this._rating = newRating;
    }





}
