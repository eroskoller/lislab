/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.facesbeans;

import java.util.Date;

/**
 *
 * @author eros
 */
public class LabPacienteBean {

    private Long pacInCodigo;
    private String pacStNome;
    private Date pacDtNascimento;
    private String uniStCodigo;

    public Date getPacDtNascimento() {
        return pacDtNascimento;
    }

    public void setPacDtNascimento(Date pacDtNascimento) {
        this.pacDtNascimento = pacDtNascimento;
    }

    public Long getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(Long pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public String getPacStNome() {
        return pacStNome;
    }

    public void setPacStNome(String pacStNome) {
        this.pacStNome = pacStNome;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    

}
