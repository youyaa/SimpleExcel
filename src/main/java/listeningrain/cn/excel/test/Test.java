package listeningrain.cn.excel.test;

import listeningrain.cn.excel.utils.ExcelUtils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: listeningrain
 * Date: 2019-11-03 10:54
 * Description: 测试
 */
public class Test {

    public static void main(String[] args) throws Exception{
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("阿锋", 22, "一班"));
        list.add(new Student("阿峰",23, "一班"));

        OutputStream outputStream = new FileOutputStream("/Applications/program/test.xlsx");
        ExcelUtils.exportExcel(outputStream, Student.class, list );
    }
}
