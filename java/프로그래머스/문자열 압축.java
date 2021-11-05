  private static int solutions(String s) {
    int inputLen = s.length();
    int compLen = 1, min = inputLen;
    //input 의 길이가 8이면 4까지만 압축할 수 있다.
    while (compLen <= inputLen / 2) {
      StringBuilder sb = new StringBuilder();
      String prev = s.substring(0, compLen);
      int cnt = 1;
      for (int start = compLen; start < inputLen; start += compLen) {
        //subString 의 end 범위가 input 길이를 넘을 경우를 위해 작은 값을 선택
        String cur = s.substring(start, Math.min(inputLen, start + compLen));
        //비교하는 문자열이 같을 경우
        if (cur.equals(prev)) {
          cnt++;
        } else {
          //문자열 압축
          compression(sb, cnt, prev);
          prev = cur;
          cnt = 1;
        }
      }
      //마지막 문자열 압축
      compression(sb, cnt, prev);
      min = Math.min(min, sb.length());
      compLen++;
    }
    return min;
  }

  static void compression(StringBuilder sb, int cnt, String prev){
    if (cnt != 1) {
      sb.append(cnt);
    }
    sb.append(prev);
  }