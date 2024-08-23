package memo;

import java.util.List;

public class MemoService {
	
	public List<MemoVO> selectMemoList(){
		MemoDAO dao = new MemoDAO();
		return dao.selectMemoList();
	}
	public MemoVO selectMemo(int serachMNO) {
		MemoDAO dao = new MemoDAO();
		return dao.selectMemo(serachMNO);
	}
	public int insertMemo(MemoVO memo) {
		MemoDAO memoDAO = new MemoDAO();
		return memoDAO.insertMemo(memo);
	}
	
	public int updateMemo(MemoVO memo) {
		MemoDAO dao = new MemoDAO();
		return dao.updateMemo(memo);
	}
	public int deleteMemo(int mNo) {
		MemoDAO memoDAO = new MemoDAO();
		return memoDAO.deleteMemo(mNo);
	}
}
