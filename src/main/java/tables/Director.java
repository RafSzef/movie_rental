package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "directors")
@Getter
@Setter
@EqualsAndHashCode
public class Director {

    public Director() {
    }

    public Director(String firstName, String lastName) {
    }

    public Director(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Override
    public String toString() {
        return "Director #" + id +
                ": " + firstName +
                " " + lastName;
    }
}
