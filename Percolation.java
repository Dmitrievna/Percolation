import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Random;

public class Percolation {
   
   private int size;
   private int[][] workSite; 
   private WeightedQuickUnionUF unionArray;    
    
    
    
   public Percolation(int n) { // create n-by-n grid, with all sites blocked
       
       this.size = n;
       this.workSite = new int[this.size][this.size];
       unionArray = new WeightedQuickUnionUF(this.size * this.size + 2);
       
       for( int i=0; i < this.size; i++  ) {
       
           for( int j=0; j < this.size; j++ ) {
           
           workSite[i][j] = 1;
           
           }
        
           
       }
   }
   
    // validate that i is a valid index
    private void validate(int i) {
           if (i < 1 || i >= size+1) {
            throw new IndexOutOfBoundsException("index " + i + " is not between 1 and " + (size + 1));  
        }
    }
   
   
   private int size() {
       
       return this.size;
   }
       
   public void open(int i, int j) {         // open site (row i, column j) if it is not open already
    
           
         validate(i); //check
         validate(j);
         workSite[i-1][j-1] = 0; // now it is opened
         
         if( i-1 == 0 ) { unionArray.union(0,j); }
         if( i-1 == size - 1  ) { unionArray.union((size*(i-1)+j),(size*size + 1)); }
           
      
   }
   
   public boolean isFull(int i, int j) {    // is site (row i, column j) full? 
       
       try{
           
          print();
           
       }catch(ArrayIndexOutOfBoundsException e) {
       throw new IndexOutOfBoundsException();
       }    
      
       return true;
  }
   
   public boolean isOpen(int i, int j) {    // is site (row i, column j) open? 
       
       try{
           
          ;
           
       }catch(ArrayIndexOutOfBoundsException e) {
       throw new IndexOutOfBoundsException();
       }    
       
       return true;
   }
   

   
   public boolean percolates() {             // does the system percolate?
            

        return true;    
   }
   
   
   
   
   public void print() {
    
           for( int i=0; i < this.size; i++  ) {
       
               for( int j=0; j < this.size; j++ ) {
           
                   System.out.print(workSite[i][j]);
                   
               }
               
               System.out.println(" ");
           }
       
           System.out.println(unionArray.find(1));
           System.out.println(unionArray.find(26));
           
       }    

   public static void main(String[] args)  // test client (optional)
   {
       Percolation newPerc = new Percolation(5);
    
       final Random random = new Random();
       
       newPerc.print();
       newPerc.open(1,1);
       newPerc.print();
       newPerc.open(5,5);
       newPerc.print();
       
       

   }

}