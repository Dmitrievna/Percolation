import edu.princeton.cs.algs4.StdStats;
import java.util.Random;


public class PercolationStats {
    
  
    private int numN;
    private int numT;
    private double[] xArray;
    
    
    public PercolationStats(int n, int trials) {    // perform trials independent experiments on an n-by-n grid
    
    numN = n;
    numT = trials;
    xArray = new double[numT];
    double sqrN =  (double) numN*numN; 
    final Random random = new Random();
    
    for (int i = 0; i < numT; i++) {
               
               
               Percolation perc = new Percolation(numN);
               int a = -15;
               int b = -15;
               
               do {
               a = random.nextInt(numN);
               b = random.nextInt(numN);
               a++;
               b++;
               if (perc.isOpen(a, b) || perc.isFull(a, b)) { 
                   continue;
               } else {
               
               perc.open(a, b);
               xArray[i]++;
               
               }
                  
               
               
               
               } while (!perc.percolates());
                
 
               
               xArray[i] =  xArray[i]/sqrN;
               
 
           
           
           
           
           }
    
    
    
    
    }
    public double mean() { // sample mean of percolation threshold
        
        return StdStats.mean(xArray);
    
    }                          
    public double stddev() {                        // sample standard deviation of percolation threshold
        
        return StdStats.stddev(xArray);
        
    }
    public double confidenceLo() {                 // low  endpoint of 95% confidence interval
     
        return (StdStats.mean(xArray) - (1.96*StdStats.stddev(xArray))/Math.sqrt(this.numT));
        
    }
    public double confidenceHi() {                 // high endpoint of 95% confidence interval
        
        return (StdStats.mean(xArray) + (1.96*StdStats.stddev(xArray))/Math.sqrt(numT));
    }    

       public static void main(String[] args) {    // test client (described below)
           
           int numT = Integer.parseInt(args[0]);
           int numN = Integer.parseInt(args[1]);
           double sqrN = (double) numN*numN; 
           final Random random = new Random();
           double[] xArray = new double[numT];
           PercolationStats stat = new PercolationStats(numN, numT);
           
           System.out.println("mean = "+ stat.mean());
           System.out.println("stddev = "+ stat.stddev());
           System.out.println("95% confidence interval = "+ stat.confidenceLo() + " , " + stat.confidenceHi());
      


       
   
   
   
   
   }
}