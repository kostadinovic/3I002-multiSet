package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private HashMap<T,Integer> hash;
	private int size;
	
	public HashMultiSet () {
		hash = new HashMap<T, Integer>();
		size=0;
	}

	
	public HashMultiSet(Collection<T> col) {
		hash = new HashMap<T, Integer>();
		for (T elem : col) {
			add(elem);
		}
	}
	
	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		if(hash.containsKey(e)) {
			hash.put(e, hash.get(e)+count);
			size=size+count;
			return true;
		}
		hash.put(e,count);
		size=size+count;
		return true;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if(hash.containsKey(e)) {
			hash.put(e,hash.get(e)+1);
			size++;
			return true;
		}
		hash.put(e,1);
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		T elem = (T) e;
		if (hash.containsKey(e)) {
			hash.put((T) e, count(elem)-1);
			size--;
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		T elem = (T)e;
		if ((hash.containsKey(e)) && (count != 0) && (count(elem) >= count)) {
			hash.put((T)e, count(elem)-count);
			size -= count;
			return true;
		}
		return false;
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		Integer val = hash.get(o);
		if(!(val == null)) {
			return val;
		}
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		hash.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	public class HashMultiSetIterator implements Iterator<T>{
		
		/* element actuel */
		private T elem;
		
		/* l'indice de elem */
		private int ind;
		
		
		/* le nb d'occurence de elem */
		private int cpt;
		
		/* l'iterateur */
		private Iterator<Entry<T, Integer>> it;
		
		/*
		 *  Constructeur et initiliase l'iterateur
		 */
		public HashMultiSetIterator() {
			it=hash.entrySet().iterator();
			ind=0;
			cpt=0;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return ind<size();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				if(cpt==0) {
					Map.Entry<T, Integer> ent = it.next();
					elem= ent.getKey();
					cpt= ent.getValue();
				}
				
			}
			ind++;
			cpt--;
			return elem;
		}	
	}
	/*
	 * methode toArray de AbstractCOllection pour que notre classe
	 * soit instanceof Collection
	 */
	public List<T> elements() {
		List<T> elems = new ArrayList(this);
		Set<T> s = new HashSet<>(elems);
		elems = new ArrayList(s);
		return elems;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new HashMultiSetIterator();
	}

}
