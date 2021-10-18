 static String solution(String new_id) {
    String id = new_id;
    id = id.toLowerCase();
    id = two(id);
    id = three(id);
    id = four(id);
    if (id.length() == 0) {
      id = "a";
    }
    if (id.length() >= 16) {
      id = id.substring(0, 15);
    }
    id = four(id);
    if (id.length() <= 2) {
      while (id.length() <= 2) {
        id += id.charAt(id.length() - 1);
      }
    }
    return id;
  }

  static String two(String id) {
    StringBuilder new_id = new StringBuilder();
    for (int i = 0; i < id.length(); i++) {
      char c = id.charAt(i);
      if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
        new_id.append(c);
      }
    }
    return new_id.toString();
  }

  static String three(String id) {
    StringBuilder new_id = new StringBuilder();
    for (int i = 0; i < id.length(); i++) {
      char c = id.charAt(i);
      if (i > 0) {
        char prev = id.charAt(i - 1);
        if (c == '.' && prev == '.') {

        } else {
          new_id.append(c);
        }
      } else {
        new_id.append(c);
      }
    }
    return new_id.toString();
  }

  static String four(String id) {
    StringBuilder new_id = new StringBuilder();
    for (int i = 0; i < id.length(); i++) {
      char c = id.charAt(i);
      if (i == 0 || i == id.length() - 1) {
        if (c != '.') {
          new_id.append(c);
        }
      } else {
        new_id.append(c);
      }
    }
    return new_id.toString();
  }