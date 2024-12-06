package Q10.department;

import Q10.company.*;


class Office{
  protected String location;
  protected int floors;
  
  public String getLocation() {
    return location;
  }
  public int getFloors() {
    return floors;
  }

  public static void main(String[] args) {
    employee e = new employee("Ansaf Hassan");
    //System.out.println(e.name);
    /*
     e.name cannot access the name field of the employee class as it is protected.
     */
    System.out.println(e.getName());
    // MODIFYING NAME FIELD
    e.setName("Ansaf Hassan Muhamed");
    System.out.println("New name : " + e.getName());
  }

  



}