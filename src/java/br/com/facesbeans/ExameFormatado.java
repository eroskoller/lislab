/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.facesbeans;


import br.com.hibernate.entities.LabExame;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author eros
 */
public class ExameFormatado {

    protected Float tabFlQtDeCh;
    protected Float rtpFlValorCh;
    protected Float  rtpFlValorChExterno;
    protected Float  rtpFlDesconto;
    protected Float  rtpFlDescontoExterno;
    protected Float  rtpFlAcrescimo;
    protected String tapStCodigo;
    protected String tapStDescricao;
    protected Character regChObrigatorioNumGuia;
    protected String tabStCodigo;
    protected String tabStDescricao;
    protected Float etpFlValorDifenciado;
    protected Float etpFlValorDifenciadoExterno;
    protected Float ediFlDesconto;
    protected Float ediFlDescontoExterno;
    protected Character etpChComAutorizacao;
    protected Character etpChNaoAutorizado;
    protected String matStCodigo;
    protected String matStDescricao;
    protected Character exaChObrigatorioPeso;
    protected Character exaChObrigatorioAltura;
    protected Character exaChObrigaGestante;
    protected Character exaChSexo;
    protected String mpaStCodigo;
    protected String exaStDescricao;
    protected String exaStGrupo;
    protected String metStCodigo;
    protected String metStCodigoGrp;
    protected String metStDescricao;
    protected java.sql.Timestamp exmDtValidade;
    protected Character exuChStatus;
    protected Character exuChFatura;
    protected Character exaChInativo;
    protected Character exuChInativo;
    protected Character exuChPreparo;
    protected Character exuChObrigaMaterial;
    protected String praStCodigo;
    protected Integer praInDias;
    protected Character praChDomingo;
    protected Character praChSegunda;
    protected Character praChTerca;
    protected Character praChQuarta;
    protected Character praChQuinta;
    protected Character praChSexta;
    protected Character praChSabado;
    protected Date praHrFinal;
    protected Integer praInHoras;
    protected Integer praInHorasU;
    protected Integer praInDiasU;
    protected Character praChSegundaU;
    protected Character praChTercaU;
    protected Character praChQuartaU;
    protected Character praChQuintaU;
    protected Character praChSextaU;
    protected Character praChSabadoU;
    protected Character praChDomingoU;
    protected Date praHrFinalU;
    protected String exuStPrazoUrgente;
    protected Character exuChNaoNecessario;
    protected String oriStCodigo;
    protected Character oriChUrgencia;
    protected String legStCogioInicial;
    protected Character oriChConfereAutomatico;
    protected Character oriChConfereAutomaticoFat;
    protected String setStCodigo;
    protected String exuStUnidadeEx;
    protected String exuStUnidadeExUrgente;
    protected Character exuChConfereAutomaticoFat;
    protected String depStCodigo;
    protected LabExame exaStCodigo;
    protected String seqStCodigo;

    public ExameFormatado() {
    }


    

