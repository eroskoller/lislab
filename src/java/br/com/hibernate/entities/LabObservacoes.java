/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_OBSERVACOES")
public class LabObservacoes implements Serializable{



    @Id
    @Column(name="OBS_ST_CODIGO")
    private String obsStCodigo;
    @Column(name="OBS_ST_DESCRICAO")
    private String obsStDescricao;
    @Column(name="OBS_ST_STATUS")
    private Character obsChStatus;
    @Column(name="OBS_ST_CATEGORIA")
    private String obsStCategoria;
    @Column(name="OBS_CH_NOVACOLETA")
    private Character obsChNovaColeta;
    @Column(name="OBS_CH_CONFIRMA")
    private Character obsChConfirma;
    @Column(name="OBS_CH_CANCELA")
    private Character obsChCancela;
    @Column(name="OBS_CH_OBSDEEXAME")
    private Character obsChDeObsExame;
    @Column(name="OBS_CH_DEVEMATERIAL")
    private Character obsChDeveMaterial;
    @Column(name="OBS_CH_RESTRICAO")
    private Character obsChRestricao;
    @Column(name="OBS_CH_AGENDAMENTO")
    private Character obsChAgendamento;
    @Column(name="OBS_CH_ATENDIMENTO")
    private Character obsChAtendimento;
    @Column(name="OBS_CH_DATAALTERACAO")
    private Character obsChDataAlteracao;

    public Character getObsChAgendamento() {
        return obsChAgendamento;
    }

    public void setObsChAgendamento(Character obsChAgendamento) {
        this.obsChAgendamento = obsChAgendamento;
    }

    public Character getObsChAtendimento() {
        return obsChAtendimento;
    }

    public void setObsChAtendimento(Character obsChAtendimento) {
        this.obsChAtendimento = obsChAtendimento;
    }

    public Character getObsChCancela() {
        return obsChCancela;
    }

    public void setObsChCancela(Character obsChCancela) {
        this.obsChCancela = obsChCancela;
    }

    public Character getObsChConfirma() {
        return obsChConfirma;
    }

    public void setObsChConfirma(Character obsChConfirma) {
        this.obsChConfirma = obsChConfirma;
    }

    public Character getObsChDataAlteracao() {
        return obsChDataAlteracao;
    }

    public void setObsChDataAlteracao(Character obsChDataAlteracao) {
        this.obsChDataAlteracao = obsChDataAlteracao;
    }

    public Character getObsChDeObsExame() {
        return obsChDeObsExame;
    }

    public void setObsChDeObsExame(Character obsChDeObsExame) {
        this.obsChDeObsExame = obsChDeObsExame;
    }

    public Character getObsChDeveMaterial() {
        return obsChDeveMaterial;
    }

    public void setObsChDeveMaterial(Character obsChDeveMaterial) {
        this.obsChDeveMaterial = obsChDeveMaterial;
    }

    public Character getObsChNovaColeta() {
        return obsChNovaColeta;
    }

    public void setObsChNovaColeta(Character obsChNovaColeta) {
        this.obsChNovaColeta = obsChNovaColeta;
    }

    public Character getObsChRestricao() {
        return obsChRestricao;
    }

    public void setObsChRestricao(Character obsChRestricao) {
        this.obsChRestricao = obsChRestricao;
    }

    public Character getObsChStatus() {
        return obsChStatus;
    }

    public void setObsChStatus(Character obsChStatus) {
        this.obsChStatus = obsChStatus;
    }

    public String getObsStCategoria() {
        return obsStCategoria;
    }

    public void setObsStCategoria(String obsStCategoria) {
        this.obsStCategoria = obsStCategoria;
    }

    public String getObsStCodigo() {
        return obsStCodigo;
    }

    public void setObsStCodigo(String obsStCodigo) {
        this.obsStCodigo = obsStCodigo;
    }

    public String getObsStDescricao() {
        return obsStDescricao;
    }

    public void setObsStDescricao(String obsStDescricao) {
        this.obsStDescricao = obsStDescricao;
    }

   

}
