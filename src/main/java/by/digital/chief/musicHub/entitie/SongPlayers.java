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
    @Column(name = "album")
    private String album;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<People> songInstrumentalist;
    public SongPlayers(long id, String song){
        this.id = id;
        this.song = song;
    }
}
