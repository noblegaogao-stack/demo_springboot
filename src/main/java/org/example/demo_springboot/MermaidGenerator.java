package org.example.demo_springboot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MermaidGenerator {

    public static void main(String[] args) throws IOException, InterruptedException {
        String mermaidCode = """
            graph TD
                A[开始] --> B{是否登录?}
                B -- 是 --> C[进入系统]
                B -- 否 --> D[跳转登录页]
                C --> E[操作流程]
                D --> E
            """;

        // 1. 写入 .mmd 文件
        File mmdFile = new File("diagram.mmd");
        try (FileWriter writer = new FileWriter(mmdFile)) {
            writer.write(mermaidCode);
        }

        // 2. 构建命令：mmdc -i diagram.mmd -o diagram.png
        ProcessBuilder pb = new ProcessBuilder(
                "mmdc",
                "-V"
        );
//
//        ProcessBuilder pb = new ProcessBuilder(
//                "mmdc",
//                "-i", "diagram.mmd",
//                "-o", "diagram.png",
//                "-t", "default" // 可选: dark / forest / neutral / default
//        );
        pb.inheritIO(); // 打印错误或输出
        Process process = pb.start();
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Mermaid 图生成成功：diagram.png");
        } else {
            System.err.println("Mermaid 渲染失败，退出码：" + exitCode);
        }
    }
}
