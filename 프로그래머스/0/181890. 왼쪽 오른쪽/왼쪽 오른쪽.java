import java.util.List;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] str_list) {
        List<String> strList = new ArrayList<>(List.of(str_list)); 
        List<String> result = new ArrayList<>();

        if (strList.contains("l") && strList.contains("r")) {
            if (strList.indexOf("l") < strList.indexOf("r")) {
                result = getL(strList);
            } else {
                result = getR(strList);
            }
        } else if (strList.contains("r")) {
            result = getR(strList);
        } else if (strList.contains("l")) {
            result = getL(strList);
        }
        return result.toArray(new String[0]);
    }

    private List<String> getR(List<String> strList) {
        return strList.subList(strList.indexOf("r") + 1, strList.size());
    }

    private List<String> getL(List<String> strList) {
        return strList.subList(0, strList.indexOf("l"));
    }
}