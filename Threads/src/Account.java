
public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    private void setBalance(double balance) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized void deposit(String name, double amt) {
        System.out.println(name + " trying to deposit " + amt);
        System.out.println(name + " getting balance");
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal += amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
        notifyAll(); // notify all threads that are in waiting list, no need to wait for full wait() duration
    }

    public synchronized  void withdraw(String name, double amt) {
        System.out.println(name + " trying to withdraw " + amt);
        int count = 0;
        while(amt > getBalance()) {
        	count++;
        	if(count >= 3) {
        		return;
        	}
        	System.out.println("Insufficient balance!");
        	try {
        		wait(5000);
        	}catch(InterruptedException e) {
        		e.printStackTrace();
        	}
        }
        System.out.println(name + " getting balance");
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal -= amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
    }
}
