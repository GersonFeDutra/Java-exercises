import java.util.Scanner;

/*
 * Fila implementada com array de tamanho flexível.
 * - O tamanho é dobrado conforme se inserem elementos,
 * os elementos anteriores são movidos para a nova fila.
 *
 * Complexidades:
 * Inserção:	O(n)
 * Remoção:		O(1)
 * Acesso:		O(1)
 */
public class ArrayQueue<T extends Object> extends AbstractQueue<T> {
	private static final int DEFAULT_SIZE = 13;
	private int max_size, tail = -1, head = 0;
	private Object[] queue;

	public ArrayQueue() {
		this.size = 0;
		this.max_size = DEFAULT_SIZE;
		this.queue = new Object[DEFAULT_SIZE];
	}

	@Override
	public void enque(T object) {

		// Tamanho máximo foi atingido.
		if (size == max_size) {
			// TODO
			// WATCH
			// FIXME
			max_size *= 2;
			Object[] newQueue = new Object[max_size];

			// Transfere os elementos deslocando de forma que head sempre acabe no índice 0
			int i;
			for (i = head; i < size; ++i)
				newQueue[i - head] = queue[i];

			i = i - head; // Salva a próxima posição que seria preenchida no loop.
			for (int k = 0; k < head; ++k)
				newQueue[k + i] = queue[k];

			// Atualiza os apontamentos
			head = 0;
			tail = size - 1;
			queue = newQueue; // newQueue não será mais referenciado, logo, será coletado pelo GC.
		}

		// Adiciona no final da fila
		tail = (tail + 1) % max_size;
		queue[tail] = object;
		size++;
	}

	@Override
	public T deque() {
		if (isEmpty())
			throw new RuntimeException("Error: can't deque empty Queue.");

		T object = (T) queue[head];
		queue[head] = null; // Atribui null apenas para ativar o GC, se necessário.
		head = (head + 1) % max_size;
		size--;

		return object;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : (T) queue[head];
	}

	private void printDebug() {
		assert max_size > 1;
		System.out.printf("[%d", queue[0]);
		for (int i = 1; i < max_size; ++i)
			System.out.printf(", %d", queue[i]);
		System.out.printf("]\n");
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		Scanner in = new Scanner(System.in);

		System.out.println(queue.toString());
		int c = 0;

		for (int k = 1; k <= 3; ++k) {
			System.out.printf("Inseriu:");
			for (int i = 0; i < ArrayQueue.DEFAULT_SIZE / k; ++i) {
				queue.enque(c); // Coerção é feita automaticamente.
				System.out.printf(" %d", c);
				c++; // Melhor linguagem :D
				// queue.printDebug();
			}
			System.out.println();
			queue.printDebug();
			System.out.println(queue.toString());
			in.nextLine();

			System.out.printf("Removeu:");
			for (int i = 0; i < ArrayQueue.DEFAULT_SIZE / 3; ++i)
				System.out.printf(" %d", queue.deque());
			System.out.println();
			queue.printDebug();
			System.out.println(queue.toString());
			in.nextLine();

			System.out.printf("Inseriu:");
			for (int i = 0; i < ArrayQueue.DEFAULT_SIZE / 4; ++i) {
				queue.enque(c);
				System.out.printf(" %d", c);
				c++;
			}
			System.out.println();
			queue.printDebug();
			System.out.println(queue.toString());
			in.nextLine();
		}
		System.out.printf("Inseriu:");
		for (int i = 0; i < ArrayQueue.DEFAULT_SIZE; ++i) {
			queue.enque(c);
			System.out.printf(" %d", c);
			c++;
		}
		System.out.println();
		queue.printDebug();
		System.out.println(queue.toString());
		in.nextLine();

		in.close();
	}
}
