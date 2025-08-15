A. Odd or Even?

import java.util.Scanner;
public class findevenorodd{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times=scanner.nextInt();
        for(int i=0;i<times;i++){
            int integ=scanner.nextInt();
            if(integ%2==0){
                System.out.println(integ+" is an Even number.");}
            else{
                System.out.println(integ+" is an Odd number.");}
        }
    }
}
