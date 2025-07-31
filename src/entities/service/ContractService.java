package entities.service;

import entities.model.Contract;
import entities.model.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, Integer months){
            OnlinePaymentService onlinePaymentService = new PaypalService();
            for (int i=1; i<=months; i++) {
               double a = onlinePaymentService.interest(contract.getTotalValue() / months, i);
               double b = onlinePaymentService.paymentFee(a + contract.getTotalValue() / months);
               double c = a + b + contract.getTotalValue() / months;
               LocalDate localDate2 = LocalDate.from(contract.getDate());
               LocalDate localDate = localDate2.plusMonths(i);
               Installment installment = new Installment(localDate, c);
               System.out.println(installment);

            }
    }
}
