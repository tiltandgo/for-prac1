import java.util.ArrayList;
import java.util.List;

public class BankAccount implements accountSavings {
    private double addSavings;
    private String BankAccountHolder;
    private double Cash;
    private List<String> transactionList = new ArrayList<>();
    private List<String> addSavingsList = new ArrayList<>();


    public BankAccount(String BankAccountHolder,double Cash,double addSavings){
         this.BankAccountHolder = BankAccountHolder;
         this.Cash = Cash;
         this.transactionList = new ArrayList<>();
         this.addSavings = addSavings;
         this.addSavingsList = new ArrayList<>();

    }
    public void setBankAccountHolder(String BankAccountHolder){
        this.BankAccountHolder = BankAccountHolder;
    }
    public String getBankAccountHolder(){
        return BankAccountHolder;
    }
    public void setCash(double Cash){
        this.Cash = Cash;
    }
    public double getCash(){
        return Cash;
    }

    public void deposit(double money){
        if(money > 0){
            Cash += money;
            saveTransaction("Deposit: "+ money);
            addSavings();

        } else{
            System.out.println("You cannot add this amount of money");
        }

    }
    public void withdraw(double money){
        if(money > 0 && money < Cash){
            Cash -= money;
            saveTransaction("Withdraw: "+ money);
        } else{
            System.out.println("You cannot withdraw this amount of money");
        }
    }
    public void setAddSavings(double addSavings){
        this.addSavings = addSavings;
    }
    public double getAddSavings(){
        return addSavings;
    }

    private void saveTransaction(String transaction){
        transactionList.add(transaction);
    }
    public  List<String> getTransactionHistory(){
        return transactionList;
    }

    public void addSavings(){
       Cash += Cash * (addSavings/100);
       saveaddTransactions("Interest:" + Cash );
    }
    private void saveaddTransactions(String addSavings){
        addSavingsList.add(addSavings);
    }
    public List<String> getAddSavingsList(){
        return addSavingsList;
    }




}
