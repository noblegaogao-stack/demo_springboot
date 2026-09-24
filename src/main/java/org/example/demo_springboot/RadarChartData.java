package org.example.demo_springboot;

import java.util.List;

/**
 * 表示雷达图的数据类
 */
public class RadarChartData {
    private String title;  // 雷达图标题
    private List<String> categories;  // 雷达图的类别
    private List<Double> values;  // 每个类别的对应值

    public RadarChartData(String title, List<String> categories, List<Double> values) {
        this.title = title;
        this.categories = categories;
        this.values = values;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Double> getValues() {
        return values;
    }
}
