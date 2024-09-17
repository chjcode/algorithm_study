import java.util.*;
import java.io.*;

public class Main {

    static int n,playerNum;
    static char game;

    static Set<String> player;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  // 임스와 같이 플레이 하기를 신청한 횟수
        game = st.nextToken().charAt(0);

        playerNum = 0;
        if (game == 'Y') {
            playerNum = 2;
        } else if (game == 'F') {
            playerNum = 3;
        } else if (game == 'O') {
            playerNum = 4;
        }

        player = new HashSet<>();
        for (int i = 0; i < n; i++) {
            player.add(br.readLine());
        }

        System.out.println(player.size()/(playerNum-1));

    }
}
