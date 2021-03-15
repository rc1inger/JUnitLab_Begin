package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class GiftCardTest
{
	@Test
	    public void getIssuingStore()
	    {
	        double       balance;
	        GiftCard     card;
	        int          issuingStore;
	        issuingStore = 1337;
	        balance      = 100.00;
	        card = new GiftCard(issuingStore, balance);
	        assertEquals("getIssuingStore()",
	                     issuingStore, card.getIssuingStore());
	        
	        double newbalance = 100.00;
		    
			assertEquals("getBalance()", newbalance, card.getBalance(), 0.001);
	} 
	
	@Test
	    public void deduct_RemainingBalance()
	    {
			double       balance;
		    GiftCard     card;
		    int          issuingStore;
		    String s = "Remaining Balance: 400.00";
		    issuingStore = 1338;
		    balance      = 500.00;
		    card = new GiftCard(issuingStore, balance);
		    double withdraw = 100.00;			
			assertEquals("deduct(400.00)", s, card.deduct(withdraw));
	    }
	
	@Test 
		public void deduct_invalidTransaction() 
		{
			double balance;  
			GiftCard card;  
			int issuingStore;  
			String s;  
			issuingStore = 1337;
			balance = 100.00;
			card = new GiftCard(issuingStore, balance);
			s = "Invalid Transaction";
			assertEquals("deduct(-5.00)", s, card.deduct(-5.00));
			
		}
	
	@Test 
		public void deduct_AmountDue()  
		{  
			double balance;  
			GiftCard card;  
			int issuingStore;  
			String s;  
			issuingStore = 1337;
			balance = 150.00;
			card = new GiftCard(issuingStore, balance);
			s = "Amount Due: " + String.format("%6.2f", 5.00);
			assertEquals("deduct(155.00)", s, card.deduct(155.00));
		}
	@Test
		public void constructor_IncorrectBalance()
		{
			assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
		}
	@Test
		public void constructor_IncorrectID_Low()
		{
			assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1337,100.00);});
		}
	
	@Test
		public void constructor_IncorrectID_High()
		{
			assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
		}
	}