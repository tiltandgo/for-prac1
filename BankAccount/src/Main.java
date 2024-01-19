

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Ilyas",20000,12);
        bankAccount.setBankAccountHolder("Chingiskhan");
        bankAccount.deposit(200000);
        bankAccount.withdraw(5000);
        bankAccount.setAddSavings(25);

        System.out.println("Bank Account Holder: " + bankAccount.getBankAccountHolder());
        System.out.println("Bank Account Cash: " + bankAccount.getCash());
        System.out.println("Bank Account Transaction History" + bankAccount.getTransactionHistory());
        System.out.println("Bank Applying your Interest in %: " + bankAccount.getAddSavings());
        System.out.println("Your interest after transaction: " + bankAccount.getAddSavingsList());
    }
}