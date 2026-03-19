class Account {
    private double balance = 0;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
            + " deposited " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                + " withdrew " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                + " tried to withdraw " + amount
                + " | Insufficient funds! Balance: " + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class User1 implements Runnable {
    private Account account;

    public User1(Account account) { this.account = account; }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1500);
            try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

class User2 implements Runnable {
    private Account account;

    public User2(Account account) { this.account = account; }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(800);
            try { Thread.sleep(400); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

public class conAccount {
    public static void main(String[] args) throws InterruptedException {
        Account sharedAccount = new Account(1000);

        Thread t1 = new Thread(new User1(sharedAccount), "User1");
        Thread t2 = new Thread(new User2(sharedAccount), "User2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: " + sharedAccount.getBalance());
    }
}