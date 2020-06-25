package jumpy.grof;
import java.util.Random;
public class Link implements Comparable<Link>
{
    // Variables
    private final Random RAND = new Random();
    private Point point;
    private int obstacle;
    private double heuristic;

    // Constructor (DONE)
    public Link(Point point) 
    {
        this(point, -69);
    }
    public Link(Point point, int obstacle)
    {
        // Assign the given point 
        this.point = point;
        
        // Set the obstacle to a random value between 1 and 6
        if(obstacle == -69)
            this.obstacle = 1 + RAND.nextInt(6);
        else
            this.obstacle = obstacle;
        
        //Initalize the heuristic value
        this.heuristic = 0;
    }
    
    // Setter and getter for point (DONE)
    public Point getPoint() {return this.point;}

    // Setter and getter for obstacle (DONE)
    public int getObstacle() {return this.obstacle;}
    
    // Set and get the heuristic value (bigger value is better) (DONE)
    public double getHeuristic() {return this.heuristic;}
    public void setHeuristic(Kangaroo kangaroo)
    {
        this.heuristic = kangaroo.canOvercome(this);
    }
    
    // String format (DONE)
    @Override
    public String toString() 
    {
        return "ID: " + point.getID() + "|Obstacle: " + obstacle;
    }

    // Used to compare the with other link (DONE)
    @Override
    public int compareTo(Link that) 
    {
        if(this.heuristic > that.heuristic) 
            return 1;
        else if(this.heuristic == that.heuristic) 
            return 0;
        else 
            return -1;
    }
}
