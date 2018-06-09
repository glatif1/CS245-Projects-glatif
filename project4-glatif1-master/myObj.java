
public class myObj
{
    // this is a linked list of object type 'myOBJ'
    String key;
    String value;

    myObj next;


    public myObj(Object key,Object value)
    {

        this.key = (String) key;
        this.value = (String) value;
        this.next = null;

    }

    @Override
    public String toString()
    {
        return "[" + key + ", " + value + "]";
    }
}