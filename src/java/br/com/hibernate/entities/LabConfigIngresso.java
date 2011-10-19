/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_CONFIGINGRESSO")
@IdClass(LabConfigIngressoPK.class)
public class LabConfigIngresso implements Serializable{

    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Id
    @Column(name="EMV_DT_VALIDADE")
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.sql.Timestamp emvDtValidade;
    @Id
    @Column(name="CIN_ST_CODIGO")
    private String cinStCodigo;

   


    @Column(name="CIN_ST_TIPORESULTADO")
    private String cinStTipoResultado;
    @Column(name="CIN_IN_DECIMAIS")
    private Integer cinInRecimais;
    @Column(name="CIN_ST_SUGERE")
    private String cinStSugere;;
    @Column(name="CIN_ST_DESCRICAO")
    private String cinStDescricao;
    @Column(name="CIN_IN_SEQUENCIA")
    private Integer cinInSequencia;
    @Column(name="UNM_ST_CODIGO")
    private String unmStCodigo;
    @Column(name="CIN_ST_EXAMELIS")
    private String cinStExameLis;
    @Column(name="CIN_ST_EXAMEEQ")
    private String cinStExameEq;



    @Column(name="CIN_ST_COMPLEMENTO")
    private String cinStComplemento;
    @Column(name="CIN_ST_CHECKFORMULA")
    private String cinStCheckFormula;
    @Column(name="CIN_CH_ENVIAPARAMETRO")
    private Character cinChEnviaParametro;
    @Column(name="CIN_CH_ATIVO")
    private Character cinChAtivo;
    @Column(name="CIN_CH_LIBERA")
    private Character cinChLibera;
    @Column(name="CIN_CH_BLOQUEIA")
    private Character cinChBloqueia;
    @Column(name="CIN_CH_MARCA")
    private Character cinChMarca;
    @Column(name="CIN_CH_ACAOSN")
    private Character cinChAcaoSn;
    @Column(name="CIN_CH_IMPRIME")
    private Character cinChImprime;
    @Column(name="CIN_BL_ACAO")
    private String cinBlAcao;
    @Column(name="CIN_IN_SEQLIS")
    private Long cinInSeqLis;
    @Column(name="CIN_ST_FORMULA")
    private String cinStFormula;
    @Column(name="CIN_BL_FORMULA")
    private String cinBlFormula;
    @Column(name="CIN_BL_CHECKFORMULA")
    private String cinBlCheckFormula;
    @Column(name="CIN_ST_ULTIMO")
    private Character cinStUltimo;
    @Column(name="CIN_CH_OBRIGATORIO")
    private Character cinChObrigatorio;
    @Column(name="CIN_CL_ACAO")
    private String cinClAcao;
    @Column(name="CIN_CL_FORMULA")
    private String cinClFormula;
    @Column(name="CIN_CL_CHECKFORMULA")
    private String cinClCheckFormula;
    @Column(name="CIN_CH_PRINCIPAL")
    private Character cinClPrincipal;



    public String getCinBlAcao() {
        return cinBlAcao;
    }

    public void setCinBlAcao(String cinBlAcao) {
        this.cinBlAcao = cinBlAcao;
    }

    public Character getCinChAcaoSn() {
        return cinChAcaoSn;
    }

    public void setCinChAcaoSn(Character cinChAcaoSn) {
        this.cinChAcaoSn = cinChAcaoSn;
    }

    public Character getCinChAtivo() {
        return cinChAtivo;
    }

    public void setCinChAtivo(Character cinChAtivo) {
        this.cinChAtivo = cinChAtivo;
    }

    public Character getCinChBloqueia() {
        return cinChBloqueia;
    }

    public void setCinChBloqueia(Character cinChBloqueia) {
        this.cinChBloqueia = cinChBloqueia;
    }

    public Character getCinChEnviaParametro() {
        return cinChEnviaParametro;
    }

    public void setCinChEnviaParametro(Character cinChEnviaParametro) {
        this.cinChEnviaParametro = cinChEnviaParametro;
    }

    public Character getCinChImprime() {
        return cinChImprime;
    }

    public void setCinChImprime(Character cinChImprime) {
        this.cinChImprime = cinChImprime;
    }

    public Character getCinChLibera() {
        return cinChLibera;
    }

    public void setCinChLibera(Character cinChLibera) {
        this.cinChLibera = cinChLibera;
    }

    public Character getCinChMarca() {
        return cinChMarca;
    }

    public void setCinChMarca(Character cinChMarca) {
        this.cinChMarca = cinChMarca;
    }

    public Integer getCinInRecimais() {
        return cinInRecimais;
    }

    public void setCinInRecimais(Integer cinInRecimais) {
        this.cinInRecimais = cinInRecimais;
    }

