import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passenger {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name;
    }
}
