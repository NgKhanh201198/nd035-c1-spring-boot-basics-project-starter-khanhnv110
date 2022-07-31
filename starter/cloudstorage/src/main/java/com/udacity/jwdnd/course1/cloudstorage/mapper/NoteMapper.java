package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getNoteListByUserId(Integer userId);

    @Insert("INSERT INTO NOTES (notetitle, notedescription,  userid) " +
            "VALUES(#{noteTitle}, #{noteDescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription}" + "WHERE userid = #{userid} AND noteid = #{noteId}")
    boolean update(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    boolean delete(Integer noteId);
}
