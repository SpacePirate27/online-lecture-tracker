package com.example.onlinelecturetracker

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LectureDAO {
    @Query("SELECT * FROM lectures_table WHERE subject='BDA' ORDER BY lectureNumber ASC")
    fun getBDARecords() : LiveData<List<LectureDetails>>

    @Query("SELECT * FROM lectures_table WHERE subject='Cloud'")
    fun getCloudRecords() : List<LectureDetails>

    @Query("SELECT * FROM lectures_table WHERE subject='PDS'")
    fun getPDSRecords() : List<LectureDetails>

    @Query("SELECT * FROM lectures_table WHERE subject='Embedded'")
    fun getEmbeddedRecords() : List<LectureDetails>

    @Query("SELECT * FROM lectures_table WHERE subject='Elective'")
    fun getElectiveRecords() : List<LectureDetails>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(lecture: LectureDetails)

    @Update
    fun updateLecture(lecture: LectureDetails)

    @Query("SELECT SUM(duration) from lectures_table WHERE status='Pending'")
    fun getTotalLectureDuration() : LiveData<Int>

    @Delete
    suspend fun deleteLecture(lecture: LectureDetails)

    @Query("DELETE FROM lectures_table")
    suspend fun deleteAllLectures()
}
