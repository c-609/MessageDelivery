package cn.tiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tiger.bean.Degree;
import cn.tiger.bean.Position;

@Mapper
public interface PositionMapper {
	//获取所有学位
	List<Degree> findAllDegree();
	
	Integer addDegree(Degree degree);
	
	Integer updateDegree(Degree degree);
	
	Integer deleteDegreeById(@Param("degreeId")Integer degreeId);
	//获取所有职位
	List<Position> findAllPosition();
	
	Integer addPosition(Position position);
	
	Integer updatePosition(Position position);
	
	Integer deletePositionById(@Param("positionId")Integer positionId);
}
