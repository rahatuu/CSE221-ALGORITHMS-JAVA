import java.util.*;
public class KnightMoves {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int x1=sc.nextInt(), y1=sc.nextInt();
        int x2=sc.nextInt(), y2=sc.nextInt();
        int[] dx={1,1,-1,-1,2,2,-2,-2};
        int[] dy={2,-2,2,-2,1,-1,1,-1};
        int[][] dist=new int[N+1][N+1];
        for(int i=0;i<=N;i++){ for(int j=0;j<=N;j++){ dist[i][j]=-1;}}
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x1,y1});
        dist[x1][y1]=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0], cy=cur[1];
            if(cx==x2 && cy==y2){ System.out.println(dist[cx][cy]); return; }
            for(int d=0;d<8;d++){
                int nx=cx+dx[d], ny=cy+dy[d];
                if(nx>=1&&nx<=N&&ny>=1&&ny<=N&&dist[nx][ny]==-1){
                    dist[nx][ny]=dist[cx][cy]+1;
                    q.add(new int[]{nx,ny}); }}}
        System.out.println(-1); }}