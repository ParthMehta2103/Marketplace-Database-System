/**
   * Interface for Editable Database
   */
public interface IEditableDatabase extends IDatabase {
	
	/**
	   * Interface Method to delete a Record.
	   */
	Boolean deleteRecord(Integer id);
	
	/**
	   * Interface Method to edit a Record.
	   */
	Boolean editRecord(Integer id, Record newRecord);

}
