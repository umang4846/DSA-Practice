package system_design.low_level_design.design_patterns.proxy_design_pattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {

        try {
            EmployeeDao empTableObj = new EmployeeDaoProxy();
            empTableObj.create("USER",new EmployeeDo());
            System.out.println("Operation successful");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
