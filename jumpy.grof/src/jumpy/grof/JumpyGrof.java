package jumpy.grof;
import java.util.ArrayList;
import java.util.Scanner;
public class JumpyGrof 
{
    // colonyMin is global because methods cannot return 2 things!!!
    static int colonyMin = -1;
    
    public static void main(String[] args) 
    {
        // Variables
        Point[] points = null;
        
        // Asking for input
        points = getInput();
        System.out.println("");
            
        // Instantiate the map
        Map map;
        if(points != null)
            map = new Map(points,  colonyMin);
        else
            map = new Map();
            
        // Show the initial state of the map
        System.out.println("Before update");
        System.out.println("Colonization threshold: " + map.getThreshold() + "\n");
        System.out.print(map);
        
        // Update the map
        map.update();
        
        // Show the final state of the map
        System.out.println("After update");
        System.out.println("Colonization threshold: " + map.getThreshold() + "\n");
        System.out.print(map);
    }
    
    // Check if string is a number (regression is nice) (DONE)
    public static boolean isNumber(String string) {return string.matches("^\\d+$");}
    
    // Abstract away the input mechanism (DONE)
    public static Point[] getInput()
    {
        // Variables
        Point[] points = null;
        final Scanner SCAN = new Scanner(System.in);
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
                    if(isNumber(input) && checkID(Integer.parseInt(input), points)) 
                        System.out.println("That ID has been taken");
                    else if(isNumber(input)) 
                        break;
                }
                data[0] = Integer.parseInt(input);

                // Get the number of food of each point
                while(true)
                {
                    System.out.print((i + 1) + ". food (>= 1): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1) 
                        break;
                }
                data[1] = Integer.parseInt(input);

                // Get the limit of kangaroo of each point
                while(true)
                {
                    System.out.print((i + 1) + ". kangaroo limit (>=1): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1) 
                        break;
                }
                data[2] = Integer.parseInt(input);

                // This is for the individual kangaroos(if bad input, stop)
                ArrayList<Kangaroo> kangaroos = new ArrayList<>();
                for(int j = 0; j < data[2]; j++)
                {
                    System.out.println("    Kangaroo " + (j + 1));

                    // If the gender of the kangaroo is neither f or m, stop 
                    System.out.print("    Gender: ");
                    String gender = SCAN.next();
                    if(gender.toLowerCase().equals("f") == false && gender.toLowerCase().equals("m") == false)
                        break;

                    // If the pouch maximum capacity is less than 5 or not a number, stop
                    System.out.print("    Pouch maximum capacity(>=5): ");
                    String capacity = SCAN.next();
                    if(isNumber(capacity) == false || Integer.parseInt(capacity) < 5)
                        break;

                    // Classify the gender
                    if(gender.equals("f"))
                        gender = "female";
                    else 
                        gender = "male";

                    // Put the kangaroo into the kangaroos arrayList
                    kangaroos.add(new Kangaroo(Integer.parseInt(capacity), gender));
                }

                // Get the number of connection of each point
                while(true)
                {
                    System.out.print((i + 1) + ". number of connections (1 - " + (points.length - 1) + "): ");
                    input = SCAN.next();
                    if(isNumber(input) && Integer.parseInt(input) >= 1 && Integer.parseInt(input) < points.length) 
                        break;
                }
                data[3] = Integer.parseInt(input);

                // This is for the individual connections
                /* This is the start of the extra inputs*/
                ArrayList<Integer> connectedPointIDs = new ArrayList<>();
                for(int j = 0; j < data[3]; j++)
                {
                    // Get the id
                    System.out.print("    Link " + (j + 1) + " ID: ");
                    String id = SCAN.next();

                    // If the id is not a number, stop
                    if(isNumber(id) == false)
                        break;
                    else
                        connectedPointIDs.add(Integer.parseInt(id));
                }
                /* This is the end of the extra inputs*/

                // Insert newline in between points
                System.out.println("");
                
                // Insert the data into the points array
                points[i] = new Point(data[0], data[1], data[2], data[3], kangaroos, connectedPointIDs);
            }

            // Get minimum number to form colony
            while(true)
            {
                System.out.print("Minimum number to form colony (>=2): ");
                input = SCAN.next();
                if(isNumber(input) && Integer.parseInt(input) > 1) 
                    break;
            }
            colonyMin = Integer.parseInt(input);
        }  
        SCAN.close();
        return points;
    }
    
    // Returns true if the id is already taken (DONE)
    public static boolean checkID(int id, Point[] points)
    {
        for(Point point : points)
            if(point == null) 
                break;
            else if(point.getID() == id) 
                return true;
        return false;
    }
}
