/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;



import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DescricaoResumida;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_EXAME")
public class LabExame implements Serializable{
    
    private String exaStCodigo;


    private String matStTriagem;
    private String matStColeta;
    private String exaStDescricao;
    private String exaStFantasia;
    private String exaBlObservacao;
    private Character exaChImagem;
    private Character exaChGrupo;
    private Character exaChFaturaGrupo;
    private Character exaChLaudoGrupo;
    private Character exaChObrigatorioPeso;
    private Character exaChObrigatorioAltura;
    private Character exaChInativo;
    private String exaStSinonimias;
    private String exaStPreRequisito;
    private String  exaClPreRequisito;
    private Character exaChObrigaGestante;
    private Character exaChSexo;
    private Character exaChCongelado;


    private List<LabMaterial> listLabMaterial;
    private List<LabExameMaterial> listLabExameMaterialEager;


    private List<LabDetalheRequisicao> listLabDetalheRequisicao;


    private List<LabExameMaterial> listLabExameMaterials;

    public LabExame() {
    }

    public LabExame(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }
    
    
    

    @OneToMany(mappedBy = "exaStCodigo")
    public List<LabExameMaterial> getListLabExameMaterials() {
      
//                  if(exaStCodigo != null && exaStCodigo.length()>1){
//                        this.listLabExameMaterials   = OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo);
//
//                  }
        
          
        return listLabExameMaterials;
    }

    public void setListLabExameMaterials(List<LabExameMaterial> listLabExameMaterials) {
        this.listLabExameMaterials = listLabExameMaterials;
    }

    @OneToMany(mappedBy = "exaStCodigo")
    public List<LabDetalheRequisicao> getListLabDetalheRequisicao() {
        return listLabDetalheRequisicao;
    }

    public void setListLabDetalheRequisicao(List<LabDetalheRequisicao> listLabDetalheRequisicao) {
        this.listLabDetalheRequisicao = listLabDetalheRequisicao;
    }

    @Column(name = "EXA_CH_CONGELADO")
    public Character getExaChCongelado() {
        return exaChCongelado;
    }

    public void setExaChCongelado(Character exaChCongelado) {
        this.exaChCongelado = exaChCongelado;
    }

    @Column(name = "EXA_CH_FATURAGRUPO")
    public Character getExaChFaturaGrupo() {
        return exaChFaturaGrupo;
    }

    public void setExaChFaturaGrupo(Character exaChFaturaGrupo) {
        this.exaChFaturaGrupo = exaChFaturaGrupo;
    }

    @Column(name = "EXA_CH_GRUPO")
    public Character getExaChGrupo() {
        return exaChGrupo;
    }

    public void setExaChGrupo(Character exaChGrupo) {
        this.exaChGrupo = exaChGrupo;
    }

    @Column(name = "EXA_CH_IMAGEM")
    public Character getExaChImagem() {
        return exaChImagem;
    }

    public void setExaChImagem(Character exaChImagem) {
        this.exaChImagem = exaChImagem;
    }

    @Column(name = "EXA_CH_INATIVO")
    public Character getExaChInativo() {
        return exaChInativo;
    }

    public void setExaChInativo(Character exaChInativo) {
        this.exaChInativo = exaChInativo;
    }

    @Column(name = "EXA_CH_LAUDOGRUPO")
    public Character getExaChLaudoGrupo() {
        return exaChLaudoGrupo;
    }

    public void setExaChLaudoGrupo(Character exaChLaudoGrupo) {
        this.exaChLaudoGrupo = exaChLaudoGrupo;
    }

    @Column(name = "EXA_CH_OBRIGAGESTANTE")
    public Character getExaChObrigaGestante() {
        return exaChObrigaGestante;
    }

    public void setExaChObrigaGestante(Character exaChObrigaGestante) {
        this.exaChObrigaGestante = exaChObrigaGestante;
    }

    @Column(name = "EXA_CH_OBRIGATORIOALTURA")
    public Character getExaChObrigatorioAltura() {
        return exaChObrigatorioAltura;
    }

    public void setExaChObrigatorioAltura(Character exaChObrigatorioAltura) {
        this.exaChObrigatorioAltura = exaChObrigatorioAltura;
    }

