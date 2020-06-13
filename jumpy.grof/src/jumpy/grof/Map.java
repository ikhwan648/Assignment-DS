package jumpy.grof;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Map 
{
    // Variables
    private final Random RAND = new Random();
    private ArrayList<Point> points = new ArrayList<>();
    private int colonizationThreshold;
    private ArrayList<Boolean> counter = new ArrayList<>();

    // Constructor (DONE)
    public Map() {this(null, -69);}
    public Map(Point[] spots, int colonizationThreshold)
    {
        // If randomly generated
        if(spots == null && colonizationThreshold == -69)
        {
            // For each of the to be points (2 - 20)
            for(int size = 2 + RAND.nextInt(19); size != 0; size--)
            {
                // Create the point
                Point point = new Point();

                // Ensure that the points' id is unique
                while(true)
                    if(this.contain(point.getID())) 
                        point.setID(RAND.nextInt(1001));
                    else 
                        break;
                
                // Add the point to the list
                this.points.add(point);
            }
            
            // The random colonization threshold is between 6 and 12
            this.colonizationThreshold = 6 + RAND.nextInt(7);
        }
        else
        {
            // Put in the points and initialize the colonization threshold
            this.points = new ArrayList<Point>(Arrays.asList(spots));
            this.colonizationThreshold = colonizationThreshold;
        }
        
        // Link the points together 
        for(int i = 0; i < this.points.size(); i++)
            for(int j = 0; j < this.points.size(); j++)
                if(this.points.get(i).linkIsFull() == false && this.points.get(i).equals(this.points.get(j)) == false)
                    this.points.get(i).makeLink(this.points.get(j % this.points.size()));
                else if(this.points.get(i).linkIsFull() == true)
                    break;
    }

    

    // Recursive method that stop when there is no change (DONE)
    public void update()
    {
        // Empty the previous result
        if(counter.isEmpty() == false)
            counter.clear();
        
        // This is for looping direction
        if(RAND.nextInt(2) == 0)
            for(int i = 0; i < points.size(); i++)
                this.counter.add(points.get(i).update(this.colonizationThreshold)); 
        else
            for(int i = points.size() - 1; i >= 0; i--)
                this.counter.add(points.get(i).update(this.colonizationThreshold));
        
        // Check if there is no movement
        if(this.counter.contains(true))
            this.update();
    }
    
    // Getter for colonization threshold (DONE)
    public int getThreshold() 
    {
        return this.colonizationThreshold;
    }
    
    // toString method (DONE)
    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i < points.size(); i++) 
            result += "Point " + (i + 1) + ": \n" + points.get(i).toString() + "\n";
        return result;
    }
    
    
    
    //Helper Methods
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    // Check whether the id is unique (DONE)
    public boolean contain(int id)
    {
        for(Point point : this.points)
            if(point.getID() == id)
                return true;
        return false;
    }
}
