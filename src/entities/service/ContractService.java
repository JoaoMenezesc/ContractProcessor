package entities.service;

import entities.model.Contract;
import entities.model.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, Integer months){
            OnlinePaymentService onlinePaymentService = new PaypalService();
            for (int i=1; i<=months; i++) {
               double finalTaxPrice = onlinePaymentService.paymentFee(onlinePaymentService.interest(contract.getTotalValue() / months, i)+ contract.getTotalValue() / months);
               double finalPrice = finalTaxPrice + contract.getTotalValue() / months;
               LocalDate contractDate = LocalDate.from(contract.getDate());
               LocalDate installmentContract = contractDate.plusMonths(i);
               Installment installment = new Installment(installmentContract, finalPrice);
               System.out.println(installment);

            }
    }
}
