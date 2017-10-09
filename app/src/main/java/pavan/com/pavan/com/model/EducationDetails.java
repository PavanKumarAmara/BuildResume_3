package pavan.com.pavan.com.model;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hitesh_A on 6/24/2017.
 */

public class EducationDetails
{
    private TextView educationTextView;
    private String educationHeader;
    private EditText degreeEditText;
    private EditText instituteEditText;
    private EditText starDateEditText;
    private EditText endDateEditText;
    private EditText percentageEditText;
    private String degree;
    private String institute;
    private String starDate;
    private String endDate;
    private String percentage;
    private EditText durationEditText;
    private String duration;
    private TextView removeEducationTextView;
    private LinearLayout educationDetailsLinearLayout;

    public LinearLayout getEducationDetailsLinearLayout() {
        return educationDetailsLinearLayout;
    }

    public void setEducationDetailsLinearLayout(LinearLayout educationDetailsLinearLayout) {
        this.educationDetailsLinearLayout = educationDetailsLinearLayout;
    }

    public TextView getRemoveEducationTextView() {
        return removeEducationTextView;
    }

    public void setRemoveEducationTextView(TextView removeEducationTextView) {
        this.removeEducationTextView = removeEducationTextView;
    }

    int educationDetailsCount=1;

    public EditText getDurationEditText() {
        return durationEditText;
    }

    public void setDurationEditText(EditText durationEditText) {
        this.durationEditText = durationEditText;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getEducationDetailsCount() {
        return educationDetailsCount;
    }

    public void setEducationDetailsCount(int educationDetailsCount) {
        this.educationDetailsCount = educationDetailsCount;
    }

    public TextView getEducationTextView() {
        return educationTextView;
    }

    public void setEducationTextView(TextView educationTextView) {
        this.educationTextView = educationTextView;
    }

    public String getEducationHeader() {
        return educationHeader;
    }

    public void setEducationHeader(String educationHeader) {
        this.educationHeader = educationHeader;
    }

    public EditText getDegreeEditText() {
        return degreeEditText;
    }

    public void setDegreeEditText(EditText degreeEditText) {
        this.degreeEditText = degreeEditText;
    }

    public EditText getInstituteEditText() {
        return instituteEditText;
    }

    public void setInstituteEditText(EditText instituteEditText) {
        this.instituteEditText = instituteEditText;
    }

    public EditText getStarDateEditText() {
        return starDateEditText;
    }

    public void setStarDateEditText(EditText starDateEditText) {
        this.starDateEditText = starDateEditText;
    }

    public EditText getEndDateEditText() {
        return endDateEditText;
    }

    public void setEndDateEditText(EditText endDateEditText) {
        this.endDateEditText = endDateEditText;
    }

    public EditText getPercentageEditText() {
        return percentageEditText;
    }

    public void setPercentageEditText(EditText percentageEditText) {
        this.percentageEditText = percentageEditText;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
