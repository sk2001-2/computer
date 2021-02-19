package ru.sapteh.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Table(name = "config_pc")
@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "HDD")
    private String hdd;

    @Column(name = "Power_supply")
    private String powerSupply;

    @Column(name = "Video_card")
    private String Video_card;

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", powerSupply=" + powerSupply +
                ", Video_card='" + Video_card + '\'' +
                '}';
    }
}
