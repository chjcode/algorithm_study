
import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        double weight;

        Edge(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Plant implements Comparable<Plant>{
        int plantNo;
        double dist;

        Plant(int plantNo, double dist) {
            this.plantNo = plantNo;
            this.dist = dist;
        }
        @Override
        public int compareTo(Plant p) {
            return Double.compare(this.dist,p.dist);
        }
    }

    static int n, w;
    static double m;
    static int[][] powerPlants;
    static List<List<Edge>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        m = Double.parseDouble(br.readLine());
        powerPlants = new int[n][2];    // [[x,y]]
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            powerPlants[i][0] = Integer.parseInt(st.nextToken());
            powerPlants[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                double dist = calculateDistance(powerPlants[i], powerPlants[j]);
                if (dist <= m * m) {
                    double realDist = Math.sqrt(dist);
                    graph.get(i).add(new Edge(j, realDist));
                    graph.get(j).add(new Edge(i, realDist));
                }
            }
        }

        while (w > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            graph.get(start).add(new Edge(end,0));
            graph.get(end).add(new Edge(start, 0));
            w -= 1;
        }

        System.out.println((int) (dijkstra() * 1000));
    }

    private static double calculateDistance(int[] point1, int[] point2) {
        double dx = (double) (point1[0] - point2[0]);
        double dy = (double) (point1[1] - point2[1]);
        return dx * dx + dy * dy;
    }

    private static double dijkstra() {
        double[] minDist = new double[powerPlants.length];
        for (int i = 0; i < powerPlants.length; i++) {
            minDist[i] = Double.MAX_VALUE;
        }

        PriorityQueue<Plant> pq = new PriorityQueue<>();
        pq.add(new Plant(0, 0));
        minDist[0] = 0;

        while (!pq.isEmpty()) {
            Plant curr = pq.poll();
            int currPlantNo = curr.plantNo;
            double currDist = curr.dist;

            if (minDist[currPlantNo] < currDist) continue;

            for (Edge edge : graph.get(currPlantNo)) {
                if (currDist + edge.weight < minDist[edge.to]) {
                    minDist[edge.to] = currDist + edge.weight;
                    pq.add(new Plant(edge.to, minDist[edge.to]));
                }
            }
        }

        return minDist[powerPlants.length - 1];
    }
}
