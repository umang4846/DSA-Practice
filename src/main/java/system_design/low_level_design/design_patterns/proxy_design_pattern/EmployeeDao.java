package system_design.low_level_design.design_patterns.proxy_design_pattern;

public interface EmployeeDao {
    public void create(String client, EmployeeDo obj) throws Exception;
    public void delete(String client, int employeeId) throws Exception;
    public EmployeeDo get(String client, int employeeId) throws Exception;
}
