import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@ToString
public class Student {
    String firstName;
    String lastName;
    Integer age;
}
