package pavan.com.pavan.com.model;

import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Hitesh_A on 6/26/2017.
 */

public class Achievements {
    public String achievementHeader="Achievements";
    public int achievementId;
    /*public TextView addAchievementsTextView;*/
    public TextView removeAchievementsTextView;
    public EditText achievementEditText;
    public RelativeLayout achievementRelativeLayout;

    public String getAchievementHeader() {
        return achievementHeader;
    }

    public void setAchievementHeader(String achievementHeader) {
        this.achievementHeader = achievementHeader;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

/*    public TextView getAddAchievementsTextView() {
        return addAchievementsTextView;
    }

    public void setAddAchievementsTextView(TextView addAchievementsTextView) {
        this.addAchievementsTextView = addAchievementsTextView;
    }*/

    public TextView getRemoveAchievementsTextView() {
        return removeAchievementsTextView;
    }

    public void setRemoveAchievementsTextView(TextView removeAchievementsTextView) {
        this.removeAchievementsTextView = removeAchievementsTextView;
    }

    public EditText getAchievementEditText() {
        return achievementEditText;
    }

    public void setAchievementEditText(EditText achievementEditText) {
        this.achievementEditText = achievementEditText;
    }

    public RelativeLayout getAchievementRelativeLayout() {
        return achievementRelativeLayout;
    }

    public void setAchievementRelativeLayout(RelativeLayout achievementRelativeLayout) {
        this.achievementRelativeLayout = achievementRelativeLayout;
    }
}
