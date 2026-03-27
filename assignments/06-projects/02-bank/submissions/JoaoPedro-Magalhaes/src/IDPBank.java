import java.util.Scanner;

public class IDPBank {
    private static final Scanner scanner = new Scanner(System.in);

    private static Customer customer;
    private static Account account;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair\n");

            int option = readInt("Digite o número correspondente à opção desejada: ");

            switch (option) {
                case 1:
                    handleOpenAccount();
                    break;
                case 2:
                    handleConsultCustomer();
                    break;
                case 3:
                    handleDeposit();
                    break;
                case 4:
                    handleWithdraw();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    break;
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String CPF) {
        return new Customer(firstName, lastName, CPF);
    }

    public static Account openAccount(Customer customer) {
        return new Account();
    }

    public static void deposit(double amount) {
        account.deposit(amount);
    }

    public static void withdraw(double amount) {
        account.withdraw(amount);
    }

    private static void handleOpenAccount() {
        System.out.println("Digite os dados para a abertura da conta.\n");

        String firstName = readString("Primeiro nome: ");
        String lastName = readString("Sobrenome: ");
        String cpf = readString("CPF: ");

        customer = createCustomer(firstName, lastName, cpf);
        account = openAccount(customer);
        customer.addAccount(account);

        System.out.println("\nCliente cadastrado com sucesso!\n");
        System.out.println("Nome: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("CPF: " + customer.getCpf());
        System.out.println("Número da Conta: " + account.getId());
        System.out.println("Saldo: " + account.getBalance() + "\n");

        System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
        pressEnterToContinue();
    }

    private static void handleConsultCustomer() {
        if (customer == null || customer.getAccounts() == null) {
            System.out.println("\nNenhum cliente cadastrado.\n");
            System.out.println("Pressione enter para continuar...");
            pressEnterToContinue();
            return;
        }

        System.out.println();
        System.out.print(customer.displayInformation());
        System.out.println("\nPressione enter para continuar...");
        pressEnterToContinue();
    }

    private static void handleDeposit() {
        if (customer == null || account == null) {
            System.out.println("\nNenhum cliente/conta cadastrada.\n");
            System.out.println("Pressione enter para continuar...");
            pressEnterToContinue();
            return;
        }

        System.out.println("Digite o valor que deseja depositar.\n");
        double amount = readDouble("Valor: ");

        try {
            deposit(amount);
            System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".\n");
            System.out.print(customer.displayInformation());
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        System.out.println("\nPressione enter para continuar...");
        pressEnterToContinue();
    }

    private static void handleWithdraw() {
        if (customer == null || account == null) {
            System.out.println("\nNenhum cliente/conta cadastrada.\n");
            System.out.println("Pressione enter para continuar...");
            pressEnterToContinue();
            return;
        }

        System.out.println("Digite o valor que deseja sacar.\n");
        double amount = readDouble("Valor: ");

        try {
            withdraw(amount);
            System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".\n");
            System.out.print(customer.displayInformation());
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        System.out.println("\nPressione enter para continuar...");
        pressEnterToContinue();
    }

    private static void pressEnterToContinue() {
        scanner.nextLine();
        System.out.println();
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            String input = readString(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nValor inválido.\n");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            String input = readString(prompt).replace(",", ".");
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("\nValor inválido.\n");
            }
        }
    }
}

public class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account accounts;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        if (this.accounts != null) {
            return false;
        }
        this.accounts = account;
        return true;
    }

    public String displayInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");

        if (accounts != null) {
            sb.append("Número da Conta: ").append(accounts.getId()).append("\n");
            sb.append("Saldo: ").append(accounts.getBalance()).append("\n");
        }

        return sb.toString();
    }
}

// Account.java
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private static int accountCounter = 1000;

    private int id;
    private double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getBalance() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return currency.format(balance);
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo.");
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }
        setBalance(this.balance + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        setBalance(this.balance - amount);
    }
}
