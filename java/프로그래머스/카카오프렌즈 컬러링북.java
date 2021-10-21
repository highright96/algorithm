class Solution {
    
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int cnt = 0, area = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            if (!visited[i][j] && picture[i][j] != 0) {
              area = Math.max(area, bfs(i, j, picture, visited));
              cnt++;
            }
          }
        }
        return new int[]{cnt, area};
    }


  static int bfs(int y, int x, int[][] picture, boolean[][] visited) {
    int total = 1;
    Queue<Area> q = new LinkedList<>();
    q.add(new Area(y, x));
    visited[y][x] = true;
    while (!q.isEmpty()) {
      Area area = q.poll();
      for (int i = 0; i < 4; i++) {
        int yy = area.y + dy[i];
        int xx = area.x  + dx[i];
        if (yy >= 0 && xx >= 0 && yy < picture.length && xx < picture[0].length) {
          if (!visited[yy][xx] && picture[area.y][area.x] == picture[yy][xx]) {
            q.add(new Area(yy, xx));
            visited[yy][xx] = true;
            total++;
          }
        }
      }
    }
    return total;
  }


    static class Area {

        int y;
        int x;

        public Area(int y, int x) {
          this.y = y;
          this.x = x;
        }
    }
}