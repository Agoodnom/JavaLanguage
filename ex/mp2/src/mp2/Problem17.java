package mp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class myMap<K, V> extends TreeMap<K,V>{
	
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

class MapManager {

	public static Map<String, Double> readData(String str) {

		BufferedReader br = null;
		Map<String, Double> map = new myMap<>();
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

		return map;
	}

}

public class Problem17 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if (map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}
