package br.com.unifor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "music")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musicSeq")
    @SequenceGenerator(name = "musicSeq", sequenceName = "music_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String artist;

    @JsonIgnore
    @ManyToMany(mappedBy = "musics")
    private Set<PlaylistEntity> playlists = new HashSet<>();
}
