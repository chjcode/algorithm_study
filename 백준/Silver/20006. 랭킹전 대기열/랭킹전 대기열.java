import java.util.*;
import java.io.*;

public class Main {
    static int p,m;
    static List<Room> rooms;
    static class Player implements Comparable<Player>{
        int level;
        String id;

        Player(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player p) {
            return this.id.compareTo(p.id);
        }
    }

    static class Room {
        String status = "Waiting!";
        List<Player> players = new ArrayList<>();
        int firstPlayerLevel;

        Room(Player player) {
            this.firstPlayerLevel = player.level;
            players.add(player);
        }

        public void addPlayer(Player p) {
            players.add(p);
        }

        public void startGame() {
            this.status = "Started!";
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            Player player = new Player(l, n);

            boolean joined = false;
            for (Room room : rooms) {
                if (Math.abs(room.firstPlayerLevel - l) <= 10 && room.players.size() < m) {
                    room.addPlayer(player);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                Room newRoom = new Room(player);
                rooms.add(newRoom);
            }
        }

        for (Room room : rooms) {
            if (room.players.size() == m) {
                room.startGame();
            }
        }

        for (Room room : rooms) {
            System.out.println(room.status);

            Collections.sort(room.players);

            for (Player p : room.players) {
                System.out.println(p.level + " " + p.id);
            }
        }
    }
}
