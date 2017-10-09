package pavan.com.pavan.com.model;

import android.widget.EditText;

/**
 * Created by Hitesh_A on 6/20/2017.
 */

public class BasicDetails {
    public String Name;
    public String email;
    public String phoneNo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
