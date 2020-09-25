package album.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumListController {
	final String command = "list.ab";
	final String getPage = "AlbumList";
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam(value="whatColumn", required = false) String whatColumn, @RequestParam(value = "keyword", required = false) String keyword) {
		
		System.out.println("wh :"+whatColumn);
		System.out.println("ke :"+keyword);
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", keyword);
		
		List<AlbumBean> lists = albumDao.getAlbumList(map); 
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists",lists);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}