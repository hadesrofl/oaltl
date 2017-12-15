package de.uzl.hsr.oaltl;

public interface ObjectAlgebraFactory<T> {
	T next(T child);
	T fin(T child);
	T until(T child1, T child2);
	T neg(T child);
	T and(T child1, T child2);
	T or(T child1, T child2);
	T val(boolean val);
	T var(String varName);
}
