import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Random;

public class Percolation {
   
   private int size;
   private int[][] workSite; 
   private WeightedQuickUnionUF wquArray;    
    
    
    
   public Percolation(int n) { // create n-by-n grid, with all sites blocked
       
       this.size = n;
       this.workSite = new int[this.size][this.size];
       wquArray = new WeightedQuickUnionUF(this.size * this.size + 2);
       for( int i=0; i < this.size; i++  ) {
       
           for( int j=0; j < this.size; j++ ) {
           
           workSite[i][j] = 1;
           
           }
        
           
       }
   }
   
   public int size() {
       
       return this.size;
   }
       
   public void open(int i, int j) {         // open site (row i, column j) if it is not open already
    
       try {
           
           if(workSite[i-1][j-1] == 1){    
              
              workSite[i-1][j-1] = 0;
              if(i-1==0) {
         
                  workSite[i-1][j-1]= -1;
                  wquArray.union(0,j);
                  
              }
              if(i-1== size-1) {
                
                  
                  workSite[i-1][j-1]= -1;
                  wquArray.union(size*(i-1)+j,size*size+1);   
                  
              }
              if ( i-1!=0 && isFull(i-1,j) ) { 
             
                  workSite[i-1][j-1] = -1;
                  wquArray.union(size*(i-1)+j,size*(i-2)+j);
                  
              }
             
              if ( j-1!=0 && isFull(i,j-1)) { 
             
                  wquArray.union(size*(i-1)+2,size*(i-1)+j);
                  workSite[i-1][j-1] = -1;
                  
              }
              
              if ( j-1!=size - 1 && isOpen(i-1,j)) {
                  
              wquArray.union(size*(i-1)+size ,size*(i-1)+j);
              workSite[i-1][j] = -1;
              
              }
              
              if ( i-1!=size - 1 && isOpen(i,j-1)) {
                  
              wquArray.union(size*i+ j ,size*(i-1)+j);
              workSite[i][j-1] = -1;
              
              
              }
              
              
       
           }
       } catch(ArrayIndexOutOfBoundsException e) {
       throw new IndexOutOfBoundsException();
       }
   }
   public boolean isOpen(int i, int j){     // is site (row i, column j) open?
    
       try{
           
           if(workSite[i-1][j-1] == 0){ return true; }
       
           else { return false; }
           
       }catch(ArrayIndexOutOfBoundsException e) {
       throw new IndexOutOfBoundsException();
       }
   }
   
   public boolean isFull(int i, int j) {    // is site (row i, column j) full? 
       
       try{
           
           if(workSite[i-1][j-1] == -1){ return true; }
       
           else { return false; }           
           
       }catch(ArrayIndexOutOfBoundsException e) {
       throw new IndexOutOfBoundsException();
       }    
       
   }
   
   public boolean percolates() {             // does the system percolate?
            
       System.out.println(wquArray.count() + " fuck you " + wquArray.find(2));
       print();
       
    if( wquArray.connected(0,size*size+1)) 
        return true;
    else
        return false;    
   }
   public void print() {
    
           for( int i=0; i < this.size; i++  ) {
       
               for( int j=0; j < this.size; j++ ) {
           
                   System.out.print(workSite[i][j]);
                   
               }
               System.out.println(" ");
           }
       
       }    

   public static void main(String[] args)  // test client (optional)
   {
       Percolation newPerc = new Percolation(1);
 //      newPerc.open(1,1);
       
       final Random random = new Random();
//       int i = 0;  
       int a = -100;
       int b = -100;
    //   newPerc.print();
/*       if(newPerc.percolates()) newPerc.print();
       while( newPerc.percolates() == false ) {
           
           a = random.nextInt(4);
           System.out.println("a = " + a);
           a++;
           System.out.println("a = " + a);
           b = random.nextInt(4);
           System.out.println("a = " + a + " b = " + b );
           
           b++;
           System.out.println("a = " + a + " b = " + b );
           if(newPerc.isOpen(a-1,b-1) == false ) {
           newPerc.open(a,b);
           newPerc.print();
           i++;
           if(i==20) break;
           }
           
           
       
       }
   */
      /* for(int i = 1; i < 5; i++ ){
           
           for(int j = 1; j< 5; j++ ){
           
           newPerc.open(i,j);
           System.out.println("-----");
           newPerc.print();
           
           }
       }*/
   
      
      if (newPerc.percolates()) {  newPerc.print(); }
   }

}