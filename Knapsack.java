import java.util.*;

public class Knapsack {
    static int [] p, wt;
    static int C, n;
    static void ks(){
        int i,j,w;
        int k[][] = new int[n+1][C+1];
        for(i=0;i<=n;i++){
             for(w=0;w<=C;w++){
                if(i==0||w==0){
                    k[i][w] = 0;
                }
                else if(wt[i]<=w){
                    k[i][w] = max(p[i] + k[i-1][w-wt[i]],k[i-1][w]);
                }
                else{
                    k[i][w] = k[i-1][w];
                }
             }
        }
        System.out.println("the selected items are: ");
       int m=n, c=C;
       while(m>0){
        if(k[m][c]!=k[m-1][c]){
            System.out.println("item "+m+"( weight "+wt[m]+", profit "+p[m]+")");
            c= c-wt[m];
        }
        m--;
       } 
       System.out.println("total profit = "+k[n][C]);
       System.out.print("Intermidiate\ncapacity: \t");
       for(j=0;j<=C;j++){
        System.out.print(j+"\t");
       }
      System.out.println();
      for(i = 0;i<=n;i++){
        System.out.print("item "+i+"("+wt[i]+","+p[i]+")\t");
        for(j=0;j<=C;j++){
            System.out.print(k[i][j]+"\t");
        }
        System.out.println();
      }
    }

static int max(int a, int b){
    return (a>b)? a:b;
}

public static void main(String[] args) {
    int i;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no. of items ");
    n= sc.nextInt();
    System.out.println("Enter the weight");
    wt = new int[n+1];
    for(i = 1;i<=n;i++){
        wt[i] = sc.nextInt();
    }
    System.out.println("Enter the profit");
    p = new int[n+1];
    for(i = 1;i<=n;i++){
        p[i] = sc.nextInt();
    }
    System.out.println("Enter the capacity");
    C= sc.nextInt();
    ks();
}


}
