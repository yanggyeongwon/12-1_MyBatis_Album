package album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumInsertController {
	String command = "insert.ab";
	String getPage = "AlbumInsertForm";
	
	@RequestMapping(value="command")
	public String insert() {
		
		return "insert";
	}
}
