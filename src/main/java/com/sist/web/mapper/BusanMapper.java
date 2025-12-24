package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BusanVO;
import com.sist.web.vo.SeoulVO;

@Mapper
@Repository
public interface BusanMapper {
	/*
	<select id="busanListData" resultType="com.sist.web.vo.BusanVO" parameterType="hashmap">
		SELECT no,title,image1,contentid,address,hit,contenttype
		FROM busantravel
		<include refid="where-sql"/>
		OFFSET #{start} ROWS FETCH NEXT 6 ROWS ONLY
	</select>
	 */
	public List<BusanVO> busanListData(Map map);
	/*
	<select id="busanTotalPage" resultType="int" parameterType="hashmap">
		SELECT CEIL(COUNT(*)/6.0)
		FROM busantravel
		<include refid="where-sql"/>
	</select>	
	 */
	public int busanTotalPage(Map map);
	
	
	@Select("SELECT * FROM busantravel "
			+ "WHREE no=#{no}")
	public BusanVO busanDetailData(int no);
	
	@Update("UPDATE busantravel SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void busanHitIncrement(int no);
}
