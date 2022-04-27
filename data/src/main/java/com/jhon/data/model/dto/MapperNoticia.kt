package com.jhon.data.model.dto

import com.jhon.data.model.bean.news.News
import com.jhon.data.room.entity.RoomNews
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface MapperClient : MapperBase<News, RoomNews>
