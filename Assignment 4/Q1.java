import java.util.ArrayList;

class Q1{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        @SuppressWarnings({ "rawtypes" })
        Inventory <Product> inv = new Inventory();
        // adding Product
        Product p1 = new Product("Toilet Paper");
        Electronics e1 = new Electronics("Washing Machine",10);
        Clothing c1 = new Clothing("D&G",39);

        inv.addProduct(p1);
        inv.addProduct(e1);
        inv.addProduct(c1);

        inv.listProducts();

        inv.removeProduct(p1);
        System.out.println("Removed product.");

        inv.listProducts();

        


 
    }
}

/*
 *     Create a simple inventory management system using generics and inheritance. You need to implement a generic class Inventory<T> where T is a subtype of a base class Product. The Inventory class should manage a collection of products and provide the following functionalities:

        addProduct(T product): Adds a product to the inventory.

        removeProduct(T product): Removes a product from the inventory.

        listProducts(): Lists all products in the inventory.   \

Create a base class Product with a name property, and two subclasses Electronics and Clothing, where Electronics has an additional warrantyPeriod property, and Clothing has an additional size property.
 */


 class Inventory<T>{
    ArrayList<T>allProducts = new ArrayList<>();

    

    void addProduct(T product){
        allProducts.add(product);
    }

    void removeProduct(T product){
        allProducts.remove(product);
    }

    void listProducts(){
        allProducts.forEach(product->{
            System.out.println(product.toString());
        });
    }

 }



 class Product{
    String name;

    Product(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override 
    public String toString(){
        return this.name;
    }

 }

 class Electronics extends Product{
    int warrantyPeriod;

    Electronics(String name,int warrantyPeriod){
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }

 }

 class Clothing extends Product{
    int size;
    
    Clothing(String name,int size){
        super(name);
        this.size = size;
    }
 }
