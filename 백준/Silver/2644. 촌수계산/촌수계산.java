import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        String[] q = br.readLine().split(" ");
        int a = Integer.parseInt(q[0]);
        int b = Integer.parseInt(q[1]);
        int relationCnt = Integer.parseInt(br.readLine());

        // 크기가 n+1인 ArrayList
        List<List<Integer>> relationList = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            relationList.add(new ArrayList<>());
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < relationCnt; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            relationList.get(x).add(y);
            relationList.get(y).add(x);
        }

        int result = 0; // 시작점은 포함하지 않으므로

        // bfs 시작 - a에서 시작
            queue.offer(a);
            visited[a] = true;

        boolean isRelated = false;
        BFS_LOOP:
        while(!queue.isEmpty()) {
            result++;
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Integer polledItem = queue.poll();

                List<Integer> polledList = relationList.get(polledItem);
                for (Integer j : polledList) {
                    // b와 일치하는지 확인한다. -> 일치하면 종료
                    if (j == b) {
                        isRelated = true;
                        break BFS_LOOP;
                    }
                    // 조건을 충족하면 queue에 넣는다.
                    if(!visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        if(!isRelated) {
            result = -1;
        }
        System.out.println(result);

    }
}