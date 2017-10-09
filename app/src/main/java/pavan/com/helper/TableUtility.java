package pavan.com.helper;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.List;

import pavan.com.pavan.com.model.EducationDetails;

/**
 * Created by Hitesh_A on 6/24/2017.
 */

public class TableUtility {
    public static PdfPTable generateRectangle(String contentInCell, Font font){
        PdfPTable table = new PdfPTable(4);
        PdfPCell cell;
        table.setTotalWidth(PageSize.A4.getWidth()-70f);
        table.setLockedWidth(true);
        cell = new PdfPCell(new Phrase(contentInCell, font));
        cell.setColspan(4);
        Float padding = 5f;
        cell.setPadding(padding);
        cell.setPaddingBottom(10f);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        table.setHorizontalAlignment(table.ALIGN_LEFT);
        return table;
    }
    public static Paragraph  generateCustomParagraphs(String[] data,PdfPTable table){
        Paragraph paragraph=new Paragraph();
        paragraph.setLeading(PDFHelper.lineSpacing);
//        paragraph.setIndentationLeft(40);
       if(table!=null){
        paragraph.add(table);
        paragraph.add("\n");}
        for(int i=0;i<data.length;i++){
            if(i%2==0){
                paragraph.add(new Chunk(data[i],PDFHelper.subHeadingFont));
            }
            else {
                paragraph.add(new Chunk(data[i],PDFHelper.contentFont));
            }
        }
        paragraph.setKeepTogether(true);
       return paragraph;
    }
    public static PdfPTable generateTableWithContent(List<EducationDetails> totalEducationDetails) throws DocumentException {
        PdfPTable table=new PdfPTable(5);
        table.setTotalWidth(PageSize.A4.getWidth()-70f);
        table.setLockedWidth(true);
        table.setWidths(new int[]{1, 2, 3,2,1});
        table.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
        table.setSpacingBefore(5);
        table.setSpacingAfter(5);
        PdfPCell sNocell=new PdfPCell(new Phrase("S.NO",PDFHelper.contentFont));
        sNocell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        Float padding = 3f;
        sNocell.setPadding(padding);
        sNocell.setPaddingBottom(6f);
        PdfPCell degreeCell=new PdfPCell(new Phrase("Degree",PDFHelper.contentFont));
        degreeCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell instituteCell=new PdfPCell(new Phrase("Institution",PDFHelper.contentFont));
        instituteCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell durationCell=new PdfPCell(new Phrase("Duration",PDFHelper.contentFont));
        durationCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell percentagecell=new PdfPCell(new Phrase("Percentage/GPA",PDFHelper.contentFont));
        percentagecell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(sNocell);
        table.addCell(degreeCell);
        table.addCell(instituteCell);
        table.addCell(durationCell);
        table.addCell(percentagecell);
        table.getKeepTogether();
        table= appendDataToTable(table,totalEducationDetails) ;
        return table;
    }
    public static PdfPTable appendDataToTable(PdfPTable table, List<EducationDetails> totalEducationDetails){
        int count=1;
        float padding=3f;
        for(EducationDetails educationDetails:totalEducationDetails){
            PdfPCell sNoCell=new PdfPCell( new Phrase(String.valueOf(count),PDFHelper.subHeadingFont));
            PdfPCell degreeCell= new PdfPCell( new Phrase(educationDetails.getDegree(),PDFHelper.subHeadingFont));
            PdfPCell instituteCell= new PdfPCell( new Phrase(educationDetails.getInstitute(),PDFHelper.subHeadingFont));
            PdfPCell durationCell= new PdfPCell( new Phrase(educationDetails.getDuration(),PDFHelper.subHeadingFont));
            PdfPCell percentageCell=new PdfPCell( new Phrase(educationDetails.getPercentage(),PDFHelper.subHeadingFont));
            sNoCell.setPadding(padding);
            sNoCell.setPaddingBottom(6f);
            degreeCell.setPadding(padding);
            degreeCell.setPaddingBottom(6f);
            instituteCell.setPadding(padding);
            instituteCell.setPaddingBottom(6f);
            durationCell.setPadding(padding);
            durationCell.setPaddingBottom(6f);
            percentageCell.setPadding(padding);
            percentageCell.setPaddingBottom(6f);
            table.addCell(sNoCell);
            table.addCell(degreeCell);
            table.addCell(instituteCell);
            table.addCell(durationCell);
            table.addCell(percentageCell);
            count++;
        }
        return table;
    }

}
