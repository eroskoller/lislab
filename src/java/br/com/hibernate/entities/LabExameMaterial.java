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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_EXAMEMATERIAL")
@IdClass(LabExameMaterialPK.class)
public class LabExameMaterial  implements Serializable{

    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @ManyToOne
    @JoinColumn(name="MAT_ST_CODIGO")
    private LabMaterial matStCodigo;

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public LabMaterial getMatStCodigo() {
        return matStCodigo;
    }

    public void setMatStCodigo(LabMaterial matStCodigo) {
        this.matStCodigo = matStCodigo;
    }



    

}
