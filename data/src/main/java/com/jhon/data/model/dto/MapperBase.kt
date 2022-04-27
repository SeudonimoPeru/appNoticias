package com.jhon.data.model.dto
//mapper base para manejar entidades y objetos
interface MapperBase<BEAN, ENTITY> {
    fun toBean(entity: ENTITY): BEAN
    fun toEntity(bean: BEAN): ENTITY
    fun toListBean(entityList: List<ENTITY>): List<BEAN>
    fun toListEntity(beanList: List<BEAN>): List<ENTITY>
}