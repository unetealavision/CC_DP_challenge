import java.math.BigInteger;
import java.util.List;

public class client {
    public String name;
    public String id;
    public String address;
    public double budget;
    public BigInteger age;
    public String phone;
    public List<Item> itemsPurchased;

    public client(String name, String id, String address, double budget, BigInteger age, String phone, List<Item> itemsPurchased) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.budget = budget;
        this.age = age;
        this.phone = phone;
        this.itemsPurchased = itemsPurchased;
    }

    public void buy(){
    }
}
