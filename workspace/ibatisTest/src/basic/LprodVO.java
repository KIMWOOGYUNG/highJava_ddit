package basic;

public class LprodVO {
	private  int lprod_id;
	private  String lprod_gu;
	private  String lprod_nm;
	
	//iBatis���� ���Ǵ� VO��ü�� ������ �����ڸ� ����� �Ǹ�
	//�ݵ�� �⺻ �����ڵ� ����� ��� �Ѵ�.
	//���� : iBatis�� �⺻ �����ڷ� ��ü�� �����ؼ� ����ϱ� ������...
	
	
	public int getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
}
