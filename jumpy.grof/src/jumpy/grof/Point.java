package jumpy.grof;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Point
{
    // Variables (DONE)
    private static final Random RAND = new Random();
    private ArrayList<Kangaroo> kangaroos = new ArrayList<>();
    private ArrayList<Link> links = new ArrayList<>();
    private ArrayList<Integer> pointIDSpecified = null;
    private int id, foodEnum, maxKangarooCapacity, linkLimit, females = 0;
    private boolean colonized = false;
    
    // Constructors (DONE)
    public Point()
    {
        // Give this point an id between 0 and 1000 just to be safe that there is no point with the same id
        // The random number of food for each point is between 5 and 20
        // The random kangaroo limit of each point is between 5 and 12
        // The random number of link for each point is between 2 and 7
       this(RAND.nextInt(1001), 5 + RAND.nextInt(16), 5 + RAND.nextInt(8), 2 + RAND.nextInt(6), new ArrayList<Kangaroo>(), new ArrayList<Integer>());
    }
    public Point(int id, int foodEnum, int maxKangarooCapacity, int linkLimit, ArrayList<Kangaroo> kangaroos, ArrayList<Integer> pointsID)
    {
        // ID assignment
        this.id = id;
        
        // Food assignment 
        this.foodEnum = foodEnum;
        
        // maxCapacity assignment
        this.maxKangarooCapacity = maxKangarooCapacity;

        // Assign the link limit
        this.linkLimit = linkLimit;
        
        // If the kangaroos arrayList is empty
        if(kangaroos.size() == 0)
        {
            // Initial number of kangaroo is between 1 to 3/5 of the maximum number of kangaroo allowed
            int size = (this.maxKangarooCapacity > 1) ? 2 + RAND.nextInt(this.maxKangarooCapacity * 3/5) : this.maxKangarooCapacity;
            for(int i = 0; i < size; i++)
            {
                Kangaroo kangaroo = new Kangaroo();
                if(kangaroo.getGender().equals("female")) 
                    this.females++;
                this.kangaroos.add(kangaroo);
            }
        }
        // If the user set the kangaroos for the point
        else
        {
            this.kangaroos = kangaroos;
            for(int i = 0; i < this.kangaroos.size(); i++)
                if(this.kangaroos.get(i).getGender().equals("female"))
                    this.females++;
        }

        // Make sure it doesn't have id of this point to avoid linking to itself
        for(int i = 0; i < pointsID.size(); i++)
            if(pointsID.get(i).equals(this.id))
                pointsID.remove(i);

        // Just assign the value of the points
        this.pointIDSpecified = pointsID;
    }
    
    // Establish link to the point (DONE)
    public void makeLink(Point that) 
    {
        if(this.links.size() < this.linkLimit)
            this.links.add(new Link(that));
        else
            throw new Error("You exceeded the link limit of the point " + this.id);
    }
    
    // Check if the user specified any ID for the connection (DONE)
    public boolean haveSpecifiedID()
    {
        return this.pointIDSpecified.size() >= 0;
    }
    // Check whether a connection has already been established with the point (DONE)
    public boolean containSpecifiedID(Point that)
    {
        return this.pointIDSpecified.contains(that.id);
    }
    
    // Update the point (false; no movement, tue; movement) (DONE)
    public boolean update(int colonizationThreshold)
    {
        // Flag to check whether there is any movement (assume initially there is no movement)
        boolean hasMoved = false;
        
        // See if this point is colonized
        if(this.kangaroos.size() >= colonizationThreshold) 
            this.colonized = true;
        
        // If this point is already colonized or there is no kangaroo
        if(this.colonized || this.kangaroos.size() == 0) 
            return hasMoved;
        
        // For each kangaroo that is going to migrate between 1 and 2 fifth of the kangaroos
        // A third of the kangaroos because I want to ensure that there are a few kangaroos that decide to stay for whatever reason
        int migratingNumber = (this.kangaroos.size() == 1) ? 1 : this.kangaroos.size() * 2/5;
        for(; migratingNumber > 0; migratingNumber--)
        {
            // The kangaroo that is going to or not, migrate
            Kangaroo kangaroo = this.kangaroos.get(RAND.nextInt(this.kangaroos.size()));

            // Set and sort the links based on the heuristic
            this.setAndSortLinks(kangaroo);
            
            // For each link
            for(int i = 0; i < this.links.size(); i++)
            {
                // If the heuristic value is less than 0 or this point is better then it won't traverse through 
                if((int)this.links.get(i).getHeuristic() < 0 || this.foodEnum * 1/4 + this.females >= links.get(i).getHeuristic())
                    break;

                // If the point is not full
                if(links.get(i).getPoint().isFull() == false)
                {
                    // There is movement
                    hasMoved = true;
                    
                     // Remove the instance of the kangaroo from the array list
                    this.kangaroos.remove(kangaroo);
                    
                    // Consume food after going through the obstacle and get the food from the point
                    kangaroo.update(this.links.get(i));
                    
                    // Move the kangaroo from this point to that point
                    this.kangaroos.remove(kangaroo);
                    links.get(i).getPoint().kangaroos.add(kangaroo);
                    
                    // Update females count
                    if(kangaroo.getGender().equals("female")) 
                    {
                        this.females--;
                        this.links.get(i).getPoint().females++;
                    }
                    break;
                }
            }
        }
        return hasMoved;
    }
    
    // Getter and setter for id (DONE)
    public int getID() {return this.id;}
    public void setID(int id) {this.id = id;}
    
    // Get the number of kangaroos in this point (DONE)
    public int getPointCapacity() {return this.kangaroos.size();}
    
    // Check if the number of kangaroos already reach max capacity (DONE)
    public boolean isFull() 
    {
        if(this.kangaroos.size() > this.maxKangarooCapacity)
            throw new Error("This point exceeded the limit number of kangaroos");
        return this.kangaroos.size() == this.maxKangarooCapacity;
    }
    
    // Getter and setter for foodEnum (DONE)
    public int getFoodEnum()
    {
        return this.foodEnum;
    }
    public void setFoodEnum(int foodEnum)
    {
        this.foodEnum = foodEnum;
    }

    // Get the number of female at this point (DONE)
    public int getFemales() {return this.females;}
    
    // Check if this point is colonized (DONE)
    public boolean isColonized() {return this.colonized;}
    
    // Check if the number of link is full(DONE)
    public boolean linkIsFull() 
    {
        if(this.links.size() > this.linkLimit)
            throw new Error("Exceeded link limit");
        return this.links.size() == this.linkLimit;
    }
    
    // toString (DONE)
    @Override
    public String toString()
    {
        String result = "";
        result += "ID: " + id + "\n";
        result += "Food: " + foodEnum + "\n";
        result += "Kangaroo limit: " + maxKangarooCapacity + "\n";
        result += "Number of male kangaroos: " + (this.kangaroos.size() - this.females) + "\n";
        result += "Number of female kangaroos: " + this.females + "\n";
        result += "Connection limit: " + this.linkLimit + "\n";
        result += "This point is connected to: " + this.links.toString() + "\n";
        result += "Colonized: " + this.colonized + "\n";
        return result;
    }

    // Helper methods 
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    // Set the temporary heuristic of the points to this kangaroo (DONE)
    private void setAndSortLinks(Kangaroo kangaroo)
    {
        // Set each links 
        for(int i = 0; i < this.links.size(); i++)
           this.links.get(i).setHeuristic(kangaroo);
        
        // Sort the links
        Collections.sort(links, Collections.reverseOrder());
    }
}
