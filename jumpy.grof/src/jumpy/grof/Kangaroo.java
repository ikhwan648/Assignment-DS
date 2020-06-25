package jumpy.grof;
import java.util.Random;
public class Kangaroo
{
    private static final Random RAND = new Random();
    private int food, maxFoodCapacity;
    private String gender;

    // All kangaroo will be randomly generated just like life with genetics which is unfair
    public Kangaroo()
    {
        // The random maximum food capacity is between 5 and 12
        // 60% to be male 40% to be female
        this(5 + RAND.nextInt(8), (RAND.nextInt(100) <= 60) ? "male" : "female");
    }
    public Kangaroo(int maxFoodCapacity, String gender)
    {
        // Assign the given maximum food capacity
        this.maxFoodCapacity = maxFoodCapacity;

        // All kangaroo will have 5 to max food capacity food initailly
        this.food = 5 + this.RAND.nextInt(this.maxFoodCapacity - 4);

        // Assign the given gender 
        this.gender = gender;
    }
    
    // The value will be used to set the heuristic of the link
    // The offering for each kangaroo is 0.5 food
    public int canOvercome(Link link)
    {
        if(link.getPoint().isColonized())
        {
            int baseHeuristic = this.food - (link.getObstacle() + this.food/2 + link.getPoint().getPointCapacity()/2);
            if(baseHeuristic >= 0)
                return baseHeuristic + link.getPoint().getFoodEnum() + link.getPoint().getFemales();
            else 
                return baseHeuristic;
        }
        else
        {
            int baseHeuristic = this.food - (link.getObstacle() + this.food/2);
            if(baseHeuristic >= 0)
                return baseHeuristic + link.getPoint().getFoodEnum() + link.getPoint().getFemales();
            else
                return baseHeuristic;
            
        }
    }
    
    // This method is used to update the kangaroo and the point (DONE)
    public void update(Link link)
    {
        // Consume the food 
        if(link.getPoint().isColonized())
            this.food -= (link.getObstacle() + this.food/2 + link.getPoint().getPointCapacity()/2);
        else
            this.food -= (link.getObstacle() + this.food/2);
        
        // Check if there is a negative amount of food
        if(this.food < 0)
            throw new Error("The kangaroo consumed food that doesnt exist");
        
        // Update the food accordingly in the point and on this kangaroo
        while(this.food < this.maxFoodCapacity && link.getPoint().getFoodEnum() > 0)
        {
            this.food++;
            link.getPoint().setFoodEnum(link.getPoint().getFoodEnum() - 1);
            
            if(this.food > this.maxFoodCapacity || link.getPoint().getFoodEnum() < 0)
                throw new Error("There is a problem in the transfer of food");
        }
    }
    
    // Getter for the gender of the kangaroo (DONE)
    public String getGender() {return this.gender;}
    
    // Setter and getter for food (DONE)
    public void setFood(int food) {this.food = food;}
    public int getFood() {return this.food;}
    
    // toString (DONE)
    @Override
    public String toString()
    {
        String result = "This kangaroo has \n";
        result += "Food: " + food + "\n";
        result += "Capacity: " + maxFoodCapacity + "\n";
        result += "and is a " + gender + "\n";
        return result;
    }
}
