
import org.junit.Test;

import static org.junit.Assert.*;

public class JUnit {
	
	//1 mark
	
	@Test
	public void checkGetName() {
		User user = new User(0,"Avi",200.0);
		String name = user.getName();
		assertEquals(name,"Avi");
	}
	
	//1 mark
	
	@Test
	public void checkGetBalance() {
		User user = new User(0,"Avi",200.0);
		Double balance = user.getBalance();
		assertEquals(balance,Double.valueOf(200.0));
	}
	
	//1 mark
	
	@Test
	public void checkChangeOwner() {
		User user = new User(0,"Avi",200.0);
		User user1 = new User(0,"Jaskaran",500.0);
		Product product = new Product(0,"laptop",user,100.0);
		product.changeOwner(user1);
		String owner=product.getOwner().getName();
		assertEquals(owner,"Jaskaran");	
	}
	
	//1 mark
	
	@Test
	public void checkEditRecord() {
		Market market = new Market();
		market.addUserRecord("Avi",200.0);
		market.addProductRecord("laptop", 2110.0, 0);
		market.addProductRecord("iPhone", 5000.0, 0);
		Product newProduct = (Product) (market.productDatabase.getRecord(1));
		market.productDatabase.editRecord(0, newProduct);
		Product changedProduct = (Product) (market.productDatabase.getRecord(0));
		assertEquals(changedProduct.getName(),newProduct.getName());	
	}
	
	//1 mark
	
	@Test
	public void checkVerifyOwnership() {
		Market market = new Market();
		market.addUserRecord("Avi",200.0);
		market.addUserRecord("Jaskaran",300.0);
		market.addProductRecord("laptop", 2110.0, 0);
		Boolean check_=market.verifyOwnership(0,0);
		Boolean check1_=market.verifyOwnership(0,1);
		assertEquals(check_,true);
		assertEquals(check1_,false);	
	}
	
	//1 mark
	
	@Test
	public void checkVerifyBalance() {
		Market market = new Market();
		market.addUserRecord("Avi",2500.0);
		market.addUserRecord("Jaskaran",300.0);
		market.addProductRecord("laptop", 2110.0, 0);
		Boolean check_=market.verifyBalance(0,0);
		Boolean check1_=market.verifyBalance(0,1);
		assertEquals(check_,true);
		assertEquals(check1_,false);	
	}
	
	//1 mark
	
	@Test
	public void checkAddToBuyer() {
		Market market = new Market();
		market.addUserRecord("Avi",2500.0);
		market.addUserRecord("Jaskaran",300.0);
		market.addProductRecord("laptop", 2000.0, 0);
		Product product = (Product) (market.productDatabase.getRecord(0));
		market.productDatabase.deleteRecord(0);
		market.addToBuyer(product, 1);
		Product newProduct = (Product) (market.productDatabase.getRecord(0));
		User user = (User) (market.userDatabase.getRecord(1));
		String name = newProduct.getOwner().getName();
		Double balance = user.getBalance();
		assertEquals(balance,Double.valueOf(-1700.0));
		assertEquals(name,"Jaskaran");
	}
	
	//1 mark
	
	@Test
	public void checkRemoveFromSeller() {
		Market market = new Market();
		market.addUserRecord("Avi",2500.0);
		market.addUserRecord("Jaskaran",300.0);
		market.addProductRecord("laptop", 2000.0, 0);
		market.addProductRecord("iPhone", 4000.0, 1);
		Product product = (Product) (market.productDatabase.getRecord(0));
		market.removeFromSeller(0, 0);
		Product newProduct = (Product) (market.productDatabase.getRecord(0));
		User user = (User) (market.userDatabase.getRecord(0));
		String name = newProduct.getOwner().getName();
		Double balance = user.getBalance();
		assertEquals(balance,Double.valueOf(4500.0));
		assertEquals(name,"Jaskaran");
	}
	
	//2mark
	
	@Test
	public void checkTransaction() {
		Market market = new Market();
		market.addUserRecord("Avi",500.0);
		market.addUserRecord("Jaskaran",3000.0);
		market.addProductRecord("laptop", 2000.0, 0);
		Product product = (Product) (market.productDatabase.getRecord(0));
		market.transaction(0,0,1);
		User user = (User) (market.userDatabase.getRecord(0));
		Double sellerBalance=user.getBalance();
		User user1 = (User) (market.userDatabase.getRecord(1));
		Double buyerBalance=user1.getBalance();
		String owner=product.getOwner().getName();
		assertEquals(sellerBalance,Double.valueOf(2500.0));
		assertEquals(buyerBalance,Double.valueOf(1000.0));
		assertEquals(owner,"Jaskaran");
	}
	
	//2 mark
	
	@Test
	public void checkGetTransactedValue() {
		Market market = new Market();
		market.addUserRecord("Avi",500.0);
		market.addUserRecord("Jaskaran",3000.0);
		market.addProductRecord("laptop", 2000.0, 0);
		Product product = (Product) (market.productDatabase.getRecord(0));
		market.transaction(0,0,1);
		String transactedValue= market.transactionDatabase.getTransactedValue();
		assertEquals(Double.toString(2000.0),transactedValue);
		market.transaction(0,1,0);
		String transactedValueC= market.transactionDatabase.getTransactedValue();
		assertEquals(Double.toString(4000.0),transactedValueC);
	
	}	
}
