package com.sist.web.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;

@Mapper
@Repository
/*
 * 인터페이스는 서로 다른 클래스를 연결할 때 사용 
 * 	=> 리모콘 역할
 * 	=> 모든 변수, 모든 메소드는 public
 * 		List<SeoulVO> seoulListData(Map map);
 * 		 ㄴ즉, public 생략 가능
 *  => 1.8버전부터는 default 메소드가 등장
 *  	ㄴ구현 메소드 => 추상 클래스 대체
 */
public interface SeoulMapper {
	/*
	<select id="seoulListData" resultType="com.sist.web.vo.SeoulVO" parameterType="hashmap">
		SELECT no,title,poster,address,hit
		FROM ${table_name}
		ORDER BY no ASC
		OFFSET #{start} ROWS FETCH NEXT 6 ROWS ONLY
	</select>
	 */
	public List<SeoulVO> seoulListData(Map map);
	
	/*
	<select id="seoulTotalPage" resultType="int" parameterType="hashmap">
		SELECT CEIL(COUNT(*)/6.0)
		FROM ${table_name}
	</select>	
	 */
	public int seoulTotalPage(Map map);
	
	/*
	<select id="seoulDetailData" resultType="com.sist.web.vo.SeoulVO" parameterType="hashmap">
		SELECT no,title,poster,address,hit
		FROM ${table_name}
		WHERE no=#{no}
	</select>
	 */
	public SeoulVO seoulDetailData(Map map);
	@Update("UPDATE ${table_name} SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void seoulHitIncrement(Map map);
}
