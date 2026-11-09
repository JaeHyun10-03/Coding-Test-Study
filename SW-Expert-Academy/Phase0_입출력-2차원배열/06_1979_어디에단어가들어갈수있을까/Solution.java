import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            int result = 0;

            // 2차원 배열을 만들자.
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // for(int i=0; i<N; i++){
            //     for(int j=0; j<N; j++){
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.print("\n");
            // }
            // System.out.print("123412341234");

            // 만들어진 N x N 배열에서 가로에서 연속된 K개의 칸이 있는지 확인하자
            for(int i=0; i<N; i++){
                String seq = "";
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 1){
                        seq += "1";
                    }
                    if(arr[i][j] == 0 || j == N-1){
                        if(seq.length() == K){
                            result++;
                            seq = "";
                        }else{
                            seq = "";
                        }
                    }
                }
            }

            // 세로도 확인해.
            for(int j=0; j<N; j++){
                String seq = "";
                for(int i=0; i<N; i++){
                    if(arr[i][j] == 1){
                        seq += "1";
                    }
                    if(arr[i][j] == 0 || i == N-1){
                        if(seq.length() == K){
                            result++;
                            seq = "";
                        }else{
                            seq = "";
                        }
                    }
                }
            }



            // StirngBuilder에 답 밀어넣어.
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
