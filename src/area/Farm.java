package area;
import animals.Animal;
import humans.*;
import machines.Machine;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Farm {

    private String farmName;
    private String farmAddres;
    private Border FarmBorder;
    private Double cash;

    private List<Employee>employees=new ArrayList<>(10);

    private List<Bulding>buildings=new ArrayList<>(15);

    private List<Machine>machines=new ArrayList<>(10);

    private List<Animal>animals=new ArrayList<>(15);

    public Farm(String farmName, String farmAddres, Border farmBorder, Double cash) {
        this.farmName = farmName;
        this.farmAddres = farmAddres;
        this.FarmBorder = farmBorder;
        this.cash = cash;
    }

    public Border getFarmBorder() {
        return FarmBorder;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}




