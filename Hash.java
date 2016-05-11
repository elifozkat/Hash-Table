import java.util.ArrayList;

public class Hash {
	private Integer[] keyArray;
	private Object[] valueArray;
	private int hashTableSize;

	public Hash(int hashTableSize) {
		this.hashTableSize = hashTableSize;
		keyArray = new Integer[hashTableSize];
		valueArray = new Object[hashTableSize];
	}

	public Object get(int key) {
		int i = key % hashTableSize;
		int p = 0;
		while (p < hashTableSize) {
			Integer c = keyArray[i];
			if (c == null) {
				return null;
			} else if (c == key) {
				return valueArray[i];
			} else {
				i = (i + 1) % hashTableSize;
				p++;
			}
		}
		return null;
	}

	public Object put(int key, Object value) {
		int i = key % hashTableSize;
		int p = 0;
		while (p < hashTableSize) {
			Integer c = keyArray[i];
			if (c == null) {
				keyArray[i] = key;
				valueArray[i] = value;
			} else if (c == key) {
				Object temp = valueArray[i];
				valueArray[i] = value;
				return temp;
			} else {
				i = (i + 1) % hashTableSize;
				p++;
			}
		}
		return null;
	}

	public Object remove(int key) {
		int i = key % hashTableSize;
		int p = 0;
		while (p < hashTableSize) {
			Integer c = keyArray[i];
			if (c == null) {
				return null;
			} else {
				if (c == key) {
					Object temp = valueArray[i];
					valueArray[i] = null;
					return temp;
				} else {
					i = (i + 1) % hashTableSize;
					p++;
				}
			}
		}
		return null;
	}

	public boolean isEmpty() {
		boolean a = true;
		for (int i = 0; i < hashTableSize; i++) {
			if (keyArray[i] != null) {
				a = false;
				break;
			}
		}
		return a;
	}

	public int size() {
		int a = 0;
		for (int i = 0; i < hashTableSize; i++) {
			if (keyArray[i] != null) {
				a++;
			}
		}
		return a;
	}

	public ArrayList<Object> keySet() {
		ArrayList<Object> temp = new ArrayList<Object>();
		for (int i = 0; i < hashTableSize; i++) {
			if (keyArray[i] != null)
				temp.add(keyArray[i]);
		}
		return temp;
	}

	public ArrayList<Object> values() {
		ArrayList<Object> temp = new ArrayList<Object>();
		for (int i = 0; i < hashTableSize; i++) {
			if (valueArray[i] != null)
				temp.add(valueArray[i]);
		}
		return temp;
	}
}
