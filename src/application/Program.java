package application;

import entities.model.Contract;
import entities.service.ContractService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre os dados do contrato:");
        System.out.println("Numero: ");
        int number = sc.nextInt();
        System.out.println("Data (dd/MM/yyyy): ");
        sc.nextLine();
        String dataString = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dataString, dtf);
        System.out.println("Valor do contrato: ");
        Double contractValue = sc.nextDouble();
        Contract contract = new Contract(number, date, contractValue);
        System.out.println("Entre com o numero de parcelas: ");
        int installment = sc.nextInt();

        System.out.println("Parcelas:");
        ContractService contractService = new ContractService();
        contractService.processContract(contract, installment);
        2





    }
}
