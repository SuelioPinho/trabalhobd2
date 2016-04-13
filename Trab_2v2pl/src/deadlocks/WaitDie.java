/*
package deadlocks;

import model.Scheduler;
import model.Transaction;

public class WaitDie implements DeadlockPrevention {

        private final Scheduler scheduler;
        
        public WaitDie(Scheduler scheduler) {
                this.scheduler = scheduler;
        }
        
        @Override
        public boolean detect(Transaction T1, Transaction T2) {
                if (!T1.isBeforeTransaction(T2)) {
                        scheduler.abortTransaction(T1);
                        return true;
                }
                return false;
        }//Victor : Parei aqui.

}*/