package tables;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "branches")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Branch {

    public Branch (){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    @Column(name = "postal_code", length = 6, unique = true, nullable = false)
    private String postalCode;

    @Column(length = 64)
    private String address;

    @Override
    public String toString() {
        return "Branch" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", postalCode = '" + postalCode + '\'' +
                ", adres = '" + address + '\'';
    }
}
