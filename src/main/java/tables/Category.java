package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Category {

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64, unique = true)
    private String title;

    @Override
    public String toString() {
        return "Category " +
                "id: " + id +
                "\t" + title;
    }
}
