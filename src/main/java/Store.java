import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Store {
    public List<String> employeesNames = new LinkedList<String>();
    public List<String> employeesIds = new LinkedList<>();
    public List<String> employeesAddresses = new ArrayList<>();
    public List<String> employeesphones = new LinkedList<>();
    public String nombre;
    public List<Products> productsList;

    public Store(List<String> employeesNames, List<String> employeesIds, List<String> employeesAddresses, List<String> employeesphones, String nombre, List<Products> productsList) {
        this.employeesNames = employeesNames;
        this.employeesIds = employeesIds;
        this.employeesAddresses = employeesAddresses;
        this.employeesphones = employeesphones;
        this.nombre = nombre;
        this.productsList = productsList;
    }

    public void openStore(){
        System.out.println("Store is open");
    }

    public void sell(Products product, client client){
        double price = 0;
        for (int i=0; i<productsList.size(); i++){
            if(product.equals(productsList.get(i))){
                price = productsList.get(i).getPrice();
                client.budget = client.budget - price;
                client.itemsPurchased.add(productsList.get(i).removeItem());

            }
        }
        if (price==0){
            System.out.println("That product isn't exists on this store");
        }
    }

    public void closeStore(){
        System.out.println("Closing store");
    }

}

class Products{
    public String name;
    public String price;
    public String quantity;
    public Queue<Item> items;

    public Products(String name, String price, String quantity, Queue<Item> items) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.items = items;
    }

    public double getPrice(){
        return Double.valueOf(this.price);
    }

    public Item removeItem (){
        this.quantity = Integer.toString(Integer.valueOf(this.quantity)-1);
        return items.poll();
    }

    public void addItems(List<Item> items_to_add){
        this.items.addAll(items_to_add);
    }

    @Override
    public String toString() {
        return String.format("\n Name: %s\n Price: %s \n Quantity: %s", this.name, this.price, this.quantity);
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        return (this.toString().equalsIgnoreCase(other.toString()));
    }
}
