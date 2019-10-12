package l2.commons.lang.reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HardReferences {
    private static HardReference<?> EMPTY_REF = new HardReferences.EmptyReferencedHolder((Object)null);

    private HardReferences() {
    }

    public static <T> HardReference<T> emptyRef() {
        return EMPTY_REF;
    }

    public static <T> Collection<T> unwrap(Collection<HardReference<T>> refs) {
        List<T> result = new ArrayList(refs.size());
        Iterator var2 = refs.iterator();

        while(var2.hasNext()) {
            HardReference<T> ref = (HardReference)var2.next();
            T obj = ref.get();
            if (obj != null) {
                result.add(obj);
            }
        }

        return result;
    }

    public static <T> Iterable<T> iterate(Iterable<HardReference<T>> refs) {
        return new HardReferences.WrappedIterable(refs);
    }

    private static class WrappedIterable<T> implements Iterable<T> {
        final Iterable<HardReference<T>> refs;

        WrappedIterable(Iterable<HardReference<T>> refs) {
            this.refs = refs;
        }

        public Iterator<T> iterator() {
            return new HardReferences.WrappedIterable.WrappedIterator(this.refs.iterator());
        }

        private static class WrappedIterator<T> implements Iterator<T> {
            final Iterator<HardReference<T>> iterator;

            WrappedIterator(Iterator<HardReference<T>> iterator) {
                this.iterator = iterator;
            }

            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            public T next() {
                return ((HardReference)this.iterator.next()).get();
            }

            public void remove() {
                this.iterator.remove();
            }
        }
    }

    private static class EmptyReferencedHolder extends AbstractHardReference<Object> {
        public EmptyReferencedHolder(Object reference) {
            super(reference);
        }
    }
}
