package listeningrain.cn.excel.utils;

import listeningrain.cn.excel.annotation.ExcelField;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * User:        listeningrain.cn
 * Date:        2018/10/16 15:12
 * Description:
 */
public class ExcelUtils {

    /**
     * 导出Excel到输出流
     * @param os
     * @param cls
     * @param data
     * @param <T>
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> void exportExcel(OutputStream os, Class<T> cls, List<T> data) throws IOException, IllegalArgumentException, IllegalAccessException {
        // 声明一个工作簿
        @SuppressWarnings("resource")
        Workbook wb = new HSSFWorkbook();
        // 生成一个sheet
        Sheet sheet = wb.createSheet();

        // 创建标题行
        Row titleRow = sheet.createRow(0);
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (excelField == null) {
                continue;
            }
            // 单元格样式
            CellStyle cellStyle = wb.createCellStyle();

            Font font = wb.createFont();
            // 粗体
            font.setBold(true);
            cellStyle.setFont(font);

            Cell cell = titleRow.createCell(excelField.index() - 1);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(excelField.title());
        }

        // 设置导出内容
        int beginIndex = 1;
        // 填充内容
        for (T obj : data) {
            Row row = sheet.createRow(beginIndex);
            for (Field field : fields) {
                field.setAccessible(true);
                ExcelField excelField = field.getAnnotation(ExcelField.class);
                if (excelField == null) {
                    continue;
                }
                // 转换为字符串值
                String cellVal = String.valueOf(field.get(obj) == null ? "" : field.get(obj));
                Cell cell = row.createCell(excelField.index() - 1);
                cell.setCellValue(cellVal);
            }
            beginIndex++;
        }

        wb.write(os);
    }

    @SuppressWarnings("unchecked")
    private static <T> T transferString(String strVal, int type) {
        switch (type) {
            case ExcelField.STRING:
                return (T) strVal;
            case ExcelField.INT:
                return (T) Integer.valueOf(strVal);
            case ExcelField.LONG:
                return (T) Long.valueOf(strVal);
            case ExcelField.TIMESTAMP:{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String parse =sdf.format(strVal);
                return (T) parse;
            }
            default:
                return null;
        }
    }
}
