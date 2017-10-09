package pavan.com.pavan.com.model;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Hitesh_A on 6/25/2017.
 */

public class KeySkills {
    public String coreSubjects;
    public String computerSkills;
    public LinearLayout keySkillsLinearLayout;
    public TextView keySkillsTextView;
    public EditText coreSubjectsEditText;
    public EditText computerSkillsEditText;
    public int keySkillsCount=1;

    public LinearLayout getKeySkillsLinearLayout() {
        return keySkillsLinearLayout;
    }

    public void setKeySkillsLinearLayout(LinearLayout keySkillsLinearLayout) {
        this.keySkillsLinearLayout = keySkillsLinearLayout;
    }

    public TextView getKeySkillsTextView() {
        return keySkillsTextView;
    }

    public void setKeySkillsTextView(TextView keySkillsTextView) {
        this.keySkillsTextView = keySkillsTextView;
    }

    public EditText getCoreSubjectsEditText() {
        return coreSubjectsEditText;
    }

    public void setCoreSubjectsEditText(EditText coreSubjectsEditText) {
        this.coreSubjectsEditText = coreSubjectsEditText;
    }

    public EditText getComputerSkillsEditText() {
        return computerSkillsEditText;
    }

    public void setComputerSkillsEditText(EditText computerSkillsEditText) {
        this.computerSkillsEditText = computerSkillsEditText;
    }

    public int getKeySkillsCount() {
        return keySkillsCount;
    }

    public void setKeySkillsCount(int keySkillsCount) {
        this.keySkillsCount = keySkillsCount;
    }

    public String getCoreSubjects() {
        return coreSubjects;
    }

    public void setCoreSubjects(String coreSubjects) {
        this.coreSubjects = coreSubjects;
    }

    public String getComputerSkills() {
        return computerSkills;
    }

    public void setComputerSkills(String computerSkills) {
        this.computerSkills = computerSkills;
    }
}
