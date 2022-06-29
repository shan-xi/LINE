import org.json.JSONObject;

import java.util.Iterator;

/**
 * {
 * "A":"1",
 * "B":"1",
 * "C":{
 * "D":1,
 * "E":{
 * "F":1
 * }
 * },
 * }
 * <p>
 * A=1
 * B=1
 * C.D=1
 * C.E.F=1
 */

public class JsonConverter {
    public static void main(String[] args) {
        String jsonString = new JSONObject()
                .put("A", "1")
                .put("B", "1")
                .put("C", new JSONObject().put("D", "1").put("E", new JSONObject().put("F", 1)))
                .toString();

        System.out.println(jsonString);

        JSONObject json_obj = new JSONObject(jsonString);
        StringBuilder sb = new StringBuilder();
        r(json_obj, "", sb);
        System.out.println(sb.toString());
    }

    static void r(JSONObject j, String path, StringBuilder sb) {
        Iterator<String> iter = j.keys();
        while (iter.hasNext()) {
            String v = iter.next();
            if (j.get(v).getClass() == JSONObject.class) {
                if (!path.equals("")) {
                    path = path + ".";
                }
                path += v;
                r((JSONObject) j.get(v), path, sb);
            } else {
                if (!path.equals("")) {
                    path = path + ".";
                }
                path += v;
//                System.out.println(path + "=" + j.get(v));
                sb.append(path + "=" + j.get(v)+"\n");
            }
        }
    }
}
