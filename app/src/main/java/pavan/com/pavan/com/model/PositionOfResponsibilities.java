package pavan.com.pavan.com.model;

import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Hitesh_A on 6/27/2017.
 */

public class PositionOfResponsibilities extends Achievements{
    public String posHeader="Position Of Responsibilities";
    public TextView removePOSTextView;
    public EditText posEditText;
    public RelativeLayout posRelativeLayout;

    public String getPosHeader() {
        return posHeader;
    }

    public void setPosHeader(String posHeader) {
        this.posHeader = posHeader;
    }

    public TextView getRemovePOSTextView() {
        return removePOSTextView;
    }

    public void setRemovePOSTextView(TextView removePOSTextView) {
        this.removePOSTextView = removePOSTextView;
    }

    public EditText getPosEditText() {
        return posEditText;
    }

    public void setPosEditText(EditText posEditText) {
        this.posEditText = posEditText;
    }

    public RelativeLayout getPosRelativeLayout() {
        return posRelativeLayout;
    }

    public void setPosRelativeLayout(RelativeLayout posRelativeLayout) {
        this.posRelativeLayout = posRelativeLayout;
    }
}
