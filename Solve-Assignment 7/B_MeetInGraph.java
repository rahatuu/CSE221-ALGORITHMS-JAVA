import java.util.*;

public class MeetInGraph {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),s=sc.nextInt(),t=sc.nextInt();
        ArrayList<int[]>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++) g[i]=new ArrayList<int[]>();
        for(int i=0;i<m;i++) g[sc.nextInt()].add(new int[]{sc.nextInt(),sc.nextInt()});

        int[] distA=new int[n+1],distB=new int[n+1];
        for(int i=1;i<=n;i++){ distA[i]=Integer.MAX_VALUE; distB[i]=Integer.MAX_VALUE; }

        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){public int compare(int[]a,int[]b){return a[1]-b[1];}});
        distA[s]=0; pq.add(new int[]{s,0});
        while(!pq.isEmpty()){int[]c=pq.poll();int u=c[0],d=c[1];if(d>distA[u])continue;for(int i=0;i<g[u].size();i++){int[]e=g[u].get(i);if(distA[e[0]]>distA[u]+e[1]){distA[e[0]]=distA[u]+e[1];pq.add(new int[]{e[0],distA[e[0]]});}}}

        distB[t]=0; pq.add(new int[]{t,0});
        while(!pq.isEmpty()){int[]c=pq.poll();int u=c[0],d=c[1];if(d>distB[u])continue;for(int i=0;i<g[u].size();i++){int[]e=g[u].get(i);if(distB[e[0]]>distB[u]+e[1]){distB[e[0]]=distB[u]+e[1];pq.add(new int[]{e[0],distB[e[0]]});}}}

        int ans=Integer.MAX_VALUE,meet=-1;
        for(int i=1;i<=n;i++) if(distA[i]!=Integer.MAX_VALUE&&distB[i]!=Integer.MAX_VALUE){
            int w=Math.max(distA[i],distB[i]);
            if(w<ans||(w==ans&&i<meet)){ans=w;meet=i;}
        }
        System.out.println(meet==-1?-1:ans+" "+meet);
    }
}
