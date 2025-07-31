package entities.service;

import entities.model.Contract;
import entities.model.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, Integer months){
        OnlinePaymentService onlinePaymentService = new PaypalService();
        for (int i=1; i<=months; i++) {
            double interest = onlinePaymentService.interest(contract.getTotalValue() / months, i);
            double paymentFee = onlinePaymentService.paymentFee(interest + contract.getTotalValue() / months);
            double finalPrice = interest + paymentFee + contract.getTotalValue() / months;
            LocalDate contractDate = LocalDate.from(contract.getDate());
            LocalDate installmentDate = contractDate.plusMonths(i);
            contract.setInstallment(new Installment(installmentDate, finalPrice));
            System.out.println(contract.getInstallment());

        }

    }
}