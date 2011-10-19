/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author eros
 */


@Entity
@Table(name="LAB_EXAMEUNIDADE")
@IdClass(LabExameUnidadePK.class)
public class LabExameUnidade  implements Serializable{

    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;


    @Column(name="MPA_ST_CODIGO")
    private String mpaStCodigo;

    @Column(name="EXU_ST_UNIDADEEX")
    private String exuStUnidadeEx;
    @Column(name="PRA_ST_CODIGO")
    private String praStCodigo;
    @Column(name="SET_ST_CODIGO")
    private String setStCodigo;
    @Column(name="APO_ST_CODIGO")
    private String apoStCodigo;
    @Column(name="EXA_ST_CODIGO")
    private String pexStCodigo;
    @Column(name="REC_ST_COLETA")
    private String recStColeta;
    @Column(name="REC_ST_TRIAGEM")
    private String recStTriagem;
    @Column(name="EXU_FL_VOLUME")
    private Float exuFlVolume;
    @Column(name="EXU_IN_SEQPERFIL")
    private Integer exuInSeqPerfil;
    @Column(name="EXU_ST_COLETASEPARADO")
    private String exuStColetaSeparado;
    @Column(name="EXU_CH_INTEFACE")
    private Character exuChInteface;
    @Column(name="EXU_CH_STATUS")
    private Character exuChStatus;
    @Column(name="EXU_ST_UNIDADEEXURGENTE")
    private String exuStUnidadeExUrgente;
    @Column(name="EXU_IN_SEQMAPAAMOSTRA")
    private Integer exuINSeqMapaAmostra;
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Column(name="EXU_ST_PRAZOURGENTE")
    private String exuStPrazoUrgente;
    @Column(name="EXU_IN_ULTIMO")
    private Integer exuInUltimo;
    @Column(name="GRU_ST_CODSUS")
    private String gruStCodSUS;
    @Column(name="EXU_CH_SOFATURAMENTO")
    private Character exuChSoFaturamento;
    @Column(name="EXU_CH_NAONECESSARIO")
    private Character exuChNaoNecessario;
    @Column(name="EXU_CH_OMITEINTERFACE")
    private Character exuChOmiteInterface;
    @Column(name="EXU_CH_INATIVO")
    private Character exuChInativo;
    @Column(name="EXU_CH_INGRESSONAOTRIADO")
    private Character exuChIngressoNaoTriado;
    @Column(name="EXU_CH_OBRIGAMATERIAL")
    private Character exuChObrigaMaterial;
    @Column(name="EXU_CH_VOLUME")
    private Character exuChVolume;
    @Column(name="EXU_CH_ESPECIAL")
    private Character exuChEspecial;
    @Column(name="EXU_CH_INGRESSOAUTO")
    private Character exuChIngressoAuto;
    @Column(name="EXU_ST_USUARIOINGRESSO")
    private String exuStUsuarioIngresso;
    @Column(name="EXU_CH_FATURAGRUPO")
    private Character exuChFaturaGrupo;
    @Column(name="RCC_IN_CODIGO")
    private Long rccInCodigo;
    @Column(name="EXU_ST_PRAZOTRANSPORTE")
    private String exuStPrazoTransporte;
    @Column(name="EXU_CH_FATURA")
    private Character exuChFatura;
    @Column(name="EXU_CH_LIBERAINGRESSOMANUAL")
    private Character exuChLiberaIngressoManual;
    @Column(name="EXU_CH_PARCIALAUTO")
    private Character exuChParcialAuto;
    @Column(name="EXU_CH_PREINGRESSO")
    private Character exuChPreIngresso;
    @Column(name="SUB_ST_CODIGO")
    private String subStCodigo;
    @Column(name="EXU_CH_AGENDA")
    private Character exuChAgenda;
    @Column(name="EXU_CH_CONFEREAUTOMATICOFAT")
    private Character exuChConfereAutomaticoFat;
    @Column(name="EXU_ST_UNIDADEEXREVISAO")
    private String exuStUnidadeExRevisao;
    @Column(name="EXU_CH_PREPARO")
    private Character exuChPreparo;
    @Column(name="EXU_ST_TITULO")
    private String exuStTitulo;
    @Column(name="EXU_IN_TITULO")
    private Integer exuIntitulo;
    @Column(name="EXU_CH_REVISAO")
    private Character exuChRevisao;
    @Column(name="EXU_CH_OBRIGAGESTANTE")
    private Character exuChObrigaGestante;
    @Column(name="EXU_CH_SEXO")
    private Character exuChSexo;
    @Column(name="EXU_CH_TEMPO")
    private Character exuChTempo;

    public LabExameUnidade() {
    }

    public String getApoStCodigo() {
        return apoStCodigo;
    }

