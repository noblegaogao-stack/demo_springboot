package org.example.demo_springboot;

import org.example.demo_springboot.FlowChartNode;
import org.example.demo_springboot.MermaidUtils;
import org.example.demo_springboot.RadarChartData;
import org.example.demo_springboot.XYChartData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MermaidController {

    @GetMapping("/mermaid/flowchart")
    public String getMermaidFlowChart() {
        var nodes = Arrays.asList(
                new FlowChartNode("A[开始]", "B[处理]"),
                new FlowChartNode("B", "C[结束]")
        );
        return MermaidUtils.generateFlowChart(nodes);
    }

    @GetMapping("/mermaid/piechart")
    public String getMermaidPieChart() {
        // 假设 PieChartData 类存在
        List<PieChartData> dataList = Arrays.asList(
                new PieChartData("A 部分", 30),
                new PieChartData("B 部分", 50),
                new PieChartData("C 部分", 20)
        );
        return MermaidUtils.generatePieChart(dataList);
    }

    @GetMapping("/mermaid/xychart")
    public String getMermaidXYChart() {
        String title = "Sales Revenue";
        List<String> xAxisLabels = Arrays.asList("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec");
        String yAxisLabel = "Revenue (in $)";
        double yMin = 4000;
        double yMax = 11000;
        List<Double> barData = Arrays.asList(5000.0, 6000.0, 7500.0, 8200.0, 9500.0, 10500.0, 11000.0, 10200.0, 9200.0, 8500.0, 7000.0, 6000.0);
        List<Double> lineData = Arrays.asList(5000.0, 6000.0, 7500.0, 8200.0, 9500.0, 10500.0, 11000.0, 10200.0, 9200.0, 8500.0, 7000.0, 6000.0);

        return MermaidUtils.generateXYChart(title, xAxisLabels, yAxisLabel, yMin, yMax, barData, lineData);
    }

    // 新增获取雷达图的接口
    @GetMapping("/mermaid/radarchart")
    public String getMermaidRadarChart() {
        String title = "Product Performance";
        List<String> categories = Arrays.asList("Quality", "Features", "Usability", "Price", "Support");
        List<Double> values = Arrays.asList(8.5, 9.0, 8.0, 7.5, 8.8);
        RadarChartData radarChartData = new RadarChartData(title, categories, values);
        return MermaidUtils.generateRadarChart(radarChartData);
    }
}
