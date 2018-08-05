
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;
    private final double ECONOMICAL_PRICE = 2.5;
    private final double GOURMET_PRICE = 4.0;

    public CashRegister() {
        // at start the register has 1000 euros 
        this.cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens        
        if(cashGiven >= ECONOMICAL_PRICE){
            economicalSold++;
            this.cashInRegister += ECONOMICAL_PRICE;
            return cashGiven - ECONOMICAL_PRICE;
        }
        return cashGiven;
    }

    public double payGourmet(double cashGiven) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        if(cashGiven >= GOURMET_PRICE){
            gourmetSold++;
            this.cashInRegister += GOURMET_PRICE;
            return cashGiven - GOURMET_PRICE;
        } else{
            return cashGiven;
        }
        
    }
    
    public boolean payEconomical(LyyraCard card){
        if(card.balance() >= ECONOMICAL_PRICE){
            economicalSold++;
            card.pay(ECONOMICAL_PRICE);
            return true;
        } else{
            return false;
        }
    }
    
    public boolean payGourmet(LyyraCard card){
        if(card.balance() >= GOURMET_PRICE){
            gourmetSold++;
            card.pay(GOURMET_PRICE);
            return true;
        } else{
            return false;
        }
    }
    
    public void loadMoneyToCard(LyyraCard card, double sum){
        if(sum > 0){
            card.loadMoney(sum);
            this.cashInRegister += sum;
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}
