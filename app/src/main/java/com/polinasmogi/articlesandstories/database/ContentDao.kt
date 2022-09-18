package com.polinasmogi.articlesandstories.database

import androidx.room.*

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContent(content: ContentEntity)

    @Query("UPDATE contents SET views = :views WHERE objectID =:id")
    fun updateContent(id: String, views: Int)

    @Query("SELECT * FROM contents WHERE objectID = :id")
    fun getContent(id: String): ContentEntity?

    @Query("SELECT * FROM contents")
    fun getVisited() : List<ContentEntity>

//    @Query("SELECT * FROM holidays")
//    fun getHolidayList(): Flow<List<HolidayEntity>>
//
//    @Query("SELECT count(*) FROM holidays")
//    fun databaseSize(): Int
//
//    @Query("SELECT * FROM holidays WHERE :id = id")
//    fun getHoliday(id: Int): HolidayEntity
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertHolidayList(holidays: List<HolidayEntity>)
//
//    @Query("UPDATE holidays SET is_favorite = :isFavorite WHERE id =:id")
//    fun updateTheHoliday(id: Int, isFavorite: Boolean)
//
//    @Query("DELETE FROM holidays")
//    fun deleteAll()

}