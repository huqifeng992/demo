package com.example.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.ExcelModel.StudentEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		List<StudentEntity> list = new ArrayList<>();
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId("1");
		studentEntity.setBirthday(new Date());
		studentEntity.setName("胡奇锋");
		studentEntity.setSex(1);
		studentEntity.setRegistrationDate(new Date());
		list.add(studentEntity);
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
				StudentEntity.class, list);
		File savefile = new File("D:/excel/");
		if (!savefile.exists()) {
			savefile.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream("D:/excel/胡奇锋.xls");
		workbook.write(fos);
		fos.close();
	}

	@Test
	public void test1() throws Exception{
		List<StudentEntity> list = new ArrayList<StudentEntity>();
		Workbook workbook = null;
		Date start = new Date();
		ExportParams params = new ExportParams("大数据测试", "测试");
		for (int i = 0; i < 1000000; i++) {  //一百万数据量
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setBirthday(new Date());
			studentEntity.setSex(1);
			studentEntity.setName("huqifeng"+i);
			studentEntity.setId(""+i);
			studentEntity.setRegistrationDate(new Date());
			list.add(studentEntity);
			if(list.size() == 10000){
				workbook = ExcelExportUtil.exportBigExcel(params, StudentEntity.class, list);
				list.clear();
			}
		}
		ExcelExportUtil.closeExportBigExcel();
		System.out.println(new Date().getTime() - start.getTime());
		File savefile = new File("D:/excel/");
		if (!savefile.exists()) {
			savefile.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream("D:/excel/ExcelExportBigData.bigDataExport.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
