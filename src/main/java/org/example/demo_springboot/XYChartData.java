package org.example.demo_springboot;

import java.util.List;

// 表示 XY 图的数据类
public class XYChartData {
    private String datasetName;  // 数据集名称
    private List<Double[]> dataPoints;  // 数据点列表，每个数据点是一个包含 x 和 y 坐标的数组

    public XYChartData(String datasetName, List<Double[]> dataPoints) {
        this.datasetName = datasetName;
        this.dataPoints = dataPoints;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public List<Double[]> getDataPoints() {
        return dataPoints;
    }
}
