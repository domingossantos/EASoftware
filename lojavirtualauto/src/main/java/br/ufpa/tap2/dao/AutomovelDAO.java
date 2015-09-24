package br.ufpa.tap2.dao;

import br.ufpa.tap2.dao.common.DAO;
import br.ufpa.tap2.model.Automovel;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domingossantos on 14/09/15.
 */
public class AutomovelDAO extends DAO<Automovel> {

    public List<Automovel> listaPorCaracteristica(Automovel automovel, Float precoMax, Float precoMin, Integer kiloMax, Integer kiloMin) throws Exception {
        List<Automovel> automoveis = new ArrayList<>();

        try{
            StringBuilder sql = new StringBuilder();

            sql.append("select a from Automovel a where 1 = 1 ");

            if(automovel.getModelo() != null){
                sql.append(" and a.modelo = :modelo and a.modelo.marca = :marca");
            }

            if(automovel.getAnoFabricacao() != null){
                sql.append(" and a.anoFabricacao = :fabricacao");
            }

            if(automovel.getAnoModelo() != null){
                sql.append(" and a.anoModelo = : anoModelo");
            }

            if(kiloMax != null && kiloMin != null) {
                sql.append(" and kilometragem between :kiloMin and :kiloMax");
            } else if(kiloMax != null && kiloMin == null) {
                sql.append(" and kilometragem <= :kiloMax ");
            } else if(kiloMin != null && kiloMax == null) {
                sql.append(" and kilometragem >= :kiloMin ");
            }

            if(precoMax != null && precoMin != null) {
                sql.append(" and preco between :precoMin and :precoMax");
            } else if(precoMax != null && precoMin == null) {
                sql.append(" and preco <= :precoMax ");
            } else if(precoMin != null && precoMax == null) {
                sql.append(" and preco >= :precoMin ");
            }

            Query query = getEm().createQuery(sql.toString());

            if(automovel.getModelo() != null){
                query.setParameter("modelo",automovel.getModelo());
                query.setParameter("marca", automovel.getModelo().getMarca());
            }

            if(automovel.getAnoFabricacao() != null){
                query.setParameter("fabricacao",automovel.getAnoFabricacao());
            }

            if(automovel.getAnoModelo() != null){
                query.setParameter("anoModelo", automovel.getAnoModelo());
            }

            if(precoMax != null){
                query.setParameter("precoMax", precoMax);
            }

            if(precoMin != null){
                query.setParameter("precoMin", precoMin);
            }

            if(kiloMax != null){
                query.setParameter("kiloMax", kiloMax);
            }

            if(kiloMin != null){
                query.setParameter("kiloMin", kiloMin);
            }

            automoveis = query.getResultList();

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return automoveis;
    }






}
