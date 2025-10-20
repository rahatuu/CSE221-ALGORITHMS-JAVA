import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
        int[] dx={-1,-1,-1,0,0,1,1,1};
        int[] dy={-1,0,1,-1,1,-1,0,1};
        int[][] moves=new int[8][2];
        int c=0;
        for(int i=0;i<8;i++){
            int nx=x+dx[i],ny=y+dy[i];
            if(nx>=1&&nx<=N&&ny>=1&&ny<=N){
                moves[c][0]=nx;
                moves[c][1]=ny;
                c++;
            }
        }
        for(int i=0;i<c-1;i++){
            for(int j=0;j<c-1-i;j++){
                if(moves[j][0]>moves[j+1][0]||(moves[j][0]==moves[j+1][0]&&moves[j][1]>moves[j+1][1])){
                    int t0=moves[j][0],t1=moves[j][1];
                    moves[j][0]=moves[j+1][0];
                    moves[j][1]=moves[j+1][1];
                    moves[j+1][0]=t0;
                    moves[j+1][1]=t1;
                }
            }
        }
        System.out.println(c);
        for(int i=0;i<c;i++) System.out.println(moves[i][0]+" "+moves[i][1]);
    }
}