    public void setApoStCodigo(String apoStCodigo) {
        this.apoStCodigo = apoStCodigo;
    }

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public Character getExuChAgenda() {
        return exuChAgenda;
    }

    public void setExuChAgenda(Character exuChAgenda) {
        this.exuChAgenda = exuChAgenda;
    }

    public Character getExuChConfereAutomaticoFat() {
        return exuChConfereAutomaticoFat;
    }

    public void setExuChConfereAutomaticoFat(Character exuChConfereAutomaticoFat) {
        this.exuChConfereAutomaticoFat = exuChConfereAutomaticoFat;
    }

    public Character getExuChEspecial() {
        return exuChEspecial;
    }

    public void setExuChEspecial(Character exuChEspecial) {
        this.exuChEspecial = exuChEspecial;
    }

    public Character getExuChFatura() {
        return exuChFatura;
    }

    public void setExuChFatura(Character exuChFatura) {
        this.exuChFatura = exuChFatura;
    }

    public Character getExuChFaturaGrupo() {
        return exuChFaturaGrupo;
    }

    public void setExuChFaturaGrupo(Character exuChFaturaGrupo) {
        this.exuChFaturaGrupo = exuChFaturaGrupo;
    }

    public Character getExuChInativo() {
        return exuChInativo;
    }

    public void setExuChInativo(Character exuChInativo) {
        this.exuChInativo = exuChInativo;
    }

    public Character getExuChIngressoAuto() {
        return exuChIngressoAuto;
    }

    public void setExuChIngressoAuto(Character exuChIngressoAuto) {
        this.exuChIngressoAuto = exuChIngressoAuto;
    }

    public Character getExuChIngressoNaoTriado() {
        return exuChIngressoNaoTriado;
    }

    public void setExuChIngressoNaoTriado(Character exuChIngressoNaoTriado) {
        this.exuChIngressoNaoTriado = exuChIngressoNaoTriado;
    }

    public Character getExuChInteface() {
        return exuChInteface;
    }

    public void setExuChInteface(Character exuChInteface) {
        this.exuChInteface = exuChInteface;
    }

    

    public Character getExuChLiberaIngressoManual() {
        return exuChLiberaIngressoManual;
    }

    public void setExuChLiberaIngressoManual(Character exuChLiberaIngressoManual) {
        this.exuChLiberaIngressoManual = exuChLiberaIngressoManual;
    }

    public Character getExuChNaoNecessario() {
        return exuChNaoNecessario;
    }

    public void setExuChNaoNecessario(Character exuChNaoNecessario) {
        this.exuChNaoNecessario = exuChNaoNecessario;
    }

    public Character getExuChObrigaGestante() {
        return exuChObrigaGestante;
    }

    public void setExuChObrigaGestante(Character exuChObrigaGestante) {
        this.exuChObrigaGestante = exuChObrigaGestante;
    }

    public Character getExuChObrigaMaterial() {
        return exuChObrigaMaterial;
    }

    public void setExuChObrigaMaterial(Character exuChObrigaMaterial) {
        this.exuChObrigaMaterial = exuChObrigaMaterial;
    }

    public Character getExuChOmiteInterface() {
        return exuChOmiteInterface;
    }

    public void setExuChOmiteInterface(Character exuChOmiteInterface) {
        this.exuChOmiteInterface = exuChOmiteInterface;
    }

    public Character getExuChParcialAuto() {
        return exuChParcialAuto;
    }

    public void setExuChParcialAuto(Character exuChParcialAuto) {
        this.exuChParcialAuto = exuChParcialAuto;
    }

    public Character getExuChPreIngresso() {
        return exuChPreIngresso;
    }

    public void setExuChPreIngresso(Character exuChPreIngresso) {
        this.exuChPreIngresso = exuChPreIngresso;
    }

    public Character getExuChPreparo() {
        return exuChPreparo;
    }

    public void setExuChPreparo(Character exuChPreparo) {
        this.exuChPreparo = exuChPreparo;
    }

    public Character getExuChRevisao() {
        return exuChRevisao;
    }

    public void setExuChRevisao(Character exuChRevisao) {
        this.exuChRevisao = exuChRevisao;
    }

    public Character getExuChSexo() {
        return exuChSexo;
    }

    public void setExuChSexo(Character exuChSexo) {
        this.exuChSexo = exuChSexo;
    }

    public Character getExuChSoFaturamento() {
        return exuChSoFaturamento;
    }

    public void setExuChSoFaturamento(Character exuChSoFaturamento) {
        this.exuChSoFaturamento = exuChSoFaturamento;
    }

    public Character getExuChStatus() {
        return exuChStatus;
    }

    public void setExuChStatus(Character exuChStatus) {
        this.exuChStatus = exuChStatus;
    }

    public Character getExuChTempo() {
        return exuChTempo;
    }

