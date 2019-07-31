
public class AccountClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Account account = new Account(5000);
        TransactionThread t1 =
                new TransactionThread(account, TransactionType.CREDIT, "Roger", 2000);
        TransactionThread t2 =
                new TransactionThread(account, TransactionType.CREDIT, "\tAmy", 3500);
        TransactionThread t3 =
                new TransactionThread(account, TransactionType.DEBIT, "\t\tCalvin", 6000);
        
        t3.start();
        try {
        	Thread.sleep(10);
        }catch(InterruptedException e){
        	e.printStackTrace();     // to makesure t3 gets lock first in 10ms sleep
        }
        
        t1.start();
        t2.start();// the thread start need not be the order in which they acquire locks
        
        
        try {
        	t1.join(); //main() should wait for t1 to finish
        	t2.join(); //main() should wait for t2 to finish
        	t3.join(); //main() should wait for t3 to finish
        }catch(InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("Final Balance: " + account.getBalance());
	}

}
