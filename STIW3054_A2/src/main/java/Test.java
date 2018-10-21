import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, DocumentException {
        Excel excel = new Excel();
        ConvertPDF convertPDF = new ConvertPDF();

        excel.readExcel();
        excel.printArrayList();
        convertPDF.exportPDF(excel.getTextArrayList1(), excel.getTextArrayList2(), excel.getChessArrayList());
    }
}
