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

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_PROFISSAO")
public class LabProfissao implements Serializable{


    @Id
    @Column(name="PRO_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String proStCodigo;
    @Column(name="PRO_ST_DESCRICAO")
    private String proStDescricao;


//    @OneToMany(mappedBy="proStCodigo")
//    private List<LabAgendaPaciente>  listLabAgendaPaciente;

//    @OneToMany(mappedBy="proStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

//    @OneToMany(mappedBy="proStCodigo")
//    private List<LabSolicitante> listLabSolicitante;

   
    


    public String getProStCodigo() {
        return proStCodigo;
    }

    public void setProStCodigo(String proStCodigo) {
        this.proStCodigo = proStCodigo;
    }

    public String getProStDescricao() {
        return proStDescricao;
    }

    public void setProStDescricao(String proStDescricao) {
        this.proStDescricao = proStDescricao;
    }

   
    
}
