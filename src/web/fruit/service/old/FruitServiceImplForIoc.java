package web.fruit.service.old;

import web.fruit.DAO.FruitDAO;
import web.fruit.DAO.impl.FruitDAOImpl;
import web.fruit.Pojo.Fruit;
import web.fruit.service.FruitService;

import java.util.List;

public class FruitServiceImplForIoc implements FruitService {

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
    public Fruit getFruitByFid(Integer fid) {
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

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.update(fruit);
    }
}
