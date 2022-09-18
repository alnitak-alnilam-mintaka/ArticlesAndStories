package com.polinasmogi.articlesandstories.database

class ContentSource(private val dao: ContentDao) {

    fun insertContent(contentEntity: ContentEntity) = dao.insertContent(contentEntity)

    fun updateContent(id: String, views: Int) = dao.updateContent(id, views)

    fun getContent(id: String) = dao.getContent(id)

    fun getVisited() = dao.getVisited()

//    fun getHolidayList(): Flow<List<HolidayEntity>> = dao.getHolidayList()
//
//    fun getDatabaseSize(): Int = dao.databaseSize()
//
//    fun insertHolidays(holidays: List<HolidayEntity>) = dao.insertHolidayList(holidays)
//
//    fun getSingleHoliday(id: Int) = dao.getHoliday(id)
//
//    fun updateTheHoliday(id: Int, isFavorite: Boolean) = dao.updateTheHoliday(id, isFavorite)

}