    public ExameFormatado(Float tabFlQtDeCh, Float rtpFlValorCh, Float rtpFlValorChExterno, Float rtpFlDesconto,
            Float rtpFlDescontoExterno, Float rtpFlAcrescimo, String tapStCodigo, Character regChObrigatorioNumGuia,
            String tabStCodigo, String tabStDescricao, Float etpFlValorDifenciado, Float etpFlValorDifenciadoExterno,
            Float ediFlDesconto, Float ediFlDescontoExterno, Character etpChComAutorizacao, Character etpChNaoAutorizado,
            String matStCodigo, String matStDescricao, Character exaChObrigatorioPeso, Character exaChObrigatorioAltura, Character exaChObrigaGestante,
            Character exaChSexo, String mpaStCodigo, String exaStDescricao, String exaStGrupo, String metStCodigo, String metStDescricao,java.sql.Timestamp exmDtValidade, Character exuChStatus, Character exuChFatura, Character exaChInativo, Character exuChInativo, Character exuChPreparo, Character exuChObrigaMaterial, String praStCodigo, Integer praInDias, Character praChDomingo, Character praChSegunda, Character praChTerca, Character praChQuarta, Character praChQuinta, Character praChSexta, Character praChSabado, Date praHrFinal, Integer praInHoras, Integer praInHorasU, Integer praInDiasU, Character praChSegundaU, Character praChTercaU, Character praChQuartaU, Character praChQuintaU, Character praChSextaU, Character praChSabadoU, Character praChDomingoU, Date praHrFinalU, String exuStPrazoUrgente, Character exuChNaoNecessario, String oriStCodigo, Character oriChUrgencia, String legStCogioInicial, Character oriChConfereAutomatico, Character oriChConfereAutomaticoFat, String setStCodigo, String exuStUnidadeEx, String exuStUnidadeExUrgente, Character exuChConfereAutomaticoFat, String depStCodigo) {
        this.tabFlQtDeCh = tabFlQtDeCh;
        this.rtpFlValorCh = rtpFlValorCh;
        this.rtpFlValorChExterno = rtpFlValorChExterno;
        this.rtpFlDesconto = rtpFlDesconto;
        this.rtpFlDescontoExterno = rtpFlDescontoExterno;
        this.rtpFlAcrescimo = rtpFlAcrescimo;
        this.tapStCodigo = tapStCodigo;
        this.regChObrigatorioNumGuia = regChObrigatorioNumGuia;
        this.tabStCodigo = tabStCodigo;
        this.tabStDescricao = tabStDescricao;
        this.etpFlValorDifenciado = etpFlValorDifenciado;
        this.etpFlValorDifenciadoExterno = etpFlValorDifenciadoExterno;
        this.ediFlDesconto = ediFlDesconto;
        this.ediFlDescontoExterno = ediFlDescontoExterno;
        this.etpChComAutorizacao = etpChComAutorizacao;
        this.etpChNaoAutorizado = etpChNaoAutorizado;
        this.matStCodigo = matStCodigo;
        this.matStDescricao = matStDescricao;
        this.exaChObrigatorioPeso = exaChObrigatorioPeso;
        this.exaChObrigatorioAltura = exaChObrigatorioAltura;
        this.exaChObrigaGestante = exaChObrigaGestante;
        this.exaChSexo = exaChSexo;
        this.mpaStCodigo = mpaStCodigo;
        this.exaStDescricao = exaStDescricao;
        this.exaStGrupo = exaStGrupo;
        this.metStCodigo = metStCodigo;
        this.metStDescricao = metStDescricao;
        this.exmDtValidade = exmDtValidade;
        this.exuChStatus = exuChStatus;
        this.exuChFatura = exuChFatura;
        this.exaChInativo = exaChInativo;
        this.exuChInativo = exuChInativo;
        this.exuChPreparo = exuChPreparo;
        this.exuChObrigaMaterial = exuChObrigaMaterial;
        this.praStCodigo = praStCodigo;
        this.praInDias = praInDias;
        this.praChDomingo = praChDomingo;
        this.praChSegunda = praChSegunda;
        this.praChTerca = praChTerca;
        this.praChQuarta = praChQuarta;
        this.praChQuinta = praChQuinta;
        this.praChSexta = praChSexta;
        this.praChSabado = praChSabado;
        this.praHrFinal = praHrFinal;
        this.praInHoras = praInHoras;
        this.praInHorasU = praInHorasU;
        this.praInDiasU = praInDiasU;
        this.praChSegundaU = praChSegundaU;
        this.praChTercaU = praChTercaU;
        this.praChQuartaU = praChQuartaU;
        this.praChQuintaU = praChQuintaU;
        this.praChSextaU = praChSextaU;
        this.praChSabadoU = praChSabadoU;
        this.praChDomingoU = praChDomingoU;
        this.praHrFinalU = praHrFinalU;
        this.exuStPrazoUrgente = exuStPrazoUrgente;
        this.exuChNaoNecessario = exuChNaoNecessario;
        this.oriStCodigo = oriStCodigo;
        this.oriChUrgencia = oriChUrgencia;
        this.legStCogioInicial = legStCogioInicial;
        this.oriChConfereAutomatico = oriChConfereAutomatico;
        this.oriChConfereAutomaticoFat = oriChConfereAutomaticoFat;
        this.setStCodigo = setStCodigo;
        this.exuStUnidadeEx = exuStUnidadeEx;
        this.exuStUnidadeExUrgente = exuStUnidadeExUrgente;
        this.exuChConfereAutomaticoFat = exuChConfereAutomaticoFat;
        this.depStCodigo = depStCodigo;
    }



    


