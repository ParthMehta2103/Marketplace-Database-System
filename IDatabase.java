/**
   * Interface for Database
   */
public interface IDatabase {
	
	/**
	   * Interface Method to retrieve number of Records in the Database.
	   */
	Integer getNumRecords();
	
	/**
	   * Interface Method to retrieve a Record with the given ID from the Database.
	   */
	Record getRecord(Integer id);
	
	/**
	   * Interface Method to insert a record into the Database.
	   */
	Boolean putRecord(Record newRecord);
}
