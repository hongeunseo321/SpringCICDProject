package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.SeoulVO;
/*
 *  DAO => table 1개 제어: 순수하게 SQL 문장만 수행
 *   ㄴRepository
 *  Service => DAO 여러 개를 동시에 제어: 추가 기능을 수행
 *   ㄴBI 
 */
public interface SeoulService {
	public List<SeoulVO> seoulListData(Map map);
	public int seoulTotalPage(Map map);
}
