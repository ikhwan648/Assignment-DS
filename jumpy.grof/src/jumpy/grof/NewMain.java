/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpy.grof;

import java.util.Random;

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] num = new int [3];
        Random rand = new Random();
        
        //generate unique place
        for(int i=0;i<3;i++){
            num[i] = 1+rand.nextInt(20);
            
            for(int j=0;j<i;j++){
                if(num[i]==num[j])
                    i--;
            }
        }
        
        System.out.println(num[0]);
        System.out.println(num[1]);
        System.out.println(num[2]);
    }
    
}