    public String getDepStCodigo() {
        return depStCodigo;
    }

    public void setDepStCodigo(String depStCodigo) {
        this.depStCodigo = depStCodigo;
    }

    public Float getEdiFlDesconto() {
        return ediFlDesconto;
    }

    public void setEdiFlDesconto(Float ediFlDesconto) {
        this.ediFlDesconto = ediFlDesconto;
    }

    public Float getEdiFlDescontoExterno() {
        return ediFlDescontoExterno;
    }

    public void setEdiFlDescontoExterno(Float ediFlDescontoExterno) {
        this.ediFlDescontoExterno = ediFlDescontoExterno;
    }

    public Character getEtpChComAutorizacao() {
        return etpChComAutorizacao;
    }

    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    public void setEtpChComAutorizacao(Character etpChComAutorizacao) {
        this.etpChComAutorizacao = etpChComAutorizacao;
    }

    public Character getEtpChNaoAutorizado() {
        return etpChNaoAutorizado;
    }

    public void setEtpChNaoAutorizado(Character etpChNaoAutorizado) {
        this.etpChNaoAutorizado = etpChNaoAutorizado;
    }

    public Float getEtpFlValorDifenciado() {
        return etpFlValorDifenciado;
    }

    public String getTapStDescricao() {
        return tapStDescricao;
    }

    public void setTapStDescricao(String tapStDescricao) {
        this.tapStDescricao = tapStDescricao;
    }

    public void setEtpFlValorDifenciado(Float etpFlValorDifenciado) {
        this.etpFlValorDifenciado = etpFlValorDifenciado;
    }

    public Float getEtpFlValorDifenciadoExterno() {
        return etpFlValorDifenciadoExterno;
    }

    public void setEtpFlValorDifenciadoExterno(Float etpFlValorDifenciadoExterno) {
        this.etpFlValorDifenciadoExterno = etpFlValorDifenciadoExterno;
    }

    public Character getExaChInativo() {
        return exaChInativo;
    }

    public void setExaChInativo(Character exaChInativo) {
        this.exaChInativo = exaChInativo;
    }

    public Character getExaChObrigaGestante() {
        return exaChObrigaGestante;
    }

    public void setExaChObrigaGestante(Character exaChObrigaGestante) {
        this.exaChObrigaGestante = exaChObrigaGestante;
    }

    public Character getExaChObrigatorioAltura() {
        return exaChObrigatorioAltura;
    }

    public void setExaChObrigatorioAltura(Character exaChObrigatorioAltura) {
        this.exaChObrigatorioAltura = exaChObrigatorioAltura;
    }

    public Character getExaChObrigatorioPeso() {
        return exaChObrigatorioPeso;
    }

    public void setExaChObrigatorioPeso(Character exaChObrigatorioPeso) {
        this.exaChObrigatorioPeso = exaChObrigatorioPeso;
    }

    public Character getExaChSexo() {
        return exaChSexo;
    }

    public void setExaChSexo(Character exaChSexo) {
        this.exaChSexo = exaChSexo;
    }

    public String getExaStDescricao() {
        return exaStDescricao;
    }

    public void setExaStDescricao(String exaStDescricao) {
        this.exaStDescricao = exaStDescricao;
    }

    public String getExaStGrupo() {
        return exaStGrupo;
    }

    public void setExaStGrupo(String exaStGrupo) {
        this.exaStGrupo = exaStGrupo;
    }

