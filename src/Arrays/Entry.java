package Arrays;

//Entry buckets created for HashMap
//holds key, value and pointer to next bucket 
public class Entry<K,V> {
	private final K key;
	private final V value;
	private Entry next;
	
	public Entry(K key,V value){
		this.key=key;
		this.value=value;
		this.next=null;
	}
	
	public void setNext(Entry next){
		this.next=next;
	}
	
	public Entry getNext(){
		return next;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
}

