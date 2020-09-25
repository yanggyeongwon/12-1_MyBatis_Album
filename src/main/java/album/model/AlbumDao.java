package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public List<AlbumBean> getAlbumList(Map<String,String> map){
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList", map);
		return lists;
	}
	public void deleteAlbum(int num) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum", num);

	}

	public AlbumBean selectAlbum(int num) {
		// TODO Auto-generated method stub
		AlbumBean bean = sqlSessionTemplate.selectOne("album.AlbumBean.selectAlbum", num);
		return bean;
	}

	public void updateAlbum(AlbumBean ab) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("album.AlbumBean.updateAlbum", ab);
	}


}
