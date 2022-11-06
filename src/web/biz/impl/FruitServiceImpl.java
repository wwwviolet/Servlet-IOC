package web.biz.impl;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import web.biz.FruitService;
import web.fruit.DAO.FruitDAO;
import web.fruit.DAO.impl.FruitDAOImpl;
import web.fruit.Pojo.Fruit;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO =  new FruitDAOImpl();

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int fruitCount = fruitDAO.getFruitCount(keyword);
        return (fruitCount + 5 - 1) / 5;

    }
}
