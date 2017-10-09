package pavan.com.helper;

import java.util.List;

import pavan.com.pavan.com.model.EducationDetails;

/**
 * Created by Hitesh_A on 6/25/2017.
 */

public class DataHelper {
    public static List<EducationDetails> setEducationDataToObject(List<EducationDetails> totalEducationDetails){
        if(totalEducationDetails!=null){
            for(int i=0;i<totalEducationDetails.size();i++){
                totalEducationDetails.get(i).setDegree(totalEducationDetails.get(i).getDegreeEditText().getText().toString());
                totalEducationDetails.get(i).setInstitute(totalEducationDetails.get(i).getInstituteEditText().getText().toString());
                totalEducationDetails.get(i).setDuration(totalEducationDetails.get(i).getDurationEditText().getText().toString());
                totalEducationDetails.get(i).setPercentage(totalEducationDetails.get(i).getPercentageEditText().getText().toString());
            }
        }

        return totalEducationDetails;
    }
}
