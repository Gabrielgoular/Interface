package services;

public interface OnlinePaymentService {
	double paymentFree(Double amount);
	double interest(double amount, int moths);
}
