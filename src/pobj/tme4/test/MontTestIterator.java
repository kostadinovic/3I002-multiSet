package pobj.tme4.test;

import java.util.ArrayList;
import java.util.List;

import pobj.tme4.HashMultiSet;

public class MontTestIterator {
	public static void main(String [] args) {
		HashMultiSet<String> m = new HashMultiSet<>();
		List<String> l = new ArrayList<>();
		m.add("a",3);
		m.add("b");
		m.add("c");
		for (String s : m) {
			l.add(s);
		}
		System.out.println(l.size());
		System.out.println(l.get(0));
		System.out.println(l.get(1));
	}

}
