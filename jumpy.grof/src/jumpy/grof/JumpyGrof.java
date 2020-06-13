package jumpy.grof;
import java.util.Scanner;
// Concerns
// 1. Is the heuristic evaluation correct according to the fucking question
// 2. What if the colonization threshold is bigger than the kangaroo limit of all the points
// 3. The input function needs to be prettier
// 4. The method names need to be more descriptive and concise
// 5. The constansts need to be collected
// 6. Gotta test more
// 7. Gotta add more extra features
public class JumpyGrof 
{
    // colonyMin is global because methods cannot return 2 things!!!
    static int colonyMin = -1;
    
    public static void main(String[] args) 
    {
        // Variables
        Point[] points = null;          //points variable []
        
        // Asking for input
        points = getInput();            // input in points
        System.out.println("");
            
        // Instantiate the map
        Map map;
        if(points != null)                              // get input from user
            map = new Map(points,  colonyMin);
        else
            map = new Map();                            // input null
            
        // Show the initial state of the map
        System.out.println("Before update");
        System.out.println("Colonization threshold: " + map.getThreshold() + "\n");
        System.out.print(map);
        
        // Update the map (PROBLEM)
        map.update();
        
        // Show the final state of the map
        System.out.println("After update");
        System.out.println("Colonization threshold: " + map.getThreshold() + "\n");
        System.out.print(map);
    }
    
    // Check if string is a number (regression is nice) (DONE)
    public static boolean isNumber(String string) {return string.matches("^\\d+$");}
    
    // Abstract away the input mechanism (it is ugly as heck but it gets the job done which is good enough)
    public static Point[] getInput()
    {
        // Variables
        Point[] points = null;
        Scanner SCAN = new Scanner(System.in);
        String input;
        
        // Determine to randomize input  or to get input from user
        System.out.print("Do you wish to set the wild life environment: ");
        input = SCAN.next();
        if(input.equals("yes") || input.equals("y") || input.equals("1") || input.equals("sure man why not"))
        {
            // Get the number of points
            while(true)
            {
                System.out.print("Number of Points (2 - 20): ");
                input = SCAN.next();
                if(isNumber(input) && Integer.parseInt(input) <= 20 && Integer.parseInt(input) >= 2)
                    break;
            }

             // Create array of points and placeholder array to hold the value temporarily
            points = new Point[Integer.parseInt(input)];
            int[] data = new int[4];

            for(int i = 0; i < points.length; i++)
            {
                // Get the id of this point
                while(true)
                {
                    System.out.print((i + 1) + ". id: ");
                    input = SCAN.next();
                    if(isNumber(input) && checkID(Integer.parseInt(input), points)) System.out.println("That ID has been taken");
                    else if(isNumber(input)) break;
                }
                data[0] = Integer.parseInt(input);

                // Get the number of food of each point
                while(true)
                {
                    System.out.print((i + 1) + ". food (>= 1): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1) break;
                }
                data[1] = Integer.parseInt(input);

                // Get the limit of kangaroo of each point
                while(true)
                {
                    System.out.print((i + 1) + ". kangaroo limit (>=1): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1) break;
                }
                data[2] = Integer.parseInt(input);

                // Get the number of connection of each point
                while(true)
                {
                    System.out.print((i + 1) + ". number of connections (1 - " + (points.length - 1) + "): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1 && Integer.parseInt(input) < points.length) break;
                }
                data[3] = Integer.parseInt(input);

                // Insert newline in between points
                System.out.println("");
                
                // Insert the data into the points array
                points[i] = new Point(data[0], data[1], data[2], data[3]);
            }

            // Get minimum number to form colony
            while(true)
            {
                System.out.print("Minimum number to form colony (>=2): ");
                input = SCAN.next();
                if(isNumber(input) && Integer.parseInt(input) > 1) break;
            }
            colonyMin = Integer.parseInt(input);
        }
        return points;
    }
    
    // Returns true if the id is already taken (DONE)
    public static boolean checkID(int id, Point[] points)
    {
        for(Point point : points)
            if(point == null) break;
            else if(point.getID() == id) return true;
        return false;
    }
}
