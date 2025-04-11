package system_design.low_level_design.design_patterns.Adapter_2.Client;


import system_design.low_level_design.design_patterns.Adapter_2.Adaptee.WeightMachineForBabies;
import system_design.low_level_design.design_patterns.Adapter_2.Adapter.WeightMachineAdapter;
import system_design.low_level_design.design_patterns.Adapter_2.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
