import java.util.*;

public class Auction {

    private Seller seller;
    private int lowestBidLimit;
    private int highestBidLimit;
    private int participationCost;
    private int auctionId;
    private HashMap<Buyer, Integer> bidList;
    List<Integer> bids;

    public Seller getSeller() {
        return seller;
    }

    public int getLowestBidLimit() {
        return lowestBidLimit;
    }

    public int getHighestBidLimit() {
        return highestBidLimit;
    }

    public int getParticipationCost() {
        return participationCost;
    }

    public int getAuctionId() {
        return auctionId;
    }




    public Auction(int auctionId, int lowestBidLimit, int highestBidLimit,
                   int participationCost, Seller seller) {

        this.auctionId = auctionId;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        bidList = new HashMap<>();
        bids = new ArrayList<>();
    }

    public void createBid(Buyer buyer, int amount) {
        bidList.put(buyer, amount);
        bids.add(amount);
    }

    public void withdrawBid(Buyer buyer) {
        bidList.remove(buyer);
    }

    public String getWinner() {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (Integer num : bids) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Integer maxUniqueValue = null;

        for (Integer num : bids) {
            if (countMap.get(num) == 1) {
                if (maxUniqueValue == null || num > maxUniqueValue) {
                    maxUniqueValue = num;
                }
            }
        }

        if(maxUniqueValue == null) {
            System.out.println("No winner");
            return null;
        }
        else{
            for (Map.Entry<Buyer,Integer> mapElement : bidList.entrySet()) {
                if(mapElement.getValue() == maxUniqueValue) {
                    return mapElement.getKey().getName();
                }
            }
        }
        return null;
    }
}
