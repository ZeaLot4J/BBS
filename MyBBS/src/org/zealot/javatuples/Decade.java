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
import org.zealot.javatuples.valueintf.IValue8;
import org.zealot.javatuples.valueintf.IValue9;

/**
 * <p>
 * A tuple of ten elements.
 * </p> 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Decade<A,B,C,D,E,F,G,H,I,J>
        extends Tuple
        implements IValue0<A>,
                   IValue1<B>,
                   IValue2<C>,
                   IValue3<D>,
                   IValue4<E>,
                   IValue5<F>,
                   IValue6<G>,
                   IValue7<H>,
                   IValue8<I>,
                   IValue9<J> {

    private static final long serialVersionUID = -1607420937567707033L;

    private static final int SIZE = 10;
    
    public static <A,B,C,D,E,F,G,H,I,J> Decade<A,B,C,D,E,F,G,H,I,J> with(final A value0, final B value1, final C value2, final D value3, final E value4, final F value5, final G value6, final H value7, final I value8, final J value9) {
        return new Decade<A,B,C,D,E,F,G,H,I,J>(value0,value1,value2,value3,value4,value5,value6,value7,value8,value9);
    }

    
    /**
     * <p>
     * Create tuple from array. Array has to have exactly ten elements.
     * </p>
     * 
     * @param <X> the array component type 
     * @param array the array to be converted to a tuple
     * @return the tuple
     */
    public static <X> Decade<X,X,X,X,X,X,X,X,X,X> fromArray(final X[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (array.length != 10) {
            throw new IllegalArgumentException("Array must have exactly 10 elements in order to create a Decade. Size is " + array.length);
        }
        return new Decade<X,X,X,X,X,X,X,X,X,X>(
                array[0],array[1],array[2],array[3],array[4],
                array[5],array[6],array[7],array[8],array[9]);
    }

    
    /**
     * <p>
     * Create tuple from collection. Collection has to have exactly ten elements.
     * </p>
     * 
     * @param <X> the collection component type 
     * @param collection the collection to be converted to a tuple
     * @return the tuple
     */
    public static <X> Decade<X,X,X,X,X,X,X,X,X,X> fromCollection(final Collection<X> collection) {
        return fromIterable(collection);
    }
    
    
    
    /**
     * <p>
     * Create tuple from iterable. Iterable has to have exactly ten elements.
     * </p>
     * 
     * @param <X> the iterable component type 
     * @param iterable the iterable to be converted to a tuple
     * @return the tuple
     */
    public static <X> Decade<X,X,X,X,X,X,X,X,X,X> fromIterable(final Iterable<X> iterable) {
        return fromIterable(iterable, 0, true);
    }

    
    
    /**
     * <p>
     * Create tuple from iterable, starting from the specified index. Iterable
     * can have more (or less) elements than the tuple to be created.
     * </p>
     * 
     * @param <X> the iterable component type 
     * @param iterable the iterable to be converted to a tuple
     * @return the tuple
     */
    public static <X> Decade<X,X,X,X,X,X,X,X,X,X> fromIterable(final Iterable<X> iterable, int index) {
        return fromIterable(iterable, index, false);
    }

    
    
    private static <X> Decade<X,X,X,X,X,X,X,X,X,X> fromIterable(final Iterable<X> iterable, int index, final boolean exactSize) {
        
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
        X element8 = null;
        X element9 = null;
        
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
        
        if (iter.hasNext()) {
            element8 = iter.next();
        } else {
            tooFewElements = true;
        }
        
        if (iter.hasNext()) {
            element9 = iter.next();
        } else {
            tooFewElements = true;
        }
        
        if (tooFewElements && exactSize) {
            throw new IllegalArgumentException("Not enough elements for creating a Decade (10 needed)");
        }
        
        if (iter.hasNext() && exactSize) {
            throw new IllegalArgumentException("Iterable must have exactly 10 available elements in order to create a Decade.");
        }
        
        return new Decade<X,X,X,X,X,X,X,X,X,X>(
                element0, element1, element2, element3, element4,
                element5, element6, element7, element8, element9);
        
    }

    
    
    
    public Decade(
            final A value0,
            final B value1,
            final C value2,
            final D value3,
            final E value4,
            final F value5,
            final G value6,
            final H value7,
            final I value8,
            final J value9) {
        super(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9);
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

    @SuppressWarnings("unchecked")
    public I getValue8() {
        return (I)super.getValue(8);
    }

    @SuppressWarnings("unchecked")
    public J getValue9() {
        return (J)super.getValue(9);
    }


    @Override
    public int getSize() {
        return SIZE;
    }
    
    
    @SuppressWarnings("unchecked")
    public <X> Decade<X,B,C,D,E,F,G,H,I,J> setAt0(final X value) {
        return new Decade<X,B,C,D,E,F,G,H,I,J>(
                value, (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,X,C,D,E,F,G,H,I,J> setAt1(final X value) {
        return new Decade<A,X,C,D,E,F,G,H,I,J>(
                (A)super.getValue(0), value, (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,X,D,E,F,G,H,I,J> setAt2(final X value) {
        return new Decade<A,B,X,D,E,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), value, (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,X,E,F,G,H,I,J> setAt3(final X value) {
        return new Decade<A,B,C,X,E,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), value, (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,X,F,G,H,I,J> setAt4(final X value) {
        return new Decade<A,B,C,D,X,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), value, (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,E,X,G,H,I,J> setAt5(final X value) {
        return new Decade<A,B,C,D,E,X,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), value, (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,E,F,X,H,I,J> setAt6(final X value) {
        return new Decade<A,B,C,D,E,F,X,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), value, (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,E,F,G,X,I,J> setAt7(final X value) {
        return new Decade<A,B,C,D,E,F,G,X,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), value, (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,E,F,G,H,X,J> setAt8(final X value) {
        return new Decade<A,B,C,D,E,F,G,H,X,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), value, (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public <X> Decade<A,B,C,D,E,F,G,H,I,X> setAt9(final X value) {
        return new Decade<A,B,C,D,E,F,G,H,I,X>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), value);
    }
    

    

    
    
    
    @SuppressWarnings("unchecked")
    public Ennead<B,C,D,E,F,G,H,I,J> removeFrom0() {
        return new Ennead<B,C,D,E,F,G,H,I,J>(
                (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,C,D,E,F,G,H,I,J> removeFrom1() {
        return new Ennead<A,C,D,E,F,G,H,I,J>(
                (A)super.getValue(0), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,D,E,F,G,H,I,J> removeFrom2() {
        return new Ennead<A,B,D,E,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,E,F,G,H,I,J> removeFrom3() {
        return new Ennead<A,B,C,E,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,F,G,H,I,J> removeFrom4() {
        return new Ennead<A,B,C,D,F,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,E,G,H,I,J> removeFrom5() {
        return new Ennead<A,B,C,D,E,G,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,E,F,H,I,J> removeFrom6() {
        return new Ennead<A,B,C,D,E,F,H,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (H)super.getValue(7), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,E,F,G,I,J> removeFrom7() {
        return new Ennead<A,B,C,D,E,F,G,I,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (I)super.getValue(8), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,E,F,G,H,J> removeFrom8() {
        return new Ennead<A,B,C,D,E,F,G,H,J>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (J)super.getValue(9));
    }
    @SuppressWarnings("unchecked")
    public Ennead<A,B,C,D,E,F,G,H,I> removeFrom9() {
        return new Ennead<A,B,C,D,E,F,G,H,I>(
                (A)super.getValue(0), (B)super.getValue(1), (C)super.getValue(2), (D)super.getValue(3), (E)super.getValue(4), (F)super.getValue(5), (G)super.getValue(6), (H)super.getValue(7), (I)super.getValue(8));
    }
    
    
}
