import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class OccuranceSet<T> implements Set<T>{
		private HashMap<T, Integer> entries;
		public OccuranceSet(){
			entries = new HashMap();
		}
		
		//good
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return entries.size();
		}
		
		@Override
		//good
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			if (entries.size() <1){
			
				return true;}
			else{return false;}
		}
		//good
		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			if (entries.containsKey(o))
				return true;
			else{return false;}
		}
		//extracredit**
		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			NewIterator<T> it = new NewIterator<T>();
			return it;
		}
		//?
		@Override
		public Object[] toArray() {
			List<T> set1 = 	new ArrayList<T>(entries.keySet());
			
			Collections.sort(set1, new Comparator<T>() { 
				
	           public int compare(T o1, T o2) {  

	        	  if ( entries.get(o1) == entries.get(o2) )
	        		  return 0;
	        	  else if( entries.get(o1) > entries.get(o2) )
	        		  return -1;
	        	  else 
	        		  return 1;
	            }  
	        }); 	
			return set1.toArray();
			
		}
		//??
		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			List<T> set1 = 	new ArrayList<T>((Collection<? extends T>) entries.keySet());
			
			Collections.sort(set1, new Comparator<T>() { 
				
	           public int compare(T o1, T o2) {  

	        	  if ( entries.get(o1) == entries.get(o2) )
	        		  return 0;
	        	  else if( entries.get(o1) > entries.get(o2) )
	        		  return -1;
	        	  else 
	        		  return 1;
	            }  
	        }); 	
			return set1.toArray(a);
			}
			
		
		//working
		@Override
		public boolean add(T e) {
			// TODO Auto-generated method stub
			int count;
			
			if (entries.containsKey(e)){
				count = entries.get(e);
				//increment counter
				entries.put(e, count+1);
				
			}else{
				entries.put(e, 1);
			}
			
			return false;
		}
		//working
		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			int count;
			if (entries.get(o) == 1)
				entries.remove(o);
			else{
				count = entries.get(o);
				entries.put((T) o, count-1);
			}
			return false;
		}
		//good
		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			boolean var = false;
			for (Object entry: c){
				if (entries.containsKey(entry))
					var = true;
				else{return false;}
			}
			return var;
		}
		//good
		@Override
		public boolean addAll(Collection<? extends T> c) {
			int count;	
				for (T entry:c){
				if (entries.containsKey(entry)){
					count = entries.get(entry);
					//increment counter
					entries.put(entry, count+1);
					
				}else{
					entries.put(entry, 1);
				}
				}//endfor
			return false;
		}
		//??
		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			for (Object entry: c){
				if(entries.containsKey(entry) != true){
					entries.remove(entry);
				}
					
			}
				
			return false;
		}
		//good
		@Override
		public boolean removeAll(Collection<?> c) {
			for (Object entry:c){
				entries.remove(entry);
			}
			return false;
		}

		@Override
		public void clear() {
			
			entries.clear();
			
		}
		
		
		public String toString(){
			
			
			List<T> listToSort = 	new ArrayList<T>(entries.keySet());
					
			Collections.sort(listToSort, new Comparator<T>() { 
				
	           public int compare(T o1, T o2) {  

	        	  if ( entries.get(o1) == entries.get(o2) )
	        		  return 0;
	        	  else if( entries.get(o1) > entries.get(o2) )
	        		  return -1;
	        	  else 
	        		  return 1;
	            }  
	        }); 	
				
		
			
			return listToSort.toString();
		}
		
			
		
		 
		
		public static void main(String[] args) {
			
			OccuranceSet<Integer> intSet = new OccuranceSet<Integer>();
			intSet.add(1);
			intSet.add(3);
			intSet.add(5);
			intSet.add(5);
			intSet.add(3);
			intSet.add(3);
			intSet.add(3);
			System.out.println(intSet);
			OccuranceSet<String> stringSet = new OccuranceSet<String>();
			stringSet.add("hello");
			stringSet.add("hello");
			stringSet.add("world");
			stringSet.add("world");
			stringSet.add("world");
			stringSet.add("here");
			stringSet.add("I");
			stringSet.add("am");
			System.out.println(stringSet);
			//need to do the following
			//
			//
		}
		
		//creating new iterator class to use for EXTRA CREDIT
		//got help from kewen during office hours
		public class NewIterator<T> implements Iterator<T>{
			Iterator<T> iterator;
				ArrayList<T> set;
				int index = 0;
			public NewIterator(){
				set = new ArrayList(entries.keySet());
				
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				//need to increment my iterator
				index++;
				if (index == set.size())
					return false;
				else{return true;}
				
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				//need to increment my iterator
				index++;
				
				if (set.get(index)!=null){
					return (T) entries.get(index);
				}
				
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				if (set.get(index)!=null){
					entries.remove(index);
					set.remove(index);
				}
			}
			
		}
		
}