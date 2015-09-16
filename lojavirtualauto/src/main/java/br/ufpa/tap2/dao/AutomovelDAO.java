package br.ufpa.tap2.dao;

import br.ufpa.tap2.dao.common.DAO;
import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domingossantos on 14/09/15.
 */
public class AutomovelDAO extends DAO<Automovel> {

    public List<Automovel> listaPorMarca(Marca marca) throws Exception {
        List<Automovel> automoveis = new ArrayList<>();

        try{
            Query query = getEm().createQuery("select a from Automovel a where a.modelo.marca = :marca");
            query.setParameter("marca",marca);
            automoveis = query.getResultList();

        } catch (Exception ex){
            throw  new Exception("Erro ao consultar automovel");
        }

        return automoveis;

    }

    public List<Automovel> listaPorModelo(Modelo modelo) throws Exception {
        List<Automovel> automoveis = new ArrayList<>();

        try{
            Query query = getEm().createQuery("select a from Automovel a where a.modelo = :modelo");
            query.setParameter("modelo",modelo);
            automoveis = query.getResultList();

        } catch (Exception ex){
            throw  new Exception("Erro ao consultar automovel");
        }

        return automoveis;
    }

    public List<Automovel> listaPorCaracteristica(Automovel automovel) throws Exception {
        List<Automovel> automoveis = new ArrayList<>();

        try{
            StringBuilder sql = new StringBuilder();

            sql.append("select a from Automovel a where 1 = 1 ");

            if(!automovel.getModelo().equals(null)){
                sql.append(" and a.modelo = :modelo and a.modelo.marca = :marca");
            }

            if(!automovel.getAnoFabricacao().equals(null)){
                sql.append(" and a.anoFabricacao = :fabricacao");
            }

            if(!automovel.getAnoModelo().equals(null)){
                sql.append(" and a.anoModelo = : anoModelo");
            }

            if(!automovel.getKilometragem().equals(null)){
                sql.append(" and kilometragem = :kilometragem");
            }

            if(!automovel.getPreco().equals(null)){
                sql.append(" and preco : preco");
            }

            Query query = getEm().createQuery(sql.toString());

            if(!automovel.getModelo().equals(null)){
                query.setParameter("modelo",automovel.getModelo());
                query.setParameter("marca", automovel.getModelo().getMarca());
            }

            if(!automovel.getAnoFabricacao().equals(null)){
                query.setParameter("fabricacao",automovel.getAnoFabricacao());
            }

            if(!automovel.getAnoModelo().equals(null)){
                query.setParameter("anoModelo", automovel.getAnoModelo());
            }

            if(!automovel.getKilometragem().equals(null)){
                query.setParameter("kilometragem",automovel.getKilometragem());
            }

            if(!automovel.getPreco().equals(null)){
                query.setParameter("preco",automovel.getPreco());
            }

            automoveis = query.getResultList();

        } catch (Exception ex){
            throw  new Exception("Erro ao consultar automovel");
        }

        return automoveis;
    }






}
