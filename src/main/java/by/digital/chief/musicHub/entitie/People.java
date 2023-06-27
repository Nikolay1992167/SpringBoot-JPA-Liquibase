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
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "human")
    private String human;
    @Column(name = "age")
    private Integer age;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "stile")
    private String stile;
    @ManyToOne(cascade = CascadeType.MERGE)
    private PankGroup pankGroup;
    @ManyToMany(mappedBy = "songInstrumentalist", fetch = FetchType.EAGER)
    private List<SongPlayers> songItems;
    public People(long id, String human){
        this.id = id;
        this.human = human;
    }
}
