package jumpy.grof;
import java.util.Random;
public class Kangaroo implements Comparable<Kangaroo>
{
    private static final Random RAND = new Random();
    private int food, strength, maxFoodCapacity;
    private String gender;

    // All kangaroo will be randomly generated just like life with genetics which is unfair
    public Kangaroo()
    {
        // Their maximum food capacity is between 5 to 12
        this.maxFoodCapacity = 5 + RAND.nextInt(8);
        
        // All kangaroo will have 5 to max food capacity food initailly
        this.food = 5 + this.RAND.nextInt(this.maxFoodCapacity - 4);
        
        // All kangaroos have different strength between 1 and 5
        this.strength = 1 + this.RAND.nextInt(5);
        
        // 60% to be male 40% to be female
        if(RAND.nextInt(101) <= 60) this.gender = "male";
        else this.gender = "female";
    }
    
    public int canOvercome(Link link)
    {
        if(link.getPoint().isColonized())
        {
            int placeholder = this.food - ( link.getObstacle() + this.food/2 + link.getPoint().getPointCapacity()/2 );
            if(placeholder >= 0)
                return placeholder + link.getPoint().getFemales();
            else 
                return placeholder;
        }
        else
        {
            int placeholder = this.food - ( link.getObstacle() + this.food/2 );
            if( placeholder >= 0 )
                return placeholder + link.getPoint().getFemales();
            else
                return placeholder;
            
        }
    }
    
    // This method is used for updating things when there is dt (for now its empty cuz I dont know what to do with it) (DONE)
    public void update(Link link)
    {
        // Consume the food 
        if( link.getPoint().isColonized() )
            this.food -= ( link.getObstacle() + this.food/2 + link.getPoint().getPointCapacity()/2 );
        else
            this.food -= ( link.getObstacle() + this.food/2 );
        
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
    
    // Check if the pouch is full (DONE)
    public boolean isFull() 
    {
        if(this.food > this.maxFoodCapacity)
            throw new Error("This kangaroo exceeded its maximum food capacity");
        return this.food == this.maxFoodCapacity;
    }
    
    // toString (DONE)
    @Override
    public String toString()
    {
        String result = "This kangaroo has \n";
        result += "Food: " + food + "\n";
        result += "Capacity: " + maxFoodCapacity + "\n";
        result += "Strength: " + strength + "\n";
        result += "and is a " + gender + "\n";
        return result;
    }
    
    // This compare to is used for the social heirachy (DONE)
    @Override 
    public int compareTo(Kangaroo that) 
    {
        if(this.strength > that.strength) return 1;
        else if(this.strength == that.strength) return 0;
        else return -1;
    }

    
}
