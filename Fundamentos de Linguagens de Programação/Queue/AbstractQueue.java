/**
 * Uma fila de elementos é uma estrutura de dados do tipo FIFO
 * (First-In Last-Out), onde elementos são inseridos apenas no
 * final e removidos ou acessados no início.
 */
public abstract class AbstractQueue<T extends Object> {
	protected int size;

	/* Insere um elemento no final da fila. */
	public abstract void enque(T object);

	/* Remove um elemento do início da fila. */
	public abstract T deque();

	/*
	 * Retorna o primeiro elemento na fila, sem removê-lo.
	 * Retorna null se estiver vazia.
	 */
	public abstract T peek();

	/* Verifica se a fila está vazia. */
	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {

		return String.format("Queue<size: %s, head: %s>", this.getSize(), this.peek());
	}

}
