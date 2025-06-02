package org.scoula.dao;

import org.scoula.db.JDBCUtil;
import org.scoula.vo.DiaryVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiaryDaoImpl implements DiaryDao {
    Connection conn= JDBCUtil.getConnection();


    @Override
    public void createDiary(DiaryVO diaryVO) {
        String sql="INSERT INTO DIARY(TITLE,CONTENT) VALUES (?,?)";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, diaryVO.getTitle());
            pstmt.setString(2, diaryVO.getContent());
            int rows=pstmt.executeUpdate();
            System.out.println(rows+" Append process");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteDiary(DiaryVO diaryVO) {
        String sql="DELETE FROM DIARY WHERE ID=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setLong(1,diaryVO.getId());
            int rows=pstmt.executeUpdate();
            System.out.println(rows+" Delete process");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateDiary(DiaryVO diaryVO) {
        String sql="UPDATE DIARY SET TITLE=?,CONTENT=? WHERE ID=?";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, diaryVO.getTitle());
            pstmt.setString(2, diaryVO.getContent());
            pstmt.setLong(3,diaryVO.getId());
            int rows=pstmt.executeUpdate();
            System.out.println(rows+" Modify process");


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private DiaryVO map(ResultSet rs) throws SQLException {
        return DiaryVO.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .date(rs.getTimestamp("created_at"))
                .build();
    }

    @Override
    public List<DiaryVO> readDiary() {
        System.out.println("readDiary");
        List<DiaryVO>diarys=new ArrayList<>();
        String sql="SELECT * FROM DIARY";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                DiaryVO diary=map(rs);
                diarys.add(diary);

            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return diarys;
    }
}
