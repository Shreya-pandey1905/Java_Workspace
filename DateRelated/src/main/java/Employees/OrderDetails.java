

public record OrderDetails(int orderId, String CustomerName, double  amount, String status) {

//    public OrderDetails(int orderId,String CustomerName, double amount, String status){
//        this.orderId= orderId;
//        this.CustomerName= CustomerName;
//        this.amount= amount*0.2;
//        this.status= status;

//    public OrderDetails {
//        if(orderId<=0){
//            throw new  IllegalArgumentException();
//        }
//        if (amount>=300){
//            amount= amount*100;
//        }
//    }

    public boolean highamount(){
        if (amount>100){
            System.out.println(true);
        }
        return false;
    }

    public static void highAmount2(){
        System.out.println("Hello Jake");
    }
}

        //Cannonical Constructor
        // Every record has a constructor containing all the field and we can override it

        //Compact Constructors:
        //Instead of repeating the params we can only apply the logic inside constructor
static void main() {
OrderDetails od = new OrderDetails(1,"jakke",200,"PLACED");
    System.out.println(od);
    od.highamount();

    OrderDetails.highAmount2();

}

