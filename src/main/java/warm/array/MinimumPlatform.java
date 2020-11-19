package warm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumPlatform {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {
                int n = Integer.parseInt(br.readLine().trim());

                int arr1[] = new int[n];
                int arr2[] = new int[n];

                String arr1Ele[] = br.readLine().split(" ");
                String arr2Ele[] = br.readLine().split(" ");

                int index = 0;
                for (int i = 0; i < arr1Ele.length; i++) {
                    if (!arr1Ele[i].trim().isEmpty()) {
                        arr1[index++] = Integer.parseInt(arr1Ele[i].trim());
                    }
                }

                index = 0;
                for (int i = 0; i < arr2Ele.length; i++) {
                    if (!arr2Ele[i].trim().isEmpty())
                        arr2[index++] = Integer.parseInt(arr2Ele[i].trim());
                }
                System.out.println(minimumPlatform(arr1, arr2, n));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    private static int minimumPlatform(int[] arr1, int[] arr2, int n) {

        int time[] = new int[2400];
        for (int i = 0; i < n; i++) {
            int arrival = arr1[i];
            int departure = arr2[i];
            increment(time, arrival, departure);
        }

        int minPlatform = 0;
        for (int i = 0; i < time.length; i++) {
            if (minPlatform < time[i]) {
                minPlatform = time[i];
            }
        }
        return minPlatform;
    }

    private static void increment(int time[], int arrival, int departure) {
        while (arrival <= departure) {
            time[arrival]++;
            arrival++;
        }
    }

}
