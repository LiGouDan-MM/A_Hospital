package com.zhiyou100;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class TestPOI {
	/**
	 * 导出: 从系统中导出到本地
	 * @throws IOException 
	 */
    @Test
	public void export() throws IOException {
		// 1.创建工作表
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.创建sheet
		HSSFSheet sheet1 = wb.createSheet();
		// 3.在sheet中创建行:
		// 参数rownum指创建第几行  从0开始 
		HSSFRow row0 = sheet1.createRow(0);
		
		//设置行高
		row0.setHeight((short) 500);
		
		
		// 4.在行中创建列
		// 参数column指创建第几列 从0开始 
		HSSFCell r0c0 = row0.createCell(0);
		// 5.在单元格中写内容
		r0c0.setCellValue("门诊编号");
		// 6.导出:  输出流导出
		OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xls");
		wb.write(os);
		os.close();
		System.out.println("成功");
	}
    
    /**
     * 导入: 从本地导入到程序中
     * @throws IOException 
     * 
     */
    @Test
    public void importExcel() throws IOException {
    	// l.将本地文件一输入流的形式,读入程序
    	FileInputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.xls");
    	// 2.通过流创建工作表
    	HSSFWorkbook wb = new  HSSFWorkbook(in);
    	// 3.获得sheet  根据sheet下标获得
    	HSSFSheet sheet0 = wb.getSheetAt(0);
        // 4.获得行  : 获得第二行对象
    	HSSFRow row1 = sheet0.getRow(0);
    	
    	
    	
    	
    	// 5.获得列 : 获得第二列
    	HSSFCell r1c1 = row1.getCell(0);
    	// 6.获得值
    	String value = r1c1.getStringCellValue();
    	System.out.println("导出Excel,读出数据"+value);
    	
    
    }

}
