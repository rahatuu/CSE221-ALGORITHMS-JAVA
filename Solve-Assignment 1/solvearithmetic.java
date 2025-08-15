B. Can you solve Arithmetic Expressions?

import java.util.Scanner;
public class solvearithmetic{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<times;i++){
            String full=scanner.nextLine();
            String[] parts=full.split(" ");
            if(parts[2].equals("+")){System.out.printf("%.6f\n", Double.valueOf(parts[1]) + Double.valueOf(parts[3]));}
            else if(parts[2].equals("-")){System.out.printf("%.6f\n", Double.valueOf(parts[1]) - Double.valueOf(parts[3]));}
            else if(parts[2].equals("*")){System.out.printf("%.6f\n", Double.valueOf(parts[1]) * Double.valueOf(parts[3]));}
            else {System.out.printf("%.6f\n", Double.valueOf(parts[1]) / Double.valueOf(parts[3]));}}
    }
}
