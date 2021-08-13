    public int[] Solution(int[][] v) {
        int x = v[0][0], y = v[0][1];
        int xt = 0, yt = 0;
        int xc = 1, yc = 1;
        for (int i = 1; i < v.length; i++) {
            if (v[i][0] == x) {
                xc += 1;
            } else if (v[i][0] != x) {
                xt = v[i][0];
            }

            if (v[i][1] == y) {
                yc += 1;
            } else if (v[i][1] != y) {
                yt = v[i][1];
            }
        }
        int ansX = xc == 1 ? x : xt;
        int ansY = yc == 1 ? y : yt;
        return new int[]{ansX, ansY};
    }