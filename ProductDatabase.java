/**
   * Represents the Product Database
   */
public class ProductDatabase extends Database implements IEditableDatabase {
	
	/**
	   * Initialize the variables. Initialize the records[] array for storing Product records
	   */
	public ProductDatabase() {
		super();
		this.records = new Product[this.MAX_RECORDS];

	}

	/**
	   * Method to delete a Record.
	   * Delete the record and update the IDs of all the subsequent records.
	   * <br>Hint: ID of a Record is same as the array index the record will be stored at in the records[] array.
	   * @param id ID of the Record to be deleted
	   * @return Return True if the record with the given ID has been successfully deleted, else return False
	   */
	@Override
	public Boolean deleteRecord(Integer id) {
		for (int i = 0; i < numRecords; i++) {
			if (this.records[i].getId().equals(id)) {
				for (int j = i; j < numRecords - 1; j++) {
					records[j] = records[j + 1];
					records[j].changeId(records[j].getId()-1);
				}
				numRecords--;
				return true;
			}

		}
		return false;
	}

	/**
	   * Method to edit a Record.
	   * Replace the Record having the given ID with the given new Record.
	   * <br>Hint: Set the ID of the given new Record before inserting into the Database.
	   * @param id ID of the Record to be edited
	   * @param newRecord The new Record that will replace the Record with the given ID
	   * @return Return True if the record with the given ID has been successfully edited, else return False
	   */
	@Override
	public Boolean editRecord(Integer id, Record newRecord) {
		for (int i = 0; i < numRecords; i++) {
			if (this.records[i].getId().equals(id)) {
				newRecord.changeId((id));
				records[i] = newRecord;
				return true;
			}

		}
		return false;
	}

}
