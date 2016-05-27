package deadlocks;

public class Detection {
	
	int idTransactionWait;
	int idTransactionBlock;
	
	public Detection(int idTransactionWait, int idTransactionBlock) {
		this.idTransactionWait = idTransactionWait;
		this.idTransactionBlock = idTransactionBlock;
	}

	public int getIdTransactionWait() {
		return idTransactionWait;
	}

	public void setIdTransactionWait(int idTransactionWait) {
		this.idTransactionWait = idTransactionWait;
	}

	public int getIdTransactionBlock() {
		return idTransactionBlock;
	}

	public void setIdTransactionBlock(int idTransactionBlock) {
		this.idTransactionBlock = idTransactionBlock;
	}

}
