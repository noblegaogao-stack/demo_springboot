package org.example.demo_springboot;

public class PieChartData {
    private String label;
    private double value;

    // 无参构造函数
    public PieChartData() {}

    // 带参构造函数，用于初始化标签和值
    public PieChartData(String label, double value) {
        this.label = label;
        this.value = value;
    }

    // 获取标签的方法
    public String getLabel() {
        return label;
    }

    // 获取值的方法
    public double getValue() {
        return value;
    }

    // 设置标签的方法
    public void setLabel(String label) {
        this.label = label;
    }

    // 设置值的方法
    public void setValue(double value) {
        this.value = value;
    }
}