    @Column(name = "EXA_CH_OBRIGATORIOPESO")
    public Character getExaChObrigatorioPeso() {
        return exaChObrigatorioPeso;
    }

    public void setExaChObrigatorioPeso(Character exaChObrigatorioPeso) {
        this.exaChObrigatorioPeso = exaChObrigatorioPeso;
    }

    @Column(name = "EXA_CH_SEXO")
    public Character getExaChSexo() {
        return exaChSexo;
    }

    public void setExaChSexo(Character exaChSexo) {
        this.exaChSexo = exaChSexo;
    }






//    @OneToMany(mappedBy="exaStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPacientes;





    

   
    @Lob
    @Column(name = "EXA_BL_OBSERVACAO")
    public String getExaBlObservacao() {
        return exaBlObservacao;
    }

    public void setExaBlObservacao(String exaBlObservacao) {
        this.exaBlObservacao = exaBlObservacao;
    }

   

    @Lob
    @Column(name = "EXA_CL_PREREQUISITO")
    public String getExaClPreRequisito() {
        return exaClPreRequisito;
    }

    public void setExaClPreRequisito(String exaClPreRequisito) {
        this.exaClPreRequisito = exaClPreRequisito;
    }

    @Id
    @Column(name = "EXA_ST_CODIGO")
    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    @Column(name = "EXA_ST_DESCRICAO")
    public String getExaStDescricao() {
        return exaStDescricao;
    }
    
    @Transient
    public String getExaStDescricaoResumida() {
        return DescricaoResumida.descResuminda(exaStDescricao, 10);
    }
    

    public void setExaStDescricao(String exaStDescricao) {
        this.exaStDescricao = exaStDescricao;
    }

    @Column(name = "EXA_ST_FANTASIA")
    public String getExaStFantasia() {
        return exaStFantasia;
    }

    public void setExaStFantasia(String exaStFantasia) {
        this.exaStFantasia = exaStFantasia;
    }

    @Column(name = "EXA_ST_PREREQUISITO")
    public String getExaStPreRequisito() {
        return exaStPreRequisito;
    }

    public void setExaStPreRequisito(String exaStPreRequisito) {
        this.exaStPreRequisito = exaStPreRequisito;
    }

    @Column(name = "EXA_ST_SINONIMIAS")
    public String getExaStSinonimias() {
        return exaStSinonimias;
    }

    public void setExaStSinonimias(String exaStSinonimias) {
        this.exaStSinonimias = exaStSinonimias;
    }

    @Column(name = "MAT_ST_COLETA")
    public String getMatStColeta() {
        return matStColeta;
    }

    public void setMatStColeta(String matStColeta) {
        this.matStColeta = matStColeta;
    }

    @Column(name = "MAT_ST_TRIAGEM")
    public String getMatStTriagem() {
        return matStTriagem;
    }

    public void setMatStTriagem(String matStTriagem) {
        this.matStTriagem = matStTriagem;
    }



    @Transient
    public List<LabMaterial> getListLabMaterial(){
        if(listLabMaterial == null){
             if(exaStCodigo != null && exaStCodigo.length()>1){
                List<LabExameMaterial>  l = getListLabExameMaterialEager();//OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo);
                List<LabMaterial>  l2 = null;
                if(l != null && l.size()>0){
                    l2 = new ArrayList<LabMaterial>();
                    for(LabExameMaterial lem : l ){
                        l2.add(lem.getMatStCodigo());
                    }

                    listLabMaterial = l2;
                    return listLabMaterial;
                }
            }
        }
       
        return listLabMaterial;
    }


     @Transient
    public List<LabExameMaterial> getListLabExameMaterialEager(){
        if(listLabExameMaterialEager == null){
             if(exaStCodigo != null && exaStCodigo.length()>1){
                List<LabExameMaterial>  l = OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo);
                if(l != null && l.size()>0){
                    listLabExameMaterialEager = l;
                    setListLabExameMaterials(listLabExameMaterials);
                    return listLabExameMaterialEager;
                }
            }
        }

        return listLabExameMaterialEager;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExame other = (LabExame) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        return hash;
    }




    
    
    

}
