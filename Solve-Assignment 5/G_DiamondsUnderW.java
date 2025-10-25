import java.util.*;
public class G_DiamondsUnderW{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt(), H=sc.nextInt(), max=0;
        char[][] g=new char[R][H];
        boolean[][] v=new boolean[R][H];
        for(int i=0;i<R;i++) g[i]=sc.next().toCharArray();
        int[] dx={1,-1,0,0}, dy={0,0,1,-1};
        
        for(int i=0;i<R;i++){
            for(int j=0;j<H;j++){
                if(!v[i][j] && g[i][j]!='#'){
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    v[i][j]=true;
                    int c=0;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        if(g[cur[0]][cur[1]]=='D') c++;
                        for(int k=0;k<4;k++){
                            int nx=cur[0]+dx[k], ny=cur[1]+dy[k];
                            if(nx>=0 && nx<R && ny>=0 && ny<H && !v[nx][ny] && g[nx][ny]!='#'){
                                v[nx][ny]=true;
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                    if(c>max) max=c;
                }
            }
        }
        System.out.println(max);
    }
}
