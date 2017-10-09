package pavan.com.pavan.com.model;

/**
 * Created by Hitesh_A on 6/20/2017.
 */

public class WorkExperiance {
    public String getWorkExHeader() {
        return workExHeader;
    }

    public void setWorkExHeader(String workExHeader) {
        this.workExHeader = workExHeader;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String workExHeader;
    public String organization;
    public String designation;
    public String location;
    public String startDate;
    public String endDate;
    public ProjectDetails projectDetails;
    int workExEditTextCount=1;

    public int getWorkExEditTextCount() {
        return workExEditTextCount;
    }

    public void setWorkExEditTextCount(int workExEditTextCount) {
        this.workExEditTextCount = workExEditTextCount;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }
}
