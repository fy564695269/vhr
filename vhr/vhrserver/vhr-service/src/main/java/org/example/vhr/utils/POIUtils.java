package org.example.vhr.utils;

import com.example.springbootvhr.entity.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POIUtils {
    public static ResponseEntity<byte[]> employeeToExcel(List<Employee> list) {
        //1.创建一个excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建文档摘要
        workbook.createInformationProperties();
        //3.获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工信息");
        //文档管理员
        docInfo.setManager("fy");
        //文档公司
        docInfo.setCompany("家里蹲公司");
        //4.获取文档摘要信息
        SummaryInformation sumInfo = workbook.getSummaryInformation();
        //文档标题
        sumInfo.setTitle("员工信息表");
        //文档作者
        sumInfo.setAuthor("fy");
        //文档备注
        sumInfo.setComments("本文档由fy提供");
        //5.创建样式
        //创建标题行样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillBackgroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//填充
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        HSSFSheet hssfSheet = workbook.createSheet("员工信息表");
        hssfSheet.setColumnWidth(0, 5 * 256);
        hssfSheet.setColumnWidth(1, 12 * 256);
        hssfSheet.setColumnWidth(2, 10 * 256);
        hssfSheet.setColumnWidth(3, 5 * 256);
        hssfSheet.setColumnWidth(4, 12 * 256);
        hssfSheet.setColumnWidth(5, 20 * 256);
        hssfSheet.setColumnWidth(6, 10 * 256);
        hssfSheet.setColumnWidth(7, 10 * 256);
        hssfSheet.setColumnWidth(8, 16 * 256);
        hssfSheet.setColumnWidth(9, 12 * 256);
        hssfSheet.setColumnWidth(10, 25 * 256);
        hssfSheet.setColumnWidth(11, 15 * 256);
        hssfSheet.setColumnWidth(12, 20 * 256);
        hssfSheet.setColumnWidth(13, 16 * 256);
        hssfSheet.setColumnWidth(14, 14 * 256);
        hssfSheet.setColumnWidth(15, 12 * 256);
        hssfSheet.setColumnWidth(16, 12 * 256);
        hssfSheet.setColumnWidth(17, 8 * 256);
        hssfSheet.setColumnWidth(18, 12 * 256);
        hssfSheet.setColumnWidth(19, 12 * 256);
        hssfSheet.setColumnWidth(20, 12 * 256);
        hssfSheet.setColumnWidth(21, 12 * 256);
        hssfSheet.setColumnWidth(22, 12 * 256);
        hssfSheet.setColumnWidth(23, 20 * 256);
        hssfSheet.setColumnWidth(24, 20 * 256);


        //6.创建标题行
        HSSFRow row0 = hssfSheet.createRow(0);
        //创建标题列
        HSSFCell cell0 = row0.createCell(0);
        cell0.setCellValue("编号");
        cell0.setCellStyle(headerStyle);
        HSSFCell cell1 = row0.createCell(1);
        cell1.setCellStyle(headerStyle);
        cell1.setCellValue("姓名");
        HSSFCell cell2 = row0.createCell(2);
        cell2.setCellStyle(headerStyle);
        cell2.setCellValue("工号");
        HSSFCell cell3 = row0.createCell(3);
        cell3.setCellStyle(headerStyle);
        cell3.setCellValue("性别");
        HSSFCell cell4 = row0.createCell(4);
        cell4.setCellStyle(headerStyle);
        cell4.setCellValue("出生日期");
        HSSFCell cell5 = row0.createCell(5);
        cell5.setCellStyle(headerStyle);
        cell5.setCellValue("身份证号码");
        HSSFCell cell6 = row0.createCell(6);
        cell6.setCellStyle(headerStyle);
        cell6.setCellValue("婚姻状况");
        HSSFCell cell7 = row0.createCell(7);
        cell7.setCellStyle(headerStyle);
        cell7.setCellValue("民族");
        HSSFCell cell8 = row0.createCell(8);
        cell8.setCellStyle(headerStyle);
        cell8.setCellValue("籍贯");
        HSSFCell cell9 = row0.createCell(9);
        cell9.setCellStyle(headerStyle);
        cell9.setCellValue("政治面貌");
        HSSFCell cell10 = row0.createCell(10);
        cell10.setCellStyle(headerStyle);
        cell10.setCellValue("电子邮件");
        HSSFCell cell11 = row0.createCell(11);
        cell11.setCellStyle(headerStyle);
        cell11.setCellValue("电话号码");
        HSSFCell cell12 = row0.createCell(12);
        cell12.setCellStyle(headerStyle);
        cell12.setCellValue("联系地址");
        HSSFCell cell13 = row0.createCell(13);
        cell13.setCellStyle(headerStyle);
        cell13.setCellValue("所属部门");
        HSSFCell cell14 = row0.createCell(14);
        cell14.setCellStyle(headerStyle);
        cell14.setCellValue("职位");
        HSSFCell cell15 = row0.createCell(15);
        cell15.setCellStyle(headerStyle);
        cell15.setCellValue("职称");
        HSSFCell cell16 = row0.createCell(16);
        cell16.setCellStyle(headerStyle);
        cell16.setCellValue("聘用形式");
        HSSFCell cell17 = row0.createCell(17);
        cell17.setCellStyle(headerStyle);
        cell17.setCellValue("入职日期");
        HSSFCell cell18 = row0.createCell(18);
        cell18.setCellStyle(headerStyle);
        cell18.setCellValue("转正日期");
        HSSFCell cell19 = row0.createCell(19);
        cell19.setCellStyle(headerStyle);
        cell19.setCellValue("合同起始日期");
        HSSFCell cell20 = row0.createCell(20);
        cell20.setCellStyle(headerStyle);
        cell20.setCellValue("合同终止日期");
        HSSFCell cell21 = row0.createCell(21);
        cell21.setCellStyle(headerStyle);
        cell21.setCellValue("合同期限");
        HSSFCell cell22 = row0.createCell(22);
        cell22.setCellStyle(headerStyle);
        cell22.setCellValue("最高学历");
        HSSFCell cell23 = row0.createCell(23);
        cell23.setCellStyle(headerStyle);
        cell23.setCellValue("毕业院校");
        HSSFCell cell24 = row0.createCell(24);
        cell24.setCellStyle(headerStyle);
        cell24.setCellValue("专业");
        HSSFCell cell25 = row0.createCell(25);
        cell25.setCellStyle(headerStyle);
        cell25.setCellValue("工作状态");

        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            HSSFRow row = hssfSheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkID());
            row.createCell(3).setCellValue(emp.getGender());
            HSSFCell c4 = row.createCell(4);
            c4.setCellStyle(dateCellStyle);
            c4.setCellValue(emp.getBirthday());
            row.createCell(5).setCellValue(emp.getIdCard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativePlace());
            row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(emp.getEmail());
            row.createCell(11).setCellValue(emp.getPhone());
            row.createCell(12).setCellValue(emp.getAddress());
            row.createCell(13).setCellValue(emp.getDepartment().getName());
            row.createCell(14).setCellValue(emp.getPosition().getName());
            row.createCell(15).setCellValue(emp.getJoblevel().getName());
            row.createCell(16).setCellValue(emp.getEngageForm());
            HSSFCell c17 = row.createCell(17);
            c17.setCellStyle(dateCellStyle);
            c17.setCellValue(emp.getBeginDate());
            HSSFCell c18 = row.createCell(18);
            c18.setCellStyle(dateCellStyle);
            c18.setCellValue(emp.getConversionTime());
            HSSFCell c19 = row.createCell(19);
            c19.setCellStyle(dateCellStyle);
            c19.setCellValue(emp.getBeginContract());
            HSSFCell c20 = row.createCell(20);
            c20.setCellStyle(dateCellStyle);
            c20.setCellValue(emp.getEndContract());
            row.createCell(21).setCellValue(emp.getContractTerm());
            row.createCell(22).setCellValue(emp.getTiptopDegree());
            row.createCell(23).setCellValue(emp.getSchool());
            row.createCell(24).setCellValue(emp.getSpecialty());
            row.createCell(25).setCellValue(emp.getWorkState());
        }

        ByteArrayOutputStream bios = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",
                    new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(bios);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(bios.toByteArray(), headers, HttpStatus.CREATED);
    }

    //excel解析成employee集合
    public static List<Employee> excelToEmployee(MultipartFile file, List<Nation> allNations, List<Politicsstatus> allPoliticsstatus, List<Department> allDepartments, List<Position> allPositions, List<Joblevel> allJobLevels) {
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            //1.创建一个workBook对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2.获取workBook中的表单数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3.获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4.获取表单中的行数
                int numOfRow = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < numOfRow; j++) {
                    //5.跳过标题行
                    if (j == 0) {
                        continue; //跳过标题行
                    }
                    //6.获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue; //防止数据中间有空行
                    }
                    //7.获取列
                    int numOfCell = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < numOfCell; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        int valueIndex = allNations.indexOf(new Nation(cellValue));
                                        employee.setNationId(allNations.get(valueIndex).getId());
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        int PIndex = allPoliticsstatus.indexOf(new Politicsstatus(cellValue));
                                        employee.setPoliticId(allPoliticsstatus.get(PIndex).getId());
                                        break;
                                    case 10:
                                        employee.setEmail(cellValue);
                                        break;
                                    case 11:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 12:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 13:
                                        int departmentIndex = allDepartments.indexOf(new Department(cellValue));
                                        employee.setDepartmentId(allDepartments.get(departmentIndex).getId());
                                        break;
                                    case 14:
                                        int posIndex = allPositions.indexOf(new Position(cellValue));
                                        employee.setPosId(allPositions.get(posIndex).getId());
                                        break;
                                    case 15:
                                        int jobLevelIndex = allJobLevels.indexOf(new Joblevel(cellValue));
                                        employee.setJobLevelId(allJobLevels.get(jobLevelIndex).getId());
                                        break;
                                    case 16:
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 22:
                                        employee.setTiptopDegree(cellValue);
                                        break;
                                    case 23:
                                        employee.setSchool(cellValue);
                                        break;
                                    case 24:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 25:
                                        employee.setWorkState(cellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 17:
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 18:
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 20:
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 21:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                }
                            }
                        }
                    }
                    list.add(employee);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
