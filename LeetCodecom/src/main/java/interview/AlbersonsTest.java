package interview;


//public class AlbersonsTest {
//
//    public static String getString(String s) {
//
//        String str = s;
//        String result = helper(s.toCharArray(), s.length());
//        while (isSmaller(str, result)){
//            str = result;
//            result = helper(str.toCharArray(), s.length());
//        }
//
//        return str;
//    }
//
//    private static boolean isSmaller (String s1, String s2){
//
//        int index = 0;
//
//        while (index < s1.length()){
//
//            char ch1 = s1.charAt(index);
//            char ch2 = s2.charAt(index++);
//            if(ch1 < ch2) return false;
//            if (ch1 > ch2) return true;
//        }
//
//        return false;
//    }
//
//    private static String helper(char[] str, int length){
//
//        int i, j = 0;
//        int []chk = new int[26];
//        for (i = 0; i < 26; i++)
//            chk[i] = -1;
//        for (i = 0; i < str.length; i++) {
//            if (chk[str[i] - 'a'] == -1)
//                chk[str[i] - 'a'] = i;
//        }
//        for (i = 0; i < str.length; i++) {
//            boolean flag = false;
//            for (j = 0; j < str[i] - 'a'; j++) {
//                if (chk[j] > chk[str[i] - 'a'])
//                {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag)
//                break;
//        }
//        if (i < str.length) {
//            char ch1 = str[i];
//            char ch2 = (char) (j + 'a');
//            for (i = 0; i < str.length; i++) {
//                if (str[i] == ch1) {
//                    str[i] = ch2;
//                }else if (str[i] == ch2) {
//                    str[i] = ch1;
//                }
//            }
//        }
//
//        return String.valueOf(str);
//    }
//
//    @Test
//    public void test(){
//
//        Assert.assertEquals(getString("bdea"), "abde");
//        Assert.assertEquals(getString("abba"), "abba");
//    }
//
//
//    public static String getCapitalCity(String country) {
//        try {
//
//            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + country);
//
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestProperty("accept", "application/json");
//
//            InputStream responseStream = connection.getInputStream();
//
//            String text = new BufferedReader(
//                    new InputStreamReader(responseStream, StandardCharsets.UTF_8))
//                    .lines()
//                    .collect(Collectors.joining("\n"));
//
//            System.out.println(text);
//
//
//
//        } catch (Exception e) {
//
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode node = mapper.readTree(json_str);
//            String name = node.get("name").asText();
//            String place = node.get("age").asText();
//            System.out.println("node"+node);
//            System.out.println("name: "+name +", place: "+place);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
