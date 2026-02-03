class Solution {
    public String solution(String new_id) {
            return convertId(new_id);
        }

        private String convertId(String newId) {
            String newId1 = newId.toLowerCase();
            String newId2 = newId1.replaceAll("[^a-z0-9-_.]", "");
            String newId3 = newId2.replaceAll("\\.{2,}", ".");
            if (newId3.charAt(0) == '.') {
                newId3 = newId3.substring(1);
            }
            if (newId3.isBlank()) {
                newId3 = "a";
            }
            if(newId3.charAt(newId3.length()-1) == '.') {
                newId3 = newId3.substring(0, newId3.length()-1);
            }
            if (newId3.length() >= 16) {
                newId3 = newId3.substring(0, 15);
            }
            if(newId3.charAt(newId3.length()-1) == '.') {
                newId3 = newId3.substring(0, newId3.length()-1);
            }
            if (newId3.length() <= 2) {
                char lastChar = newId3.charAt(newId3.length() - 1);
                while (newId3.length() != 3) {
                    newId3 += lastChar;
                }
            }
            return newId3;
        }
}