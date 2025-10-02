package com.hilllel.cw_24.gof.builder;

final class Report {
    private final String title;
    private final String body;

    private Report(Builder b) {
        this.title = b.title;
        this.body = b.body;
    }

    public String toString() {
        return "Report{title='" + title + "', body='" + body + "'}";
    }

    static class Builder {
        private String title;
        private String body;

        public Builder title(String t) { this.title = t; return this; }
        public Builder body(String b) { this.body = b; return this; }

        public Report build() {
            if (title == null) throw new IllegalStateException("title required");
            return new Report(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Report r1 = new Report.Builder()
            .title("Q3 Results")
            .body("Revenue +12%")
            .build();

        Report r2 = new Report.Builder()
            .title("Board Brief")
            .build();

        System.out.println(r1);
        System.out.println(r2);
    }
}

