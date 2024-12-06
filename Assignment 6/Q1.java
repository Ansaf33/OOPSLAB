import java.util.ArrayList;


class Q1{

    public static void main(String[] args) {
        // SINGLE PRICE AND QUANTITY
        ArrayList<Item>allItems = new ArrayList<>();

        // SINGLE TOTAL COST
        Item first = new Item("Phone",2300,2);
        Item second = new Item("Ring",6500,2);
        Item third = new Item("Doormat",32,150);

        allItems.add(first);
        allItems.add(second);
        allItems.add(third);

        System.out.println();

        pricecalc c = new pricecalc();

        System.out.println(c.totalPrice(first));

        System.out.println(c.totalPrice(allItems));

        System.out.println(c.totalPrice(first,90));

    

        
    }


}

class Item{
    String name;
    int price;
    int quantity;

    Item(String name,int price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}

class pricecalc{

    

    double totalPrice(Item i){
        return i.price*i.quantity;
    }

    double totalPrice(ArrayList<Item>ar){
        double fin = 0;
        for(int i=0;i<ar.size();i++){
            fin+=ar.get(i).price*ar.get(i).quantity;
        }
        return fin;
    }

    double totalPrice(Item i,double discount){
        return (((100-discount)/100)*i.price)*i.quantity;
    }
}


