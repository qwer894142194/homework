package ResLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {
    private static List<Person> list = new ArrayList();
    private static Map<String,Person> map = new HashMap<>();

    public static List getList() {
        return list;
    }

    public static void setList(Person person) {
        UserData.list.add(person);
    }

    public static Map<String, Person> getMap() {
        return map;
    }

    public static void setMap(Map<String, Person> map) {
        UserData.map = map;
    }

}
