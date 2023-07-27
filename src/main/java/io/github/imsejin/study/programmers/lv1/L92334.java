package io.github.imsejin.study.programmers.lv1;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92334">신고 결과 받기</a>
 */
public class L92334 {

    static int[] solve(String[] idList, String[] reportStrings, int k) {
        Set<Report> reports = new HashSet<>();
        for (String reportString : reportStrings) {
            StringTokenizer tokenizer = new StringTokenizer(reportString);
            String reportId = tokenizer.nextToken();
            String id = tokenizer.nextToken();

            reports.add(new Report(id, reportId));
        }

        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < idList.length; i++) {
            String id = idList[i];
            idIndexMap.put(id, i);
        }

        Map<String, List<Report>> reportMap = reports.stream().collect(groupingBy(Report::getReportId));

        DirectedGraph graph = new DirectedGraph(idList.length);
        for (String reportId : idList) {
            int reportIdIndex = idIndexMap.get(reportId);
            List<Report> reportList = reportMap.get(reportId);
            if (reportList == null) continue;

            for (Report report : reportList) {
                String id = report.getId();
                Integer idIndex = idIndexMap.get(id);
                graph.addEdge(reportIdIndex, idIndex);
            }
        }

        int[] mailCounts = new int[idList.length];
        for (int i = 0; i < mailCounts.length; i++) {
            int[] adjacentVertexes = graph.getAdjacentVertexes(i);
            for (int adjacentVertex : adjacentVertexes) {
                int inboundSize = graph.getInboundSize(adjacentVertex);
                if (inboundSize >= k) mailCounts[i]++;
            }
        }

        return mailCounts;
    }

    // -------------------------------------------------------------------------------------------------

    private static class DirectedGraph {
        private final int[][] table;

        public DirectedGraph(int vertexCount) {
            this.table = new int[vertexCount][vertexCount];
        }

        public void addEdge(int start, int end) {
            this.table[start][end]++;
        }

        public int[] getAdjacentVertexes(int vertex) {
            List<Integer> vertexes = new ArrayList<>();

            int[] row = this.table[vertex];
            for (int i = 0; i < row.length; i++) {
                if (row[i] > 0) vertexes.add(i);
            }

            return vertexes.stream().mapToInt(it -> it).toArray();
        }

        public int getInboundSize(int vertex) {
            int count = 0;

            for (int[] row : this.table) {
                if (row[vertex] > 0) count++;
            }

            return count;
        }
    }

    private static class Report {
        private final String id;

        private final String reportId;

        public Report(String id, String reportId) {
            this.id = id;
            this.reportId = reportId;
        }

        public String getId() {
            return id;
        }

        public String getReportId() {
            return reportId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Report that = (Report) o;
            return Objects.equals(id, that.id) && Objects.equals(reportId, that.reportId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, reportId);
        }
    }

}