    public Timestamp getExmDtValidade() {
        return exmDtValidade;
    }

    public void setExmDtValidade(Timestamp exmDtValidade) {
        this.exmDtValidade = exmDtValidade;
    }

  

    public Character getExuChConfereAutomaticoFat() {
        return exuChConfereAutomaticoFat;
    }

    public void setExuChConfereAutomaticoFat(Character exuChConfereAutomaticoFat) {
        this.exuChConfereAutomaticoFat = exuChConfereAutomaticoFat;
    }

    public Character getExuChFatura() {
        return exuChFatura;
    }

    public void setExuChFatura(Character exuChFatura) {
        this.exuChFatura = exuChFatura;
    }

    public Character getExuChInativo() {
        return exuChInativo;
    }

    public void setExuChInativo(Character exuChInativo) {
        this.exuChInativo = exuChInativo;
    }

    public Character getExuChNaoNecessario() {
        return exuChNaoNecessario;
    }

    public void setExuChNaoNecessario(Character exuChNaoNecessario) {
        this.exuChNaoNecessario = exuChNaoNecessario;
    }

    public Character getExuChObrigaMaterial() {
        return exuChObrigaMaterial;
    }

    public void setExuChObrigaMaterial(Character exuChObrigaMaterial) {
        this.exuChObrigaMaterial = exuChObrigaMaterial;
    }

    public Character getExuChPreparo() {
        return exuChPreparo;
    }

    public void setExuChPreparo(Character exuChPreparo) {
        this.exuChPreparo = exuChPreparo;
    }

    public Character getExuChStatus() {
        return exuChStatus;
    }

    public void setExuChStatus(Character exuChStatus) {
        this.exuChStatus = exuChStatus;
    }

    public String getExuStPrazoUrgente() {
        return exuStPrazoUrgente;
    }

    public void setExuStPrazoUrgente(String exuStPrazoUrgente) {
        this.exuStPrazoUrgente = exuStPrazoUrgente;
    }

    public String getExuStUnidadeEx() {
        return exuStUnidadeEx;
    }

    public void setExuStUnidadeEx(String exuStUnidadeEx) {
        this.exuStUnidadeEx = exuStUnidadeEx;
    }

    public String getExuStUnidadeExUrgente() {
        return exuStUnidadeExUrgente;
    }

    public void setExuStUnidadeExUrgente(String exuStUnidadeExUrgente) {
        this.exuStUnidadeExUrgente = exuStUnidadeExUrgente;
    }

    public String getLegStCogioInicial() {
        return legStCogioInicial;
    }

    public void setLegStCogioInicial(String legStCogioInicial) {
        this.legStCogioInicial = legStCogioInicial;
    }

    public String getMatStCodigo() {
        return matStCodigo;
    }

    public void setMatStCodigo(String matStCodigo) {
        this.matStCodigo = matStCodigo;
    }

    public String getMatStDescricao() {
        return matStDescricao;
    }

