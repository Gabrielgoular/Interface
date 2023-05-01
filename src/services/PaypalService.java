package services;

public class PaypalService implements OnlinePaymentService{
	  
	private static final double PAYMENT_FREE= 0.02;
	private static final double MONTHLY_INTEREST= 0.01;
	
	@Override
	public double paymentFree(Double amount) {
		return amount * PAYMENT_FREE;
	}

	@Override
	public double interest(double amount, int moths) {
		return amount * moths * MONTHLY_INTEREST;
	}

}
