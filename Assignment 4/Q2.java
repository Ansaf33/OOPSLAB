import java.util.ArrayList;

class Q2 {

    public static void main(String[] args) {
        Entity e1 = new Entity("GS");
        Employee emp1 = new Employee("NIT Calicut","HOD","Ansaf");
        Manager m1 = new Manager("GS","Mathew");
        @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
        HeirarchicalManager<Entity>hm = new HeirarchicalManager();

        hm.addEntity(e1);
        hm.addEntity(emp1);
        hm.addEntity(m1);

        System.out.println("Get All Entities : ");
        hm.getAllEntities();

        System.out.println("Print Heirarchy : ");
        hm.printHeirarchy();

        System.out.println("Get entities by type : ");

        hm.getEntitiesbyType(Manager.class);
       
    }
    
}


class HeirarchicalManager<T>{
    ArrayList<T>allEntities = new ArrayList<>();

    void addEntity(T obj){
        allEntities.add(obj);

    }

    void removeEntity(T obj){
        allEntities.remove(obj);
    }

    void getAllEntities(){
     
        allEntities.forEach(entity->{
            System.out.println("----------------------");
            System.out.println("Type = " + entity.getClass().getName());
            System.out.println(entity.toString());
        });

    }

    void printHeirarchy(){
        allEntities.forEach(entity->{
            System.out.println("---------------------");
            System.out.println("Type = " + entity.getClass().getName());
        });
    }

    void getEntitiesbyType(Class <? extends T> type){
        allEntities.forEach(entity->{
            if(type.isInstance(entity) ){
                System.out.println("-----------------------");
                System.out.println(entity.getClass().getName());
            }
            
        });
    }


}

class Entity{
    String eName;

    Entity(String eName){
        this.eName = eName;
    }

    @Override
    public String toString(){
        String a = "Entity Name : " + this.eName;
        return a;

    }

}

class Manager extends Entity{
    String empname;


    Manager(String eName,String empname){
        super(eName);
        this.empname = empname;
    }

    @Override
    public String toString(){
        String a = "Entity Name : " + this.eName;
        String b = "Manager Name : " + this.empname;
        return a + "\n" + b;

    }

}

class Employee extends Manager{
    String name;

    Employee(String eName,String empName,String name){
        super(eName,empName);
        this.name = name;
    }

    @Override
    public String toString(){
        String a = "Entity Name : " + this.eName;
        String b = "Manager Name : " + this.empname;
        String c = "Employee Name : " + this.name;
        return a + "\n" + b + "\n" + c;

    }

}

