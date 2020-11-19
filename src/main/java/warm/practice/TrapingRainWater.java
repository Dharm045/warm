package warm.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrapingRainWater {

    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {
                int n = Integer.parseInt(br.readLine());
                String arrEle[] = br.readLine().split(" ");
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(arrEle[i]);
                }
                System.out.println(trapWater(arr, n));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int trapWater(int arr[], int n) {
        int preMax[] = new int[n];
        int postMax[] = new int[n];

        preMax[0] = arr[0];
        postMax[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            postMax[i] = Math.max(postMax[i + 1], arr[i]);
        }

        int tappedWarer = 0;
        for (int i = 1; i < n - 1; i++) {
            tappedWarer = tappedWarer + Math.max(0, Math.min(preMax[i - 1], postMax[i + 1]) - arr[i]);
        }
        return tappedWarer;

    }

}
