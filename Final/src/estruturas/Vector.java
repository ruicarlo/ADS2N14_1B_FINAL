package estruturas;

import java.lang.reflect.Array;

public class Vector<T> {

	private Object[] array;
	private int size;

	public Vector() {
		this.array = new Object[0];
	}

	public int getSize() {
	    return this.size;
	}

	@SuppressWarnings("unchecked")
	public T getValueOf(int index) {
	    if (index >= this.size || index < 0)
	        throw new ArrayIndexOutOfBoundsException(index);

	    return (T) array[index];
	}

	public int getIndexOf(T value) {
		for (int i = 0; i < this.size; i++) {
			if (this.getValueOf(i).equals(value)) {
				return i;
			}
		}

		return -1;
	}

	public boolean append(T value) {
	    ensureCapacity(this.size + 1);

	    this.array[this.size] = value;

	    this.size++;

	    return true;
	}

	public boolean insert(int index, T value) {
	    ensureCapacity(this.size + 1);

		Object[] arrayTemp = new Object[this.array.length];

		System.arraycopy(this.array, 0, arrayTemp, 0, this.array.length);

		arrayTemp[index] = value;

		System.arraycopy(
							this.array, index
							, arrayTemp, index + 1
							, this.array.length - index - 1
		);

		this.array =  arrayTemp;

		this.size++;

		return true;
	}

	public boolean remove(int index) {
	    if (index >= this.size)
	        throw new ArrayIndexOutOfBoundsException(index);

		System.arraycopy(
				this.array, index + 1,
				this.array, index,
				this.array.length - 1 - index
		);

		this.size--;

		return true;
	}

	private void ensureCapacity(int newSize) {
		if (this.array.length < newSize) {
			this.enlargeVector();
		}
	}

	private void enlargeVector() {
		Object[] newArray = new Object[this.array.length + 1];

		System.arraycopy(this.array, 0, newArray, 0, this.array.length);

		this.array = newArray;
	}

	public boolean isEmpty() {
	    return this.size == 0;
	}

	@SuppressWarnings("unchecked")
	public T[] asArray() {
	    if (this.array == null) {
	        return null;
	    }

	    T t = this.getValueOf(0);
	    T[] newArray = (T[]) Array.newInstance(t.getClass(), this.getSize());

	    System.arraycopy(this.array, 0, newArray, 0, this.getSize());

	    return newArray;
	}
}