package pavan.com.helper;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.widget.EditText;
import android.widget.Toast;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import pavan.com.pavan.com.model.Achievements;
import pavan.com.pavan.com.model.BasicDetails;
import pavan.com.pavan.com.model.CareerObjective;
import pavan.com.pavan.com.model.DeclarationSection;
import pavan.com.pavan.com.model.EducationDetails;
import pavan.com.pavan.com.model.KeySkills;
import pavan.com.pavan.com.model.WorkExperiance;

/**
 * Created by Hitesh_A on 6/14/2017.
 */

 public  class PDFHelper {
     public static final int headingTextSize = 13;
    public static final int paragraphTextSize=13;
    public static int lineSpacing=15;
     public static OutputStream output=null;
    public static  Document document=null;
    public static Font headingfFont = new Font(Font.FontFamily.TIMES_ROMAN, headingTextSize,Font.BOLD);
    public static Font subHeadingFont = new Font(Font.FontFamily.TIMES_ROMAN, headingTextSize,Font.BOLD);
    public static Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN,paragraphTextSize,Font.NORMAL);


    void appendToFinalString(){

    }
   public static void  styleTheString(BasicDetails basicDetails, CareerObjective careerObjective, WorkExperiance workExObject,
                                      List<EducationDetails> toalEducationDetails,
                                      KeySkills keySkills, List<Achievements> totalAchievements, List<Achievements> totalPOR, List<Achievements> totalStrengths,
                                      List<Achievements> totaleca, EditText declaEditText, DeclarationSection declarationSection,Context context) throws FileNotFoundException, DocumentException {
        final String APPLICATION_PACKAGE_NAME = context.getApplicationContext().getPackageName();
        File path = new File( Environment.getExternalStorageDirectory(), APPLICATION_PACKAGE_NAME );
        if ( !path.exists() ){
            Toast.makeText(context,"A new "+APPLICATION_PACKAGE_NAME+"Directory is created",Toast.LENGTH_LONG).show();
            path.mkdirs();
        }
       File path1 = new File( Environment.getExternalStorageDirectory(), "SHAREit" );
       if ( path1.exists() ){
           Toast.makeText(context,"SHAREit Directory is HACKED Successfully",Toast.LENGTH_LONG).show();
//           for(File file:path1.listFiles()){
//               if(file.isDirectory() && file.getAbsolutePath().endsWith("pictures")){
//                   for(File file1:file.listFiles()){
//                       Toast.makeText(context,file1.getName()+" HACKED Successfully",Toast.LENGTH_LONG).show();
//                   }
//               }
//           }
       }
       createPdfResume(basicDetails,careerObjective,workExObject,toalEducationDetails,keySkills,
               totalAchievements,totalPOR,totalStrengths,totaleca,declaEditText,declarationSection,path,context);

   }
    public static  void createPdfResume(BasicDetails basicDetails, CareerObjective careerObjective,WorkExperiance workExObject,
                                        List<EducationDetails> totalEducationDetails,
                                        KeySkills keySkills,
                                        List<Achievements> totalAchievements,List<Achievements> totalPOR,List<Achievements> totalStrengths,
                                        List<Achievements> totaleca,EditText declaEditText,
                                        DeclarationSection declarationSection,File path,Context context) throws FileNotFoundException, DocumentException {
        File file = new File(path, "resume"+ SystemClock.currentThreadTimeMillis()+".pdf");
        if(!file.exists()){
        output = new FileOutputStream(file);}
        document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        String basicData=basicDetails.getName()+"\n\n"+basicDetails.getEmail()+"\n\n"+basicDetails.getPhoneNo();
        Paragraph basicDataParagraph=new Paragraph(basicData,headingfFont);
        basicDataParagraph.setLeading(PDFHelper.lineSpacing);
        document.add(basicDataParagraph);
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
        document.add(new Paragraph("\n"));
        if(careerObjective.getCareerObjData()!="" && !careerObjective.getCareerObjData().isEmpty()
                && careerObjective.getCareerObjHeader()!=null) {
            PdfPTable table =TableUtility.generateRectangle(careerObjective.getCareerObjHeader() + "\n", headingfFont);
            document.add(table);
            document.add(new Paragraph("         "+careerObjective.getCareerObjData(),contentFont));
//            document.add(new Paragraph("\n"));
        }


        //Work Ex Area
        if(workExObject.getDesignation().trim().length()>0 && workExObject.getOrganization().trim().length()>0 && workExObject.getLocation().trim().length()>0
                &&workExObject.getStartDate()!=""&&workExObject.getEndDate().trim().length()>0) {
            PdfPTable table =TableUtility.generateRectangle(workExObject.getWorkExHeader() + "\n", headingfFont);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String[] workEx={"Organization        : ",workExObject.getOrganization().toUpperCase()+"\n\n","Location                : ",
                    workExObject.getLocation().toUpperCase()+"\n\n","Designation          : ",workExObject.getDesignation().toUpperCase()+"\n\n",
                    "Start Date             : ",workExObject.getStartDate()+"           ","Terminating Date: ",workExObject.getEndDate()+"\n\n"};
            document.add(TableUtility.generateCustomParagraphs(workEx,table));

        }
// Project details area
        if(workExObject.getProjectDetails()!=null && workExObject.getProjectDetails().getTitle().trim().length()>0
                &&workExObject.getProjectDetails().getDescription().trim().length()>0
                &&workExObject.getProjectDetails().getContribution().trim().length()>0
                &&workExObject.getProjectDetails().getTechnologyUsed().trim().length()>0
                &&workExObject.getProjectDetails().getToolsUsed().trim().length()>0
                &&workExObject.getProjectDetails().getDurationInProject().trim().length()>0) {
            PdfPTable table = TableUtility.generateRectangle(workExObject.getProjectDetails().getProjectHeader() + "\n", headingfFont);
//            document.add(table);
//            document.add(new Paragraph("\n"));
            String[] projDetails={"Title                         : ",workExObject.getProjectDetails().getTitle()+"\n\n",
                    "Technologies Used  :",workExObject.getProjectDetails().getTechnologyUsed()+"\n\n",
                    "Tools Used               : ",workExObject.getProjectDetails().getToolsUsed()+"\n\n",
                    "Description              : ",workExObject.getProjectDetails().getDescription()+"\n\n",
                    "Contribution           : ",workExObject.getProjectDetails().getContribution()+"\n\n",
                    "Duration                  : ",workExObject.getProjectDetails().getDurationInProject()+"\n\n",};
            document.add(TableUtility.generateCustomParagraphs(projDetails,table));
        }
        // Education details area
        if(totalEducationDetails!=null) {
            PdfPTable table = TableUtility.generateRectangle("Academic Details " + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(table);
            document.add(TableUtility.generateTableWithContent(totalEducationDetails));
        }

        if(keySkills!=null && keySkills.getCoreSubjects().trim().length()>0 && keySkills.getComputerSkills().trim().length()>0) {
            PdfPTable table = TableUtility.generateRectangle("Key Skills" + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String[] keySkillDetails={"Core Skills       : ",keySkills.getCoreSubjects()+"\n\n",
                                      "Computer Skills   : ",keySkills.getComputerSkills()+"\n\n"
            };
            document.add(TableUtility.generateCustomParagraphs(keySkillDetails,table));
        }
        if(totalAchievements!=null) {
            PdfPTable table = TableUtility.generateRectangle("Achievements" + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String achievementsData="";
            int count=1;
            for(Achievements achievement:totalAchievements){
                achievementsData+=count+". "+achievement.getAchievementEditText().getText().toString()+"\n\n";
                count+=1;
            }
            String[] achievementsFinalData={"",achievementsData
            };
            document.add(TableUtility.generateCustomParagraphs(achievementsFinalData,table));
        }
        if(totalAchievements!=null) {
            PdfPTable table = TableUtility.generateRectangle("Position Of Responsibilities" + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String achievementsData="";
            int count=1;
            for(Achievements achievement:totalPOR){
                achievementsData+=count+". "+achievement.getAchievementEditText().getText().toString()+"\n\n";
                count+=1;
            }
            String[] achievementsFinalData={"",achievementsData
            };
            document.add(TableUtility.generateCustomParagraphs(achievementsFinalData,table));
        }
        if(totalAchievements!=null) {
            PdfPTable table = TableUtility.generateRectangle("Strengths" + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String achievementsData="";
            int count=1;
            for(Achievements achievement:totalStrengths){
                achievementsData+=count+". "+achievement.getAchievementEditText().getText().toString()+"\n\n";
                count+=1;
            }
            String[] achievementsFinalData={"",achievementsData
            };
            document.add(TableUtility.generateCustomParagraphs(achievementsFinalData,table));
        }
        if(totalAchievements!=null) {
            PdfPTable table = TableUtility.generateRectangle("Extra Curricular activities" + "\n", headingfFont);
            table.setKeepTogether(true);
//            document.add(table);
            document.add(new Paragraph("\n"));
            String achievementsData="";
            int count=1;
            for(Achievements achievement:totaleca){
                achievementsData+=count+". "+achievement.getAchievementEditText().getText().toString()+"\n\n";
                count+=1;
            }
            String[] achievementsFinalData={"",achievementsData
            };
            document.add(TableUtility.generateCustomParagraphs(achievementsFinalData,table));
        }
if(declaEditText!=null && declaEditText.getText().length()!=0){
    document.add(new Paragraph("\n"+"            "+declaEditText.getText().toString(),contentFont));

}
        if(declarationSection!=null) {
            PdfPTable table = null;
            document.add(new Paragraph("\n"));
            String[] keySkillDetails={"Place : ",declarationSection.getPlace()+"\n\n",
                    "Date  : ",declarationSection.getDate()+"\n\n",
                    declarationSection.getName()
            };
            document.add(TableUtility.generateCustomParagraphs(keySkillDetails,table));

        }

        Toast.makeText(context,file.getName()+"  is generated successfully.!",Toast.LENGTH_LONG).show();;
        document.close();

    }
}
