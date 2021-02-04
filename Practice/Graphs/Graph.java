import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int num) {
        V = num;
        adj = new LinkedList[V];
        for (int i = 0; i < num; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void bfs(int s) {

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        LinkedList<Integer> q = new LinkedList<Integer>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            s = q.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
            System.out.print(s + " ");
        }
    }

    public void conCompHelper(int s, boolean[] visited) {
        LinkedList<Integer> q = new LinkedList<Integer>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            s = q.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }

            System.out.print(s + " ");
        }
    }

    public int connectedComp(int s) {
        int ans = 0;

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                conCompHelper(i, visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfshelper(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfshelper(n, visited);
            }
        }
    }

    public void dfs(int s) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        dfshelper(s, visited);
    }

    // some error
    public int TwoEChelper(int s, int parent, int[] arrival, boolean[] visited, int time) {
        arrival[s] = time++;
        visited[s] = true;
        int dbe = arrival[s];

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dbe = Math.min(dbe, TwoEChelper(n, s, arrival, visited, time));
            else if (n != parent)
                dbe = Math.min(dbe, arrival[n]);
        }
        if (dbe == arrival[s] && parent != -1) {
            System.out.println(parent + " -> " + s);
            // return -1;
        }
        return dbe;
    }

    public boolean TwoEC(int s) {
        boolean visited[] = new boolean[V];
        int arrival[] = new int[V];
        if (TwoEChelper(s, -1, arrival, visited, 0) == -1)
            return false;
        return true;
    }

    public void TwoECrun(int s) {
        boolean visited[] = new boolean[V];
        int arrival[] = new int[V];
        TwoEChelper(s, -1, arrival, visited, 0);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        // g.bfs(2);
        // System.out.println();
        // g.dfs(2);
        // g.TwoECrun(0);
        System.out.println(g.connectedComp(0));
    }
}
