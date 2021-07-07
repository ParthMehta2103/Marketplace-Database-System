/**
   * Represents an User
   */
public class User extends Record {
	
	/**
	   * Name of the User
	   */
    private String name;
    /**
     * Current balance of the user
     */
    private Double balance;
    
    /**
     * Initialize the variables
     * @param id Record ID of the User
     * @param name Name of the User
     * @param balance Initial balance
     */
    public User(Integer id, String name, Double balance) {
        super(id);
        this.name = name;
        this.balance = balance;

    }
    
    /**
     * Retrieve the name of the User
     * @return name - Name of the User
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Retrieve the current balance of the User
     * @return balance - Current balance of the User
     */
    public Double getBalance() {
        return this.balance;
    }
    
    /**
     * Update the current balance of the User with the given Balance
     * @param newBalance The new current balance of the user
     */
    public void updateBalance(Double newBalance) {
        this.balance = newBalance;
    }

}