    public Long getCinInSeqLis() {
        return cinInSeqLis;
    }

    public void setCinInSeqLis(Long cinInSeqLis) {
        this.cinInSeqLis = cinInSeqLis;
    }

    public Integer getCinInSequencia() {
        return cinInSequencia;
    }

    public void setCinInSequencia(Integer cinInSequencia) {
        this.cinInSequencia = cinInSequencia;
    }

    public String getCinStCheckFormula() {
        return cinStCheckFormula;
    }

    public void setCinStCheckFormula(String cinStCheckFormula) {
        this.cinStCheckFormula = cinStCheckFormula;
    }

    public String getCinStCodigo() {
        return cinStCodigo;
    }

    public void setCinStCodigo(String cinStCodigo) {
        this.cinStCodigo = cinStCodigo;
    }

    public String getCinStComplemento() {
        return cinStComplemento;
    }

    public void setCinStComplemento(String cinStComplemento) {
        this.cinStComplemento = cinStComplemento;
    }

    public String getCinStDescricao() {
        return cinStDescricao;
    }

    public void setCinStDescricao(String cinStDescricao) {
        this.cinStDescricao = cinStDescricao;
    }

    public String getCinStExameEq() {
        return cinStExameEq;
    }

    public void setCinStExameEq(String cinStExameEq) {
        this.cinStExameEq = cinStExameEq;
    }

    public String getCinStExameLis() {
        return cinStExameLis;
    }

    public void setCinStExameLis(String cinStExameLis) {
        this.cinStExameLis = cinStExameLis;
    }

    public String getCinStSugere() {
        return cinStSugere;
    }

    public void setCinStSugere(String cinStSugere) {
        this.cinStSugere = cinStSugere;
    }

    public String getCinStTipoResultado() {
        return cinStTipoResultado;
    }

    public void setCinStTipoResultado(String cinStTipoResultado) {
        this.cinStTipoResultado = cinStTipoResultado;
    }

    public Timestamp getEmvDtValidade() {
        return emvDtValidade;
    }

    public void setEmvDtValidade(Timestamp emvDtValidade) {
        this.emvDtValidade = emvDtValidade;
    }

  

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public String getUnmStCodigo() {
        return unmStCodigo;
    }

    public void setUnmStCodigo(String unmStCodigo) {
        this.unmStCodigo = unmStCodigo;
    }

    public String getCinBlCheckFormula() {
        return cinBlCheckFormula;
    }

    public void setCinBlCheckFormula(String cinBlCheckFormula) {
        this.cinBlCheckFormula = cinBlCheckFormula;
    }

    public String getCinBlFormula() {
        return cinBlFormula;
    }

    public void setCinBlFormula(String cinBlFormula) {
        this.cinBlFormula = cinBlFormula;
    }

    public Character getCinChObrigatorio() {
        return cinChObrigatorio;
    }

    public void setCinChObrigatorio(Character cinChObrigatorio) {
        this.cinChObrigatorio = cinChObrigatorio;
    }

    public String getCinClAcao() {
        return cinClAcao;
    }

    public void setCinClAcao(String cinClAcao) {
        this.cinClAcao = cinClAcao;
    }

    public String getCinClCheckFormula() {
        return cinClCheckFormula;
    }

    public void setCinClCheckFormula(String cinClCheckFormula) {
        this.cinClCheckFormula = cinClCheckFormula;
    }

    public String getCinClFormula() {
        return cinClFormula;
    }

    public void setCinClFormula(String cinClFormula) {
        this.cinClFormula = cinClFormula;
    }

    public Character getCinClPrincipal() {
        return cinClPrincipal;
    }

    public void setCinClPrincipal(Character cinClPrincipal) {
        this.cinClPrincipal = cinClPrincipal;
    }

    public String getCinStFormula() {
        return cinStFormula;
    }

    public void setCinStFormula(String cinStFormula) {
        this.cinStFormula = cinStFormula;
    }

    public Character getCinStUltimo() {
        return cinStUltimo;
    }

    public void setCinStUltimo(Character cinStUltimo) {
        this.cinStUltimo = cinStUltimo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabConfigIngresso other = (LabConfigIngresso) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.metStCodigo == null) ? (other.metStCodigo != null) : !this.metStCodigo.equals(other.metStCodigo)) {
            return false;
        }
        if (this.emvDtValidade != other.emvDtValidade && (this.emvDtValidade == null || !this.emvDtValidade.equals(other.emvDtValidade))) {
            return false;
        }
        if ((this.cinStCodigo == null) ? (other.cinStCodigo != null) : !this.cinStCodigo.equals(other.cinStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 67 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 67 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        hash = 67 * hash + (this.cinStCodigo != null ? this.cinStCodigo.hashCode() : 0);
        return hash;
    }

    

  
    

}
