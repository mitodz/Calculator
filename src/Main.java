import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]d = new int[n];
        int[]s = new int[n];
        int[]prev = new int[n];
        for (int i = 0; i < n; i++) {
            d[i]= i + 1;
        }
        s[0] = 0;
        for (int j = 1; j < n+1; j++) {
            int temp = j * 2;
            int step = s[j-1] + 1;
            if (temp<=n && s[temp - 1]==0 || temp<=n && s[temp-1]>step) {
                s[temp-1]=step;
                prev[temp-1]=d[j-1];
            }
            temp = j * 3;
            step = s[j-1] + 1;
            if (temp<=n && s[temp - 1]==0 || temp<=n && s[temp-1]>step) {
                s[temp-1]=step;
                prev[temp-1]=d[j-1];
            }
            temp = j + 1;
            step = s[j-1] + 1;
            if (temp<=n && s[temp - 1]==0 || temp<=n && s[temp-1]>step) {
                s[temp-1]=step;
                prev[temp-1]=d[j-1];
            }
        }
        int[] res = new int[s[n-1]+1];
        Arrays.fill(res,-1);
        System.out.println(s[n-1]);
        res[s[n-1]]=d[n-1];
            for (int i = n - 1, k=s[n-1]; i >0;k--) {
                res[k - 1]=prev[i];
                i=prev[i]-1;
            }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
