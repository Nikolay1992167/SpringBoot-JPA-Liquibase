package by.digital.chief.musicHub.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
public class PankGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable=false, updatable=false)
    private long id;
    @Column(name = "pankgroup")
    private String pankGroup;
    @OneToMany(mappedBy = "pankGroup", fetch = FetchType.EAGER)
    private List<People> peopleList;
}
