package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.com.jcaguiar.ecommerce.util.DataFormato;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jcaguiar.ecommerce.Proprietario;
import br.com.jcaguiar.ecommerce.projection.MasterGET;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "nota_fiscal")
final public class NotaFiscal implements Entidade<Long>, MasterGET {

	//TODO: descobrir quais campos são oficialmente obrigatórios numa NF!

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY) @JsonIgnore
	Long id;
	
	//INFORMAÇÕES DA NOTA
	@Column(nullable = false, unique = true) String arquivoXml;
	@Column(nullable = false) String numero;
	@Column(nullable = false) String serie;
	boolean nf_saida = true;  //false = ENTRADA[0]; true = SAÍDA[1]
	@Temporal(TemporalType.DATE) LocalDateTime dataEmissao = DataFormato.now();
	@Column(nullable = false) LocalDateTime dataVencimento;
	String nop;
	@Column(nullable = false) BigDecimal total;
	
	//INFORMAÇÕES DO EMISSOR
	final String emissorNome = Proprietario.NOME;
	final String emissorDocumento = Proprietario.DOCUMENTO;
	final String emissorInscEstadual = Proprietario.INSCRICAO_ESTADUAL;
	final String emissorEndereco = Proprietario.ENDERECO;
	final String emissorBairro = Proprietario.BAIRRO;
	final String emissorCep = Proprietario.CEP;
	final String emissorCidade = Proprietario.CIDADE;
	final String emissorUf = Proprietario.UF;
	final String emissorContato = Proprietario.TELEFONE;
	
	//INFORMAÇÕES DO DESTINATÁRIO
	@ManyToOne(fetch = FetchType.LAZY) Cliente destinatario;
	@Column(nullable = false) String destinatarioNome;
	@Column(nullable = false) String destinatarioDocumento;
	@Column(nullable = false) String destinatarioEndereco;
	@Column(nullable = false) String destinatarioBairro;
	@Column(nullable = false) String destinatarioCep;
	@Column(nullable = false) String destinatarioCidade;
	@Column(nullable = false) String destinatarioUf;
	String destinatarioComplemento;
	String destinatarioInscEstadual;
	
	//INFORMAÇÕES DO TRANSPORTADOR
	@ManyToOne(fetch = FetchType.LAZY) Transportador transportador;
	@Column(nullable = false) String transportadorNome;
	@Column(nullable = false) String transportadorFrete;
	@Column(nullable = false) String transportadorPlaca;
	@Column(nullable = false) String transportadorDocumento;
	@Column(nullable = false) String transportadorEndereco;
	@Column(nullable = false) String transportadorCidade;
	@Column(nullable = false) String transportadorUf;
	String transportadorInscEstadual;
	
	//INFORMAÇÕES GERAIS DA MERCADORIA
	@ManyToOne(fetch = FetchType.LAZY) Pedido pedido;
	@OneToMany(fetch = FetchType.LAZY)  @Column(nullable = false) final List<PedidoItem> mercadoria = new ArrayList<>();
	@Column(nullable = false) String mercadoriaEspecie;
	@Column(nullable = false) String mercadoriaNumeracao;
	@Column(nullable = false) Double mercadoriaPesoBruto;
	@Column(nullable = false) Double mercadoriaPesoLiquido;
	
	//INFORMAÇÕES DE CADA MERCADORIA
//	List<String> mercadoriaCodigo = new ArrayList<>();
//	List<String> mercadoriaDescricao = new ArrayList<>();
//	List<String> mercadoriaNcm = new ArrayList<>();
//	List<String> mercadoriaCst = new ArrayList<>();
//	List<String> mercadoriaCfop = new ArrayList<>();
//	List<String> mercadoriaUn = new ArrayList<>();
//	List<Short> mercadoriaQunantidade = new ArrayList<>();
//	List<BigDecimal> mercadoriaValorUnitario = new ArrayList<>();
//	List<BigDecimal> mercadoriaValorTotal = new ArrayList<>();
//	List<BigDecimal> mercadoriaIcmsBase = new ArrayList<>();
//	List<BigDecimal> mercadoriaIcmsTotal = new ArrayList<>();
//	List<BigDecimal> mercadoriaIcmsAliquota = new ArrayList<>();
//	List<BigDecimal> mercadoriaIpi = new ArrayList<>();
//	List<BigDecimal> mercadoriaIpiAliquota = new ArrayList<>();
}
