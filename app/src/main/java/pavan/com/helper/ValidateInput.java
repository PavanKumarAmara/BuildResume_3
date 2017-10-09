package pavan.com.helper;

import android.content.Context;
import android.widget.Toast;

import pavan.com.pavan.com.model.BasicDetails;

/**
 * Created by Hitesh_A on 6/25/2017.
 */

public class ValidateInput {
    public static Boolean validateInputData(Object dataObject,Context context){
        boolean valid=Boolean.FALSE;
        if(dataObject instanceof BasicDetails){
           BasicDetails basicDetails=(BasicDetails) dataObject;
            if(!isEmpty(basicDetails.getName())){
                if(!isEmpty(basicDetails.getEmail())){
                    if(!isEmpty(basicDetails.getPhoneNo()) && basicDetails.getPhoneNo().length()==10) {
                        valid=Boolean.TRUE;
                    }
                    else{
                        Toast.makeText(context, "Please Enter Your Phone No Correctly", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(context,"Please Enter Your Email",Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(context,"Please Enter Your Name",Toast.LENGTH_LONG).show();
            }


        }
        return valid;
    }

    public static boolean isEmpty(String dataString){
        Boolean isEmptyData=Boolean.FALSE;
        if(dataString.isEmpty() || dataString.trim().length()==0){
            isEmptyData =Boolean.TRUE;
        }
        return isEmptyData;
    }
}

