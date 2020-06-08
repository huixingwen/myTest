package com.rt;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/12/16 10:29
 * @描述
 */
public class ExcelTest {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\wenxinghui\\Desktop\\191216103525.xls"); // 创建文件对象
            Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）
            Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）
            for (int i = 0; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    System.out.printf(cell.getContents()+" ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
