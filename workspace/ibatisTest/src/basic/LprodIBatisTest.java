package basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIBatisTest {

	public static void main(String[] args) {
		//iBatis�� �̿��Ͽ� DB�ڷḦ ó���ϴ� �۾� ����
		
		try {
			//1. iBatis�� ȯ�漳�� ������ �о�ͼ� �����Ų��.
			
			//1-1. ���� ���ڵ� ĳ���ͼ� ����
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			//1-2. ȯ�漳����  xml���� �о����
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			//1-3. ������ �о�� Reader��ü�� �̿��Ͽ� ���� �۾��� ����� ��ü�� �����Ѵ�.
			//		==> ȯ�漳���� xml������ ������ ó���� �� �۾��� ����� ��ü�� ������ �ش�.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			//----------------------------------------------------------------------
			
		//2. ������ SQL���� �´� �������� ȣ���ؼ� ���ϴ� �۾��� �����Ѵ�.
			
		//2-1. insert ����
			/*
			// 1) VO��ü�� insert�� �����͸� �����Ѵ�.
			System.out.println("insert �۾� ����..");
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(200);
			lvo.setLprod_gu("T101");
			lvo.setLprod_nm("�޴���");
			
			// 2) SqlMapClient ��ü������ �̿��Ͽ� �ش� �������� ȣ���ؼ� �����Ѵ�.
			// ����) smc.insert("namespace�Ӽ���.ȣ����id�Ӽ���", �Ķ����Ŭ����);
			//		��ȯ�� : insert���� : null, ���� : ������ü��ȯ
			Object obj = smc.insert("lprodTest.insertLprod", lvo);
			if(obj == null){
				System.out.println("insert �۾� ����~~~!");
			}else{
				System.out.println("insert �۾� ����....");
			System.out.println("------------------------------------");
			}
			*/
			
		//2-2. update ����
			/*
			System.out.println("update ����...");
			//����� �����͸� VO��ü�� �����Ѵ�.
			LprodVO lpvo2 = new LprodVO();
			lpvo2.setLprod_id(250);
			lpvo2.setLprod_gu("T101");
			lpvo2.setLprod_nm("����Ʈ��");
			
			//update()�޼��带 �̿��ؼ� ó���Ѵ�.
			//����) smc.update("namespace�Ӽ���.ȣ����id�Ӽ���", �Ķ����Ŭ����)
			//		��ȯ�� : �۾��� ������ ���ڵ� ��
			int cnt = smc.update("lprodTest.updateLprod",lpvo2);
			if(cnt > 0){
				System.out.println("update �۾� ����!!!!");
			}else{
				System.out.println("update �۾� ����....");
			}
			System.out.println("------------------------------------");
			*/
			
		//2-3. delete ����
			/*
			System.out.println("delete �۾� ����...");
			
			//delete()�޼��带 ����Ѵ�.
			//delete()�޼����� ��ȯ���� �۾��� ������ ���ڵ� ���̴�.
			int cnt2 = smc.delete("lprodTest.deleteLprod", "p601");
			if(cnt2>0){
				System.out.println("delete �۾� ����~~!!");
			}else{
				System.out.println("delete �۾� ����....");
			}
			System.out.println("--------------------------------------");
			*/
			
		//2-4. select ����
			/*
			//1) select�� ����� �������� ���
			System.out.println("select ���� (����� �������� ���...)");
			//���� ����� �������� ��쿡�� queryForList()�޼��带 ����Ѵ�.
			//�� �޼���� �������� ���ڵ� ������ VO�� ���� �� �� VO��ü�� List�� �߰��� �ִ� �۾��� �ڵ����� �����Ѵ�.
			List<LprodVO> lprodList = smc.queryForList("lprodTest.getAllLprod");
			
			for(LprodVO lpvo3 : lprodList){
				System.out.println("ID: " + lpvo3.getLprod_id());
				System.out.println("GU: " + lpvo3.getLprod_gu());
				System.out.println("NM: " + lpvo3.getLprod_nm());
				System.out.println("--------------------------------");
			}
			System.out.println("��� ��....");
			*/
			
			//2) select�� ����� 1���� ���
			System.out.println("select ����(����� 1���� ���)...");
			
			//���� ����� 1���� Ȯ���� ��쿡�� queryForObject()�޼��带 ����Ѵ�.
			//��ȯ���� �ش� �������� resultClass�� ������ ��ü�� ��ȯ�Ǵµ�
			//Object������ ��ȯ�Ǿ� ����ȯ�� �ؾ��Ѵ�.
			LprodVO lpvo4 = (LprodVO) smc.queryForObject("lprodTest.getLprod", "P101");
			System.out.println("ID: " + lpvo4.getLprod_id());
			System.out.println("GU: " + lpvo4.getLprod_gu());
			System.out.println("NM: " + lpvo4.getLprod_nm());
			System.out.println("--------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
