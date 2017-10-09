package pavan.com.pavan.com.model;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hitesh_A on 6/29/2017.
 */

public class DeclarationSection {
    private String name;
    private String date;
    private String place;
    private LinearLayout declarationLinearLayout;
    private int finaDeclarationCount=1;
    private EditText dateEditText;
    private EditText placeEditText;

    public EditText getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(EditText nameTextView) {
        this.nameTextView = nameTextView;
    }

    public EditText getDateEditText() {
        return dateEditText;
    }

    public void setDateEditText(EditText dateEditText) {
        this.dateEditText = dateEditText;
    }

    public EditText getPlaceEditText() {
        return placeEditText;
    }

    public void setPlaceEditText(EditText placeEditText) {
        this.placeEditText = placeEditText;
    }

    private EditText nameTextView;
    public int getFinaDeclarationCount() {
        return finaDeclarationCount;
    }

    public void setFinaDeclarationCount(int finaDeclarationCount) {
        this.finaDeclarationCount = finaDeclarationCount;
    }

    public LinearLayout getDeclarationLinearLayout() {
        return declarationLinearLayout;
    }

    public void setDeclarationLinearLayout(LinearLayout declarationLinearLayout) {
        this.declarationLinearLayout = declarationLinearLayout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
