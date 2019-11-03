package listeningrain.cn.excel.test;

import listeningrain.cn.excel.annotation.ExcelField;

/**
 * Author: listeningrain
 * Date: 2019-11-03 10:55
 * Description:
 */
public class Student {
    @ExcelField(index = 1, name = "name", title = "学生姓名", type = ExcelField.STRING)
    private String name;

    @ExcelField(index = 2, name = "age", title = "学生年纪", type = ExcelField.INT)
    private int age;

    @ExcelField(index = 3, name = "classes", title = "学生班级", type = ExcelField.STRING)
    private String classes;

    public Student(String name, int age, String classes) {
        this.name = name;
        this.age = age;
        this.classes = classes;
    }
}
