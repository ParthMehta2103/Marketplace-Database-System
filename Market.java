/**
   * Represents the Market
   */
public class Market {
	
	/**
	   * User Database of the Market that contains user records
	   */
	public UserDatabase userDatabase;
	
	/**
	   * Product Database of the Market that contains product records
	   */
	public ProductDatabase productDatabase;
	
	/**
	   * Transaction Database of the Market that contains transaction records
	   */
	public TransactionDatabase transactionDatabase;

	/**
	   * Instantiate userDatabase, productDatabase and transactionDatabase
	   */
	public Market() {
		userDatabase = new UserDatabase();
		productDatabase = new ProductDatabase();
		transactionDatabase = new TransactionDatabase();
	}

	/**
	   * Method to add a User Record to the User Database
	   * @param name Name of new User
	   * @param balance Initial balance of the new User
	   * @return Return True if the User record was successfully added to the User Database, else return False
	   */
	public Boolean addUserRecord(String name, Double balance) {
		User user = new User(userDatabase.getNumRecords(), name, balance);

		return userDatabase.putRecord(user);
	}

	/**
	   * Method to add a Product Record to the Product Database.
	   * Add the product with the given name and cost and ownerId to the Product Database.
	   * @param name Name of the new Product
	   * @param cost Cost of the new Product
	   * @param ownerId Record ID of the Owner of the Product
	   * @return Return True if Product Record was successfully added to the Product Database, else Return False
	   */
	public Boolean addProductRecord(String name, Double cost, Integer ownerId) {

		User owner = (User) userDatabase.getRecord(ownerId);

		Product product = new Product(productDatabase.getNumRecords(), name, owner, cost);

		return productDatabase.putRecord(product);
	}

	/**
	   * Method to remove a Product from a Seller.
	   * The Product with the given productId has to be removed from the Seller with the given sellerId.
	   * <br>Hint: Remove the Product record with the given productId from the Product Database and update the balance of the Seller with the given sellerId.
	   * @param productId Record ID of the Product to be removed
	   * @param sellerId Record ID of the Seller that the product gets removed from
	   * @return Return the product that was removed from the seller
	   */
	public Product removeFromSeller(Integer productId, Integer sellerId) {
		Product product = (Product) productDatabase.getRecord(productId);
		User seller = (User) userDatabase.getRecord(sellerId);

		seller.updateBalance(seller.getBalance() + product.getCost());
		
		productDatabase.deleteRecord(productId);
		return product;
	}

	/**
	   * Method to add a Product to a Buyer.
	   * Add the given Product to the Product Database after changing the ownership of the Product. The Buyer with the given buyerId becomes the new owner of the product.
	   * <br>Hint: Update the balance of the buyer with the given buyerId after he buys the given product.
	   * @param product The Product to be added
	   * @param buyerId The Record ID of the buyer who will own the given Product
	   */
	public void addToBuyer(Product product, Integer buyerId) {

		User buyer = (User) userDatabase.getRecord(buyerId);

		buyer.updateBalance(buyer.getBalance() - product.getCost());

		product.changeOwner(buyer);
		productDatabase.putRecord(product);

	}

	/**
	   * Method to check if a given Product is owned by a Seller.
	   * Check if the Product with the given productId belongs to the Seller with the given sellerId.
	   * @param productId Record ID of the Product
	   * @param sellerId Record ID of the Seller
	   * @return Return True if the given Seller owns the given Product, else False
	   */
	public Boolean verifyOwnership(Integer productId, Integer sellerId) {
		Product product = (Product) productDatabase.getRecord(productId);
		User seller = (User) userDatabase.getRecord(sellerId);

		if (product.getOwner().getName().equals(seller.getName())) {
			return true;
		}
		return false;
	}

	/**
	   * Method to check if a given Buyer can purchase a given product.
	   * Buyer can buy if their balance is more than the cost of the product.
	   * @param productId Record ID of the product
	   * @param buyerId Record ID of the buyer
	   * @return Return true if the given Buyer can buy the given Product, else Return False
	   */
	public Boolean verifyBalance(Integer productId, Integer buyerId) {
		Product product = (Product) productDatabase.getRecord(productId);
		User buyer = (User) userDatabase.getRecord(buyerId);

		if (product.getCost().compareTo(buyer.getBalance()) < 0) {
			return true;
		}
		return false;
	}

	/**
	   * Method to make a Transaction between a buyer and a seller.
	   * The Product with the given productId is to be sold by the Seller with given sellerId and bought by the Buyer with the given buyerId.
	   * Verify if the transaction is possible.
	   * If possible,execute the transaction and update the Transaction Database.
	   * @param productId Record ID of the product to be bought and sold
	   * @param sellerId Record ID of the seller
	   * @param buyerId Record ID of the buyer
	   * @return Return true if the transaction is successful,else Return False.
	   */
	public Boolean transaction(Integer productId, Integer sellerId, Integer buyerId) {
		if (!verifyBalance(productId, buyerId))
			return false;
		if (!verifyOwnership(productId, sellerId))
			return false;

		Product product = removeFromSeller(productId, sellerId);
		addToBuyer(product, buyerId);
		Transaction transaction = new Transaction(transactionDatabase.getNumRecords(),
				(User) userDatabase.getRecord(buyerId), (User) userDatabase.getRecord(sellerId), product);
		return transactionDatabase.putRecord(transaction);

	}
}
