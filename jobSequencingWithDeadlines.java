import java.util.Arrays;
class Job{
    int id,deadline,profit;
    //constructor
    Job(int id, int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
//main class
public class jobSequencingWithDeadlines{
    //method
    public static void schedulejobs(Job []jobs){//jobs is object array
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int n=jobs.length;
        boolean []slots=new boolean[n];
        int []result=new  int[n];
        int totalProfit=0;
        for(Job jobes:jobs){//jobes is variable
            for(int j=jobes.deadline-1;j>=0;j--){
                if(!slots[j]){
                    slots[j]=true;
                    result[j]=jobes.id;
                    totalProfit +=jobes.profit;
                    break;
                 }
            }
        }
        System.out.println("selected job:");
        for(int jobes:result){
            if(jobes!=0){
                System.out.println(jobes+" ");
            }
         }
         System.out.println("\nTotal profit:"+totalProfit);
    }
    public static void main(String []args){
        Job []jobs={
            new Job(1,2,100),
            new Job(2,1,19),
            new Job(3,2,27),
            new Job(4,1,25),
            new Job(5,3,15),
        };
        schedulejobs(jobs);
    }
 }  
    
