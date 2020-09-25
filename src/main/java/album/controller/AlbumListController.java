package album.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	final String command = "list.ab";
	final String getPage = "AlbumList";
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam(value="whatColumn", required = false) String whatColumn, @RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber, @RequestParam(value = "pageSize", required = false) String pageSize, HttpServletRequest request) {
		
		System.out.println("wh :"+whatColumn);
		System.out.println("ke :"+keyword);
		System.out.println("pn :"+pageNumber);
		System.out.println("ps :"+pageSize);
		
		Map<String,String> map = new HashMap<String, String>();
		
		String context = request.getContextPath();
		String url =  context+"/"+command;
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = albumDao.getTotalCount();
		
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		List<AlbumBean> lists = albumDao.getAlbumList(map,pageInfo); 
		
		
		
		System.out.println(totalCount);
		System.out.println("url : "+url);
		System.out.println("offset :"+ pageInfo.getOffset());
		System.out.println("Limit :"+ pageInfo.getLimit());
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}