package excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

public class XlsxReader {

    public static void main(String[] args){

        String filePathPrefix = "/Users/tingliang7t/";
        String productionValueFile = "production_value.xlsx";
        String stateBorderingFile = "state_bordering.xlsx";
        String outputFileName = "result.xlsx";

        Workbook productValue = readXlsxFile(filePathPrefix + productionValueFile);

        Workbook stateBordering = readXlsxFile(filePathPrefix + stateBorderingFile);

        Map<String, List<Integer>> stateNameToProductValuesMap = getStateNameToProductionListMap(productValue);
        Map<String, List<String>> fullStateNameToBorderingStateMap = getBorderingStateMap(stateBordering);
        Map<String, String> stateShortNameToFullNameMap = getStateShortNameToFullNameMap(stateBordering);

        Map<String, List<Double>> finalStateProductionValues = Maps.newHashMap();
        Map<String, List<Double>> importFromOtherStateSum = Maps.newHashMap();

        for(Map.Entry<String, List<Integer>> entry : stateNameToProductValuesMap.entrySet()){

           String fullStateName = entry.getKey();
           List<Integer> productValues = entry.getValue();

           List<Double> finalProductValues = Lists.newArrayList();
           List<Double> importSum = Lists.newArrayList();

           for(int i=0; i < productValues.size(); i++){

               if (productValues.get(i) != 0){
                   finalProductValues.add(Double.valueOf(productValues.get(i)));
                   importSum.add(0d);
                   continue;
               }

               List<String> borderingStateShortName = fullStateNameToBorderingStateMap.get(fullStateName);

               double borderingProductValueSum = 0d;
               for(String shortName : borderingStateShortName){

                   String fullBorderingStateName = stateShortNameToFullNameMap.get(shortName);
                   List<Integer> borderingStateProductValues = stateNameToProductValuesMap.get(fullBorderingStateName);

                   if (!CollectionUtils.isEmpty(borderingStateProductValues)){
                       borderingProductValueSum += borderingStateProductValues.get(i) * 0.1;
                   }

               }

               finalProductValues.add(borderingProductValueSum);
               importSum.add(borderingProductValueSum);
           }

           finalStateProductionValues.put(fullStateName, finalProductValues);
            importFromOtherStateSum.put(fullStateName, importSum);
        }

        writeResult(finalStateProductionValues, filePathPrefix + outputFileName);
        writeResult(importFromOtherStateSum, filePathPrefix + "importSum.xlsx");
    }

    static private void writeResult(Map<String, List<Double>> finalStateNameToProductValiuesMap, String fileName){

        XSSFWorkbook  wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("sheet1");
        Row firstRow = sheet.createRow(0);
        firstRow.createCell(0);
        firstRow.createCell(1).setCellValue("meat");
        firstRow.createCell(2).setCellValue("poultry");
        firstRow.createCell(3).setCellValue("fish");
        firstRow.createCell(4).setCellValue("milk");
        firstRow.createCell(5).setCellValue("produce");

        int rowIndex = 1;
        for(Map.Entry<String, List<Double>> entry : finalStateNameToProductValiuesMap.entrySet()){

            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(entry.getKey());

            int cellIndex = 1;
            for(Double value : entry.getValue()){
                row.createCell(cellIndex++).setCellValue(value);
            }
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            wb.write(os);
        } catch (IOException e){
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        File file = new File(fileName);//Excel文件生成后存储的位置。
        OutputStream fos  = null;
        try
        {
            fos = new FileOutputStream(file);
            wb.write(fos);
            os.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static private Workbook readXlsxFile(String fileName){

        try{
            InputStream inputStream = new FileInputStream(fileName);
            return WorkbookFactory.create(inputStream);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    static private Map<String, List<Integer>> getStateNameToProductionListMap(Workbook productValue){

        Map<String, List<Integer>> stateNameToProductionListMap = Maps.newHashMap();

        if (productValue == null){
            return stateNameToProductionListMap;
        }

        Sheet sheet = productValue.getSheetAt(0);
        int maxRows = sheet.getPhysicalNumberOfRows();

        for(int i = 1; i<maxRows; i++){

            Row row = sheet.getRow(i);
            String stateName = row.getCell(0).getStringCellValue().toLowerCase();

            List<Integer> production = Lists.newArrayList();
            for(int productionIndex = 2; productionIndex <= 6; productionIndex++){
                Cell cell = row.getCell(productionIndex);
                production.add(
                        (int)Math.ceil(cell.getNumericCellValue())
                );
            }

            stateNameToProductionListMap.put(stateName, production);
        }

        return stateNameToProductionListMap;
    }

    static private Map<String, List<String>> getBorderingStateMap(Workbook stateBordering){

        Map<String, List<String>> fullStateNameToBorderingStateMap = Maps.newHashMap();

        if (stateBordering == null){
            return fullStateNameToBorderingStateMap;
        }

        Sheet sheet = stateBordering.getSheetAt(0);

        for(int i = 0; i<sheet.getPhysicalNumberOfRows(); i++){

            Row row = sheet.getRow(i);

            String fullStateName = row.getCell(1).getStringCellValue().toLowerCase();
            List<String> borderingState = Lists.newArrayList();

            for(int j=2; j<row.getLastCellNum(); j++){
                borderingState.add(row.getCell(j).getStringCellValue());
            }

            fullStateNameToBorderingStateMap.put(fullStateName, borderingState);
        }

        return fullStateNameToBorderingStateMap;
    }

    private static Map<String, String> getStateShortNameToFullNameMap(Workbook state){

        Map<String, String> shortNameToFullNameMap = Maps.newHashMap();

        if (state == null){
            return shortNameToFullNameMap;
        }

        Sheet sheet = state.getSheetAt(0);

        for(int i = 0; i<sheet.getPhysicalNumberOfRows(); i++){

           Row row = sheet.getRow(i);

           shortNameToFullNameMap.put(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue().toLowerCase()
           );
        }

        return shortNameToFullNameMap;
    }

}
