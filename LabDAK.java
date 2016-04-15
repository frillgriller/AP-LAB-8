
package coinchange;

import java.util.*;


public class coinchange 
{
    public static int Greedy(int total)
    {
        int one = 0;
        int five = 0;
        int ten = 0;
        int twentyfive = 0;
       
        while(total > 0)
        {
            if(total >= 25)
            {
                //Checking 25 coin
                twentyfive ++;
                total = total-25;
            }
            else
            if(total >= 10)
            {
                //Checking 10 coin
                ten ++;
                total = total- 10;
            }
            else
                if(total >= 5)
            {
                //Checking 5 coin
                five ++;
                total = total- 5;
            }
            else
            {
                //Checking 1 coin
                one++;
                total = total -1;
            }     
        }
        //System.out.println("Ones: "+one);
        //System.out.println("Fives: "+five);
        //System.out.println("Tens: "+ ten);
        //System.out.println("25: "+ twentyfive);
        return  (one+five+ten+twentyfive);
        
    }
    
    
    public static int[] DP1(int[] coins, int total)
    {
        int[] temp = new int[total + 1];
        temp[0] = 0;
        
        for (int j = 1; j < total+1; j++)
        {
            temp[j] = 1000000000; //Inifinte
            for (int i = 0; i < coins.length; i++)
            {
                //All coins checking
                if(j >= coins[i] && (1+temp[j-coins[i]]) < temp[j])
                {
                    temp[j] = 1 + temp[j-coins[i]]; //Memoization
                }
                
            }	
        }
        return temp;
    }
    
    
    
    public static void main(String[] args)
    {
      
        int temp  = 0;
        int coins[] = {1,5,10,25}; // All coins
        int total; //total to make
        int gcoins;
        int ansDP[];
        while(temp < 10) // For 10 random totals
        {
           
            Random farig = new Random(); //Random Object
            total = farig.nextInt() % 1000000; //Random total
            //System.out.println(total);
            if(total > 0)
            {
                gcoins = Greedy(total); //Calling Greedy
                ansDP = DP1(coins, total); //Calling DP
                System.out.println("total " + total); //total Was
                System.out.println("Num of Coins Greedy: " + gcoins);//Greedy Result
                System.out.println("Num of Coins DP: " + ansDP[total]);//DP Result
                temp++;
            }
        }
        
        
    }
    
}
