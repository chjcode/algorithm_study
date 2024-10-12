import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        // 6의 배수만큼 더해주고 모듈러
        int cnt = 1;
        int temp = 1;
        while (temp < n) {
            temp += cnt*6;
            cnt++;
        }

        System.out.println(cnt);
    }
}
