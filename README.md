# SimpleExcel
轻松导出excel表格

最近在开发中经常遇到需要导出excel表格，经过几次的实践，本人琢磨出一套比较简单的导出excel表格的方法，在此和大家分享。

## 大家直接运行程序中test包下的Test测试类，即可看到效果哦。

使用方法：

第一步：
> 添加POI的依赖，假定大家在开发中都用Maven来管理依赖，在[MVN repository](https://mvnrepository.com/) 搜索最近的依赖版本，添加到pom.xml文件中。

```
 <!--POI操作Excel-->
        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>3.17</version>
        </dependency>
```

第二步：
> 下载target中的SimpleExcel.jar，并添加到项目的classpath路径下。

第三步：
> 具体的使用方法：
  1. 在需要输出的model对象中添加注解：
   ```
    @ExcelField(index = 1, name = "name", title = "学生姓名", type = ExcelField.STRING)
    private String name;
    
    @ExcelField(index = 2, name = "age", title = "学生年纪", type = ExcelField.INT)
    private String age;
    
    @ExcelField(index = 3, name = "classes", title = "学生班级", type = ExcelField.STRING)
    private String classes;
   ```
   
   其中index代表了在excel表格中的排序，name就是变量名，title就是excel的列名，type就是变量的类型
   
   2. 直接调用ExcelUtils中的exportExcel()方法，它接收三个参数：
      OutputStream：输出流，如果是web应用，可以从response中获取。
      class<T>： 输出对象的class对象。
      List<T>: List集合，即需要导出数据的集合。
  
    示例：
 
        List<Student> list = new ArrayList<>();
        list.add(new Student("阿锋", 22, "一班"));
        list.add(new Student("阿峰",23, "一班"));

        OutputStream outputStream = new FileOutputStream("D:\\test.xls");
        ExcelUtils.exportExcel(outputStream, Student.class, list );
    
     直接运行程序，即可见证奇迹哦！
   
   