    public void setExuChTempo(Character exuChTempo) {
        this.exuChTempo = exuChTempo;
    }

    public Character getExuChVolume() {
        return exuChVolume;
    }

    public void setExuChVolume(Character exuChVolume) {
        this.exuChVolume = exuChVolume;
    }

    public Float getExuFlVolume() {
        return exuFlVolume;
    }

    public void setExuFlVolume(Float exuFlVolume) {
        this.exuFlVolume = exuFlVolume;
    }

    public Integer getExuINSeqMapaAmostra() {
        return exuINSeqMapaAmostra;
    }

    public void setExuINSeqMapaAmostra(Integer exuINSeqMapaAmostra) {
        this.exuINSeqMapaAmostra = exuINSeqMapaAmostra;
    }

    public Integer getExuInSeqPerfil() {
        return exuInSeqPerfil;
    }

    public void setExuInSeqPerfil(Integer exuInSeqPerfil) {
        this.exuInSeqPerfil = exuInSeqPerfil;
    }

    public Integer getExuInUltimo() {
        return exuInUltimo;
    }

    public void setExuInUltimo(Integer exuInUltimo) {
        this.exuInUltimo = exuInUltimo;
    }

    public Integer getExuIntitulo() {
        return exuIntitulo;
    }

    public void setExuIntitulo(Integer exuIntitulo) {
        this.exuIntitulo = exuIntitulo;
    }

    public String getExuStColetaSeparado() {
        return exuStColetaSeparado;
    }

    public void setExuStColetaSeparado(String exuStColetaSeparado) {
        this.exuStColetaSeparado = exuStColetaSeparado;
    }

    public String getExuStPrazoTransporte() {
        return exuStPrazoTransporte;
    }

    public void setExuStPrazoTransporte(String exuStPrazoTransporte) {
        this.exuStPrazoTransporte = exuStPrazoTransporte;
    }

    public String getExuStPrazoUrgente() {
        return exuStPrazoUrgente;
    }

    public void setExuStPrazoUrgente(String exuStPrazoUrgente) {
        this.exuStPrazoUrgente = exuStPrazoUrgente;
    }

    public String getExuStTitulo() {
        return exuStTitulo;
    }

    public void setExuStTitulo(String exuStTitulo) {
        this.exuStTitulo = exuStTitulo;
    }

    public String getExuStUnidadeEx() {
        return exuStUnidadeEx;
    }

    public void setExuStUnidadeEx(String exuStUnidadeEx) {
        this.exuStUnidadeEx = exuStUnidadeEx;
    }

    public String getExuStUnidadeExRevisao() {
        return exuStUnidadeExRevisao;
    }

    public void setExuStUnidadeExRevisao(String exuStUnidadeExRevisao) {
        this.exuStUnidadeExRevisao = exuStUnidadeExRevisao;
    }

    public String getExuStUnidadeExUrgente() {
        return exuStUnidadeExUrgente;
    }

    public void setExuStUnidadeExUrgente(String exuStUnidadeExUrgente) {
        this.exuStUnidadeExUrgente = exuStUnidadeExUrgente;
    }

    public String getExuStUsuarioIngresso() {
        return exuStUsuarioIngresso;
    }

    public void setExuStUsuarioIngresso(String exuStUsuarioIngresso) {
        this.exuStUsuarioIngresso = exuStUsuarioIngresso;
    }

    public String getGruStCodSUS() {
        return gruStCodSUS;
    }

    public void setGruStCodSUS(String gruStCodSUS) {
        this.gruStCodSUS = gruStCodSUS;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public String getMpaStCodigo() {
        return mpaStCodigo;
    }

    public void setMpaStCodigo(String mpaStCodigo) {
        this.mpaStCodigo = mpaStCodigo;
    }

    public String getPexStCodigo() {
        return pexStCodigo;
    }

    public void setPexStCodigo(String pexStCodigo) {
        this.pexStCodigo = pexStCodigo;
    }

    public String getPraStCodigo() {
        return praStCodigo;
    }

    public void setPraStCodigo(String praStCodigo) {
        this.praStCodigo = praStCodigo;
    }

    public Long getRccInCodigo() {
        return rccInCodigo;
    }

    public void setRccInCodigo(Long rccInCodigo) {
        this.rccInCodigo = rccInCodigo;
    }

    public String getRecStColeta() {
        return recStColeta;
    }

    public void setRecStColeta(String recStColeta) {
        this.recStColeta = recStColeta;
    }

   
    public String getRecStTriagem() {
        return recStTriagem;
    }

    public void setRecStTriagem(String recStTriagem) {
        this.recStTriagem = recStTriagem;
    }
    

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public String getSubStCodigo() {
        return subStCodigo;
    }

    public void setSubStCodigo(String subStCodigo) {
        this.subStCodigo = subStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }


    



}
