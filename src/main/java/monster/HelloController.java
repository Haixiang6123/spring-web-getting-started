package monster;

import monster.annotation.Cache;
import monster.entity.RankItem;
import monster.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/")
    public ModelAndView index() {
        List<RankItem> rankItems = rankService.getRank();

        Map<String, Object> model = new HashMap<>();
        model.put("rankItems", rankItems);

        System.out.println("Request!!!");

        return new ModelAndView("index", model);
    }

    @Cache
    @RequestMapping("/rank")
    public Object rank() {
        return rankService.getRank();
    }
}