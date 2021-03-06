package com.jxtele.projectmanage;


import com.jxtele.projectmanage.entity.*;
import com.jxtele.projectmanage.service.*;

import com.jxtele.projectmanage.service.IMoneyInfoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectmanageApplicationTests {

	@Autowired
	private IProjectService projectService;

	@Test
	public void contextLoads() {

	}

	@Autowired
	private IFactScheduleService factScheduleService;
	@Test
	public void test(){
		FactSchedule m =new FactSchedule();

		m.setAlreadyStartday(new Float(12));
		m.setScheduleDescription("2123");
		m.setCtScheduleid(1);
		//m.setId(2);
		//projectScheduleService.updateByPrimaryKeySelective(m);
		factScheduleService.insert(m);

		System.out.println(factScheduleService.findFactScheduleleByctScheduleid(1));
	}

	@Autowired
	private IMoneyInfoService moneyInfoService;
	@Test
	public void test1(){

		//moneyInfoService.deleteByPrimaryKey(1);
		System.out.println(moneyInfoService.selectByPrimaryKey(2).getMoneyInfoItems());
	}

	@Autowired
	private IProcurementService procurementService;
	@Test
	public void test2(){
		System.out.println(procurementService.selectByPrimaryKey(1).getProcurementItems());
	}

	@Autowired
	private IRiskService riskService;

	@Test
	public void test3(){
		Risk m =new Risk();

		m.setContent("123123");
		m.setRisktype(1);
		riskService.insert(m);
		//System.out.println(procurementService.selectByPrimaryKey(1).getProcurementItems());
	}


	@Test
	public void test4(){
		Risk m =new Risk();

		m.setContent("123123");
		m.setRisktype(2);
		m.setId(1);
		//riskService.insert(m);.
		riskService.updateByPrimaryKeySelective(m,1);
		//System.out.println(procurementService.semlectByPrimaryKey(1).getProcurementItems());
	}
	@Autowired
	private ISupplierService supplierService;
	@Test
	public void test5(){
		Supplier s = new Supplier();
		s.setEvaluation("213");
		s.setProcurementId(1);
		supplierService.insert(s);
		//System.out.println(procurementService.semlectByPrimaryKey(1).getProcurementItems());
	}
    @Autowired
    private ICommunicationService communicationService;

    @Test
    public void test6(){
        Communication s = new Communication();
        s.setComtype("qewwqe");
        s.setComway("qweqw");
        s.setProjectId(1);
//        communicationService.insert(s);
        //System.out.println(procurementService.semlectByPrimaryKey(1).getProcurementItems());
    }
	@Autowired
	private IAttachmentFileService attachmentFileService;

	@Test
	public void test7(){
		attachmentFileService.deleteByPrimaryKey(4);
	}

	@Autowired
	private IStandardDayService standardDayService;

	@Test
	public void test8(){
		StandardDay s = new StandardDay();
		s.setAddress("123");
		s.setProjectId(1);
		s.setWorkcategory("123");
		standardDayService.insert(s);
		//standardDayService.deleteByPrimaryKey(4);
	}

	@Autowired
	private IStandardApplyService standardApplyService;


	@Test
	public void test9(){
		StandardApply s = new StandardApply();
		s.setApproval("13123");
		s.setProjectId(1);
		s.setContent("weqeqw");
		s.setDayid(1);
		standardApplyService.insert(s);
		System.out.println("nannnnn"+standardApplyService.findStandardApplyByProjId(1).get(0).getStandardDay().getId());
		//standardDayService.deleteByPrimaryKey(4);
	}

	@Autowired
	private IAlterScheduleService alterScheduleService;

	@Test
	public void test10(){
		AlterSchedule s = new AlterSchedule();
		s.setAlterdate(new Date());
		s.setProjectId(1);
		s.setCtScheduleid(2);
		s.setLasttotaldays(new BigDecimal(2));
		s.setCtScheduleid(1);
//		alterScheduleService.insert(s);
	}

	@Autowired
	private IProjectScheduleService projectSchedulService;
	@Test
	public void test11(){
		System.out.println(projectSchedulService.findProjectScheduleByProjId(1).get(0).getAlterSchedules().size());
	}

	@Autowired
	private IStakeholderService stakeholderService;

	@Test
	public void test12(){
		Stakeholder s = new Stakeholder();
		s.setCommethod("qwe");
		s.setName("liuy");
		s.setPhone("18146704709");
		s.setProjectId(1);
		stakeholderService.insert(s);
	}

}
