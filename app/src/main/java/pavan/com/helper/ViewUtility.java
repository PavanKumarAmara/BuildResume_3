package pavan.com.helper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pavan.com.buildresume.R;
import pavan.com.pavan.com.model.Achievements;
import pavan.com.pavan.com.model.EducationDetails;

/**
 * Created by Hitesh_A on 6/24/2017.
 */

public class ViewUtility {
    public static EditText generateEditText(Context context,String hint,int textSize){
        EditText editText=new EditText(context);
        editText.setHint(hint);
        editText.setTextSize(textSize);
        return editText;
    }
    public static TextView generateTextView(Context context, String text, int textSize){
        TextView textView=new TextView(context);
        textView.setText(text);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(textSize);
        return textView;
    }
    public static Achievements generateEditTextWithCancelView(Context context, String hint, int textSize/*, Achievements achievements*/){
        Achievements achievements=new Achievements();
        RelativeLayout relativeLayout=new RelativeLayout(context);
        EditText editText=generateEditText( context, hint, textSize);
        editText.setGravity(RelativeLayout.ALIGN_RIGHT);
        relativeLayout.addView(editText);
        TextView removeTextView=generateTextView(context,"X",textSize);
        removeTextView.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        removeTextView.setLayoutParams(params);
        relativeLayout.addView(removeTextView);

        achievements.setAchievementId(achievements.getAchievementId()+1);
        achievements.setAchievementEditText(editText);
        achievements.setRemoveAchievementsTextView(removeTextView);
        achievements.setAchievementRelativeLayout(relativeLayout);
        return achievements;
    }
    public static EducationDetails generateEducationLinearLayout(Context context){
        EducationDetails educationDetails=new EducationDetails();
        LinearLayout educationLinearLayout=new LinearLayout(context);
        educationLinearLayout.setOrientation(LinearLayout.VERTICAL);
//        educationDetails.setEducationTextView(generateTextView(context,"+Add Education Details",PDFHelper.paragraphTextSize));
        educationDetails.setDegreeEditText(generateEditText(context,"Enter your degree like B-tech,ECE",PDFHelper.paragraphTextSize));
        educationDetails.setInstituteEditText(generateEditText(context,"Enter your Institute name",PDFHelper.paragraphTextSize));
        educationDetails.setDurationEditText(generateEditText(context,"Enter duration like,2012-2016",PDFHelper.paragraphTextSize));
        educationDetails.setPercentageEditText(generateEditText(context,"Enter your percentage/CGPA",PDFHelper.paragraphTextSize));
       educationDetails.setRemoveEducationTextView(generateTextView(context,"X  Remove this education level",PDFHelper.paragraphTextSize));
        educationLinearLayout.addView(educationDetails.getRemoveEducationTextView());
        educationLinearLayout.addView(educationDetails.getDegreeEditText());
        educationLinearLayout.addView(educationDetails.getInstituteEditText());
        educationLinearLayout.addView(educationDetails.getDurationEditText());
        educationLinearLayout.addView(educationDetails.getPercentageEditText());
        educationDetails.setEducationDetailsLinearLayout(educationLinearLayout);
        return educationDetails;
    }
}
