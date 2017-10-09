package pavan.com.pavan.com.model;

/**
 * Created by Hitesh_A on 6/20/2017.
 */

public class CareerObjective {
    public String careerObjHeader;
    public String careerObjData;
    public int careerEditTextCount=1;


    public String getCareerObjHeader() {
        return careerObjHeader;
    }

    public int getCareerEditTextCount() {
        return careerEditTextCount;
    }

    public void setCareerEditTextCount(int careerEditTextCount) {
        this.careerEditTextCount = careerEditTextCount;
    }

    public void setCareerObjHeader(String careerObjHeader) {
        this.careerObjHeader = careerObjHeader;
    }

    public String getCareerObjData() {
        return careerObjData;
    }

    public void setCareerObjData(String careerObjData) {
        this.careerObjData = careerObjData;
    }
}
