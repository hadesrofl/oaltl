package de.uzl.hsr.oaltl;

public interface ObjectAlgebraFactory<T> {
	public T next(T child);
	public T fin(T child);
	public T until(T child1, T child2);
	public T neg(T child);
	public T and(T child1, T child2);
	public T or(T child1, T child2);
	public T val(boolean val);
	public T var(String varName);
}
