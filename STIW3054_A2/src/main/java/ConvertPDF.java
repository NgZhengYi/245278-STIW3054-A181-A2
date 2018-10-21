import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConvertPDF {

    public void exportPDF(final ArrayList<String> textArrayList1, final ArrayList<String> textArrayList2,
                          final ArrayList<Chess> chessArrayList) throws IOException, DocumentException {
        // create output PDF document page A4 size
        Document documentPDF = new Document(PageSize.A4);
        PdfWriter.getInstance(documentPDF, new FileOutputStream("Chess.pdf"));
        documentPDF.open();

        Font font = FontFactory.getFont(FontFactory.TIMES, 12, Font.BOLD, BaseColor.BLUE);

        Paragraph paragraph;
        for (String text : textArrayList1) {
            paragraph = new Paragraph(new Phrase(text, font));
            //paragraph1.add(text + "\n");
            //paragraph1.setAlignment(Element.ALIGN_CENTER);
            documentPDF.add(paragraph);
        }
        // Print Paragraph 1

        documentPDF.add(Chunk.SPACETABBING); // Make some spacing

        // Set Table Width Relative
        PdfPTable pdfPTable = new PdfPTable(new float[] {10, 45, 10, 10, 5, 20});
        pdfPTable.setWidthPercentage(100); // Default use 80%
        pdfPTable.getDefaultCell().setUseAscender(true);

        Iterator<Chess> chessIterator = chessArrayList.iterator();
        while (chessIterator.hasNext()) {
            Chess chess = chessIterator.next();
            //System.out.printf("%-3s %-60s %-6s %-5s %-2s %-25s %n",chess.getNo(),chess.getName(),chess.getFidelID(),
            //        chess.getFED(), chess.getRtg(), chess.getClub());
            pdfPTable.addCell(chess.getNo());
            pdfPTable.addCell(chess.getName());
            pdfPTable.addCell(chess.getFidelID());
            pdfPTable.addCell(chess.getFED());
            pdfPTable.addCell(chess.getRtg());
            pdfPTable.addCell(chess.getClub());
        }
        // Print Table
        documentPDF.add(pdfPTable);

        documentPDF.add(Chunk.SPACETABBING); // Make some spacing

        Paragraph paragraph2 = new Paragraph();
        for (String text : textArrayList2) {
            paragraph2.add(text + "\n");
            //paragraph2.setAlignment(Element.ALIGN_CENTER);
        }
        // Print Paragraph 2
        documentPDF.add(paragraph2);

        documentPDF.close();
        System.out.println("Successfully Converted to Pdf File");
    }
}
