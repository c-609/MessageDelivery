package cn.tiger.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tiger.RightsManageApplicationTest;
import cn.tiger.bean.Degree;
import cn.tiger.bean.Dept;
import cn.tiger.bean.Menu;
import cn.tiger.bean.Position;

public class PositionServiceTest extends RightsManageApplicationTest{
	@Autowired
	PositionService positionService;
	@Test
	public void testGetAllDegree() {
		List list = positionService.getAllDegree();
		System.out.println(list);
	}
	@Test
	public void testAddDegree() {
		Degree degree = new Degree();
		degree.setName("专升本");
		Integer i = positionService.addDegree(degree); 
		System.out.println(i);
	}
	@Test
	public void testUpdateDegree() {
		Degree degree = new Degree();
		degree.setId(4);
		degree.setName("test专升本");
		degree.setStatus(1);
		Integer i = positionService.updateDegree(degree);
		System.out.println(i);
	}
	@Test
	public void testDeleteDegreeById() {
		Integer i = positionService.deleteDegreeById(4);
		System.out.println(i);
	}
	//---------------------------position-----------------
	@Test
	public void testGetAllPosition() {
		List list = positionService.getAllPosition();
		System.out.println(list);
	}
	@Test
	public void testAddPosition() {
		Position position = new Position();
		position.setName("专升本");
		Integer i = positionService.addPosition(position); 
		System.out.println(i);
	}
	@Test
	public void testUpdatePosition() {
		Position Position = new Position();
		Position.setId(4);
		Position.setName("test专升本");
		Position.setStatus(1);
		Integer i = positionService.updatePosition(Position);
		System.out.println(i);
	}
	@Test
	public void testDeletePositionById() {
		Integer i = positionService.deletePositionById(4);
		System.out.println(i);
	}
}
