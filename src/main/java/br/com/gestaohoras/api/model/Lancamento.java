package br.com.gestaohoras.api.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.gestaohoras.api.enums.PeriodoEnum;
import br.com.gestaohoras.api.enums.TipoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TLANCAMENTOS", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"dt_lancamento", "ie_periodo", "ie_lancamento", "cd_funcionario" }))
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nr_sequencia")
	private Long id;

	@Column(name = "dt_lancamento", nullable = false)
	private LocalDate data;

	@Column(name = "ie_periodo", nullable = false)
	private PeriodoEnum periodo;

	@Column(name = "dt_registro", nullable = false)
	private Instant dataRegistro;

	@Column(name = "dt_alteracao")
	private Instant dataAlteracao;

	@Column(name = "ie_lancamento", nullable = false)
	private TipoEnum tipoLancamento;

	@Column(name = "hr_lancamento", nullable = false)
	private LocalTime horario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_funcionario")
	private Funcionario funcionario;

	public Lancamento(LocalDate data, PeriodoEnum periodo, Instant dataRegistro, Instant dataAlteracao,
			TipoEnum tipoLancamento, Funcionario funcionario, LocalTime horario) {
		this.data = data;
		this.periodo = periodo;
		this.dataRegistro = dataRegistro;
		this.dataAlteracao = dataAlteracao;
		this.tipoLancamento = tipoLancamento;
		this.funcionario = funcionario;
		this.horario = horario;
	}
}
