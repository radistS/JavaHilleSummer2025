package com.hilllel.cw_08.except;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class CloseExample {
    public static void main(String[] args) throws SQLException {

        try (Test text = new Test()) { // try with resources
            text.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test  implements Closeable{
    @Override
    public void close() throws IOException {
        System.out.println("run method : close()");
    }

    public void run() throws BussinesException {
        System.out.println("run method : run()");
        throw new BussinesException("class run");
    }
}
