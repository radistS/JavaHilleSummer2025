package com.hilllel.cw_24.gof.strategy;

interface CompressionStrategy { void compress(String fileName); }

class ZipCompression implements CompressionStrategy {
    public void compress(String fileName) {
        System.out.println("Compress " + fileName + " as ZIP");
    }
}

class GzipCompression implements CompressionStrategy {
    public void compress(String fileName) {
        System.out.println("Compress " + fileName + " as GZIP");
    }
}

class Compressor {
    private CompressionStrategy strategy;
    public Compressor(CompressionStrategy s) { this.strategy = s; }
    public void setStrategy(CompressionStrategy s) { this.strategy = s; }
    public void compress(String file) { strategy.compress(file); }
}

public class Strategy {
    public static void main(String[] args) {
        Compressor c = new Compressor(new ZipCompression());
        c.compress("data.txt");

        c.setStrategy(new GzipCompression());
        c.compress("data.txt");
    }
}

