package io.github.imsejin.study.programmers.lv1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150370">개인정보 수집 유효기간</a>
 */
public class L150370 {

    static int[] solve0(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = parseDate(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            StringTokenizer tokenizer = new StringTokenizer(term);
            String type = tokenizer.nextToken();
            int month = Integer.parseInt(tokenizer.nextToken());

            termMap.put(type, month);
        }

        List<Integer> privaciesToDelete = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];

            StringTokenizer tokenizer = new StringTokenizer(privacy);
            LocalDate joinDate = parseDate(tokenizer.nextToken());
            String type = tokenizer.nextToken();

            Integer month = termMap.get(type);
            LocalDate deleteDate = joinDate.plusMonths(month);

            if (!deleteDate.isAfter(todayDate)) {
                privaciesToDelete.add(i + 1);
            }
        }

        return privaciesToDelete.stream().mapToInt(it -> it).toArray();
    }

    static int[] solve1(String today, String[] terms, String[] privacies) {
        DateString todayString = new DateString(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            StringTokenizer tokenizer = new StringTokenizer(term);
            String type = tokenizer.nextToken();
            int month = Integer.parseInt(tokenizer.nextToken());

            termMap.put(type, month);
        }

        List<Integer> privaciesToDelete = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];

            StringTokenizer tokenizer = new StringTokenizer(privacy);
            DateString joinDate = new DateString(tokenizer.nextToken());
            String type = tokenizer.nextToken();

            Integer month = termMap.get(type);
            DateString deleteDate = joinDate.plusMonth(month);

            if (deleteDate.compareTo(todayString) <= 0) {
                privaciesToDelete.add(i + 1);
            }
        }

        return privaciesToDelete.stream().mapToInt(it -> it).toArray();
    }

    // -------------------------------------------------------------------------------------------------

    private static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    private static class DateString implements Comparable<DateString> {
        private final int year;

        private final int month;

        private final int day;

        public DateString(String date) {
            String[] fragments = date.split("\\.");
            this.year = Integer.parseInt(fragments[0]);
            this.month = Integer.parseInt(fragments[1]);
            this.day = Integer.parseInt(fragments[2]);
        }

        private DateString(int year, int month, int day) {
            if (year < 0) throw new IllegalArgumentException("Invalid year: " + year);
            if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month: " + month);
            if (day < 1 || day > 28) throw new IllegalArgumentException("Invalid day: " + day);

            this.year = year;
            this.month = month;
            this.day = day;
        }

        public DateString plusMonth(int monthToAdd) {
            int month = (this.month + monthToAdd) % 12;
            if (month == 0) month = 12;

            int year = this.year;
            if (this.month + monthToAdd > 12) {
                year += (this.month + monthToAdd) / 12;
                if (month == 12) year--;
            }

            return new DateString(year, month, this.day);
        }

        @Override
        public String toString() {
            return String.format("%04d.%02d.%02d", year, month, day);
        }

        @Override
        public int compareTo(DateString o) {
            int comparison = Integer.compare(this.year, o.year);
            if (comparison != 0) return comparison;

            comparison = Integer.compare(this.month, o.month);
            if (comparison != 0) return comparison;

            return Integer.compare(this.day, o.day);
        }
    }

}
