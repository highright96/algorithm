static String[] solution(String[] record) {
    List<String> ans = new ArrayList<>();
    Map<String, String> map = new TreeMap<>();
    for (String s : record) {
      String[] str = s.split(" ");
      if (str[0].equals("Enter") || str[0].equals("Change")) {
        map.put(str[1], str[2]);
      }
    }

    for (String s : record) {
      String[] str = s.split(" ");
      if (str[0].equals("Enter")) {
        ans.add(map.get(str[1]) + "님이 들어왔습니다.");
      } else if (str[0].equals("Leave")) {
        ans.add(map.get(str[1]) + "님이 나갔습니다.");
      }
    }

    return ans.toArray(new String[ans.size()]);
}