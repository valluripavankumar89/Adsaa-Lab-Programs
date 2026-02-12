import java.util.Arrays;
class Item{
    int weight,profit;
    double ratio;
    //constructor
    Item(int weight,int profit){
        this.weight=weight;
        this.profit=profit;
        this.ratio=(double)profit/weight;
    }
}
public class FractionalKnapsackProgram{           // main class
    //method
    public static double getMaxprofit(Item []items,int m){         // where m is bag weight
        //sorting items by profit/weight ratio descsnding order
        //lambda function
        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));
        double maxprofit=0.0;
        System.out.println("items placed in the bag");
        //for each loop
        for(Item item:items){       // item is variable
            if(item.weight <=m){
                maxprofit +=item.profit;
                m -=item.weight;
            }
            else{
                double fraction=(double)m/item.weight;         //the bag hava small space rather than available weight
                maxprofit +=item.profit*fraction;
                break;
           }
        }
        return maxprofit;
   }
   public static void main(String[] args){
    Item []items={
        new Item(10,60),
        new Item(20,100),
        new Item(30,120),
    };
    int m=50;
    double maxprofit=getMaxprofit(items,m);        // call method 
    System.out.println("maximum profit in knapsack:"+maxprofit);
  }
}            
            
                
