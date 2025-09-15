package org.example;

public class ImmClazz {
   private final Integer id;
   private final String str;

    public ImmClazz(Integer id, String str) {
        this.id = new Integer(id);
        this.str = new String(str);
    }
    public Integer getId() {
        return new Integer(id);
    }
    public String getStr() {
        return new String(str);
    }

    public String toString() {
        return "ImmClazz{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}
