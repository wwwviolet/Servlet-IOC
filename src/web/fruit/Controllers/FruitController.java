package web.fruit.Controllers;

import web.fruit.DAO.FruitDAO;
import web.fruit.DAO.impl.FruitDAOImpl;
import web.fruit.Pojo.Fruit;
import web.myssm.uitl.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;


//@WebServlet("/fruit.do")
//不再是Servlet组件
public class FruitController{

    private FruitDAO fruitDAO = new FruitDAOImpl();

    public FruitController(){

    }

    private String index(String operate, String keyword, Integer pageNo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (pageNo == null) {
            pageNo = 1;
        }

        if (StringUtil.isNotEmpty(operate) && "search".equals(operate)) {
            pageNo = 1;
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }

            session.setAttribute("keyword", keyword);
        } else {
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String)keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);
        int fruitCount = fruitDAO.getFruitCount(keyword);
        int pageCount = (fruitCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);
        return "index";
    }

    private String add(String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        this.fruitDAO.addFruit(fruit);
        return "redirect:fruit.do";
    }

    private String del(Integer fid) {
        if (fid != null) {
            this.fruitDAO.delFruit(fid);
            return "redirect:fruit.do";
        } else {
            return "error";
        }
    }

    private String edit(HttpServletRequest request, Integer fid) {
        if (fid != null) {
            Fruit fruit = this.fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            return "edit";
        } else {
            return "error";
        }
    }

    private String addRe(HttpServletRequest request) throws ServletException {
        return "add";
    }

    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        this.fruitDAO.update(new Fruit(fid, fname, price, fcount, remark));
        return "redirect:fruit.do";
    }
}