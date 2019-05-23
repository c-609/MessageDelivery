package cn.tiger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tiger.bean.Degree;
import cn.tiger.bean.Position;
import cn.tiger.mapper.PositionMapper;

@Service
public class PositionService {
	@Autowired
	PositionMapper positionMapper;
	
	public List<Degree> getAllDegree(){
		return positionMapper.findAllDegree();
	}
	
	public Integer addDegree(Degree degree) {
		return positionMapper.addDegree(degree);
	}
	
	public Integer updateDegree(Degree degree) {
		return positionMapper.updateDegree(degree);
	}
	
	public Integer deleteDegreeById(Integer degreeId) {
		return positionMapper.deleteDegreeById(degreeId);
	}
	
	//------------------------------------------------------------------------------
	public List<Position> getAllPosition(){
		return positionMapper.findAllPosition();
	}
	
	public Integer addPosition(Position position) {
		return positionMapper.addPosition(position);
	}
	
	public Integer updatePosition(Position position) {
		return positionMapper.updatePosition(position);
	}
	
	public Integer deletePositionById(Integer positionId) {
		return positionMapper.deletePositionById(positionId);
	}
}
