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
    public Map() 
    {
        this(null, -69);
    }
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
                    if(this.isIDTaken(point.getID())) 
                        point.setID(RAND.nextInt(1001));
                    else 
                        break;
                
                // Add the point to the list
                this.points.add(point);
            }
            // The random colonization threshold is between 6 and 12 & a more deterministic colonizationThreshold value
            // Six is a crowd
            this.colonizationThreshold = Math.min(6 + RAND.nextInt(7), getKangarooCount()/this.points.size() + 5);
        }
        else
        {
            // Put in the points and initialize the colonization threshold
            this.points = new ArrayList<Point>(Arrays.asList(spots));
            this.colonizationThreshold = colonizationThreshold;
        }

        // Establish link between points
        // Prioritize the points that is specified by the user first
        // It will connect the points that exist with the corresponding ID but ignore ones that don't exist
        for(int i = 0; i < this.points.size(); i++)
        {
            if(this.points.get(i).haveSpecifiedID())
            {
                for(int index = (i + 1) % this.points.size(), j = 0; j < this.points.size() - 1; j++, index = (index + 1) % this.points.size())
                {
                    if(this.points.get(i).containSpecifiedID(this.points.get(index)))
                        this.points.get(i).makeLink(this.points.get(index));
                }
            }
        }
        
        // Link the points together 
        for(int i = 0; i < this.points.size(); i++)
        {
            for(int index = (i + 1) % this.points.size(), j = 0; j < this.points.size() - 1; j++, index = (index + 1) % this.points.size())
            {
                if(this.points.get(i).linkIsFull() == true)
                    break;
                else if(this.points.get(i).containSpecifiedID(this.points.get(index)) == false)
                    this.points.get(i).makeLink(this.points.get(index));
            }
        }
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
        
        // Check if there is movement
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
            result += "Point " + (i + 1) + "\n" + points.get(i).toString() + "\n";
        return result;
    }
    
    //Helper Methods
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    // Count the number of kangaroos in this map (DONE)
    public int getKangarooCount()
    {
        int sum = 0;
        for(int i = 0; i < this.points.size(); i++)
            sum += this.points.get(i).getPointCapacity();
        return sum;
    }

    // Check whether the id is unique (DONE)
    public boolean isIDTaken(int id)
    {
        for(Point point : this.points)
            if(point.getID() == id)
                return true;
        return false;
    }
}
