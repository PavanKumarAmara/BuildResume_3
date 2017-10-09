package pavan.com.buildresume;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import pavan.com.helper.DataHelper;
import pavan.com.helper.PDFHelper;
import pavan.com.helper.ValidateInput;
import pavan.com.helper.ViewUtility;
import pavan.com.pavan.com.model.Achievements;
import pavan.com.pavan.com.model.BasicDetails;
import pavan.com.pavan.com.model.CareerObjective;
import pavan.com.pavan.com.model.DeclarationSection;
import pavan.com.pavan.com.model.EducationDetails;
import pavan.com.pavan.com.model.KeySkills;
import pavan.com.pavan.com.model.PositionOfResponsibilities;
import pavan.com.pavan.com.model.ProjectDetails;
import pavan.com.pavan.com.model.WorkExperiance;

public class Resume extends AppCompatActivity {
    EditText nameEditTextView=null;
    EditText mailEditTextView=null;
    EditText phoneEditTextView=null;
    TextView careertextView=null;
    TextView educationTextView=null;
    EditText careerEditText=null;
    TextView addAchievementsTextView=null;
    TextView workExperianceTextView=null;
    EditText workExEditTextOraganization=null;
    EditText workExEditTextLocation=null;
    EditText workExEditTextDesignation=null;
    EditText workExEditTextStartDate=null;
    EditText workExEditTextEndDate=null;
    LinearLayout workExLinearlayout=null;
    LinearLayout careerLinearLayout=null;
    LinearLayout projectLinearLayout=null;
    LinearLayout educationLinearLayout=null;
    LinearLayout interEducationLinearLayout=null;
    LinearLayout sscEducationLinearLayout=null;
    LinearLayout achievementsLinearLayout=null;
    LinearLayout strengthsLinearLayout=null;
    LinearLayout ecaLinearLayout=null;
    LinearLayout posLinearLayout=null;
    TextView addPosTextView=null;
    TextView strengthsTextView=null;
    TextView ecaTextView=null;
    TextView projectDetailsTextView=null;
    EditText projectTitle=null;
    EditText projectTechnologyUsed=null;
    EditText projectToolsUsed=null;
    EditText projectDescription=null;
    EditText projectContribution=null;
    EditText projectDurationInProject=null;
    ProjectDetails projectDetails=new ProjectDetails();
    BasicDetails basicDetails=new BasicDetails();
    CareerObjective careerObjective=new CareerObjective();
    WorkExperiance workExObject=new WorkExperiance();
    EducationDetails educationDetails=new EducationDetails();
    EducationDetails interEducationDetails=new EducationDetails();
    EducationDetails sscEducationDetails=new EducationDetails();
    KeySkills keySkills=new KeySkills();
    List<Achievements> totalAchievements=null;
    List<Achievements> totalPOR=null;
    List<Achievements> totalstrengths=null;
    List<Achievements> totaleca=null;
    TextView declarationTextView=null;
    LinearLayout declarationLineaLayout=null;
    EditText declarationEditText=null;
    int declarationCount=1;
    List<EducationDetails> totalEducations=null;
    DeclarationSection declarationSection=new DeclarationSection();
    Context currentContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        currentContext=this;
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linearLayout);


        nameEditTextView= ViewUtility.generateEditText(this,"Enter your Name",PDFHelper.paragraphTextSize);
        mailEditTextView=  ViewUtility.generateEditText(this,"Enter your mail id",PDFHelper.paragraphTextSize);
        mailEditTextView.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        phoneEditTextView=  ViewUtility.generateEditText(this,"Enter Mobile no",PDFHelper.paragraphTextSize);
        phoneEditTextView.setInputType(InputType.TYPE_CLASS_PHONE);
        linearLayout.addView(nameEditTextView);
        linearLayout.addView(mailEditTextView);
        linearLayout.addView(phoneEditTextView);
        careerLinearLayout=new LinearLayout(this);
        careerLinearLayout.setOrientation(LinearLayout.VERTICAL);
        careertextView=ViewUtility.generateTextView(this,"+ Add Carrer Objective",PDFHelper.paragraphTextSize);
        careerLinearLayout.addView(careertextView);
        linearLayout.addView(careerLinearLayout);
        careertextView.setOnClickListener(getCareerTextView);
        careerEditText=ViewUtility.generateEditText(this,"Enter your Career Objective",PDFHelper.paragraphTextSize);
        //Add layout for work Experiance
        workExLinearlayout=new LinearLayout(this);
        workExLinearlayout.setOrientation(LinearLayout.VERTICAL);
        workExperianceTextView=ViewUtility.generateTextView(this,"+ Add Work Experiance",PDFHelper.paragraphTextSize);
        workExperianceTextView.setOnClickListener(getWorkExTextView);
        workExLinearlayout.addView(workExperianceTextView);
        linearLayout.addView(workExLinearlayout);

        //setting view for Work eX Edit text
        workExEditTextOraganization= ViewUtility.generateEditText(this,"Enter your Organization Name",PDFHelper.paragraphTextSize);
        workExEditTextLocation=ViewUtility.generateEditText(this,"Enter your Location Name",PDFHelper.paragraphTextSize);
        workExEditTextStartDate=ViewUtility.generateEditText(this,"Enter your Start Date",PDFHelper.paragraphTextSize);
        workExEditTextStartDate.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
        workExEditTextEndDate=ViewUtility.generateEditText(this,"Enter your End Date/Currently Working",PDFHelper.paragraphTextSize);
        workExEditTextDesignation=ViewUtility.generateEditText(this,"Enter your Designation",PDFHelper.paragraphTextSize);

        //Setting project details
        projectLinearLayout =new LinearLayout(this);
        projectLinearLayout.setOrientation(LinearLayout.VERTICAL);
        projectDetailsTextView=ViewUtility.generateTextView(this,"+ Add Project Details",PDFHelper.paragraphTextSize);
        projectDetailsTextView.setOnClickListener(getCareerTextView);
        projectLinearLayout.addView(projectDetailsTextView);
        linearLayout.addView(projectLinearLayout);
        projectTitle=ViewUtility.generateEditText(this,"Enter your Project Title",PDFHelper.paragraphTextSize);
        projectTechnologyUsed=ViewUtility.generateEditText(this,"Enter Technologies Used",PDFHelper.paragraphTextSize);
        projectToolsUsed=ViewUtility.generateEditText(this,"Enter Tools Used",PDFHelper.paragraphTextSize);
        projectDescription=ViewUtility.generateEditText(this,"Enter Project Description",PDFHelper.paragraphTextSize);
        projectContribution=ViewUtility.generateEditText(this,"Enter your Contribution",PDFHelper.paragraphTextSize);
        projectDurationInProject=ViewUtility.generateEditText(this,"Enter your Duration In Project",PDFHelper.paragraphTextSize);
   //Adding education details
        educationLinearLayout=new LinearLayout(this);
        educationTextView=ViewUtility.generateTextView(this,"+ Add Education Details",PDFHelper.paragraphTextSize);
        educationTextView.setOnClickListener(getCareerTextView);
        educationLinearLayout.addView(educationTextView);
        educationLinearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(educationLinearLayout);

        keySkills.setKeySkillsLinearLayout(new LinearLayout(this));
        keySkills.getKeySkillsLinearLayout().setOrientation(LinearLayout.VERTICAL);
        keySkills.setKeySkillsTextView(ViewUtility.generateTextView(this,"+ Add Key Skills",PDFHelper.paragraphTextSize));
        keySkills.getKeySkillsTextView().setOnClickListener(getCareerTextView);
        keySkills.setCoreSubjectsEditText(ViewUtility.generateEditText(this,"Enter your core subjects",PDFHelper.paragraphTextSize));
        keySkills.setComputerSkillsEditText(ViewUtility.generateEditText(this,"Enter your computer skills",PDFHelper.paragraphTextSize));
        keySkills.getKeySkillsLinearLayout().addView(keySkills.getKeySkillsTextView());
        linearLayout.addView(keySkills.getKeySkillsLinearLayout());
        achievementsLinearLayout=new LinearLayout(this);
        addAchievementsTextView=ViewUtility.generateTextView(this,"+ Add Achievements",PDFHelper.paragraphTextSize);
        addAchievementsTextView.setOnClickListener(getCareerTextView);
        achievementsLinearLayout.addView(addAchievementsTextView);
        achievementsLinearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(achievementsLinearLayout);
       //Position of responsibilities section
        posLinearLayout=new LinearLayout(this);
        addPosTextView=ViewUtility.generateTextView(this,"+ Add Position Of Responsibilities",PDFHelper.paragraphTextSize);
        addPosTextView.setOnClickListener(getCareerTextView);
        posLinearLayout.addView(addPosTextView);
        posLinearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(posLinearLayout);
        //Strengths Section
        strengthsLinearLayout=new LinearLayout(this);
        strengthsTextView=ViewUtility.generateTextView(this,"+ Add Strengths",PDFHelper.paragraphTextSize);
        strengthsTextView.setOnClickListener(getCareerTextView);
        strengthsLinearLayout.addView(strengthsTextView);
        strengthsLinearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(strengthsLinearLayout);
        //Extra Curricular Activities Section
        ecaLinearLayout=new LinearLayout(this);
        ecaTextView=ViewUtility.generateTextView(this,"+ Add Extra Curricular Activities",PDFHelper.paragraphTextSize);
        ecaTextView.setOnClickListener(getCareerTextView);
        ecaLinearLayout.addView(ecaTextView);
        ecaLinearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(ecaLinearLayout);
        //Declaration section
        declarationLineaLayout=new LinearLayout(this);
        declarationLineaLayout.setOrientation(LinearLayout.VERTICAL);
        declarationTextView=ViewUtility.generateTextView(this,"+Add Declaration Statement",PDFHelper.paragraphTextSize);
        declarationTextView.setOnClickListener(getCareerTextView);
        declarationSection.setDeclarationLinearLayout(new LinearLayout(this));
        declarationSection.getDeclarationLinearLayout().setOrientation(LinearLayout.VERTICAL);
        declarationSection.setNameTextView(ViewUtility.generateEditText(this,"",PDFHelper.paragraphTextSize));
        declarationSection.setDateEditText(ViewUtility.generateEditText(this,"Enter Date",PDFHelper.paragraphTextSize));
        declarationSection.setPlaceEditText(ViewUtility.generateEditText(this,"Enter Place",PDFHelper.paragraphTextSize));
        declarationSection.getDeclarationLinearLayout().addView(declarationSection.getPlaceEditText());
        declarationSection.getDeclarationLinearLayout().addView(declarationSection.getDateEditText());
        declarationSection.getDeclarationLinearLayout().addView(declarationSection.getNameTextView());

        declarationLineaLayout.addView(declarationTextView);
