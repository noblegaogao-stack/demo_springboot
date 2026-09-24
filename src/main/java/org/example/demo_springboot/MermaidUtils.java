package org.example.demo_springboot;

import java.util.List;

public class MermaidUtils {
    // 已有生成流程图的方法
    public static String generateFlowChart(List<FlowChartNode> nodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("graph TD\n");
        for (FlowChartNode node : nodes) {
            sb.append("    ")
              .append(node.getFrom())
              .append(" --> ")
              .append(node.getTo())
              .append("\n");
        }
        return sb.toString();
    }

    // 生成符合 xychart-beta 格式的 XY 图代码
    public static String generateXYChart(String title, List<String> xAxisLabels, String yAxisLabel, double yMin, double yMax, List<Double> barData, List<Double> lineData) {
        StringBuilder sb = new StringBuilder();
        sb.append("xychart-beta\n");
        sb.append("    title \"").append(title).append("\"\n");
        sb.append("    x-axis [").append(String.join(", ", xAxisLabels)).append("]\n");
        sb.append("    y-axis \"").append(yAxisLabel).append("\" ").append(yMin).append(" --> ").append(yMax).append("\n");
        sb.append("    bar [").append(formatData(barData)).append("]\n");
        sb.append("    line [").append(formatData(lineData)).append("]\n");
        return sb.toString();
    }

    // 辅助方法，格式化数据列表
    private static String formatData(List<Double> data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if (i < data.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    // 生成 Mermaid 饼图代码的静态方法
    public static String generatePieChart(List<PieChartData> dataList) {
        StringBuilder sb = new StringBuilder();
        sb.append("pie\n");
        for (PieChartData data : dataList) {
            sb.append("    title Pie Chart\n")
                    .append("    \"")
                    .append(data.getLabel())
                    .append("\" : ")
                    .append(data.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    // 新增生成雷达图的方法
    public static String generateRadarChart(RadarChartData radarChartData) {
        StringBuilder sb = new StringBuilder();
        sb.append("radarChart\n");
        sb.append("    title ").append(radarChartData.getTitle()).append("\n");
        sb.append("    categories ").append(String.join(", ", radarChartData.getCategories())).append("\n");
        sb.append("    values ").append(formatData(radarChartData.getValues())).append("\n");
        return sb.toString();
    }

}

