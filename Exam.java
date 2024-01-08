class Tshirt { //Creating the class Tshirt
    String name;
    double price;
    String brand;
    int pcode; //this is productcode
    String[] size;
    String detail;
    //Creating constructor
    public Tshirt(String name, int pcode, double price, String brand, String detail, String[] size) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.pcode = pcode;
        this.size = size;
        this.detail = detail;
    }

    //getting and setting name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProductCode() {
        return pcode;
    }
    public void setProductCode(int pcode) {
        this.pcode = pcode;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getDescription() {
        return detail;
    }
    public void setDescription(String detail) {
        this.detail = detail;
    }
    public String[] getAvailableSizes() {
        return size;
    }
    public void setAvailableSizes(String[] size) {
        this.size = size;
    }
//displaying the datas
    public void display() {
        System.out.println("Item name: " + name);
        System.out.println("Product code: " + pcode);
        System.out.println("Sizes: " + java.util.Arrays.toString(size));
        System.out.println("Description: " + detail);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
}
class Order { // Creating Class Order
    String name;
    String pnum; //pnum is phone number
    int[] item;
    double[] prices;
//This is a constructor of class Order
    public Order(String name, String pnum, int[] item, double[] prices) {
        this.name = name;
        this.pnum = pnum;
        this.item = item;
        this.prices = prices;
    }
//getting and setting value
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return pnum;
    }
    public void setPhoneNumber(String pnum) {
        this.pnum = pnum;
    }
    public int[] getItems() {
        return item;
    }
    public void setItems(int[] item) {
        this.item = item;
    }
    public double[] getPrices() {
        return prices;
    }
    public void setPrices(double[] prices) {
        this.prices = prices;
    }
//calculatiing and displaying the price with vat
    public void show() {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        double vat = total * 0.13;
        double tvat = total + vat; //tvat is the price including vat
        System.out.println("Order details:");
        System.out.println("   Name: " + name);
        System.out.println("   Phone number: " + pnum);
        System.out.println("   Items: " + java.util.Arrays.toString(item));
        System.out.println("   Price: " + java.util.Arrays.toString(prices));
        System.out.println("   Total Price: " + total);
        System.out.println("   VAT (13%): " + vat);
        System.out.println("   Total Price with VAT: " + tvat);
    }
}
//linking the Tshirt and Order class with the main class Exam
public class Exam {
    public static void main(String[] args) {
        Tshirt s1 = new Tshirt("Gorkhali Batman", 572, 1235, "Karuna",
                "You either die a hero or live long enough to see yourself be a villain", new String[]{"S", "Medium", "Large"});

        Tshirt s2 = new Tshirt("Gorkhali Batman V2", 456, 1000, "Big Bang Theory",
                "Show your pride with the national flag on your chest!", new String[]{"S", "Medium", "Large"});

        System.out.println("Tshirt 1:");
        s1.display();
        System.out.println("Tshirt 2:");
        s2.display();
        Order o1 = new Order("Gopal Sharma", "0486756465", new int[]{572, 681}, new double[]{1235, 1780});
        o1.show();
    }
}