//        declarationLineaLayout.addView(declarationSection.getDeclarationLinearLayout());
        linearLayout.addView(declarationLineaLayout);
        declarationEditText=ViewUtility.generateEditText(this,"Enter Declaration Statement",PDFHelper.paragraphTextSize);
        //Final Declaration

    }


   View.OnClickListener getCareerTextView= new View.OnClickListener() {
       @Override
       public void onClick(View v) {
            if(v==careertextView){
                careerObjective.setCareerEditTextCount( careerObjective.getCareerEditTextCount()+1);
                if( careerObjective.getCareerEditTextCount()%2==0) {
                    careertextView.setText("- Remove Career Objective");
                    careerLinearLayout.addView(careerEditText);
                }
                else{
                    careertextView.setText("+ Add Career Objective");
                    careerEditText.setText("");
                    careerLinearLayout.removeView(careerEditText);
                }
            }
            else if(v==projectDetailsTextView){
                projectDetails.setProjectDetailsCount(projectDetails.getProjectDetailsCount()+1);
                if(projectDetails.getProjectDetailsCount()%2==0) {
                    projectDetailsTextView.setText("- Remove Project Details");
                    projectLinearLayout.addView(projectTitle);
                    projectLinearLayout.addView(projectTechnologyUsed);
                    projectLinearLayout.addView(projectToolsUsed);
                    projectLinearLayout.addView(projectDescription);
                    projectLinearLayout.addView(projectContribution);
                    projectLinearLayout.addView(projectDurationInProject);
                }
                else{
                    projectDetailsTextView.setText("+ Add Project Details");
                    projectTitle.setText("");
                    projectTechnologyUsed.setText("");
                    projectToolsUsed.setText("");
                    projectDescription.setText("");
                    projectContribution.setText("");
                    projectDurationInProject.setText("");
                    projectLinearLayout.removeView(projectTitle);
                    projectLinearLayout.removeView(projectTechnologyUsed);
                    projectLinearLayout.removeView(projectToolsUsed);
                    projectLinearLayout.removeView(projectDescription);
                    projectLinearLayout.removeView(projectContribution);
                    projectLinearLayout.removeView(projectDurationInProject);
                }
            }
            else if(v==educationTextView){
                EducationDetails educationDetails=ViewUtility.generateEducationLinearLayout(currentContext);
                educationDetails.getRemoveEducationTextView().setOnClickListener(removeEditTextOnClickListener);
                educationLinearLayout.addView(educationDetails.getEducationDetailsLinearLayout());
                if(totalEducations==null){
                    totalEducations=new ArrayList<EducationDetails>();
                }
                totalEducations.add(educationDetails);
            }

            else if(v==declarationTextView){
                declarationCount+=1;
                if(declarationCount%2==0) {
                    declarationTextView.setText("- Remove Declaration");
                    declarationLineaLayout.addView(declarationEditText);
                    declarationLineaLayout.addView(declarationSection.getDeclarationLinearLayout());
                }
                else{
                    declarationTextView.setText("+ Add Declaration");
                    declarationEditText.setText("");
                    declarationLineaLayout.removeView(declarationEditText);
                    declarationLineaLayout.removeView(declarationSection.getDeclarationLinearLayout());
                }
            }

            else if(v==keySkills.getKeySkillsTextView()){
                keySkills.setKeySkillsCount(keySkills.getKeySkillsCount()+1);
                if(keySkills.getKeySkillsCount()%2==0) {
                    keySkills.getKeySkillsTextView().setText("- Remove KeySkills");
                    keySkills.getKeySkillsLinearLayout().addView(keySkills.getCoreSubjectsEditText());
                    keySkills.getKeySkillsLinearLayout().addView(keySkills.getComputerSkillsEditText());
                }
                else{
                    keySkills.getKeySkillsTextView().setText("+ Add Key Skills");
                    keySkills.getCoreSubjectsEditText().setText("");
                    keySkills.getComputerSkillsEditText().setText("");
                    keySkills.getKeySkillsLinearLayout().removeView(keySkills.getCoreSubjectsEditText());
                    keySkills.getKeySkillsLinearLayout().removeView(keySkills.getComputerSkillsEditText());
                }
            }
            else if(v==addAchievementsTextView){
                Achievements achievements=ViewUtility.generateEditTextWithCancelView
                        (currentContext,"Enter Achievements",PDFHelper.paragraphTextSize);
                achievements.getRemoveAchievementsTextView().setOnClickListener(removeEditTextOnClickListener);
                achievementsLinearLayout.addView(achievements
                        .getAchievementRelativeLayout());
                if(totalAchievements==null){
                    totalAchievements=new ArrayList<Achievements>();
                }
                totalAchievements.add(achievements);
            }
            else if(v==addPosTextView){
                Achievements positionOfResponsibilities=ViewUtility.generateEditTextWithCancelView
                        (currentContext,"Enter positionOfResponsibilities",PDFHelper.paragraphTextSize);
                positionOfResponsibilities.getRemoveAchievementsTextView().setOnClickListener(removeEditTextOnClickListener);
                posLinearLayout.addView(positionOfResponsibilities
                        .getAchievementRelativeLayout());
                if(totalPOR==null){
                    totalPOR=new ArrayList<Achievements>();
                }
                totalPOR.add(positionOfResponsibilities);
            }
            else if(v==strengthsTextView){
                Achievements strengths=ViewUtility.generateEditTextWithCancelView
                        (currentContext,"Enter Strengths",PDFHelper.paragraphTextSize);
                strengths.getRemoveAchievementsTextView().setOnClickListener(removeEditTextOnClickListener);
                strengthsLinearLayout.addView(strengths
                        .getAchievementRelativeLayout());
                if(totalstrengths==null){
                    totalstrengths=new ArrayList<Achievements>();
                }
                totalstrengths.add(strengths);
            }
            else if(v==ecaTextView){
                Achievements eca=ViewUtility.generateEditTextWithCancelView
                        (currentContext,"Enter Extra Curricular Activities",PDFHelper.paragraphTextSize);
                eca.getRemoveAchievementsTextView().setOnClickListener(removeEditTextOnClickListener);
                ecaLinearLayout.addView(eca
                        .getAchievementRelativeLayout());
                if(totaleca==null){
                    totaleca=new ArrayList<Achievements>();
                }
                totaleca.add(eca);
            }
       }

   };
    View.OnClickListener getWorkExTextView= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v==workExperianceTextView){
                workExObject.setWorkExEditTextCount( workExObject.getWorkExEditTextCount()+1);
                if( workExObject.getWorkExEditTextCount()%2==0) {
                    workExperianceTextView.setText("- Remove Work Experience");
                    workExLinearlayout.addView(workExEditTextOraganization);
                    workExLinearlayout.addView(workExEditTextLocation);
                    workExLinearlayout.addView(workExEditTextDesignation);
                    workExLinearlayout.addView(workExEditTextStartDate);
                    workExLinearlayout.addView(workExEditTextEndDate);

                }
                else{
                    workExperianceTextView.setText("+Add Work Experience");
                    workExEditTextOraganization.setText("");
                    workExEditTextLocation.setText("");
                    workExEditTextDesignation.setText("");
                    workExEditTextStartDate.setText("");
                    workExEditTextEndDate.setText("");
                    workExLinearlayout.removeView(workExEditTextOraganization);
                    workExLinearlayout.removeView(workExEditTextLocation);
                    workExLinearlayout.removeView(workExEditTextDesignation);
                    workExLinearlayout.removeView(workExEditTextStartDate);
                    workExLinearlayout.removeView(workExEditTextEndDate);

                }


            }
        }

    };
    View.OnClickListener removeEditTextOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(totalAchievements!=null) {
                for (Achievements achievements:totalAchievements) {
                    if(v==achievements.getRemoveAchievementsTextView()){
                        achievementsLinearLayout.removeView(achievements.getAchievementRelativeLayout());
                    }
                }
            }
            if(totalPOR!=null){
                for (Achievements positionOfResponsibilities:totalPOR) {
                    if(v==positionOfResponsibilities.getRemoveAchievementsTextView()){
                        posLinearLayout.removeView(positionOfResponsibilities.getAchievementRelativeLayout());
                    }
                }
            }
            if(totalstrengths!=null) {
                for (Achievements strength:totalstrengths) {
                    if(v==strength.getRemoveAchievementsTextView()){
                        strengthsLinearLayout.removeView(strength.getAchievementRelativeLayout());
                    }
                }
            }
            if(totaleca!=null) {
                for (Achievements eca:totaleca) {
                    if(v==eca.getRemoveAchievementsTextView()){
                        ecaLinearLayout.removeView(eca.getAchievementRelativeLayout());
                    }
                }
            }
            if(totalEducations!=null) {
                for (EducationDetails eduDetails:totalEducations) {
                    if(v==eduDetails.getRemoveEducationTextView()){
                        educationLinearLayout.removeView(eduDetails.getEducationDetailsLinearLayout());
                    }
                }
            }

        }
    };

    void createResume(View view) throws FileNotFoundException, DocumentException {
        basicDetails.setName(nameEditTextView.getText().toString());
        basicDetails.setEmail(mailEditTextView.getText().toString());
        basicDetails.setPhoneNo(phoneEditTextView.getText().toString());
        if(ValidateInput.validateInputData(basicDetails,this)) {
            careerObjective.setCareerObjHeader("Career Objective");
            careerObjective.setCareerObjData(careerEditText.getText().toString());
            workExObject.setWorkExHeader("Work Experience");
            workExObject.setOrganization(workExEditTextOraganization.getText().toString());
            workExObject.setLocation(workExEditTextLocation.getText().toString());
            workExObject.setDesignation(workExEditTextDesignation.getText().toString());
            workExObject.setStartDate(workExEditTextStartDate.getText().toString());
            workExObject.setEndDate(workExEditTextEndDate.getText().toString());
            projectDetails.setProjectHeader("Project Details");
            projectDetails.setTitle(projectTitle.getText().toString());
            projectDetails.setTechnologyUsed(projectTechnologyUsed.getText().toString());
            projectDetails.setToolsUsed(projectToolsUsed.getText().toString());
            projectDetails.setContribution(projectContribution.getText().toString());
            projectDetails.setDescription(projectDescription.getText().toString());
            projectDetails.setDurationInProject(projectDurationInProject.getText().toString());
            workExObject.setProjectDetails(projectDetails);
            keySkills.setCoreSubjects(keySkills.getCoreSubjectsEditText().getText().toString());
            keySkills.setComputerSkills(keySkills.getComputerSkillsEditText().getText().toString());
            declarationSection.setName(declarationSection.getNameTextView().getText().toString());
            declarationSection.setPlace(declarationSection.getPlaceEditText().getText().toString());
            declarationSection.setDate(declarationSection.getDateEditText().getText().toString());
            PDFHelper.styleTheString(basicDetails, careerObjective, workExObject, DataHelper.setEducationDataToObject(totalEducations), keySkills,totalAchievements,totalPOR,totalstrengths,totaleca,declarationEditText
                    ,declarationSection, this);
        }
    }
}
