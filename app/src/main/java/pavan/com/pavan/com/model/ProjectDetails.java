package pavan.com.pavan.com.model;

/**
 * Created by Hitesh_A on 6/22/2017.
 */

public class ProjectDetails {
    public String projectHeader;
    public String title;
    public String technologyUsed;
    public String toolsUsed;
    public String description;
    public String contribution;
    public String durationInProject;
    int projectDetailsCount=1;

    public int getProjectDetailsCount() {
        return projectDetailsCount;
    }

    public void setProjectDetailsCount(int projectDetailsCount) {
        this.projectDetailsCount = projectDetailsCount;
    }

    public String getProjectHeader() {
        return projectHeader;
    }

    public void setProjectHeader(String projectHeader) {
        this.projectHeader = projectHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
    }

    public String getToolsUsed() {
        return toolsUsed;
    }

    public void setToolsUsed(String toolsUsed) {
        this.toolsUsed = toolsUsed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getDurationInProject() {
        return durationInProject;
    }

    public void setDurationInProject(String durationInProject) {
        this.durationInProject = durationInProject;
    }
}
