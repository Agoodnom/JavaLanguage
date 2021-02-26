package mp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class myMap<K, V> extends LinkedHashMap<K,V>{
	
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		StringBuilder r =  new StringBuilder("");
		
		final Iterator<Map.Entry<K,V>> it = entrySet().iterator();
		
        while(it.hasNext()) {
            Map.Entry<K,V> e = it.next();
            r.append(e.getKey());
            r.append(' ');
            r.append(e.getValue());
            r.append("\n");
        }
        return r.toString().trim();
	}
}
class ValueComparator<T> implements Comparator<T> {
	@SuppressWarnings("unchecked")
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			Map.Entry<String, Double> e1 = (Map.Entry<String, Double>) o1;
			Map.Entry<String, Double> e2 = (Map.Entry<String, Double>) o2;
			if (e2.getValue() > e1.getValue())
				return -1;
			if (e2.getValue() < e1.getValue())
				return 1;
			return e1.getKey().compareTo(e2.getKey());
		}
		return -1;
	}
}
class MapManager {

	public static Map<String, Double> readData(String str) {

		BufferedReader br = null;
		Map<String, Double> map = new myMap<>();
		Map<String, Double> map2 = new myMap<>();
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			return null;
		}
		while (true) {
			try {
				String line = br.readLine();
				if (line == null)
					break;
				String[] token = line.split(" ");
				map.put(token[0], Double.parseDouble(token[1]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Iterator<Map.Entry<String, Double>> it;
		Set<Map.Entry<String, Double>> set = map.entrySet();
		List<Map.Entry<String, Double>> list = new ArrayList<>(set);
		Collections.sort(list, new ValueComparator<Map.Entry<String, Double>>());
		
		it = list.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Double> entry = it.next();
			map2.put(entry.getKey(), entry.getValue());
		}
		
		return map2;
	}

}

public class Problem18 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if (map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}