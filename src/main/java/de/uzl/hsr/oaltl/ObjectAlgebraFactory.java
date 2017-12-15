package de.uzl.hsr.oaltl;

/**
 * This factory interface represents the object algebras data variants of operation <em>T</em>
 *
 * @param <T> is a generic type of the operation, which will be implemented for these variants
 * @author Hannes Kallwies
 */
public interface ObjectAlgebraFactory<T> {
    /**
     * Takes an object of type T and creates a new object T with the implemented operation of T for data variant <em>next</em>
     *
     * @param child is a generic object to create a a new object T according to data variant <em>next</em>
     * @return new object, which has operations of T implemented for data variant <em>next</em>
     */
    T next(T child);

    /**
     * Takes an object of type T and creates a new object T with the implemented operation of T for data variant <em>finally</em>
     *
     * @param child is a generic object to create a a new object T according to data variant <em>finally</em>
     * @return new object, which has operations of T implemented for data variant <em>finally</em>
     */
    T fin(T child);

    /**
     * Takes objects of type T and creates a new object T with the implemented operation of T for data variant <em>until</em>
     *
     * @param child1 is the left hand side generic object of data variant <em>until</em>
     * @param child2 is the right hand side object of data variant <em>until</em>
     * @return new object, which has operations of T implemented for data variant <em>until</em>
     */
    T until(T child1, T child2);

    /**
     * Takes an object of type T and creates a new object T with the implemented operation of T for data variant <em>negation</em>
     *
     * @param child is a generic object to create a a new object T according to data variant <em>negation</em>
     * @return new object, which has operations of T implemented for data variant <em>negation</em>
     */
    T neg(T child);

    /**
     * Takes objects of type T and creates a new object T with the implemented operation of T for data variant <em>and</em>
     *
     * @param child1 is the left hand side generic object of data variant <em>and</em>
     * @param child2 is the right hand side generic object of data variant <em>and</em>
     * @return new object, which has operations of T implemented for data variant <em>and</em>
     */
    T and(T child1, T child2);

    /**
     * Takes objects of type T and creates a new object T with the implemented operation of T for data variant <em>or</em>
     *
     * @param child1 is the left hand side generic object of data variant <em>or</em>
     * @param child2 is the right hand side generic object of data variant <em>or</em>
     * @return new object, which has operations of T implemented for data variant <em>or</em>
     */
    T or(T child1, T child2);

    /**
     * Takes an object of type T and creates a new object T with the implemented operation of T for data variant <em>value</em>
     *
     * @param val is a boolean value
     * @return new object, which has operations of T implemented for data variant <em>value</em>
     */
    T val(boolean val);

    /**
     * Takes a string and creates a new object T with the implemented operation of T for data variant <em>variable</em>
     *
     * @param varName is the name of the variable
     * @return new object, which has operations of T implemented for data variant <em>variable</em>
     */
    T var(String varName);
}
