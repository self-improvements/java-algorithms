package io.github.imsejin.study.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178871">달리기 경주</a>
 */
public class L178871 {

    static String[] solve(String[] players, String[] callings) {
        Map<String, Integer> playerToRank = new HashMap<>();
        Map<Integer, String> rankToPlayer = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerToRank.put(players[i], i + 1);
            rankToPlayer.put(i + 1, players[i]);
        }

        for (String chasingPlayer : callings) {
            Integer rank = playerToRank.get(chasingPlayer);
            String chasedPlayer = rankToPlayer.get(rank - 1);

            playerToRank.replace(chasingPlayer, rank - 1);
            rankToPlayer.replace(rank - 1, chasingPlayer);

            rankToPlayer.replace(rank, chasedPlayer);
            playerToRank.replace(chasedPlayer, rank);
        }

        return rankToPlayer.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toArray(String[]::new);
    }

}
