/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_PACIENTE")
public class LabPaciente implements Serializable{


    @Id
    @Column(name="PAC_IN_CODIGO")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_PAC_IN_CODIGO")
    @SequenceGenerator(name="SEQ_PAC_IN_CODIGO", sequenceName = "SEQ_PAC_IN_CODIGO")
    private Long pacInCodigo;
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="CON_ST_CODIGO")
    @Column(name="CON_ST_CODIGO")
    private String conStCodigo;
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="UNI_ST_CODIGO")
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;


    @Column(name="PAC_ST_NOME")
    private String pacStNome;
    @Column(name="PAC_ST_MATRICULA")
    private String pacStMatricula;
    @Column(name="PAC_DT_NASCIMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pacDtNascimento;
    @Column(name="PAC_DT_VALIDADECARTEIRA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pacDtValidadeCarteira;
    @Column(name="PAC_ST_SEXO")
    private Character pacStSexo;
    @Column(name="PAC_ST_ESTADOCIVIL")
    private String pacStEstadoCivil;
    @Column(name="PAC_ST_RG")
    private String pacStRG;
    @Column(name="PAC_ST_CPF")
    private String pacStCPF;
    @Column(name="PAC_ST_PROFISSAO")
    private String pacStProfissao;
    @Column(name="PAC_ST_EMAIL")
    private String pacStEmail;
    @Column(name="PAC_ST_ENDERECO")
    private String pacStEndereco;
    @Column(name="PAC_ST_BAIRRO")
    private String pacStBairro;
    @Column(name="PAC_ST_CIDADE")
    private String pacStCidade;
    @Column(name="PAC_ST_ESTADO")
    private String pacStEstado;
    @Column(name="PAC_ST_CEP")
    private String pacStCEP;
    @Column(name="PAC_ST_TELEFONE")
    private String pacStTelefone;
    @Column(name="PAC_ST_CELULAR")
    private String pacStCelular;
    @Column(name="PAC_DT_CADASTRO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pacDtCadastro;
    @Column(name="PAC_HR_CADASTRO")
    private Timestamp pacHrCadastro;
    @Column(name="PAC_ST_NUMERO")
    private String pacStNumero;
    @Column(name="PAC_ST_COMPLEMENTO")
    private String pacStComplemento;
    @Column(name="PAC_HR_NASCIMENTO")
    private Timestamp pacHrNascimento;
    @Column(name="PAC_IN_IDADE")
    private Integer pacInIdade;
    @Column(name="PAC_ST_ID")
    private String pacStId;
    @Column(name="PAC_IN_CODSUS")
    private Long pacInCodSUS;
    @Column(name="PAC_ST_TELRESP")
    private String pacStTelResp;
    @Column(name="PAC_ST_RESP")
    private String pacStResp;
    @Column(name="PAC_ST_COR")
    private String pacStCor;
    @Column(name="PAC_ST_PRONTUARIO")
    private String pacStProntuario;
    @Column(name="PAC_ST_PESO")
    private String pacStPeso;
    @Column(name="PAC_ST_ALTURA")
    private String pacStAltura;
    @Lob
    @Column(name="PAC_BL_OBSERVACAO")
    private String pacBlObservacao;
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumns({
//        @JoinColumn(name="SIS_ST_CODIGO"),
//        @JoinColumn(name="UNI_ST_CODIGO")
//    })
//    private LabSistema sisStCodigo;

   






    @OneToMany(mappedBy="pacInCodigo")
    private List<LabAgendaPaciente> listLabAgendaPaciente;

    @OneToMany(mappedBy="pacInCodigo")
    private List<LabRequisicao> listLabRequisicao;

    public List<LabRequisicao> getListLabRequisicao() {
        return listLabRequisicao;
    }

    public void setListLabRequisicao(List<LabRequisicao> listLabRequisicao) {
        this.listLabRequisicao = listLabRequisicao;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }



  
    public String getPacBlObservacao() {
        return pacBlObservacao;
    }

    public void setPacBlObservacao(String pacBlObservacao) {
        this.pacBlObservacao = pacBlObservacao;
    }

    public Date getPacDtCadastro() {
        return pacDtCadastro;
    }

    public void setPacDtCadastro(Date pacDtCadastro) {
        this.pacDtCadastro = pacDtCadastro;
    }

    public Date getPacDtNascimento() {
        return pacDtNascimento;
    }

    public void setPacDtNascimento(Date pacDtNascimento) {
        this.pacDtNascimento = pacDtNascimento;
    }

    public Date getPacDtValidadeCarteira() {
        return pacDtValidadeCarteira;
    }

    public void setPacDtValidadeCarteira(Date pacDtValidadeCarteira) {
        this.pacDtValidadeCarteira = pacDtValidadeCarteira;
    }

    public Timestamp getPacHrCadastro() {
        return pacHrCadastro;
    }

    public void setPacHrCadastro(Timestamp pacHrCadastro) {
        this.pacHrCadastro = pacHrCadastro;
    }

    public Timestamp getPacHrNascimento() {
        return pacHrNascimento;
    }

    public void setPacHrNascimento(Timestamp pacHrNascimento) {
        this.pacHrNascimento = pacHrNascimento;
    }

    public Long getPacInCodSUS() {
        return pacInCodSUS;
    }

    public void setPacInCodSUS(Long pacInCodSUS) {
        this.pacInCodSUS = pacInCodSUS;
    }

    public Long getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(Long pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public Integer getPacInIdade() {
        return pacInIdade;
    }

    public void setPacInIdade(Integer pacInIdade) {
        this.pacInIdade = pacInIdade;
    }

    public String getPacStAltura() {
        return pacStAltura;
    }

    public void setPacStAltura(String pacStAltura) {
        this.pacStAltura = pacStAltura;
    }

    public String getPacStBairro() {
        return pacStBairro;
    }

    public void setPacStBairro(String pacStBairro) {
        this.pacStBairro = pacStBairro;
    }

    public String getPacStCEP() {
        return pacStCEP;
    }

    public void setPacStCEP(String pacStCEP) {
        this.pacStCEP = pacStCEP;
    }

    public String getPacStCPF() {
        return pacStCPF;
    }

    public void setPacStCPF(String pacStCPF) {
        this.pacStCPF = pacStCPF;
    }

    public String getPacStCelular() {
        return pacStCelular;
    }

    public void setPacStCelular(String pacStCelular) {
        this.pacStCelular = pacStCelular;
    }

    public String getPacStCidade() {
        return pacStCidade;
    }

    public void setPacStCidade(String pacStCidade) {
        this.pacStCidade = pacStCidade;
    }

    public String getPacStComplemento() {
        return pacStComplemento;
    }

    public void setPacStComplemento(String pacStComplemento) {
        this.pacStComplemento = pacStComplemento;
    }

    public String getPacStCor() {
        return pacStCor;
    }

    public void setPacStCor(String pacStCor) {
        this.pacStCor = pacStCor;
    }

    public String getPacStEmail() {
        return pacStEmail;
    }

    public void setPacStEmail(String pacStEmail) {
        this.pacStEmail = pacStEmail;
    }

    public String getPacStEndereco() {
        return pacStEndereco;
    }

    public void setPacStEndereco(String pacStEndereco) {
        this.pacStEndereco = pacStEndereco;
    }

    public String getPacStEstado() {
        return pacStEstado;
    }

    public void setPacStEstado(String pacStEstado) {
        this.pacStEstado = pacStEstado;
    }

    public String getPacStEstadoCivil() {
        return pacStEstadoCivil;
    }

    public void setPacStEstadoCivil(String pacStEstadoCivil) {
        this.pacStEstadoCivil = pacStEstadoCivil;
    }

    public String getPacStId() {
        return pacStId;
    }

    public void setPacStId(String pacStId) {
        this.pacStId = pacStId;
    }

    public String getPacStMatricula() {
        return pacStMatricula;
    }

    public void setPacStMatricula(String pacStMatricula) {
        this.pacStMatricula = pacStMatricula;
    }

    public String getPacStNome() {
        return pacStNome;
    }

    public void setPacStNome(String pacStNome) {
        this.pacStNome = pacStNome;
    }

    public String getPacStNumero() {
        return pacStNumero;
    }

    public void setPacStNumero(String pacStNumero) {
        this.pacStNumero = pacStNumero;
    }

    public String getPacStPeso() {
        return pacStPeso;
    }

    public void setPacStPeso(String pacStPeso) {
        this.pacStPeso = pacStPeso;
    }

    public String getPacStProfissao() {
        return pacStProfissao;
    }

    public void setPacStProfissao(String pacStProfissao) {
        this.pacStProfissao = pacStProfissao;
    }

    public String getPacStProntuario() {
        return pacStProntuario;
    }

    public void setPacStProntuario(String pacStProntuario) {
        this.pacStProntuario = pacStProntuario;
    }

    public String getPacStRG() {
        return pacStRG;
    }

    public void setPacStRG(String pacStRG) {
        this.pacStRG = pacStRG;
    }

    public String getPacStResp() {
        return pacStResp;
    }

    public void setPacStResp(String pacStResp) {
        this.pacStResp = pacStResp;
    }

    public Character getPacStSexo() {
        return pacStSexo;
    }

    public void setPacStSexo(Character pacStSexo) {
        this.pacStSexo = pacStSexo;
    }

   

    public String getPacStTelResp() {
        return pacStTelResp;
    }

    public void setPacStTelResp(String pacStTelResp) {
        this.pacStTelResp = pacStTelResp;
    }

    public String getPacStTelefone() {
        return pacStTelefone;
    }

    public void setPacStTelefone(String pacStTelefone) {
        this.pacStTelefone = pacStTelefone;
    }

    public List<LabAgendaPaciente> getListLabAgendaPaciente() {
        return listLabAgendaPaciente;
    }

    public void setListLabAgendaPaciente(List<LabAgendaPaciente> listLabAgendaPaciente) {
        this.listLabAgendaPaciente = listLabAgendaPaciente;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    
   
        @Transient
        public String getPacStNomeResumido(){
            if(pacStNome !=null && pacStNome.length()>21){
                return pacStNome.substring(0, 18)+"...";
            }else{
                return  pacStNome;
            }
        }

    

}
