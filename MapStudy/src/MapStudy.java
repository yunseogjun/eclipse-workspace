import java.text.Format;
import java.util.HashMap;
import java.util.Map;

public class MapStudy {

	public static void main(String[] args) {
		System.out.println("============== 예제1 ==================");
		Map<String, String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "30");

		System.out.println(map.get("name")); // 홍길동
		System.out.println(map.get("age"));  // 30

		System.out.println("============== 예제2 ==================");
		Map<String, Object> map1 =
				Map.of (
					"name","홍길동",
					"age","30",
					"addr","서울시"
				);
		System.out.println(map1.get("age"));

		for (Map.Entry<String, Object> entry : map1.entrySet()) {
			String key = entry.getKey();
			Object val = entry.getValue();
			System.out.println("ENTRYSET = " + "key=" + key + " val=" + val  );
		}

		for (String key : map1.keySet()) {
			Object val = map1.get(key);
			System.out.println("key = " + "key=" + key + " val=" + val  );
		}

		map1.forEach((key,value) -> {
			if (key == "name") System.out.println("foreach name" + value);
		});

		System.out.println("============== 예제3 ==================");

		Yun y1 = new Yun();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("data1", y1);

		Yun yy = (Yun) map2.get("data1");
		System.out.println("yy=" + yy.a2);

		System.out.println("============== 예제4 ==================");
		Yun2 y2 = new Yun2();
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("data1", y2);

		Yun2 y3 = (Yun2) map3.get("data1");
		y2.fun1();
		System.out.println("map3==" +  y3.a1[0]);

		for (String key  : map1.keySet()) {
			System.out.println("==>" + key + " / " + map1.get(key));
			if (key.equals("name")) {
				System.out.println("name ====");
			}
		}
	}
}
