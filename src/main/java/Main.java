import com.github.javafaker.Faker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static Faker faker = new Faker();
    public static void main(String args[]){
        List<String> employeesNames = new LinkedList<String>();
        List<String> employeesIds = new LinkedList<>();
        List<String> employeesAddresses = new ArrayList<>();
        List<String> employeesphones = new LinkedList<>();
        List<Products> productsList = new ArrayList<>();
        Queue<Item> vanillaCookie_items = new LinkedList<Item>();
        Queue<Item> chocolateCookie_items = new LinkedList<Item>();
        Queue<Item> lactoseFreeMilk_items = new LinkedList<Item>();
        Queue<Item> NormalMilk_items = new LinkedList<Item>();

        employeesNames.add(generateName());
        employeesNames.add(generateName());
        employeesNames.add(generateName());
        employeesNames.add(generateName());
        employeesNames.add(generateName());

        employeesIds.add(generateId());
        employeesIds.add(generateId());
        employeesIds.add(generateId());
        employeesIds.add(generateId());
        employeesIds.add(generateId());

    employeesAddresses.add(generateAddress());
    employeesAddresses.add(generateAddress());
    employeesAddresses.add(generateAddress());
    employeesAddresses.add(generateAddress());
    employeesAddresses.add(generateAddress());

        employeesphones.add(generatePhone());
        employeesphones.add(generatePhone());
        employeesphones.add(generatePhone());
        employeesphones.add(generatePhone());
        employeesphones.add(generatePhone());

        Products vanillaCookie = new Cookie ("vanilla cookie", "1.5", "24", vanillaCookie_items);
        vanillaCookie.addItems(generateItemsList(24));

        Products ChocolateCookie = new Cookie ("chocolate cookie", "2.0", "17", chocolateCookie_items);
        ChocolateCookie.addItems(generateItemsList(17));

        Products VanillaMilk = new Milk ("vanilla milk", "3.6", "22", lactoseFreeMilk_items);
        VanillaMilk.addItems(generateItemsList(22));

        Products chocolateMilk = new Milk ("chocolate milk", "3.1", "54", NormalMilk_items);
        chocolateMilk.addItems(generateItemsList(54));

        productsList.add(vanillaCookie);
        productsList.add(ChocolateCookie);
        productsList.add(VanillaMilk);
        productsList.add(chocolateMilk);
        Store store = new Store(employeesNames,employeesIds,employeesAddresses,employeesphones,"tiendita", productsList);

        store.openStore();
        List<client> clients = new ArrayList<>();
        clients.add(new client(generateName(), generateId(), generateAddress(), 13.5, BigInteger.valueOf(23), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 10.8, BigInteger.valueOf(31), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 9.1, BigInteger.valueOf(19), generatePhone(), new ArrayList<>()));
            clients.add(new client(generateName(), generateId(), generateAddress(), 27.8, BigInteger.valueOf(25), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 5.0, BigInteger.valueOf(37), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 14.6, BigInteger.valueOf(47), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 11.2, BigInteger.valueOf(81), generatePhone(), new ArrayList<>()));
    clients.add(new client(generateName(), generateId(), generateAddress(), 10.1, BigInteger.valueOf(42), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 13.0, BigInteger.valueOf(19), generatePhone(), new ArrayList<>()));
        clients.add(new client(generateName(), generateId(), generateAddress(), 43.2, BigInteger.valueOf(33), generatePhone(), new ArrayList<>()));

       store.sell(vanillaCookie,clients.get(0));
        store.sell(vanillaCookie,clients.get(0));
        store.sell(vanillaCookie,clients.get(4));
        store.sell(ChocolateCookie,clients.get(4));
        store.sell(vanillaCookie,clients.get(7));
           store.sell(vanillaCookie,clients.get(7));
        store.sell(vanillaCookie,clients.get(7));
        store.sell(vanillaCookie,clients.get(3));
        store.sell(chocolateMilk,clients.get(9));
        store.sell(ChocolateCookie,clients.get(9));
        store.sell(ChocolateCookie,clients.get(9));
   store.sell(ChocolateCookie,clients.get(1));

        store.closeStore();

    }

    public static String generateName(){
        return faker.harryPotter().character();
    }

    public static String generateAddress(){
        return faker.address().fullAddress();
    }

    public static String generatePhone(){
        return faker.phoneNumber().cellPhone();
    }

    public static String generateId(){
        return faker.number().digits(9);
    }

    public static List<Item> generateItemsList(int size){
        List<Item> items = new LinkedList<Item>();
        for (int i=0;i<size;i++){
            Item item = new Item(faker.number().numberBetween(0,1000000));
        while (isItemInList(item, items)){
                item = new Item(faker.number().numberBetween(0,1000000)); }
            items.add(item);
        }
        return items;
    }

    public static boolean isItemInList(Item expectedItem, List<Item> lista){
        for(Item item: lista){
            if (expectedItem.id==item.id){
                return true;
            }
        }
        return false;
    }

}
