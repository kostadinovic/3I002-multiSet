package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private List<T> liste;
	
	public NaiveMultiSet() {
		liste=new ArrayList<T>();
	}

	@Override
	public boolean isEmpty() {
		return (liste.size()==0);
	}


	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		if(count==0) return false;
		for(int i=0;i<count;i++) {
			liste.add(e);
		}
		return true;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		liste.add(e);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		T elem = (T) e;
		if (count(elem) != 0) {
			for (int i=0; i<liste.size(); i++) {
				if (liste.get(i).equals(e)) {
					liste.remove(i);
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T elem = (T) e;
		if ((count(elem) != 0) && (count != 0) && (count(elem) >= count)) {
			for (int i=0; i<liste.size(); i++) {
				if (count != 0) {
					if (liste.get(i).equals(e)) {
						liste.remove(i);
						count--;
					}
				} else {
					break;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		int cpt=0;
		for(T e:liste) {
			if(e.equals(o)) {
				cpt++;
			}
		}
		return cpt;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		liste.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		Set<T> hs = new HashSet<>(liste);
		List<T> elements = new ArrayList<T>(hs);
		return elements;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new NaiveMultiSetIterator();
	}
	
	private class NaiveMultiSetIterator implements Iterator<T> {

		private int ind = 0;
		
		@Override
		public boolean hasNext() {
			return ind < size();
		}

		@Override
		public T next() {
			return liste.get(ind++);
		}
	}
	
      }
