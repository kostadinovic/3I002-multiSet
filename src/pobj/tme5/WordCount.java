package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import pobj.tme4.MultiSet;
import pobj.tme4.NaiveMultiSet;
import pobj.util.Chrono;

public class WordCount {
	
	public static void wordcount(MultiSet<String> ms) {
		String file= "data/text.txt";
		BufferedReader br;
		try {
			String line;
			br = new BufferedReader(new FileReader(file));
			while((line=br.readLine()) != null) {
				for(String word: line.split("\\P{L}+")) {
					if(word.equals("")) continue; //ignore les mots vides
					ms.add(word);			
				}
			}
			br.close();
			
			/*
			 * class MultiSetComparator afin de rendre notre MultiSet comparable
			 */
			class MultiSetComparator<T> implements Comparator<T>{
				MultiSet<T> ms;
				public MultiSetComparator(MultiSet<T> ms) {
					this.ms=ms;
				}
				@Override
				public int compare(T o1, T o2) {
					// TODO Auto-generated method stub
					return Integer.compare(ms.count(o2), ms.count(o1));
				}	
			}
			
			Comparator<String> msc = new MultiSetComparator<String>(ms);
			List<String> liste = ms.elements();
			liste.sort(msc);
			for(int i=0;i<10;i++) {
				String e = liste.get(i);
				System.out.println(e+" : "+ms.count(e));
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		HashMultiSet<String> hms = new HashMultiSet<String>();
		NaiveMultiSet<String> nms = new NaiveMultiSet<String>();
		System.out.println("Avec HashMultiSet :");
		Chrono chrono = new Chrono();
		wordcount(hms);
		chrono.stop();
		System.out.println("----------------------------");
		System.out.println("Avec NaiveMultiSet :");
		Chrono chrono2 = new Chrono();
		wordcount(nms);
		chrono2.stop();
		
		
		
		
	}
	
	

}
