package csc131.junit;

import static org.junit.Assert.assertEquals;
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
        
        double newbalance = 100.0001;			
	    
		assertEquals("getBalance()", newbalance, card.getBalance(), 0.001);
} 

@Test
    public void deduct_RemainingBalance()
    {
		double       balance;
	    GiftCard     card;
	    int          issuingStore;
	    issuingStore = 1338;
	    balance      = 500.00;
	    card = new GiftCard(issuingStore, balance);
	    
	    double withdraw = 100.00;			
	    
		assertEquals("deduct(withdraw)", "Remaining Balance: 400.00", card.deduct(withdraw));
    }

}