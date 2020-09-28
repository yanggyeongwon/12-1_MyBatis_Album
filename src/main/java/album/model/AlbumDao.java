package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

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

	public List<AlbumBean> getAlbumList(Map<String,String> map,Paging pageInfo){
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset() , pageInfo.getLimit());
		/*
		 * offset은 데이터를 가져오는 시작점에서 얼마나 떨어진 데이터인지를 의미하며 limit은 몇 개의 값을 가져올지를 의미한다.
		 */

		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList", map, rowBounds);
		System.out.println("lists: "+lists);
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

	public int getTotalCount(Map<String,String> map) {
		// TODO Auto-generated method stub
		int totlCount = sqlSessionTemplate.selectOne("album.AlbumBean.countAlbum", map);
		return totlCount;
	}




}
