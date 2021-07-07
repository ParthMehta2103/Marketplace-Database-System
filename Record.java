/**
   * Represents a Record
   */
public class Record {
	
	/**
	   * ID of the Record
	   */
	private Integer id;
	
	/**
	   * Initialize the variables. Initialize id with the given id
	   * @param id The ID of the Record
	   */
	public Record(Integer id) {
		this.id = id;
	}
	/**
	   * Retrieve the ID of the Record
	   * @return id - Return the ID of the Record
	   */
	public Integer getId() {
		return id;
	}
	/**
	   * Change the ID of the record.
	   * @param id The new ID
	   */
	public void changeId(Integer id) {
		this.id = id;
	}

}
