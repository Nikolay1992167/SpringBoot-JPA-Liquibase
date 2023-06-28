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
@Table(name = "songplayers")
@NoArgsConstructor
@AllArgsConstructor
public class SongPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "song")
    private String song;
    @Column(name = "composer")
    private String composer;
    @Column(name = "poet")
    private String poet;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Album album;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "people_songplayers",
            joinColumns = @JoinColumn(name = "songplayers_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    private List<People> songInstrumentalist;
    public SongPlayers(long id, String song){
        this.id = id;
        this.song = song;
    }
}