    public void setMatStDescricao(String matStDescricao) {
        this.matStDescricao = matStDescricao;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public String getMetStCodigoGrp() {
        return metStCodigoGrp;
    }

    public void setMetStCodigoGrp(String metStCodigoGrp) {
        this.metStCodigoGrp = metStCodigoGrp;
    }

    public String getMetStDescricao() {
        return metStDescricao;
    }

    public void setMetStDescricao(String metStDescricao) {
        this.metStDescricao = metStDescricao;
    }

    public String getMpaStCodigo() {
        return mpaStCodigo;
    }

    public void setMpaStCodigo(String mpaStCodigo) {
        this.mpaStCodigo = mpaStCodigo;
    }

    public Character getOriChConfereAutomatico() {
        return oriChConfereAutomatico;
    }

    public void setOriChConfereAutomatico(Character oriChConfereAutomatico) {
        this.oriChConfereAutomatico = oriChConfereAutomatico;
    }

    public Character getOriChConfereAutomaticoFat() {
        return oriChConfereAutomaticoFat;
    }

    public void setOriChConfereAutomaticoFat(Character oriChConfereAutomaticoFat) {
        this.oriChConfereAutomaticoFat = oriChConfereAutomaticoFat;
    }

    public Character getOriChUrgencia() {
        return oriChUrgencia;
    }

    public void setOriChUrgencia(Character oriChUrgencia) {
        this.oriChUrgencia = oriChUrgencia;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public Character getPraChDomingo() {
        return praChDomingo;
    }

    public void setPraChDomingo(Character praChDomingo) {
        this.praChDomingo = praChDomingo;
    }

    public Character getPraChDomingoU() {
        return praChDomingoU;
    }

    public void setPraChDomingoU(Character praChDomingoU) {
        this.praChDomingoU = praChDomingoU;
    }

    public Character getPraChQuarta() {
        return praChQuarta;
    }

    public void setPraChQuarta(Character praChQuarta) {
        this.praChQuarta = praChQuarta;
    }

    public Character getPraChQuartaU() {
        return praChQuartaU;
    }

    public void setPraChQuartaU(Character praChQuartaU) {
        this.praChQuartaU = praChQuartaU;
    }

    public Character getPraChQuinta() {
        return praChQuinta;
    }

    public void setPraChQuinta(Character praChQuinta) {
        this.praChQuinta = praChQuinta;
    }

    public Character getPraChQuintaU() {
        return praChQuintaU;
    }

    public void setPraChQuintaU(Character praChQuintaU) {
        this.praChQuintaU = praChQuintaU;
    }

    public Character getPraChSabado() {
        return praChSabado;
    }

    public void setPraChSabado(Character praChSabado) {
        this.praChSabado = praChSabado;
    }

    public Character getPraChSabadoU() {
        return praChSabadoU;
    }

    public void setPraChSabadoU(Character praChSabadoU) {
        this.praChSabadoU = praChSabadoU;
    }

    public Character getPraChSegunda() {
        return praChSegunda;
    }

    public void setPraChSegunda(Character praChSegunda) {
        this.praChSegunda = praChSegunda;
    }

    public Character getPraChSegundaU() {
        return praChSegundaU;
    }

    public void setPraChSegundaU(Character praChSegundaU) {
        this.praChSegundaU = praChSegundaU;
    }

    public Character getPraChSexta() {
        return praChSexta;
    }

    public void setPraChSexta(Character praChSexta) {
        this.praChSexta = praChSexta;
    }

    public Character getPraChSextaU() {
        return praChSextaU;
    }

    public void setPraChSextaU(Character praChSextaU) {
        this.praChSextaU = praChSextaU;
    }

    public Character getPraChTerca() {
        return praChTerca;
    }

    public void setPraChTerca(Character praChTerca) {
        this.praChTerca = praChTerca;
    }

    public Character getPraChTercaU() {
        return praChTercaU;
    }

    public void setPraChTercaU(Character praChTercaU) {
        this.praChTercaU = praChTercaU;
    }

    public Date getPraHrFinal() {
        return praHrFinal;
    }

    public void setPraHrFinal(Date praHrFinal) {
        this.praHrFinal = praHrFinal;
    }

    public Date getPraHrFinalU() {
        return praHrFinalU;
    }

    public void setPraHrFinalU(Date praHrFinalU) {
        this.praHrFinalU = praHrFinalU;
    }

    public Integer getPraInDias() {
        return praInDias;
    }

    public void setPraInDias(Integer praInDias) {
        this.praInDias = praInDias;
    }

    public Integer getPraInDiasU() {
        return praInDiasU;
    }

    public void setPraInDiasU(Integer praInDiasU) {
        this.praInDiasU = praInDiasU;
    }

    public Integer getPraInHoras() {
        return praInHoras;
    }

    public void setPraInHoras(Integer praInHoras) {
        this.praInHoras = praInHoras;
    }

    public Integer getPraInHorasU() {
        return praInHorasU;
    }

    public void setPraInHorasU(Integer praInHorasU) {
        this.praInHorasU = praInHorasU;
    }

    public String getPraStCodigo() {
        return praStCodigo;
    }

    public void setPraStCodigo(String praStCodigo) {
        this.praStCodigo = praStCodigo;
    }

    public Character getRegChObrigatorioNumGuia() {
        return regChObrigatorioNumGuia;
    }

    public void setRegChObrigatorioNumGuia(Character regChObrigatorioNumGuia) {
        this.regChObrigatorioNumGuia = regChObrigatorioNumGuia;
    }

    public Float getRtpFlAcrescimo() {
        return rtpFlAcrescimo;
    }

    public void setRtpFlAcrescimo(Float rtpFlAcrescimo) {
        this.rtpFlAcrescimo = rtpFlAcrescimo;
    }

    public Float getRtpFlDesconto() {
        return rtpFlDesconto;
    }

    public void setRtpFlDesconto(Float rtpFlDesconto) {
        this.rtpFlDesconto = rtpFlDesconto;
    }

    public Float getRtpFlDescontoExterno() {
        return rtpFlDescontoExterno;
    }

    public void setRtpFlDescontoExterno(Float rtpFlDescontoExterno) {
        this.rtpFlDescontoExterno = rtpFlDescontoExterno;
    }

    public Float getRtpFlValorCh() {
        return rtpFlValorCh;
    }

    public void setRtpFlValorCh(Float rtpFlValorCh) {
        this.rtpFlValorCh = rtpFlValorCh;
    }

    public Float getRtpFlValorChExterno() {
        return rtpFlValorChExterno;
    }

    public void setRtpFlValorChExterno(Float rtpFlValorChExterno) {
        this.rtpFlValorChExterno = rtpFlValorChExterno;
    }

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public Float getTabFlQtDeCh() {
        return tabFlQtDeCh;
    }

    public void setTabFlQtDeCh(Float tabFlQtDeCh) {
        this.tabFlQtDeCh = tabFlQtDeCh;
    }

    public String getTabStCodigo() {
        return tabStCodigo;
    }

    public void setTabStCodigo(String tabStCodigo) {
        this.tabStCodigo = tabStCodigo;
    }

    public String getTabStDescricao() {
        return tabStDescricao;
    }

    public void setTabStDescricao(String tabStDescricao) {
        this.tabStDescricao = tabStDescricao;
    }

    public String getTapStCodigo() {
        return tapStCodigo;
    }

    public void setTapStCodigo(String tapStCodigo) {
        this.tapStCodigo = tapStCodigo;
    }

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }
    

    @Override
    public String toString() {
        return
      "tabFlQtDeCh : "+ tabFlQtDeCh.toString()+"\n"
    +"rtpFlValorCh : "+rtpFlValorCh.toString()+"\n"
    +"rtpFlValorChExterno : "+  rtpFlValorChExterno.toString()+"\n"
    +"rtpFlDesconto : "+  rtpFlDesconto.toString()+"\n"
    +"rtpFlDescontoExterno : "+  rtpFlDescontoExterno.toString()+"\n"
    +"rtpFlAcrescimo : "+    rtpFlAcrescimo.toString()+"\n"
    +"tapStCodigo : "+   tapStCodigo+"\n"
    +"regChObrigatorioNumGuia : "+   regChObrigatorioNumGuia.toString()+"\n"
    +"tabStCodigo : "+  tabStCodigo+"\n"
    +"tabStDescricao : "+  tabStDescricao+"\n"
    +"etpFlValorDifenciado : "+  etpFlValorDifenciado.toString()+"\n"
    +"etpFlValorDifenciadoExterno : "+  etpFlValorDifenciadoExterno.toString()+"\n"
    +"ediFlDesconto : "+  ediFlDesconto.toString()+"\n"
    +"ediFlDescontoExterno : "+  ediFlDescontoExterno.toString()+"\n"
    +"etpChComAutorizacao : "+  etpChComAutorizacao.toString()+"\n"
    +"etpChNaoAutorizado : "+  etpChNaoAutorizado.toString()+"\n"
    +"matStCodigo : "+   matStCodigo+"\n"
    +"matStDescricao : "+   matStDescricao+"\n"
    +"exaChObrigatorioPeso : "+   exaChObrigatorioPeso.toString()+"\n"
    +"exaChObrigatorioAltura : "+   exaChObrigatorioAltura.toString()+"\n"
    +"exaChObrigaGestante : "+   exaChObrigaGestante.toString()+"\n"
    +"exaChSexo : "+   exaChSexo.toString()+"\n"
    +"mpaStCodigo : "+   mpaStCodigo+"\n"
    +"exaStDescricao : "+   exaStDescricao+"\n"
    +"exaStGrupo : "+   exaStGrupo+"\n"
    +"metStCodigo : "+   metStCodigo+"\n"
    +"metStDescricao : "+   metStDescricao+"\n"
    +"exmDtValidade : "+  exmDtValidade.toString()+"\n"
    +"exuChStatus : "+   exuChStatus.toString()+"\n"
    +"exuChFatura : "+   exuChFatura.toString()+"\n"
    +"exaChInativo : "+   exaChInativo.toString()+"\n"
    +"exuChInativo : "+   exuChInativo.toString()+"\n"
    +"exuChPreparo : "+   exuChPreparo.toString()+"\n"
    +"exuChObrigaMaterial : "+   exuChObrigaMaterial.toString()+"\n"
    +"praStCodigo : "+   praStCodigo+"\n"
    +"praInDias : "+   praInDias.toString()+"\n"
    +"praChDomingo : "+   praChDomingo.toString()+"\n"
    +"praChSegunda : "+   praChSegunda.toString()+"\n"
    +"praChTerca : "+   praChTerca.toString()+"\n"
    +"praChQuarta : "+   praChQuarta.toString()+"\n"
    +"praChQuinta : "+   praChQuinta.toString()+"\n"
    +"praChSexta : "+   praChSexta.toString()+"\n"
    +"praChSabado : "+   praChSabado.toString()+"\n"
    +"praHrFinal : "+   praHrFinal+"\n"
    +"praInHoras : "+   praInHoras.toString()+"\n"
    +"praInHorasU : "+   praInHorasU.toString()+"\n"
    +"praInDiasU : "+   praInDiasU.toString()+"\n"
    +"praChSegundaU : "+   praChSegundaU.toString()+"\n"
    +"praChTercaU : "+   praChTercaU.toString()+"\n"
    +"praChQuartaU : "+   praChQuartaU.toString()+"\n"
    +"praChQuintaU : "+   praChQuintaU.toString()+"\n"
    +"praChSextaU : "+   praChSextaU.toString()+"\n"
    +"praChSabadoU : "+   praChSabadoU.toString()+"\n"
    +"praChDomingoU : "+   praChDomingoU.toString()+"\n"
    +"praHrFinalU : "+   praHrFinalU+"\n"
    +"exuStPrazoUrgente : "+   exuStPrazoUrgente+"\n"
    +"exuChNaoNecessario : "+   exuChNaoNecessario.toString()+"\n"
    +"oriStCodigo : "+   oriStCodigo+"\n"
    +"oriChUrgencia : "+   oriChUrgencia+"\n"
    +"legStCogioInicial : "+   legStCogioInicial+"\n"
    +"oriChConfereAutomatico : "+   oriChConfereAutomatico.toString()+"\n"
    +"oriChConfereAutomaticoFat : "+   oriChConfereAutomaticoFat.toString()+"\n"
    +"setStCodigo : "+   setStCodigo+"\n"
    +"exuStUnidadeEx : "+   exuStUnidadeEx+"\n"
    +"exuStUnidadeExUrgente : "+   exuStUnidadeExUrgente+"\n"
    +"exuChConfereAutomaticoFat : "+   exuChConfereAutomaticoFat.toString()+"\n"
    +"depStCodigo : "+   depStCodigo+"\n";
    }

   




    


}
