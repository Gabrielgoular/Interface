package services;

import java.util.Calendar;  
import java.util.Date;
import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService ( OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	public void processContract(Contract contract, int months) {
		double basicQuota= contract.getTotalValor() / months;
		//basiquota = 200
		for (int i= 1; i <= months; i++) {
			double updateQuota= basicQuota + onlinePaymentService.interest(basicQuota,i);
			//updateQuota= 202
			double fullQuota = updateQuota + onlinePaymentService.paymentFree(updateQuota);
			//fullQuota = 206.04
			//dueDate para vencimento do contrato
			Date dueDate = addMonths(contract.getDate(),i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota) );
		}
	}
	//uma função auxiliar para add messes em uma data 
		private Date addMonths (Date date, int N) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, N);
			return calendar.getTime();
		}
}
