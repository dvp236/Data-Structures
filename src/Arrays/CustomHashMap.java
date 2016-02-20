package Arrays;

/**
 * Implementation of HashMap 
 * Average Search Complexity: O(1) 
 * @author dharmik
 * 
 * @param <K>
 * @param <V>
 */
public class CustomHashMap<K,V> {
	private int size = 64;
	private Entry<K,V>[] table;

	
	@SuppressWarnings("unchecked")
	public CustomHashMap(){
		table= new Entry[size];
	}
	
	//put key value 
	public void put(K key,V value){
		
		int temp = key.hashCode();
		int hash=temp%size;
		//if table[hash] is null then we directly put the entry there.
		if(table[hash]==null){
			table[hash]=new Entry<K, V>(key,value);
		}else{
			//if we have an entry then we will link the new entry to existing entry
			Entry newEntry=new Entry(key,value);
			Entry currentEntry=table[hash];
			Entry prevEntry=null;
			//if any key is existing in the hashmap we replace it by new key value pair
			while(currentEntry!=null){
				K currKey=(K)currentEntry.getKey();
				if(currKey.equals(key)){
					if(prevEntry == null){
						newEntry.setNext(currentEntry.getNext());
						table[hash]=newEntry;
					}else{
						prevEntry.setNext(newEntry);
						newEntry.setNext(currentEntry.getNext());
						currentEntry.setNext(null);
					}
					return;
				}
				
				prevEntry=currentEntry;
				currentEntry=currentEntry.getNext();
			}
			prevEntry.setNext(newEntry);
			
		}
	}
	
	
	//get value by key
	public V get(K key){
		int temp = key.hashCode();
		int hash=temp%size;
		
		if(table[hash]==null){
			System.out.println("No value for this key");
			return null;
		}else{
			Entry currentEntry = table[hash];
			while(currentEntry.getNext()!=null){
				if(currentEntry.getKey().equals(key)){
					return (V) currentEntry.getValue();
				}
				currentEntry=currentEntry.getNext();
			}
			
			return (V) currentEntry.getValue();
		}
	
	}
	
	//remove value by key
	public void remove(K key){
		int hash = key.hashCode()%size;
		if(table[hash] == null){
			System.out.println("Nothing to remove. Wrong input");
			return;
		}
		Entry currEntry=table[hash];
		Entry prevEntry=null;
		//if only one value exist for table[hash] then we remove it directly
		if(currEntry.getNext()==null){
			table[hash]=null;
		}else{
			//iterate over all the entries and remove the entry that matches key
			while(currEntry!=null){
				if(currEntry.getKey().equals(key)){
					if(prevEntry==null){
						currEntry=currEntry.getNext();
						table[hash]=currEntry;
						
					}else{
						prevEntry.setNext(currEntry.getNext());
						currEntry.setNext(null);
						
					}
					return;
				}
			}
		}
		
	}
	
}
