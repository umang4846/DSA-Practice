package system_design.low_level_design.java8.stream;

class Project {
    public Project() {
    }

    public Project(String projectCode, String name, String client, String buLeadName) {
        this.projectCode = projectCode;
        this.name = name;
        this.client = client;
        this.buLeadName = buLeadName;
    }

    private String projectCode;
    private String name;
    private String client;
    private String buLeadName;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBuLeadName() {
        return buLeadName;
    }

    public void setBuLeadName(String buLeadName) {
        this.buLeadName = buLeadName;
    }

}