import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

/**
 * @author Alex Stepurko
 * @version 0.0.2
 * <p>
 * DTO class for store information about student
 */
@Setter
@Getter
@Accessors(chain = true)
public class Student {
    private int id;
    @CsvBindByPosition(position = 0)
    private String firstName;
    @CsvBindByPosition(position = 1)
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override

    public String toString() {
        return "firstName='" + firstName  +
                " lastName='" + lastName;
    }
}
