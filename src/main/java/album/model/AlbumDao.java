package album.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int inserAlbum(AlbumBean album) {
		// TODO Auto-generated method stub
		
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum", album);
		System.out.println("cnt : "+ cnt);
		return cnt;
	}
	public List<AlbumBean> getAlbumList(){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList");
		return lists;
	}
	public void deleteAlbum(int num) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum", num);

	}

}
