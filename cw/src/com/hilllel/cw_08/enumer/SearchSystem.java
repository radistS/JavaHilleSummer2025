package com.hilllel.cw_08.enumer;

public enum SearchSystem {
    GOOGLE("google.com", 1, "USA"),
    YANDEX("yandex.com", 2, "RUS"),
    BING("bing.com", 3, "USA");

    private String name;
    private Integer rating;
    private String country;

    SearchSystem(String name, Integer rating, String country) {
        System.out.println("run...");
        this.name = name;
        this.rating = rating;
        this.country = country;
    }

    public String url() {
        return name;
    }

    Integer rating() {
        return rating;
    }

    String country() {
        return country;
    }

    @Override
    public String toString() {
        return "SearchSystem{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", country='" + country + '\'' +
                '}';
    }
}
