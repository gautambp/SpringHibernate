package self.learning.spring.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"self/learning/spring/database/beans.xml");
		UploadDAO dao = (UploadDAO) ctx.getBean("uploadDAO");
		for (UploadVO uploadVO : dao.findUploads())
			System.out.println(uploadVO);
		UploadVO uploadVO = createUploadVO();
		System.out.println("Creating item with id 1000 : " + dao.create(uploadVO));
		System.out.println("Find item with id 1000 : " + dao.findUpload(1000));
		System.out.println("Delete item with id 1000 : " + dao.delete(1000));
		
		UploadVO uploadVO2 = createUploadVO();
		uploadVO2.setId(1001);
		List<UploadVO> list = new ArrayList<UploadVO>();
		list.add(uploadVO);
		list.add(uploadVO2);
		System.out.println("Creating item with id 1000 & 1001 : " + dao.create(list));
		System.out.println("Find item with id 1000 : " + dao.findUpload(1000));
		System.out.println("Find item with id 1001 : " + dao.findUpload(1001));
		System.out.println("Delete item with id 1000 : " + dao.delete(1000));
		System.out.println("Delete item with id 1001 : " + dao.delete(1001));
		ctx.close();
	}
	
	public static UploadVO createUploadVO() {
		UploadVO uploadVO = new UploadVO();
		uploadVO.setId(1000);
		uploadVO.setEhrUploadBy(1);
		uploadVO.setEhrUploadDate(new Date());
		uploadVO.setEhrUploadFile("a file");
		uploadVO.setEhrUploadId(1);
		uploadVO.setFacilityId(1);
		uploadVO.setFormName("AF1");
		uploadVO.setRegistryName("atrialfib");
		uploadVO.setSiteId(1);
		return uploadVO;
	}

}
