class Solution {
    public int solution(String s) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= s.length(); i++) {
                String value = compress(s, i);
                min = Math.min(min, value.length());
            }
            return min;
        }

        private static String compress(String s, int k) {
            // 1. 하나만 자르기
            StringBuilder sb = new StringBuilder();
            int dupCnt = 1;
            String prevStr = s.substring(0, k);
            for (int i = k; i < s.length(); i=i+k) {
                String curStr = null;
                if(i+k > s.length()) {
                    curStr = s.substring(i);
                }else{
                    curStr = s.substring(i, i + k);
                }

                if (curStr.equals(prevStr)) {
                    dupCnt++;
                }else{
                    String dupCntStr = dupCnt == 1 ? "" : String.valueOf(dupCnt);
                    sb.append(dupCntStr).append(prevStr);
                    // 초기화
                    prevStr = curStr;
                    dupCnt = 1;
                }
            }
            String dupCntStr = dupCnt == 1 ? "" : dupCnt + "";
            sb.append(dupCntStr).append(prevStr);
            return sb.toString();
    }
}