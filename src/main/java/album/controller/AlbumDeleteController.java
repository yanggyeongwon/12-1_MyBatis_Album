package album.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	final String command = "delete.ab";
	final String page = "redirect:/list.ab";
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num) {
		
		albumDao.deleteAlbum(num); 

		return page;
	}
}
