/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_UNIDADE")
public class LabUnidade implements Serializable {

    @Id
    @Column(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String uniStCodigo;
    @Column(name="UNI_ST_DESCRICAO")
    private String uniStDescricao;
    @Column(name="UNI_CH_TELEFONE")
    private char uniStTelefone;
    @Column(name="UNI_ST_SISTEMA")
    private String uniStSistema;







    @OneToMany(mappedBy="uniStCodigo")
    private List<LabUsuario> uniListLabUsuario;

    @OneToMany(mappedBy="oriStCodigo")
    private List<LabOrigem> listLabOrigem;





//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPaciente;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabLocal> listLabLocal;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabOrigem> listLabOrigem;


//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabPaciente> listLabPaciente;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabRegras> listLabRegras;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabSistema> listLabSistema;

    @OneToMany(mappedBy="uniStCodigo")
    private List<LabUsuario> listLabUsuario;
    
    

    
    
    

    public List<LabOrigem> getListLabOrigem() {
        return listLabOrigem;
    }

    public void setListLabOrigem(List<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabAgenda> listLabAgenda;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabColetor> listLabColetor;
    
    public List<LabUsuario> getListLabUsuario() {
        return listLabUsuario;
    }

    public void setListLabUsuario(List<LabUsuario> listLabUsuario) {
        this.listLabUsuario = listLabUsuario;
    }


   

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUniStDescricao() {
        return uniStDescricao;
    }

    public void setUniStDescricao(String uniStDescricao) {
        this.uniStDescricao = uniStDescricao;
    }

    public String getUniStSistema() {
        return uniStSistema;
    }

    public void setUniStSistema(String uniStSistema) {
        this.uniStSistema = uniStSistema;
    }

    public char getUniStTelefone() {
        return uniStTelefone;
    }

    public void setUniStTelefone(char uniStTelefone) {
        this.uniStTelefone = uniStTelefone;
    }

    public List<LabUsuario> getUniListLabUsuario() {
        return uniListLabUsuario;
    }

    public void setUniListLabUsuario(List<LabUsuario> uniListLabUsuario) {
        this.uniListLabUsuario = uniListLabUsuario;
    }
    @Transient
    public String getUniStDescricaoResumida(){
        if(this.uniStDescricao != null && uniStDescricao.length()>13){
            return  uniStDescricao.substring(0, 10)+"...";
        }else{
            return  uniStDescricao;
        }

    }
    
    @Transient
    public String getUniStDescricaoResumida7(){
        if(this.uniStDescricao != null && uniStDescricao.length()>7){
            return  uniStDescricao.substring(0, 4)+"...";
        }else{
            return  uniStDescricao;
        }

    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUnidade other = (LabUnidade) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }

    

    
    
    
    

}
