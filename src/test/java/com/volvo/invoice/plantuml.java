package com.volvo.invoice;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.core.DiagramDescription;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;


/**
 * Author: 李中华
 * Date: 2024/5/30 7:56
 **/
public class plantuml {

    public static void main(String[] args) throws Exception {

        plantuml.genPng();

    }

    public static void genPng() throws  Exception {
        OutputStream png = new FileOutputStream("D:/plantuml02.png");
        String sourceOld = "@startuml\n";
        sourceOld += "Bob -> Alice : hello\n";
        sourceOld += "@enduml\n";

        String source = "@startuml\n" +
                "actor Client\n" +
                "participant \"APP客户端\" as APP\n" +
                "participant \"中台系统\" as bizSystem\n" +
                "participant \"发票中心\" as invoiceCenter\n" +
                "participant \"OCR图像识别系统\" as OCR\n" +
                "participant \"消息中心\" as MQ\n" +
                "participant \"存储数据\" as MySQL\n" +
                "\n" +
                "Client ->  APP:车主认证\n" +
                "APP -> bizSystem:  接收发票、车主信息\n" +
                "bizSystem -> invoiceCenter:  接收发票、车主信息\n" +
                "invoiceCenter ->  OCR: 识别发票信息\n" +
                "OCR --> invoiceCenter: 返回发票信息\n" +
                "invoiceCenter -> invoiceCenter: 校验车主信息和发票信息是否一致\n" +
                "invoiceCenter --> bizSystem: 如果不一致，返回车主\n" +
                "bizSystem --> Client: 如果不一致，返回车主\n" +
                "invoiceCenter --> bizSystem: 校验成功\n" +
                "invoiceCenter --> MQ: 发放权益\n" +
                "invoiceCenter --> MySQL: 保存数据\n" +
                "MySQL --> invoiceCenter: 保存成功\n" +
                "invoiceCenter --> bizSystem: 保存成功\n" +
                "bizSystem --> Client: 保存成功\n" +
//               "invoiceCenter --> bizSystem: 保存成功\n" + "SalesSystem --> Client: 返回开票结果\n" +
                "@enduml\n";
        SourceStringReader reader = new SourceStringReader(source);
// Write the first image to "png"
        String desc = reader.outputImage(png).getDescription();
// Return a null string if no generation
        if (desc == null) {
            System.out.println("No image generated");
        } else {
            System.out.println(desc);
        }
    }

    public void genPng2() throws  Exception {
        try {
            // PlantUML 源代码
            String plantumlCode = "@startuml\nAlice -> Bob: Test\n@enduml";
//            ISourceFileReader fileReader = new ISourceFileReader();
            // 创建 SourceString 对象
            SourceStringReader source = new SourceStringReader(plantumlCode);
            // 输出格式
            FileFormat fileFormat = FileFormat.PNG;
            DiagramDescription diagramDescription = source.generateDiagramDescription();
            System.out.println(diagramDescription);
            final ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 创建 FileOutputStream 对象，用于写入文件
            FileOutputStream fileOutputStream = new FileOutputStream("D:/aaa1.png");

// Write the first image to "os"
            String desc = source.generateImage(fileOutputStream, new FileFormatOption(FileFormat.SVG));

            // 关闭流
            fileOutputStream.close();
            os.close();
            System.out.println("Generated diagram in output directory.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
