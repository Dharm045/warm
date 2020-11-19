package warm.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Leaders {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {
                int m = Integer.parseInt(br.readLine());

                String arr1Ele[] = br.readLine().split(" ");
                int arr1[] = new int[m];
                for (int i = 0; i < m; i++) {
                    arr1[i] = Integer.parseInt(arr1Ele[i]);
                }
                findLeader(arr1, m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void findLeader(int[] arr1, int m) {
        List<Integer> leaders = new ArrayList<>();
        int currentLeader = arr1[m - 1];
        leaders.add(currentLeader);
        for (int i = m - 2; i >= 0; i--) {
            if (currentLeader <= arr1[i]) {
                currentLeader = arr1[i];
                leaders.add(currentLeader);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            sb.append(leaders.get(i) + " ");
        }
        System.out.println(new String(sb).trim());

    }
}
