import java.util.HashMap;

public class FlipBidDriver {

    private HashMap<Integer, Auction> auctionById;
    private HashMap<Integer, Buyer> buyerList;
    private HashMap<Integer, Seller> sellerList;

    public FlipBidDriver() {
        this.auctionById = new HashMap<>();
        this.buyerList = new HashMap<>();
        this.sellerList = new HashMap<>();
    }

    public Auction getAuctionById(int auctionId) {
        if(auctionById.containsKey(auctionId)) {
            return auctionById.get(auctionId);
        }
        else{
            System.out.println("Invalid auction id/ auction not created");
            return null;
        }
    }

    public Auction createAuction(int auctionId, int lowestBidLimit, int highestBidLimit,
                                 int participationCost, int sellerId) {

        if(sellerList.containsKey(sellerId)) {
            Seller seller = sellerList.get(sellerId);

            Auction auction = new Auction(auctionId, lowestBidLimit, highestBidLimit,
                    participationCost, seller);
            auctionById.put(auctionId, auction);
            return auction;
        }
        else{
            return null;
        }
    }

    public void createBid(int auctionId, int buyerId, int amount) {

        if(buyerList.containsKey(buyerId)) {
            Buyer buyer = buyerList.get(buyerId);
            if(auctionById.containsKey(auctionId)) {
                Auction auction = auctionById.get(auctionId);
                auction.createBid(buyer, amount);
            }
            else{
                System.out.println("Invalid auction id/ auction not created");
            }
        }
        else {
            System.out.println("No buyer registered with that id");
        }

    }

    public void addBuyer(int buyerId, String name) {

        Buyer buyer = new Buyer();
        buyer.setName(name);

        buyerList.put(buyerId, buyer);
    }

    public void addSeller(int sellerId, String sellerName) {

        Seller seller = new Seller();
        seller.setName(sellerName);

        sellerList.put(sellerId, seller);
    }

    public void withdrawBid(int buyerId, int auctionId) {
        if(buyerList.containsKey(buyerId)) {
            if(auctionById.containsKey(auctionId)) {
                Buyer buyer = buyerList.get(buyerId);
                Auction auction = auctionById.get(auctionId);

                auction.withdrawBid(buyer);
            }
            else{
                System.out.println("Invalid auction id/ auction not created");
            }
        }
        else {
            System.out.println("No buyer registered with this id");
        }
    }

    public String closeAuction(int auctionId) {

        if(auctionById.containsKey(auctionId)) {
            Auction auction = auctionById.get(auctionId);
            return auction.getWinner();
        }
        else{
            System.out.println("Invalid auction id/ auction not created");
            return null;
        }
    }
}
