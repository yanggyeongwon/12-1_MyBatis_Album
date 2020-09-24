package album.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	final String command = "insert.ab";
	final String getPage = "AlbumInsertForm";
	final String page = "redirect:/list.ab";
	//get 방식
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {

		return getPage;
	}
	
	//post방식
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@Valid AlbumBean album, Errors error) {
		ModelAndView mav = new ModelAndView();
		if(error.hasErrors()) {
			System.out.println("유효성 메롱");
			//eturn getPage;
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = albumDao.inserAlbum(album);
		System.out.println("AIC cnt : "+ cnt);
		mav.setViewName(page);
		
		return mav;
		//return page;
	}
}
