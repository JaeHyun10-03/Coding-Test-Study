import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];

            int x = 0;
            int y = 0;
            char d = '>';
            // H x W 크기의 격자판 2차원 배열 만들기
            for(int h=0; h<H; h++){
                char[] str = br.readLine().toCharArray();
                for(int w=0; w<W; w++){
                    arr[h][w] = str[w];
                    if(arr[h][w] == '^' || arr[h][w] == 'v' || arr[h][w] == '<' || arr[h][w] == '>'){
                        x = w;
                        y = h;
                        d = arr[h][w];
                    }
                }
            }

            // N개의 사용자의 입력 배열에 넣기
            int N = Integer.parseInt(br.readLine().trim());
            char[] input = br.readLine().toCharArray();

            // 사용자 입력에 따라 처리
            for(int i=0; i<N; i++){
                if(input[i] == 'U'){
                    d = '^';                                   // [수정] 이동 가능 여부와 무관하게 방향부터 변경
                    if(y-1 >= 0 && arr[y-1][x] == '.'){        // [수정] 범위 밖이어도 continue 금지(방향 갱신 필요)
                        arr[y][x] = '.';                       // [수정] 떠난 칸은 평지
                        y = y-1;
                    }
                    arr[y][x] = d;                             // [수정] 현재 칸에 전차 모양 반영
                }else if(input[i] == 'D'){
                    d = 'v';
                    if(y+1 < H && arr[y+1][x] == '.'){         // [수정] 조건 방향 반대였음
                        arr[y][x] = '.';
                        y = y+1;
                    }
                    arr[y][x] = d;
                }else if(input[i] == 'L'){
                    d = '<';
                    if(x-1 >= 0 && arr[y][x-1] == '.'){
                        arr[y][x] = '.';
                        x = x-1;
                    }
                    arr[y][x] = d;
                }else if(input[i] == 'R'){
                    d = '>';
                    if(x+1 < W && arr[y][x+1] == '.'){         // [수정] x+1 == W 도 범위 밖
                        arr[y][x] = '.';
                        x = x+1;
                    }
                    arr[y][x] = d;
                }else if(input[i] == 'S'){
                    int shootX = x;
                    int shootY = y;

                    if(d == '^'){
                        while(shootY > 0){
                            if(arr[shootY-1][shootX] == '*'){
                                arr[shootY-1][shootX] = '.';
                                break;
                            }else if(arr[shootY-1][shootX] == '#'){
                                break;
                            }
                            shootY--;                          // 평지·물은 통과
                        }
                    }else if(d == 'v'){
                        while(shootY < H-1){                   // [수정] shootY+1 접근하므로 H-1까지
                            if(arr[shootY+1][shootX] == '*'){
                                arr[shootY+1][shootX] = '.';
                                break;
                            }else if(arr[shootY+1][shootX] == '#'){
                                break;
                            }
                            shootY++;
                        }
                    }else if(d == '<'){
                        while(shootX > 0){
                            if(arr[shootY][shootX-1] == '*'){  // [수정] 행 인덱스는 shootY
                                arr[shootY][shootX-1] = '.';
                                break;
                            }else if(arr[shootY][shootX-1] == '#'){
                                break;
                            }
                            shootX--;
                        }
                    }else if(d == '>'){
                        while(shootX < W-1){                   // [수정] shootX+1 접근하므로 W-1까지
                            if(arr[shootY][shootX+1] == '*'){  // [수정] 행 인덱스는 shootY
                                arr[shootY][shootX+1] = '.';
                                break;
                            }else if(arr[shootY][shootX+1] == '#'){
                                break;
                            }
                            shootX++;
                        }
                    }
                }
            }

            // sb에 담기
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }
        // sb 최종 출력
        System.out.print(sb);
    }
}