
public class Driver {
	public static void main(String args[]) {
		Market market = new Market();
		market.addUserRecord("Avu", 200.0);
		market.addProductRecord("laptop", 2110.0, 0);
		market.addUserRecord("Jaskaran", 2500.0);
		market.transaction(0, 0, 1);
		Transaction t = (Transaction) (market.transactionDatabase.getRecord(0));
		System.out.println(t.product.getName());
		market.transactionDatabase.getTransactedValue();
	}
	
	//User- 
	// Get name (0.5) | Get Balance  (0.5) 
	// Change Owner (0.5) | Get Owner (0.5) .
	// Get Transacted Value {1 mark }
	// Edit Record ( Either Product or User db) {1 mark }
	// Transaction (2-3 marks) {1 and all 4 helper 0.5 each}

}
