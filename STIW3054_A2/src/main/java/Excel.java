import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Excel {
    private final String path = "D:/IntelliJ IDEA Projects/STIW3054_A2/chessResultsList.xlsx";
    private ArrayList<Chess> chessArrayList = new ArrayList<Chess>();
    private ArrayList<String> textArrayList1 = new ArrayList<String>();
    private ArrayList<String> textArrayList2 = new ArrayList<String>();

    /**
     *  Read Data in a Excel File
     */
    public void readExcel() throws IOException {
        // Read the Excel file in binary format into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        // Read workbook into XSSFWorkbook
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        // Read worksheet into XSSFSheet
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        // To iterate over the rows
        Iterator<Row> rowIterator = xssfSheet.iterator();
        String test_no, test_name, test_fidelID, test_FED, test_Rtg, test_Club;
        // Format String and Numberic to String
        DataFormatter dataFormatter = new DataFormatter();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

                if(row.getRowNum() < 4 ) {
                    textArrayList1.add(row.getCell(0).toString());
                    //System.out.println(row.getCell(0));
                } else if (row.getRowNum() > 154) {
                    textArrayList2.add(row.getCell(0).toString());
                    //System.out.println(row.getCell(0));
                } else {
                    test_no = dataFormatter.formatCellValue(row.getCell(0));
                    test_name = row.getCell(2).toString();
                    test_fidelID = row.getCell(3).toString();
                    test_FED = row.getCell(4).toString();
                    test_Rtg = dataFormatter.formatCellValue(row.getCell(5));
                    test_Club = row.getCell(6).toString();
                    chessArrayList.add(new Chess(test_no, test_name, test_fidelID, test_FED, test_Rtg, test_Club));
                    //System.out.printf("%-3s %-60s %-6s %-5s %-2s %-25s %n",test_no, test_name, test_fidelID,
                    //        test_FED, test_Rtg, test_Club);
            }
        }
    }

    public void printArrayList() {
        for (String text : textArrayList1) {
            System.out.println(text);
        }

        for (Chess chess : chessArrayList) {
            System.out.printf("%-3s %-60s %-6s %-5s %-2s %-25s %n",chess.getNo(),chess.getName(),chess.getFidelID(),
                    chess.getFED(), chess.getRtg(), chess.getClub());
        }

        for (String text : textArrayList2) {
            System.out.println(text);
        }
    }

    public ArrayList<Chess> getChessArrayList() {
        return chessArrayList;
    }

    public ArrayList<String> getTextArrayList1() {
        return textArrayList1;
    }

    public ArrayList<String> getTextArrayList2() {
        return textArrayList2;
    }

}
