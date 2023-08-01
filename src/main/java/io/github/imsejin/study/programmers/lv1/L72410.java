package io.github.imsejin.study.programmers.lv1;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72410">신규 아이디 추천</a>
 */
public class L72410 {

    static String solve(String newId) {
        String recommendedId = newId.toLowerCase();
        recommendedId = recommendedId.replaceAll("[^a-z\\d_.-]", "");
        recommendedId = recommendedId.replaceAll("\\.{2,}", ".");
        recommendedId = recommendedId.replaceAll("^\\.|\\.$", "");
        if (recommendedId.isEmpty()) recommendedId = "a";
        if (recommendedId.length() > 15) recommendedId = recommendedId.substring(0, 15).replaceAll("\\.$", "");
        if (recommendedId.length() < 3) {
            String lastString = String.valueOf(recommendedId.charAt(recommendedId.length() - 1));
            recommendedId = recommendedId + lastString.repeat(3 - recommendedId.length());
        }

        return recommendedId;
    }

}
