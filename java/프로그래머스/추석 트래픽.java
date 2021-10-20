  static int solution(String[] lines) {
    int[] count = new int[lines.length];

    for (int i = 0; i < lines.length; i++) {
      lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");

      int end = Integer.parseInt(lines[i].substring(0, 2)) * 3600 * 1000
          + Integer.parseInt(lines[i].substring(2, 4)) * 60 * 1000
          + Integer.parseInt(lines[i].substring(4, 6)) * 1000
          + Integer.parseInt(lines[i].substring(7, 10));

      int dur = Integer.parseInt(
          String.format("%.3f", Double.parseDouble(lines[i].substring(10))).replace(".", ""));
      lines[i] = end + " " + (end - dur);
    }

    for (int i = 0; i < lines.length; i++) {
      int end = Integer.parseInt(lines[i].split(" ")[0]);
      for (int j = i; j < lines.length; j++) {
        int start = Integer.parseInt(lines[j].split(" ")[1]);
        if(start + 1 <= end + 1000){
          count[i]++;
        }
      }
    }

    int max = 0;
    for (int i : count) {
      max = Math.max(max, i);
    }
    return max;
  }