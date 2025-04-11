package system_design.low_level_design.design_patterns.proxy_design_pattern;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        //creates a new row
        System.out.println("created new row in employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        //delete a row
        System.out.println("deleted row with employeeID:"+employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("fetching data from the DB");
        return new EmployeeDo();
    }
}
