public class Main {
    public static void main(String[] args) throws Exception {


        FlipBidDriver flipBidDriver = new FlipBidDriver();

        flipBidDriver.addSeller(1,"Narendra");

        // auction cant be created before a seller and a buyer;
        Auction auction  = flipBidDriver.createAuction(1, 10, 500, 5, 1);
        if(auction==null) {
            throw new Exception("auction cant be created");
        }

        flipBidDriver.addBuyer(1,"Virat");
        flipBidDriver.addBuyer(2, "Ishant");
        flipBidDriver.addBuyer(3, "Rohit");
        flipBidDriver.addBuyer(4,"Roger");
        flipBidDriver.addBuyer(5, "Irfan");
        flipBidDriver.addBuyer(6, "Zahid");



        // bid cant be made on non existing auctionId;

        flipBidDriver.createBid(1,1, 100);//(auctionId,buyerId, bidAmount)
        flipBidDriver.createBid(1,2, 100);
        flipBidDriver.createBid(1,3, 100);
        flipBidDriver.createBid(1,4, 100);
        flipBidDriver.createBid(1,5, 100);
        flipBidDriver.createBid(1,6, 100);

        String winner = flipBidDriver.closeAuction(1);
        if(winner!=null) {
            System.out.println(winner);
        }

    }
}