/*package deadlocks;

import model.Transaction;

public abstract class DeadlockPrevention {
        private TimestampTransactionOrder transactionOrder = new TimestampTransactionOrder();

        public abstract boolean detectar(Transaction T1, Transaction T2);

        public abstract String retrievePreventType();

        public void removeTimestamp(String transactionId) {
                transactionOrder.remove(transactionId);
        }

        public void addTimestamp(String t) {
                transactionOrder.add(t);
        }

}*/