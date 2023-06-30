package People;

import behaviours.IEarn;

public class StaffMember implements IEarn {


    private String name;

    private String title;
    private double hourlyWage;

    public StaffMember(String name, String title, double hourlyWage){
        this.name = name;
        this.title = title;
        this.hourlyWage = hourlyWage;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }


    @Override
    public double getPaid(int hoursWorked) {
        return (hoursWorked * hourlyWage);
    }
}
