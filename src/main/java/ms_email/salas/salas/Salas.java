package ms_email.salas.salas;

import jakarta.persistence.*;
import ms_email.salas.pessoas.Pessoas;
import ms_email.salas.pessoas.TipoPessoa;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_salas")
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hora_inicial", nullable = false)
    private LocalDateTime horaInicial;

    @Column(name = "hora_final", nullable = false)
    private LocalDateTime horaFinal;

    @ManyToOne
    @JoinColumn(name = "id_do_reservista", referencedColumnName = "id")
    private Pessoas reservista;


    @ManyToOne
    @JoinColumn(name = "id_do_palestrante", referencedColumnName = "id")
    private Pessoas palestrante;


    @Column(name = "quantidade_de_pessoas", nullable = false)
    private Integer quantidadeDePessoas;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_salas", nullable = false)
    private TipoSalas tipoSalas;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", nullable = false)
    private TipoPessoa tipoPessoa;



    @Transient
    private int diaReserva;

    @Transient
    private int mesReserva;

    @Transient
    private int anoReserva;

    @Transient
    private String horaInicialString;

    @Transient
    private String horaFinalString;


    public Salas() {}

    public Salas( LocalDateTime horaInicial, LocalDateTime horaFinal, Pessoas reservista, Pessoas palestrante,
                 Integer quantidadeDePessoas, TipoSalas tipoSalas, TipoPessoa tipoPessoa) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.reservista = reservista;
        this.palestrante = palestrante;
        this.quantidadeDePessoas = quantidadeDePessoas;
        this.tipoSalas = tipoSalas;
        this.tipoPessoa = tipoPessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalDateTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Pessoas getReservista() {
        return reservista;
    }

    public void setReservista(Pessoas reservista) {
        this.reservista = reservista;
    }

    public Pessoas getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Pessoas palestrante) {
        this.palestrante = palestrante;
    }

    public Integer getQuantidadeDePessoas() {
        return quantidadeDePessoas;
    }

    public void setQuantidadeDePessoas(Integer quantidadeDePessoas) {
        this.quantidadeDePessoas = quantidadeDePessoas;
    }

    public TipoSalas getTipoSalas() {
        return tipoSalas;
    }

    public void setTipoSalas(TipoSalas tipoSalas) {
        this.tipoSalas = tipoSalas;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public int getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(int diaReserva) {
        this.diaReserva = diaReserva;
    }

    public int getMesReserva() {
        return mesReserva;
    }

    public void setMesReserva(int mesReserva) {
        this.mesReserva = mesReserva;
    }

    public int getAnoReserva() {
        return anoReserva;
    }

    public void setAnoReserva(int anoReserva) {
        this.anoReserva = anoReserva;
    }

    public String getHoraInicialString() {
        return horaInicialString;
    }

    public void setHoraInicialString(String horaInicialString) {
        this.horaInicialString = horaInicialString;
    }

    public String getHoraFinalString() {
        return horaFinalString;
    }

    public void setHoraFinalString(String horaFinalString) {
        this.horaFinalString = horaFinalString;
    }
}
