/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The JAVATUPLES team (http://www.javatuples.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.zealot.javatuples;

import java.util.Collection;
import java.util.Iterator;

import org.zealot.javatuples.valueintf.IValue0;
import org.zealot.javatuples.valueintf.IValue1;
import org.zealot.javatuples.valueintf.IValue2;
import org.zealot.javatuples.valueintf.IValue3;
import org.zealot.javatuples.valueintf.IValue4;
import org.zealot.javatuples.valueintf.IValue5;
import org.zealot.javatuples.valueintf.IValue6;
import org.zealot.javatuples.valueintf.IValue7;

/**
 * <p>
 * A tuple of eight elements.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Octet<A, B, C, D, E, F, G, H> extends Tuple
		implements IValue0<A>, IValue1<B>, IValue2<C>, IValue3<D>, IValue4<E>, IValue5<F>, IValue6<G>, IValue7<H> {

	private static final long serialVersionUID = -1187955276020306879L;

	private static final int SIZE = 8;

	public static <A, B, C, D, E, F, G, H> Octet<A, B, C, D, E, F, G, H> with(final A value0, final B value1,
			final C value2, final D value3, final E value4, final F value5, final G value6, final H value7) {
		return new Octet<A, B, C, D, E, F, G, H>(value0, value1, value2, value3, value4, value5, value6, value7);
	}

	/**
	 * <p>
	 * Create tuple from array. Array has to have exactly eight elements.
	 * </p>
	 * 
	 * @param <X>
	 *            the array component type
	 * @param array
	 *            the array to be converted to a tuple
	 * @return the tuple
	 */
	public static <X> Octet<X, X, X, X, X, X, X, X> fromArray(final X[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array cannot be null");
		}
		if (array.length != 8) {
			throw new IllegalArgumentException(
					"Array must have exactly 8 elements in order to create an Octet. Size is " + array.length);
		}
		return new Octet<X, X, X, X, X, X, X, X>(array[0], array[1], array[2], array[3], array[4], array[5], array[6],
				array[7]);
	}

	/**
	 * <p>
	 * Create tuple from collection. Collection has to have exactly eight
	 * elements.
	 * </p>
	 * 
	 * @param <X>
	 *            the collection component type
	 * @param collection
	 *            the collection to be converted to a tuple
	 * @return the tuple
	 */
	public static <X> Octet<X, X, X, X, X, X, X, X> fromCollection(final Collection<X> collection) {
		return fromIterable(collection);
	}

	/**
	 * <p>
	 * Create tuple from iterable. Iterable has to have exactly eight elements.
	 * </p>
	 * 
	 * @param <X>
	 *            the iterable component type
	 * @param iterable
	 *            the iterable to be converted to a tuple
	 * @return the tuple
	 */
	public static <X> Octet<X, X, X, X, X, X, X, X> fromIterable(final Iterable<X> iterable) {
		return fromIterable(iterable, 0, true);
	}

	/**
	 * <p>
	 * Create tuple from iterable, starting from the specified index. Iterable
	 * can have more (or less) elements than the tuple to be created.
	 * </p>
	 * 
	 * @param <X>
	 *            the iterable component type
	 * @param iterable
	 *            the iterable to be converted to a tuple
	 * @return the tuple
	 */
	public static <X> Octet<X, X, X, X, X, X, X, X> fromIterable(final Iterable<X> iterable, int index) {
		return fromIterable(iterable, index, false);
	}

	private static <X> Octet<X, X, X, X, X, X, X, X> fromIterable(final Iterable<X> iterable, int index,
			final boolean exactSize) {

		if (iterable == null) {
			throw new IllegalArgumentException("Iterable cannot be null");
		}

		boolean tooFewElements = false;

		X element0 = null;
		X element1 = null;
		X element2 = null;
		X element3 = null;
		X element4 = null;
		X element5 = null;
		X element6 = null;
		X element7 = null;

		final Iterator<X> iter = iterable.iterator();

		int i = 0;
		while (i < index) {
			if (iter.hasNext()) {
				iter.next();
			} else {
				tooFewElements = true;
			}
			i++;
		}

		if (iter.hasNext()) {
			element0 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element1 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element2 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element3 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element4 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element5 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element6 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (iter.hasNext()) {
			element7 = iter.next();
		} else {
			tooFewElements = true;
		}

		if (tooFewElements && exactSize) {
			throw new IllegalArgumentException("Not enough elements for creating an Octet (8 needed)");
		}

		if (iter.hasNext() && exactSize) {
			throw new IllegalArgumentException(
					"Iterable must have exactly 8 available elements in order to create an Octet.");
		}

		return new Octet<X, X, X, X, X, X, X, X>(element0, element1, element2, element3, element4, element5, element6,
				element7);

	}

	public Octet(final A value0, final B value1, final C value2, final D value3, final E value4, final F value5,
			final G value6, final H value7) {
		super(value0, value1, value2, value3, value4, value5, value6, value7);
	}
	@SuppressWarnings("unchecked")
	public A getValue0() {
		return (A)super.getValue(0);
	}
	@SuppressWarnings("unchecked")
	public B getValue1() {
		return (B)super.getValue(1);
	}
	@SuppressWarnings("unchecked")
	public C getValue2() {
		return (C)super.getValue(2);
	}
	@SuppressWarnings("unchecked")
	public D getValue3() {
		return (D)super.getValue(3);
	}
	@SuppressWarnings("unchecked")
	public E getValue4() {
		return (E)super.getValue(4);
	}
	@SuppressWarnings("unchecked")
	public F getValue5() {
		return (F)super.getValue(5);
	}
	@SuppressWarnings("unchecked")
	public G getValue6() {
		return (G)super.getValue(6);
	}
	@SuppressWarnings("unchecked")
	public H getValue7() {
		return (H)super.getValue(7);
	}

	@Override
	public int getSize() {
		return SIZE;
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<X0, A, B, C, D, E, F, G, H> addAt0(final X0 value0) {
		return new Ennead<X0, A, B, C, D, E, F, G, H>(value0, (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, X0, B, C, D, E, F, G, H> addAt1(final X0 value0) {
		return new Ennead<A, X0, B, C, D, E, F, G, H>((A)super.getValue(0), value0, (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, X0, C, D, E, F, G, H> addAt2(final X0 value0) {
		return new Ennead<A, B, X0, C, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), value0, (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, X0, D, E, F, G, H> addAt3(final X0 value0) {
		return new Ennead<A, B, C, X0, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), value0, (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, D, X0, E, F, G, H> addAt4(final X0 value0) {
		return new Ennead<A, B, C, D, X0, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), value0, (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, D, E, X0, F, G, H> addAt5(final X0 value0) {
		return new Ennead<A, B, C, D, E, X0, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), value0,
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, D, E, F, X0, G, H> addAt6(final X0 value0) {
		return new Ennead<A, B, C, D, E, F, X0, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				value0, (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, D, E, F, G, X0, H> addAt7(final X0 value0) {
		return new Ennead<A, B, C, D, E, F, G, X0, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), value0, (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0> Ennead<A, B, C, D, E, F, G, H, X0> addAt8(final X0 value0) {
		return new Ennead<A, B, C, D, E, F, G, H, X0>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7), value0);
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<X0, X1, A, B, C, D, E, F, G, H> addAt0(final X0 value0, final X1 value1) {
		return new Decade<X0, X1, A, B, C, D, E, F, G, H>(value0, value1, (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3),
				(E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, X0, X1, B, C, D, E, F, G, H> addAt1(final X0 value0, final X1 value1) {
		return new Decade<A, X0, X1, B, C, D, E, F, G, H>((A)super.getValue(0), value0, value1, (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3),
				(E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, X0, X1, C, D, E, F, G, H> addAt2(final X0 value0, final X1 value1) {
		return new Decade<A, B, X0, X1, C, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), value0, value1, (C)super.getValue(2), (D)super.getValue(3),
				(E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, X0, X1, D, E, F, G, H> addAt3(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, X0, X1, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), value0, value1, (D)super.getValue(3),
				(E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, D, X0, X1, E, F, G, H> addAt4(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, D, X0, X1, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), value0, value1,
				(E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, D, E, X0, X1, F, G, H> addAt5(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, D, E, X0, X1, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), value0,
				value1, (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, D, E, F, X0, X1, G, H> addAt6(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, D, E, F, X0, X1, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), value0, value1, (G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, D, E, F, G, X0, X1, H> addAt7(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, D, E, F, G, X0, X1, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), value0, value1, (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X0, X1> Decade<A, B, C, D, E, F, G, H, X0, X1> addAt8(final X0 value0, final X1 value1) {
		return new Decade<A, B, C, D, E, F, G, H, X0, X1>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4),
				(F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), value0, value1);
	}

	public <X0> Ennead<X0, A, B, C, D, E, F, G, H> addAt0(final Unit<X0> tuple) {
		return addAt0(tuple.getValue0());
	}

	public <X0> Ennead<A, X0, B, C, D, E, F, G, H> addAt1(final Unit<X0> tuple) {
		return addAt1(tuple.getValue0());
	}

	public <X0> Ennead<A, B, X0, C, D, E, F, G, H> addAt2(final Unit<X0> tuple) {
		return addAt2(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, X0, D, E, F, G, H> addAt3(final Unit<X0> tuple) {
		return addAt3(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, D, X0, E, F, G, H> addAt4(final Unit<X0> tuple) {
		return addAt4(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, D, E, X0, F, G, H> addAt5(final Unit<X0> tuple) {
		return addAt5(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, D, E, F, X0, G, H> addAt6(final Unit<X0> tuple) {
		return addAt6(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, D, E, F, G, X0, H> addAt7(final Unit<X0> tuple) {
		return addAt7(tuple.getValue0());
	}

	public <X0> Ennead<A, B, C, D, E, F, G, H, X0> addAt8(final Unit<X0> tuple) {
		return addAt8(tuple.getValue0());
	}

	public <X0, X1> Decade<X0, X1, A, B, C, D, E, F, G, H> addAt0(final Pair<X0, X1> tuple) {
		return addAt0(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, X0, X1, B, C, D, E, F, G, H> addAt1(final Pair<X0, X1> tuple) {
		return addAt1(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, X0, X1, C, D, E, F, G, H> addAt2(final Pair<X0, X1> tuple) {
		return addAt2(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, X0, X1, D, E, F, G, H> addAt3(final Pair<X0, X1> tuple) {
		return addAt3(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, D, X0, X1, E, F, G, H> addAt4(final Pair<X0, X1> tuple) {
		return addAt4(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, D, E, X0, X1, F, G, H> addAt5(final Pair<X0, X1> tuple) {
		return addAt5(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, D, E, F, X0, X1, G, H> addAt6(final Pair<X0, X1> tuple) {
		return addAt6(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, D, E, F, G, X0, X1, H> addAt7(final Pair<X0, X1> tuple) {
		return addAt7(tuple.getValue0(), tuple.getValue1());
	}

	public <X0, X1> Decade<A, B, C, D, E, F, G, H, X0, X1> addAt8(final Pair<X0, X1> tuple) {
		return addAt8(tuple.getValue0(), tuple.getValue1());
	}

	public <X0> Ennead<A, B, C, D, E, F, G, H, X0> add(final X0 value0) {
		return addAt8(value0);
	}

	public <X0> Ennead<A, B, C, D, E, F, G, H, X0> add(final Unit<X0> tuple) {
		return addAt8(tuple);
	}

	public <X0, X1> Decade<A, B, C, D, E, F, G, H, X0, X1> add(final X0 value0, final X1 value1) {
		return addAt8(value0, value1);
	}

	public <X0, X1> Decade<A, B, C, D, E, F, G, H, X0, X1> add(final Pair<X0, X1> tuple) {
		return addAt8(tuple);
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<X, B, C, D, E, F, G, H> setAt0(final X value) {
		return new Octet<X, B, C, D, E, F, G, H>(value, (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, X, C, D, E, F, G, H> setAt1(final X value) {
		return new Octet<A, X, C, D, E, F, G, H>((A)super.getValue(0), value, (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, X, D, E, F, G, H> setAt2(final X value) {
		return new Octet<A, B, X, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), value, (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, C, X, E, F, G, H> setAt3(final X value) {
		return new Octet<A, B, C, X, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), value, (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, C, D, X, F, G, H> setAt4(final X value) {
		return new Octet<A, B, C, D, X, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), value, (F)super.getValue(5),
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, C, D, E, X, G, H> setAt5(final X value) {
		return new Octet<A, B, C, D, E, X, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), value,
				(G)super.getValue(6), (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, C, D, E, F, X, H> setAt6(final X value) {
		return new Octet<A, B, C, D, E, F, X, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				value, (H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public <X> Octet<A, B, C, D, E, F, G, X> setAt7(final X value) {
		return new Octet<A, B, C, D, E, F, G, X>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6), value);
	}
	@SuppressWarnings("unchecked")
	public Septet<B, C, D, E, F, G, H> removeFrom0() {
		return new Septet<B, C, D, E, F, G, H>((B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, C, D, E, F, G, H> removeFrom1() {
		return new Septet<A, C, D, E, F, G, H>((A)super.getValue(0), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, D, E, F, G, H> removeFrom2() {
		return new Septet<A, B, D, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, C, E, F, G, H> removeFrom3() {
		return new Septet<A, B, C, E, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, C, D, F, G, H> removeFrom4() {
		return new Septet<A, B, C, D, F, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (F)super.getValue(5), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, C, D, E, G, H> removeFrom5() {
		return new Septet<A, B, C, D, E, G, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (G)super.getValue(6),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, C, D, E, F, H> removeFrom6() {
		return new Septet<A, B, C, D, E, F, H>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(H)super.getValue(7));
	}
	@SuppressWarnings("unchecked")
	public Septet<A, B, C, D, E, F, G> removeFrom7() {
		return new Septet<A, B, C, D, E, F, G>((A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5),
				(G)super.getValue(6));
	}

}
