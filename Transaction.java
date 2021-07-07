/**
   * Represents a Transaction between Users
   */
public class Transaction extends Record {
	
	/**
	   * User who is buying the product
	   */
    private User buyer;
    /**
	   * User who is selling the Product
	   */
    private User seller;
    /**
	   * The product that is being sold by the buyer and bought by the seller
	   */
    private Product product;
    
    /**
	   * Initialize the variables
	   * @param id Record ID of the Transaction
	   * @param buyer User who is buying the product
	   * @param seller User who is selling the product
	   * @param product The product that is being sold by the buyer and bought by the seller
	   */
    public Transaction(Integer id, User buyer, User seller, Product product) {
        super(id);
        this.buyer = buyer;
        this.seller = seller;
        this.product=product;
    }
    
    /**
	   * Retrieve the buyer in the Transaction
	   * @return buyer - The buyer in the Transaction
	   */
    public User getBuyer() {
        return buyer;
    }
    
    /**
	   * Retrieve the seller in the Transaction
	   * @return seller - The seller in the Transaction
	   */
    public User getSeller() {
        return seller;
    }
    
    /**
	   * Retrieve the cost of the product in the Transaction
	   * @return The cost of the product
	   */
    public Double getCost() {
        return product.getCost();
    }
}
