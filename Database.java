/**
   * Represents a Database
   */
public class Database implements IDatabase {
	
	/**
	   * List of records in the Database
	   */
	protected Record[] records;
	/**
	   * Number of Records currently in the Database
	   */
	protected Integer numRecords;
	/**
	   * Maximum number of Records in the Database.
	   * <br>Set it to 5.
	   */
	protected final Integer MAX_RECORDS = 5;
	
	/**
	   * Initialize the variables. Initialize numRecords to 0
	   */
	public Database() {
		this.numRecords = 0;
	}
	
	/**
	   * Method to retrieve number of Records in the Database.
	   * @return The number of records in the Database
	   */
	@Override
	public Integer getNumRecords() {
		return numRecords;
	}

	/**
	   * Method to retrieve a Record with the given ID from the Database.
	   * @param id ID of the Record to be retrieved
	   * @return The Record with the given Record ID
	   */
	@Override
	public Record getRecord(Integer id) {
		for (int i = 0; i < numRecords; i++) {
			if (records[i].getId().equals(id)) {
				return records[i];
			}
		}
		return null;
	}

	/**
	   * Method to insert a record into the Database.
	   * Verify if a new record can be added.
	   * <br>Hint: ID of a Record is same as the array index the record will be stored at in the records[] array.
	   * @param newRecord The Record to be inserted
	   * @return Return True if the Record is successfully inserted, else return False
	   */
	@Override
	public Boolean putRecord(Record newRecord) {
		if (numRecords == MAX_RECORDS)
			return false;
		records[numRecords] = newRecord;
		numRecords++;
		return true;
	}

}
