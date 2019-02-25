package pobj.tme4;

import java.util.Collection;
import java.util.HashMap;

public class HashMultiSet<T> implements MultiSet<T>{
	
	private HashMap<T, Integer> hash;
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
		return false;
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

}
