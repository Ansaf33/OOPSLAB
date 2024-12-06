import java.util.ArrayList;

class Q1{

  public static void main(String[] args) {
    MessController controller = new MessController();
    MenuItem item_1 = new MenuItem("Vegetable Burger",30);
    MenuItem item_2 = new MenuItem("Aloo Paratha",65.5);
    MealPLAN vegPlan = new MealPLAN("Vegetarian Plan",130);

    MenuItem choco = new MenuItem("Chocolate Donut",40);
    MenuItem brownie = new MenuItem("Choco Covered Brownie",55);
    MenuItem cheesecake = new MenuItem("Stawberry Cheesecake",70);
    MealPLAN dessertPlan = new MealPLAN("Dessert Plan",500);

    vegPlan.addMenuItem(item_1);
    vegPlan.addMenuItem(item_2);
    dessertPlan.addMenuItem(choco);
    dessertPlan.addMenuItem(brownie);
    dessertPlan.addMenuItem(cheesecake);

    controller.addMealPLAN(vegPlan);
    controller.addMealPLAN(dessertPlan);

    StudentImpl s1 = new StudentImpl("Ansaf","S001");
    controller.subscribeStudentToMealPlan(s1, vegPlan);
    controller.subscribeStudentToMealPlan(s1, dessertPlan);

    controller.printSubscriptionStatus(s1);

    

    
    

  }

}

// PERSON INTERFACE

interface Person{
  public String getName();
  public String getID();

}

// STUDENT INTERFACE

interface Student{
  public ArrayList<MealPLAN> getSubscribedMealPlans();
  public void subscribeMealPlan(MealPLAN plan);
  public void unsubscribeMealPlan(MealPLAN plan);
}

// MEALPLAN INTERFACE

interface MealPlann{
  public String getPlanName();
  public ArrayList<MenuItem> getMenuItems();
  public double getPrice();
}

// MENUITEM CLASS

class MenuItem{
  String itemName;
  double price;

  public MenuItem(String itemName, double price) {
    this.itemName = itemName;
    this.price = price;
  }

  public String getItemName() {
    System.out.print(itemName);
    return itemName;
  }

  public double getPrice() {
    System.out.println(price);
    return price;
  }

  
}

// MEALPLAN CLASS -> MEALPLAN INTERFACE

class MealPLAN implements MealPlann{
  String planName;
  ArrayList<MenuItem>menuItems = new ArrayList<>();
  double price;

  // INTERFACE METHODS

  MealPLAN(String planName, double price) {
    this.planName = planName;
    this.price = price;
  }

  @Override
  public String getPlanName() {
    System.out.println(planName);
    return planName;
  }

  @Override
  public ArrayList<MenuItem> getMenuItems() {
    menuItems.forEach(item->{
      System.out.println(item);
    });
    return menuItems;
  }

  @Override
  public double getPrice() {
    System.out.println(price);
    return price;
  }

  // CLASS METHODS

  public void addMenuItem(MenuItem item){
    menuItems.add(item);
  }

  public void displayDetails(){
    System.out.print("Plan Name : ");
    this.getPlanName();
    System.out.println("ITEMS");
    
    menuItems.forEach(item->{
      item.getItemName();
      System.out.print(" --- ");
      item.getPrice();
    });
  }


}

// CLASS STUDENTIMPL -> STUDENT AND PERSON

class StudentImpl implements Student,Person{
  String name;
  String id;
  ArrayList<MealPLAN>subscribedMealPlans = new ArrayList<>();

  

  public StudentImpl(String name, String id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public String getName() {
    System.out.println(this.name);
    return this.name;
  }

  @Override
  public String getID() {
    System.out.println(this.id);
    return this.id;
  }

  @Override
  public ArrayList<MealPLAN> getSubscribedMealPlans() {
    subscribedMealPlans.forEach(plan->{
      System.out.println("----------");
      plan.displayDetails();
      System.out.println("----------");


    });
    return subscribedMealPlans;
  }

  @Override
  public void subscribeMealPlan(MealPLAN plan) {

    // CHECK IF YOU ALREADY SUBSCRIBED TO THE PLAN
    subscribedMealPlans.forEach(Plan->{
      if(Plan == plan){
        System.out.println("You are already subscribed to this plan.");
        return;
      }
    });
    // IF NOT
    subscribedMealPlans.add(plan);
    System.out.println("Student is now subscribed to a meal plan!");
  }

  @Override
  public void unsubscribeMealPlan(MealPLAN plan) {
    // CHECK IF MEALPLAN IS PRESENT IN THE LIST
    subscribedMealPlans.forEach(Plan->{
      if(Plan == plan){
        subscribedMealPlans.remove(plan);
        System.out.println("This Plan has been removed from your list.");
        return;
      }
    });
    System.out.println("It appears you are not currently subscribed to the meal plan.");

  }

}

// MESS CONTROLLER CLASS

class MessController{
  ArrayList<MealPLAN>availablePlans = new ArrayList<>();

  void addMealPLAN(MealPLAN plan){
    // CHECK IF THE MEALPLAN IS ALREADY PRESENT IN THE LIST
    availablePlans.forEach(Plan->{
      if(Plan == plan){
        System.out.println("Meal Plan is already added to the list of available plans. Choose another Meal Plan to add.");
        return;
      }
    });

    // IF NOT PRESENT, ADD IT
    availablePlans.add(plan);
    System.out.println("Meal Plan has been added. Here are the details of the added mealplan.");
    plan.displayDetails();

  }

  void subscribeStudentToMealPlan(StudentImpl s,MealPLAN m){
    s.subscribeMealPlan(m);
  }

  void unsubscribeStudentToMealPlan(StudentImpl s,MealPLAN m){
    s.unsubscribeMealPlan(m);
  }

  void printSubscriptionStatus(Student s){
    System.out.println("The Student is subscribed to the following meal plans : ");
    s.getSubscribedMealPlans();
  }

}