import java.util.*;
public class BSearch{
public static int binary(int a[], int key, int n) {
int low = 0;
int high= n-1;
while (low <= high) {
    int mid = (low + high)/2; 
    if(key<a[mid]){
        high = mid-1;
    }
    else if(key>a[mid]){
     low = mid + 1;
    }
    else{
      return mid; 
    } 
}
return -1;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the num of terms");
    int n= sc.nextInt();
    int a[] =new int[n];
    System.out.println("Enter the values");
    for(int i=0;i<n;i++){
      a[i] = sc.nextInt();
    }
    System.out.println("Enter key");
    int key = sc.nextInt();
    long ST = System.nanoTime();
    int result = binary(a, key, n);
    if(result!=-1){
        System.out.println(" found "+result );
    }
    else{
        System.out.println("not found ");

    }
    long ET = System.nanoTime();
    double duration = (ET-ST)/1000000.0;
    System.out.println("searching is done in "+duration+" millisecond");
}
}
