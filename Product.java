/**
   * Represents a Product
   */
public class Product extends Record {

	/**
	   * Name of the Product
	   */
    private String name;
    /**
	   * Cost of the Product
	   */
    private Double cost;
    /**
	   * Owner of the Product
	   */
    private User owner;
    
    /**
	   * Initialize the variables
	   * @param id Record ID of the Product
	   * @param name Name of the Product
	   * @param owner Owner of the Product
	   * @param cost Cost of the Product
	   */
    public Product(Integer id, String name, User owner, Double cost) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.cost = cost;
    }
    /**
	   * Retrieve the name of the Product
	   * @return name - Name of the Product
	   */
    public String getName() {
        return this.name;
    }
    
    /**
	   * Retrieve the cost of the Product
	   * @return cost - Cost of the Product
	   */
    public Double getCost() {
        return this.cost;
    }
    
    /**
	   * Retrieve the owner of the Product.
	   * @return owner - Owner of the Product
	   */
    public User getOwner() {
        return this.owner;
    }
    
    /**
	   * Change the ownership of the Product.
	   * Set the owner of the Product to the given new owner.
	   * @param newOwner The new owner of the Product
	   */
    public void changeOwner(User newOwner) {
        this.owner = newOwner;
    }

}
