/**
   * Represents the Transaction Database
   */
public class TransactionDatabase extends Database {
	
	/**
	   * Initialize the variables. Initialize the records[] array for storing Transaction records
	   */
    public TransactionDatabase() {
        super();
        this.records = new Transaction[this.MAX_RECORDS];

    }
    
    /**
	   * Method to obtain a String representation of the total cost of all transactions in the Database.
	   * <br>The cost of a transaction is equal to the cost of the product being transacted.
	   * @return Return the String representation of the total sum of cost of all transactions in the Database
	   */
    public String getTransactedValue() {
        Double sum = 0.0;
        for (int i = 0; i < numRecords; i++) {
            Transaction temp = (Transaction) records[i];
            sum += temp.getCost();
        }
        return sum.toString();
    }

}
